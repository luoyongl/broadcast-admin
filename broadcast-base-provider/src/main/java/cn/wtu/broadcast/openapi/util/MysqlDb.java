package cn.wtu.broadcast.openapi.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.*;

/**
 * Mysql数据库管理
 *
 * @author sueua
 * @since 2019-01-14
 */
public class MysqlDb {

    private static final Logger logger = LoggerFactory.getLogger(MysqlDb.class);

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 主机
     */
    private String host;

    /**
     * 端口
     */
    private String port;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 数据库名称
     */
    private String dbName;

    private BufferedOutputStream bos;

    public MysqlDb(String host, String port, String username, String password, String dbName) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.dbName = dbName;
    }

    public MysqlDb(String host, String username, String password, String dbName) {
        this.host = host;
        this.port = "3306";
        this.username = username;
        this.password = password;
        this.dbName = dbName;
    }

    /**
     * 数据库备份
     *
     * @param tableName 表名,指定时只备份单一数据表
     * @param path      保存路径
     */
    public void backup(String tableName, String path) throws Exception{
        logger.info("开始备份数据库{},指定表{},文件路径{}", dbName, tableName, path);
        boolean flag = true;
        long totalStart = System.currentTimeMillis();
        File dir = new File(path);
        if(!dir.exists()){
            flag = dir.mkdirs();
        }
        if(flag){
            String nowTimeStr = DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSS");
            String fileName = path + dbName + "_";
            if (StringUtils.isNotBlank(tableName)) {
                fileName += tableName + "_";
            }
            fileName += nowTimeStr + ".sql";
            File file = new File(fileName);
            try {
                try (FileOutputStream fos = new FileOutputStream(file)) {
                    bos = new BufferedOutputStream(fos);
                    String version = null;
                    List<Map<String, Object>> versions = queryForList(" select version() as version ");
                    if (versions.size() > 0) {
                        version = (String) versions.get(0).get("version");
                    }
                    String header = "/* \r\n" +
                            "Source Server         : " + host + " \r\n" +
                            "Source Server Version : " + version + " \r\n" +
                            "Source Host           : " + host + ":" + port + "\r\n" +
                            "Source Database       : " + dbName + " \r\n" +
                            "Date: " + dateTimeFormatter.format(LocalDateTime.now()) + " \r\n" +
                            "*/ \r\n" +
                            " \r\n" +
                            "SET FOREIGN_KEY_CHECKS=0; ";
                    writeToFile(header);
                    //写表信息
                    readTable2File(tableName);
                    if (StringUtils.isBlank(tableName)) {
                        //写视图
                        readView2File();
                        //写存储过程和函数
                        readFunctionAndProcedure2File();
                    }
                    //开启外键关联检查
                    writeToFile("SET FOREIGN_KEY_CHECKS=1; ");
                    this.bos.flush();
                    this.bos.close();
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
            long totalEnd = System.currentTimeMillis();
            logger.info("----备份总耗时：{}毫秒----", totalEnd - totalStart);
        }else{
            throw new Exception("创建文件夹失败");
        }
    }

    /**
     * 执行sql语句
     *
     * @param sql sql语句
     * @return 影响的行数
     * @throws Exception 异常
     */
    private int executeSql(String sql, Connection conn) throws Exception {
        Statement stmt = null;
        int num = 0;
        try {
            if (conn != null) {
                stmt = conn.createStatement();
                num = stmt.executeUpdate(sql);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
        return num;
    }

    /**
     * 批量执行sql
     *
     * @param sqlList sql语句list
     * @return 影响的行数
     * @throws Exception 异常
     */
    private int executeBatchSql(List<String> sqlList, Connection conn) throws Exception {
        Statement stmt = null;
        try {
            if (conn != null) {
                stmt = conn.createStatement();
                for (String sql : sqlList) {
                    sql = sql.replaceAll(";", "");
                    stmt.addBatch(sql);
                }
                int[] updateCounts = stmt.executeBatch();
                return updateCounts.length;
            }
        } catch (Exception e) {
            conn.rollback();
            throw new Exception(e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }
        return 0;
    }

    /**
     * 数据库恢复
     *
     * @param filePath 文件路径
     * @throws Exception 异常
     */
    public void recover(String filePath) throws Exception {
        logger.info("开始恢复数据库{},文件路径{}", dbName, filePath);
        long totalStart = System.currentTimeMillis();
        Connection conn = getConnection();
        if (conn == null) {
            throw new Exception("获取连接失败!");
        } else {
            conn.setAutoCommit(false);
            StringBuilder sb = new StringBuilder();
            //是否为注释
            boolean isComment = false;
            //是否为定界符
            boolean isDelimiter = false;
            List<String> insertSqlList = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {
                String content;
                while ((content = reader.readLine()) != null) {
                    //去掉空格和bom
                    content = content.trim().replace("\uFEFF", "");
                    if (StringUtils.isNoneBlank(content)) {
                        if ("DELIMITER ;;".equals(content)) {
                            isDelimiter = true;
                        } else if ("DELIMITER ;".equals(content)) {
                            isDelimiter = false;
                            executeSql(sb.toString(), conn);
                            sb.delete(0, sb.length());
                        } else if (isDelimiter) {
                            sb.append(content).append(" ");
                        } else if (content.indexOf("/*") == 0) {
                            isComment = true;
                        } else if (content.contains("*/")) {
                            isComment = false;
                        } else if (!isComment && content.indexOf("--") != 0 && content.indexOf("#") != 0) {
                            if (content.indexOf("INSERT INTO") != 0 && content.lastIndexOf(";") != content.length() - 1) {
                                sb.append(content);
                            }
                            if (content.indexOf("INSERT INTO") != 0 && content.lastIndexOf(";") == content.length() - 1) {
                                sb.append(content);
                                executeSql(sb.toString(), conn);
                                sb.delete(0, sb.length());
                            }
                            if (content.indexOf("INSERT INTO") == 0 && content.lastIndexOf(";") == content.length() - 1) {
                                insertSqlList.add(content);
                                if (insertSqlList.size() >= 1000) {
                                    executeBatchSql(insertSqlList, conn);
                                    insertSqlList.clear();
                                }
                            }
                        }
                    }
                }
                if (insertSqlList.size() > 0) {
                    executeBatchSql(insertSqlList, conn);
                    insertSqlList.clear();
                }
            }
            conn.commit();
            conn.close();
        }
        long totalEnd = System.currentTimeMillis();
        logger.info("----恢复总耗时：{}毫秒----", totalEnd - totalStart);
    }

    /**
     * 将表内容写入文件
     *
     * @param tableName 指定单个表名
     * @throws Exception 异常
     */
    private void readTable2File(String tableName) throws Exception {
        //表信息
        List<Map<String, Object>> tableList = getAllTables(tableName);
        String createTableSQL = "";
        int num = 0;
        Iterator<Map<String, Object>> iterator = tableList.iterator();
        //DDL信息
        List<Map<String, Object>> ddlList;
        while (iterator.hasNext()) {
            Map<String, Object> map = iterator.next();
            String itemTableName = (String) map.get("TABLE_NAME");
            ddlList = queryForList("show create table `" + itemTableName + "`");
            if (ddlList.size() > 0) {
                map = ddlList.get(0);
                createTableSQL = (String) map.get("Create Table");
            }
            String tableDdlInfo = " \r\n" +
                    "-- -------------------------------- \r\n" +
                    "-- Table structure for `" + itemTableName + "`\r\n" +
                    "-- -------------------------------- \r\n" +
                    "DROP TABLE IF EXISTS `" + itemTableName + "`; \r\n" +
                    createTableSQL +
                    ";\r\n";
            writeToFile(tableDdlInfo);
            Map<String, String> tableColumnType = new HashMap<>();
            List<Map<String, Object>> listTableColumn = getTableColumnsInfo(itemTableName);
            for (Map<String, Object> map3 : listTableColumn) {
                tableColumnType.put((String) map3.get("COLUMN_NAME"), (String) map3.get("DATA_TYPE"));
            }
            ++num;
            int rowCount = executeQueryForCount("select count(*) from   `" + dbName + "`.`" + itemTableName + "`");
            writeToFile("-- ---------------------------- \r\n");
            writeToFile("-- Records of " + itemTableName + ", Total rows: " + rowCount + " \r\n");
            writeToFile("-- ---------------------------- \r\n");
            int limitFrom = 0;
            int pageSize = 20000;
            for (int yy = 0; yy < rowCount; yy += pageSize) {
                String sql3 = "select  *  from  `" + dbName + "`.`" + itemTableName + "`  LIMIT " + limitFrom + "," + pageSize;
                List<Map<String, Object>> list = queryForList(sql3);
                String key;
                StringBuilder values;
                String tempValues;
                limitFrom += pageSize;
                for (Map<String, Object> row : list) {
                    StringBuilder intoSql = new StringBuilder();
                    intoSql.append("INSERT INTO `").append(itemTableName).append("` VALUES (");
                    values = new StringBuilder();
                    for (Map.Entry<String, Object> entry : row.entrySet()) {
                        key = entry.getKey();
                        if (entry.getValue() == null) {
                            values.append("null,");
                        } else if (!"int".equals(tableColumnType.get(key)) && !"smallint".equals(tableColumnType.get(key)) && !"tinyint".equals(tableColumnType.get(key)) && !"integer".equals(tableColumnType.get(key)) && !"bit".equals(tableColumnType.get(key)) && !"bigint".equals(tableColumnType.get(key)) && !"double".equals(tableColumnType.get(key)) && !"float".equals(tableColumnType.get(key)) && !"decimal".equals(tableColumnType.get(key)) && !"numeric".equals(tableColumnType.get(key)) && !"mediumint".equals(tableColumnType.get(key))) {
                            if (!"binary".equals(tableColumnType.get(key)) && !"varbinary".equals(tableColumnType.get(key))) {
                                if (!"blob".equals(tableColumnType.get(key)) && !"tinyblob".equals(tableColumnType.get(key)) && !"mediumblob".equals(tableColumnType.get(key)) && !"longblob".equals(tableColumnType.get(key))) {
                                    if ("date".equals(tableColumnType.get(key))) {
                                        tempValues = "" + entry.getValue();
                                        values.append("'").append(tempValues).append("',");
                                    } else if ("time".equals(tableColumnType.get(key))) {
                                        tempValues = "" + entry.getValue();
                                        values.append("'").append(tempValues).append("',");
                                    } else {
                                        tempValues = (String) entry.getValue();
                                        tempValues = tempValues.replace("'", "\\'");
                                        tempValues = tempValues.replace("\\", "\\\\");
                                        tempValues = tempValues.replace("\r\n", "\\r\\n");
                                        tempValues = tempValues.replace("\n\r", "\\n\\r");
                                        tempValues = tempValues.replace("\r", "\\r");
                                        tempValues = tempValues.replace("\n", "\\n");
                                        values.append("'").append(tempValues).append("',");
                                    }
                                } else {
                                    values.append("'").append(entry.getValue()).append("',");
                                }
                            } else {
                                values.append("'").append(entry.getValue()).append("',");
                            }
                        } else {
                            values.append(entry.getValue()).append(",");
                        }
                    }

                    intoSql.append(values.substring(0, values.length() - 1));
                    intoSql.append(" ); \r\n");
                    writeToFile(intoSql.toString());
                    ++num;
                    if (num >= 50000) {
                        try {
                            num = 0;
                            this.bos.flush();
                        } catch (IOException e) {
                            logger.error(e.getMessage(), e);
                        }
                    }
                }
            }
            if (num >= 50000) {
                logger.info("===============清缓存一次{}===============", num);
                try {
                    num = 0;
                    this.bos.flush();
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
    }

    /**
     * 将视图内容写入文件
     *
     * @throws Exception 异常
     */
    private void readView2File() throws Exception {
        StringBuilder sb = new StringBuilder();
        String sql = " select TABLE_NAME from information_schema.TABLES where table_schema='" + dbName + "' and table_type='VIEW' ";
        List<Map<String, Object>> viewsList = queryForList(sql);
        String viewName;
        for (Map<String, Object> view : viewsList) {
            viewName = (String) view.get("TABLE_NAME");
            sb.append("-- ---------------------------- \r\n");
            sb.append("-- View structure for `").append(viewName).append("` \r\n");
            sb.append("-- ---------------------------- \r\n");
            sb.append("DROP VIEW IF EXISTS `").append(viewName).append("`; \r\n");
            sb.append("CREATE VIEW `").append(viewName).append("` AS ").append(getViewSql(viewName)).append("; \r\n");
        }
        writeToFile(sb.toString());
    }

    /**
     * 查询结果集
     *
     * @param sql sql语句
     * @return List
     * @throws Exception 异常
     */
    @SuppressWarnings("all")
    private List<Map<String, Object>> queryForList(String sql) throws Exception {
        Connection conn;
        PreparedStatement statement;
        ResultSet rs;
        ResultSetMetaData resultSetMetaData;
        String[] fields;
        List<String> times = new ArrayList<>();
        List<String> binary = new ArrayList<>();
        List<Map<String, Object>> rows = new ArrayList<>();
        Map<String, Object> row;
        conn = getConnection();
        if (conn != null) {
            statement = conn.prepareStatement(sql);
            rs = statement.executeQuery();
            resultSetMetaData = rs.getMetaData();
            int maxSize = resultSetMetaData.getColumnCount();
            fields = new String[maxSize];
            for (int i = 0; i < maxSize; ++i) {
                fields[i] = resultSetMetaData.getColumnLabel(i + 1);
                if ("java.sql.Timestamp".equals(resultSetMetaData.getColumnClassName(i + 1))) {
                    times.add(fields[i]);
                }
                if ("[B".equals(resultSetMetaData.getColumnClassName(i + 1))) {
                    binary.add(fields[i]);
                }
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            while (rs.next()) {
                row = new LinkedHashMap<>();

                for (int i = 0; i < maxSize; ++i) {
                    Object value = times.contains(fields[i]) ? rs.getTimestamp(fields[i]) : rs.getObject(fields[i]);
                    if (times.contains(fields[i]) && value != null) {
                        value = sdf.format(value);
                    }
                    if (binary.contains(fields[i]) && value != null) {
                        value = new String((byte[]) value);
                    }
                    row.put(fields[i], value);
                }
                rows.add(row);
            }

            try {
                rs.close();
                statement.close();
                conn.close();
            } catch (SQLException e) {
                throw new Exception(e.getMessage());
            }
        }
        return rows;
    }

    /**
     * 查询记录总数
     *
     * @param sql sql语句
     * @return 记录总数
     */
    @SuppressWarnings("cast")
    private int executeQueryForCount(String sql) {
        int rowCount = 0;
        Connection conn = getConnection();
        Statement stmt;
        ResultSet rs;
        try {
            if (conn != null) {
                stmt = conn.createStatement();
                Object count;
                for (rs = stmt.executeQuery(sql); rs.next(); rowCount = Integer.parseInt(count.toString())) {
                    count = rs.getObject("count(*)");
                }
                try {
                    rs.close();
                    stmt.close();
                    conn.close();
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return rowCount;
    }

    /**
     * 获取连接
     */
    private synchronized Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName + "?characterEncoding=utf8&tinyInt1isBit=false&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&useSSL=false&serverTimezone=GMT%2B8";
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 查询所有表格信息
     *
     * @param tableName 指定表格
     * @return list
     * @throws Exception 异常
     */
    private List<Map<String, Object>> getAllTables(String tableName) throws Exception {
        String sql;
        if (StringUtils.isNotBlank(tableName)) {
            sql = " select TABLE_NAME,ENGINE, VERSION,ROW_FORMAT,TABLE_ROWS,AUTO_INCREMENT,TABLE_COLLATION,TABLE_COMMENT  from information_schema.TABLES where table_schema='" + dbName + "' and  table_name='" + tableName + "'  and table_type='BASE TABLE' ";
        } else {
            sql = " select TABLE_NAME,ENGINE, VERSION,ROW_FORMAT,TABLE_ROWS,AUTO_INCREMENT,TABLE_COLLATION,TABLE_COMMENT  from information_schema.TABLES where table_schema='" + dbName + "' and table_type='BASE TABLE' ";
        }
        return queryForList(sql);
    }

    /**
     * 寫入到文件
     *
     * @param str 待寫入的字符串
     */
    private void writeToFile(String str) {
        try {
            this.bos.write(str.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * 獲取表列信息
     *
     * @param tableName 表面
     * @return 列信息
     * @throws Exception 異常
     */
    private List<Map<String, Object>> getTableColumnsInfo(String tableName) throws Exception {
        String sql = " select column_name as TREESOFTPRIMARYKEY, COLUMN_NAME,COLUMN_TYPE , DATA_TYPE ,COLUMN_DEFAULT ,CHARACTER_MAXIMUM_LENGTH, NUMERIC_PRECISION ,NUMERIC_SCALE , IS_NULLABLE, COLUMN_KEY,extra, COLUMN_COMMENT  from information_schema.columns where   table_name='" + tableName + "' and table_schema='" + dbName + "'  ";
        return queryForList(sql);
    }


    /**
     * 获取创建视图语句名称
     *
     * @param viewName 视图名称
     * @return 创建视图语句
     * @throws Exception 异常
     */
    private String getViewSql(String viewName) throws Exception {
        String sql = " select  view_definition  from  information_schema.VIEWS  where  table_name='" + viewName + "' and table_schema='" + dbName + "'  ";
        String str = "";
        List<Map<String, Object>> list = queryForList(sql);
        if (list.size() == 1) {
            Map<String, Object> map = list.get(0);
            str = (String) map.get("view_definition");
        }
        return str;
    }


    /**
     * 写存取过程或函数
     */
    private void readFunctionAndProcedure2File() throws Exception {
        StringBuilder sb = new StringBuilder();
        String sql = "select ROUTINE_NAME,ROUTINE_TYPE from information_schema.ROUTINES where routine_schema='" + dbName + "' ";
        List<Map<String, Object>> ddlList = queryForList(sql);
        for (Map<String, Object> function : ddlList) {
            String routineName = (String) function.get("ROUTINE_NAME");
            String routineType = (String) function.get("ROUTINE_TYPE");
            sb.append("-- ---------------------------- \r\n");
            sb.append("-- ").append(routineType).append(" structure for `").append(routineName).append("` \r\n");
            sb.append("-- ---------------------------- \r\n");
            sb.append("DROP ").append(routineType).append(" IF EXISTS `").append(routineName).append("`; \r\n");
            sb.append("DELIMITER ;;\r\n");
            sb.append(getFunctionOrProcedureSQL(routineName, routineType)).append(" ;;\r\n");
            sb.append("DELIMITER ;\r\n");
        }
        writeToFile(sb.toString());
    }

    /**
     * 获取创建存储过程语句
     *
     * @return 创建存储过程语句
     */
    private String getFunctionOrProcedureSQL(String routineName, String routineType) {
        String sql = " show create " + routineType + " " + routineName;
        String str = "";
        try {
            List<Map<String, Object>> list = queryForList(sql);
            if (list.size() == 1) {
                Map<String, Object> map = list.get(0);
                str = (String) map.get("Create " + StringUtils.capitalize(routineType.toLowerCase()));
            }
        } catch (Exception e) {
            str = "";
            logger.error(e.getMessage(), e);
        }
        return str;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
}

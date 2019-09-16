package cn.wtu.broadcast.parent.utils.ftp;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class FtpUtil {
    private final static Logger logger = LoggerFactory.getLogger(FtpUtil.class);
    private static String host;
    private static int port;
    private static String username;
    private static String password;

    /**
     * Description: 向FTP服务器上传文件
     *
     * @param filePath FTP服务器文件存放路径。例如分日期存放：2015/01/01
     * @param filename 上传到FTP服务器上的文件名
     * @param input    输入流
     * @return 成功返回true，否则返回false
     */
    public static boolean uploadFile(String filePath, String filename, InputStream input) {
        boolean result = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(host, port);// 连接FTP服务器
            ftp.login(username, password);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return false;
            }
            /*filePath = "2019/07/08/audio";*/
            //切换到上传目录
            if (!ftp.changeWorkingDirectory(filePath)) {
                //如果目录不存在创建目录
                String[] dirs = filePath.split("/");
                //改进方法
            	//String[] dirs = filePath.split("[/\\]");
            	for (String dir : dirs) {
                    if (null == dir || "".equals(dir)) continue;
                    if (!ftp.changeWorkingDirectory(dir)) {
                        if (!ftp.makeDirectory(dir)) {
                            return false;
                        } else {
                            ftp.changeWorkingDirectory(dir);
                        }
                    }
                }
            }
            //设置上传文件的类型为二进制类型
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            //上传文件
            if (!ftp.storeFile(filename, input)) {
                return false;
            }
            input.close();
            ftp.logout();
            result = true;
        } catch (IOException e) {
            logger.error(e.getMessage());
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ignored) {
                }
            }
        }
        return result;
    }

    public void setHost(String host) {
        FtpUtil.host = host;
    }

    public void setPort(int port) {
        FtpUtil.port = port;
    }

    public void setUsername(String username) {
        FtpUtil.username = username;
    }

    public void setPassword(String password) {
        FtpUtil.password = password;
    }
}

package cn.wtu.broadcast.openapi.util;

import java.io.File;

/**
 * @description:
 * @author: AYY
 * @date: 2019-01-10 0:03
 */
public class FileOperate {

    /**
     * 删除文件方法
     * @param fileUrl 项目路径名
     * @param dbPath  数据库存储文件路径
     * @return
     */
    public static boolean deleteFile(String fileUrl,String dbPath){
        String path = fileUrl + dbPath.substring(dbPath.lastIndexOf(File.separator),dbPath.length());
        File file = new File(path);
        if(file.exists()&&file.isFile()){
            file.delete();
            return true;
        }else{
            return false;
        }
    }
}

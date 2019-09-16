package cn.wtu.broadcast.util;

/**
 * @description:ip流开播工具类
 * @author: AYY
 * @date: 2019-02-17 14:43
 */
public class IPToll {

    public static String getMessageLevel(Integer id){   //字典表里映射的消息级别的id
        if(id==12){
            return "01";
        }else if(id==13){
            return "02";
        }else if(id==14){
            return "03";
        }else if(id==15){
            return "04";
        }
        return null;
    }

}

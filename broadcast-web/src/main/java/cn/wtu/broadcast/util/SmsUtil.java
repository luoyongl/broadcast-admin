package cn.wtu.broadcast.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.wtu.broadcast.config.SystemConfig;
import cn.wtu.broadcast.parent.enums.SmsResponseEnum;

/**
 * 短信工具类
 *
 * @author sueua
 * @since 2019-02-15
 */
public class SmsUtil {

    private static final Logger log = LoggerFactory.getLogger(SmsUtil.class);

    public static void main(String[] args) {
        SmsResponseEnum smsResponseEnum = send("13800000000", "哈哈哈");
        System.out.println(smsResponseEnum);
    }

    /**
     * 发送短信
     *
     * @param mobile 手机号码,多个以分号隔开
     * @param text   短信内容
     * @return 发送结果
     */
    public static SmsResponseEnum send(String mobile, String text) {
        String ip = SystemConfig.get("sms_server_ip");
        String port = SystemConfig.get("sms_server_port");
        String username = SystemConfig.get("sms_server_username");
        String password = SystemConfig.get("sms_server_password");
        Socket socket = null;
        try {
            socket = new Socket(ip, Integer.valueOf(port));
            socket.setSoTimeout(5000);
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("username=" + username + "&password=" + password + "&destmobile=" + mobile + "&text=" + text);
            String response = input.readUTF();
            out.close();
            input.close();
            return SmsResponseEnum.getEnum(response);
        } catch (ConnectException e) {
            return SmsResponseEnum.TIMEOUT;
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return SmsResponseEnum.ERROR;
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    log.error("短信连接关闭异常", e);
                }
            }
        }
    }
}

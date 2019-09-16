package cn.wtu.broadcast;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;

public class PasswordTest {

    /**
     * 获取加密密码
     */
    @Test
    public void getPassword() {
        String userName = "admin";
        String password = "admin";
        SimpleHash simpleHash = new SimpleHash("md5",password, ByteSource.Util.bytes(userName), 10);
        System.out.println(simpleHash.toHex());
    }
    
}

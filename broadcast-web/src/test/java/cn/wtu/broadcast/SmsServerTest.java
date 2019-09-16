package cn.wtu.broadcast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * 短信设备模拟
 *
 * @author sueua
 * @since 2019-02-15
 */
public class SmsServerTest {

    /**
     * 监听的端口
     */
    private static final int PORT = 9000;

    private static final String[] response = new String[]{"Send OK", "No Card", "No Register"};

    public static void main(String[] args) {
        System.out.println("启动短信服务");
        SmsServerTest server = new SmsServerTest();
        server.init();
    }

    private void init() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            //noinspection InfiniteLoopStatement
            while (true) {
                //一旦有堵塞，表示服务器与客户端获得了连接
                Socket client = serverSocket.accept();
                new HandlerThread(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class HandlerThread implements Runnable {

        private Socket socket;

        HandlerThread(Socket socket) {
            this.socket = socket;
            new Thread(this).start();
        }

        @Override
        public void run() {
            try {
                //读取客户端数据
                DataInputStream input = new DataInputStream(socket.getInputStream());
                //这里要注意和客户端输出流的写方法对应,否则会抛 EOFException
                String clientInputStr = input.readUTF();
                //处理客户端发送的数据
                System.out.println("客户端发过来的内容：" + clientInputStr);
                //想客户端发送消息
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF(response[new Random().nextInt(response.length)]);
                out.close();
                input.close();
            } catch (IOException e) {
                System.out.println("服务器异常：" + e.getMessage());
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (Exception e) {
                        socket = null;
                        System.out.println("服务端 finally 异常:" + e.getMessage());
                    }
                }
            }
        }
    }

}

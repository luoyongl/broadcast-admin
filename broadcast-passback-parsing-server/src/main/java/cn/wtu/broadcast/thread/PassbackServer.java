package cn.wtu.broadcast.thread;

import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.codec.string.StringEncoder;

public class PassbackServer implements Runnable {

	private static Logger logger = LoggerFactory.getLogger(PassbackServer.class);

	private final int port;

	public PassbackServer(int port) {
		this.port = port;
	}

	@Override
	public void run() {
		try {
			EventLoopGroup bossGroup = new NioEventLoopGroup();
			EventLoopGroup group = new NioEventLoopGroup();
			try {
				ServerBootstrap sb = new ServerBootstrap();
				sb.option(ChannelOption.SO_BACKLOG, 1024);
				sb.group(group, bossGroup) // 绑定线程池
						.channel(NioServerSocketChannel.class) // 指定使用的channel
						.localAddress(this.port)// 绑定监听端口
						.childHandler(new ChannelInitializer<SocketChannel>() { // 绑定客户端连接时候触发操作
							@Override
							protected void initChannel(SocketChannel ch) throws Exception {
								logger.info("客户端IP:{} Port:{}链接到本服务端", ch.localAddress().getHostName(),
										ch.localAddress().getPort());
								ch.pipeline().addLast(new StringEncoder(Charset.forName("UTF-8")));
								ch.pipeline().addLast(new PassbackServerHandler()); // 客户端触发操作
								ch.pipeline().addLast(new ByteArrayEncoder());
							}
						});
				ChannelFuture cf = sb.bind().sync(); // 服务器异步创建绑定
				logger.info(PassbackServer.class + " 启动正在监听： " + cf.channel().localAddress());
				cf.channel().closeFuture().sync(); // 关闭服务器通道
			} finally {
				group.shutdownGracefully().sync(); // 释放线程池资源
				bossGroup.shutdownGracefully().sync();
			}
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
	}

	public static void main(String[] args) throws Exception {
		new Thread(new PassbackServer(8889)).start();
	}
}

package cn.wtu.broadcast.openapi.common;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.wtu.broadcast.openapi.model.BDeviceInfo;
import cn.wtu.broadcast.parent.utils.redis.RedisDb;
import cn.wtu.broadcast.parent.utils.redis.Tool;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {

	private static Logger logger = LoggerFactory.getLogger(NettyServer.class);

	public static Boolean start(String resourceCode, byte[] array) throws Exception {
		Boolean result = false;
		BDeviceInfo bDeviceInfo = Tool.ByteToObject(RedisDb.getObject((resourceCode).getBytes()), BDeviceInfo.class);
		String ip = null;
		Integer port = null;
		if (bDeviceInfo != null) {
			ip = bDeviceInfo.getfDeviceIp();
			port = Integer.valueOf(bDeviceInfo.getfDevicePort());
			EventLoopGroup group = new NioEventLoopGroup();
			try {
				Bootstrap bootstrap = new Bootstrap();
				bootstrap.group(group) // 注册线程池
						.channel(NioSocketChannel.class) // 使用NioSocketChannel来作为连接用的channel类
						.remoteAddress(new InetSocketAddress(ip, port)) // 绑定连接端口和host信息
						.handler(new ChannelInitializer<SocketChannel>() { // 绑定连接初始化器
							@Override
							protected void initChannel(SocketChannel ch) throws Exception {
								logger.info("connected...");
								ch.pipeline().addLast(new NettyClientHandler());
							}
						});
				// 设置了 CONNECT_TIMEOUT_MILLIS 属性, 超时时, 自然连接就断开
				bootstrap.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000);
				// 异步连接服务器并且发送数据
				logger.info("created..");
				ChannelFuture cf = null;
				try {
					cf = bootstrap.connect().sync();
					logger.info("connected..."); // 连接完成
					cf.channel().writeAndFlush(Unpooled.copiedBuffer(array));
					//cf.channel().close().sync();
					cf.channel().closeFuture().sync(); // 异步等待关闭连接channel
					logger.info("closed.."); // 关闭完成
					result = true;
				} catch (Exception e) {
					logger.error("无法连接到 {}:{}", ip, port);
					throw new RuntimeException();
				}
			} finally {
				group.shutdownGracefully().sync(); // 释放线程池资源
			}
		} else {
			logger.error("适配器数据缓存中获取不到");
		}
		
		return result;
	}

	public static void main(String[] args) throws Exception {

	}
}

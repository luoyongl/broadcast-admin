package cn.wtu.broadcast.openapi.common;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.wtu.broadcast.openapi.api.BBroadcastDataService;
import cn.wtu.broadcast.openapi.dao.extend.BBroadcastDataExtMapper;
import cn.wtu.broadcast.openapi.thread.SendIPAudioThread;
import cn.wtu.broadcast.openapi.util.SendIPUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

@Component
public class NettyClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

	private static Logger logger = LoggerFactory.getLogger(NettyClientHandler.class);
	public static NettyClientHandler echoTCPClientHandler;
	
	@Autowired
	private BBroadcastDataService broadcastService;
	
	@Autowired
	private BBroadcastDataExtMapper broadcastDataExtMapper;
	/**
	 * 2.初始化构造方法一定要有
	 */
	public NettyClientHandler(){
	}
	
	/**
	 * 3.容器初始化的时候进行执行-这里是重点
	 */
	@PostConstruct
	public void init() {
		echoTCPClientHandler = this;
		echoTCPClientHandler.broadcastService = this.broadcastService;
		echoTCPClientHandler.broadcastDataExtMapper = this.broadcastDataExtMapper;
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.info("client channelActive..");
		ctx.writeAndFlush(Unpooled.copiedBuffer("", CharsetUtil.UTF_8)); // 必须有flush
		// ctx.channel().close().sync();
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
		logger.info("client channelRead..");
		// TODO 解析适配器的回复内容（待定）
		ByteBuf buf = msg.readBytes(msg.readableBytes());
		logger.info("Client received:" + ByteBufUtil.hexDump(buf));
		String answer = ByteBufUtil.hexDump(buf);

		if ("50".equals(answer.substring(0, 2))) {
			// 业务数据类型
			String serviceType = answer.substring(6, 8);
			//开停播请求回复
			if ("17".equals(serviceType)) {
				// String adapterCode = answer.substring(18, 42); // 示例 "f64514021022030314010201"  
				//消息头有18字节
				String ebmId = answer.substring(42, 78);
				String fId = ebmId.substring(32, 36);
				String result = answer.substring(78, 80);
				String resultDetailLen = answer.substring(80, 88);
				if ("00".equals(result)) {
					String acceptStreamAddressLen = answer.substring(88 + Integer.parseInt(resultDetailLen, 16) * 2,
							88 + Integer.parseInt(resultDetailLen, 16) * 2 + 4);
					String acceptStreamAddress = answer.substring(88 + Integer.parseInt(resultDetailLen, 16) * 2 + 4,
							88 + Integer.parseInt(resultDetailLen, 16) * 2 + 4
									+ Integer.parseInt(acceptStreamAddressLen, 16) * 2);
					System.out.println(SendIPUtils.asciiToString(acceptStreamAddress));
					String[] b = SendIPUtils.asciiToString(acceptStreamAddress).split(":");
					String ip = b[1].substring(2);
					String port = b[2];
					Thread sendIPThread = new Thread(new SendIPAudioThread(Integer.parseInt(fId), ip, port,echoTCPClientHandler.broadcastService,echoTCPClientHandler.broadcastDataExtMapper));
					sendIPThread.start();
				}
			}else if("12".equals(serviceType)){
				String resultCode = answer.substring(18,26);
				if(Integer.parseInt(resultCode)==0){
					//TODO代表请求执行成功  如何返回给前端？
				}
			}
		}

		ctx.channel().close().sync();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
		logger.error(cause.getMessage() + cause);
	}
}

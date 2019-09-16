package cn.wtu.broadcast.openapi.common;

import java.util.Iterator;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.wtu.broadcast.openapi.api.BDeviceInfoService;
import cn.wtu.broadcast.openapi.api.TaskReportInstructionService;
import cn.wtu.broadcast.openapi.model.BDeviceInfo;
import cn.wtu.broadcast.openapi.protocol.ProtocolReplyCommonData;
import cn.wtu.broadcast.openapi.protocol.ProtocolTotalInfoUtil;
import cn.wtu.broadcast.openapi.protocol.ReplyProtocolTools;
import cn.wtu.broadcast.openapi.protocol.body.adapter.report.Protocol0x18Body;
import cn.wtu.broadcast.openapi.protocol.enums.ProtocolTypeEnum;
import cn.wtu.broadcast.openapi.util.Ipdata;
import cn.wtu.broadcast.openapi.util.SendIPUtils;
import cn.wtu.broadcast.openapi.util.UDPUtil;
import cn.wtu.broadcast.openapi.vo.TaskReportInstructionVO;
import cn.wtu.broadcast.parent.enums.DeviceStateEnum;
import cn.wtu.broadcast.parent.utils.redis.RedisDb;
import cn.wtu.broadcast.parent.utils.redis.Tool;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;
import net.sf.json.JSONObject;

@Component
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

	private static Logger logger = LoggerFactory.getLogger(NettyServerHandler.class);

	public static NettyServerHandler echoTCPServerHandler;

	/**
	 * 1.正常注入[记得主类也需要使用@Component注解]
	 */
	@Autowired
	private BDeviceInfoService bdeviceInfoService;
	
	/**
	 * 注入任务上报实现接口
	 * @since 7.15
	 */
	@Autowired
	private TaskReportInstructionService taskReportInstructionService;

	/**
	 * 2.初始化构造方法一定要有
	 */
	public NettyServerHandler() {
	}

	/**
	 * 3.容器初始化的时候进行执行-这里是重点
	 */
	@PostConstruct
	public void init() {
		echoTCPServerHandler = this;
		echoTCPServerHandler.bdeviceInfoService = this.bdeviceInfoService;
	}

	/*
	 * channelAction channel 通道 action 活跃的 当客户端主动链接服务端的链接后，这个通道就是活跃的了
	 * 也就是客户端与服务端建立了通信通道并且可以传输数据
	 *
	 */
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.info(ctx.channel().localAddress().toString() + " 通道已激活！");
	}

	/*
	 * channelInactive channel 通道 Inactive 不活跃的 当客户端主动断开服务端的链接后，这个通道就是不活跃的
	 * 也就是说客户端与服务端的关闭了通信通道并且不可以传输数据
	 *
	 */
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		logger.info(ctx.channel().localAddress().toString() + " 通道已断开！");
		ctx.close();
		removeDisconnectCtx(ctx);
	}

	/**
	 * 功能：读取服务器发送过来的信息
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		if (null == ctx || msg == Unpooled.EMPTY_BUFFER) {
			ReferenceCountUtil.release(msg);
			return;
		}
		// 第一种：接收字符串时的处理
		ByteBuf buf = (ByteBuf) msg;
		try {
			byte[] receiveMsgBytes = new byte[buf.readableBytes()];
			
			// 适配器回复解析操作 添加操作任务上报回复 @since 7.15
			ProtocolReplyCommonData protocolReplyCommonData = new ProtocolReplyCommonData();
			String protocolType = ReplyProtocolTools.getProtocolType(receiveMsgBytes);
			ProtocolTypeEnum protocolTypeEnum = ProtocolTypeEnum.getEnumByCode(protocolType);
			if (protocolTypeEnum.equals(ProtocolTypeEnum.Protocol0x18Body)){
				ProtocolTotalInfoUtil.parseProtocol0x18Data(protocolReplyCommonData, receiveMsgBytes);
			}
			//调用数据封装VO的方法
			protocolReplyToTaskReportInstructionVO(protocolReplyCommonData);
			
			//下面还是原来心跳处理
			buf.readBytes(receiveMsgBytes);
			String answer = UDPUtil.byteToHex(receiveMsgBytes);
			logger.info("服务器收到客服端数据:" + answer);
			// 管理web平台心跳处理
			if ("8888".equals(answer.substring(0, 4))) {
				ctx.channel().writeAndFlush(UDPUtil.hexToByte("8888"));
				// 设备交互相关数据处理
			}else if ("50".equals(answer.substring(0, 2))) {
				// 业务数据类型
				String serviceType = answer.substring(6, 8);
				// 若为心跳，则回复一般应答
				if ("20".equals(serviceType)) {
					String resourceCodeLen = answer.substring(18, 20);
					String resourceCode = answer.substring(21, 20 + Integer.parseInt(resourceCodeLen, 16) * 2); // 第20位为F?
					
					ChannelHandlerContext channelHandlerContext = SendIPUtils.ctxMap.get(resourceCode);
					// 第一次心跳进来或者设备心跳断开后重连后要更新map里面的相关值
					if (channelHandlerContext == null
							|| (channelHandlerContext != null && channelHandlerContext.isRemoved())) {
						// 保存设备上下文通道(供页面播放等功能使用)
						SendIPUtils.ctxMap.put(resourceCode, ctx);
						SendIPUtils.answerMap.put(resourceCode, answer);
					}
					
					BDeviceInfo bDeviceInfo = Tool.ByteToObject(RedisDb.getObject((resourceCode).getBytes()),
							BDeviceInfo.class);
					if (bDeviceInfo == null) {
						BDeviceInfo device = echoTCPServerHandler.bdeviceInfoService
								.getDeviceBySourceCode(resourceCode);
						RedisDb.setObject((resourceCode).getBytes(), Tool.ObjectToByte(device));
					}

					Ipdata.heartControl( answer);
					// 根据设备心跳更新适配器状态
					String deviceState = answer.substring(44, 46);
					String key = resourceCode;
					// 若缓存中没有该设备状态或者设备状态与缓存中不一样，则更新设备状态
					if (!SendIPUtils.deviceStateMap.containsKey(key) || SendIPUtils.deviceStateMap.get(key) == null
							|| (SendIPUtils.deviceStateMap.get(key) != null
									&& !deviceState.equals(SendIPUtils.deviceStateMap.get(key)))) {
						DeviceStateEnum updateState = null;
						if ("01".equals(deviceState)) {
							updateState = DeviceStateEnum.online;
						} else if ("02".equals(deviceState)) {
							updateState = DeviceStateEnum.broadcasting;
						} else if ("03".equals(deviceState)) {
							updateState = DeviceStateEnum.malfunction;
						}
						// 更新该设备状态
						Boolean updateResult = echoTCPServerHandler.bdeviceInfoService.updateDeviceStateBySourceCode(
								key, Byte.valueOf(String.valueOf(updateState.getCode())));
						logger.info("设备{" + key + "}更新为" + updateState.name() + "处理结果：{" + updateResult + "}");
						SendIPUtils.deviceStateMap.put(key, deviceState);
					}
				}
			}
		} finally {
			ReferenceCountUtil.release(buf);
		}
	}
	
	/**
	 * 功能：将任务上报数据进行VO类封装
	 */
	public void protocolReplyToTaskReportInstructionVO(ProtocolReplyCommonData protocolReplyCommonData){
		TaskReportInstructionVO taskReportInstructionVO = new TaskReportInstructionVO();
		//转为json字符串
		String protocolReply = JSONObject.fromObject(protocolReplyCommonData).toString();
		taskReportInstructionVO.setProtocolReply(protocolReply);
		Protocol0x18Body protocol0x18Body = (Protocol0x18Body)protocolReplyCommonData.getData();
		//a :23个数字码 --> 设备广播对应设备id
		taskReportInstructionVO.setDeviceResourcecode(protocol0x18Body.getReserved_and_front_code());
		//b: 应急广播类型 --> 广播类型：枚举（应急，日常等等）
		taskReportInstructionVO.setBroadcastType(protocol0x18Body.getEbm_class());
		//c:应急广播事件级别 -->消息级别（字典id）
		taskReportInstructionVO.setMessageLevel(protocol0x18Body.getEbm_level());
		//d:应急广播事件类型 -->消息类型（字典id）
		taskReportInstructionVO.setMessageType(protocol0x18Body.getEbm_type());
		//e:program_resource --> 消息来源（枚举）
		taskReportInstructionVO.setMessageSource(protocol0x18Body.getProgram_resource());
		
		//调用接口进行数据存库
		try {
			taskReportInstructionService.taskReturnToStorage(taskReportInstructionVO);			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * 功能：读取完毕客户端发送过来的数据之后的操作
	 */
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		// 第一种方法：写一个空的buf，并刷新写出区域。完成后关闭sock channel连接
		ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
		logger.info("服务端接收数据完毕..");
	}

	/**
	 * 功能：服务端发生异常的操作
	 */
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		ctx.close();
		logger.error(cause.getMessage() + cause);
		removeDisconnectCtx(ctx);
	}

	/**
	 * 可以根据事件类型进行相应的处理 服务端重点关注读超时
	 */
	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		if (evt instanceof IdleStateEvent) {
			IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
			switch (idleStateEvent.state()) {
			case READER_IDLE:
				ctx.close();
				removeDisconnectCtx(ctx);
				break;
			default:
				break;
			}
		}
	}

	private void removeDisconnectCtx(ChannelHandlerContext ctx) {
		Iterator<String> keyIterator = SendIPUtils.ctxMap.keySet().iterator();
		synchronized (keyIterator) {
			while (keyIterator.hasNext()) {
				String key = keyIterator.next();
				ChannelHandlerContext channelHandlerContext = SendIPUtils.ctxMap.get(key);
				// 如果播放列表中对应广播数据已经没有了，证明已经播放完成了，开始执行停播指令
				if (channelHandlerContext.equals(ctx)) {
					keyIterator.remove();
				}
				// 更新该设备为离线状态
				Boolean updateResult = echoTCPServerHandler.bdeviceInfoService.updateDeviceStateBySourceCode(key,
						Byte.valueOf(String.valueOf(DeviceStateEnum.offline.getCode())));
				SendIPUtils.deviceStateMap.remove(key);
				logger.info("设备{}更新为离线处理结果：{}", key, updateResult);
			}
		}
	}
}

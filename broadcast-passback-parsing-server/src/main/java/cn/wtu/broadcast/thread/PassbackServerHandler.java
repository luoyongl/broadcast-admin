package cn.wtu.broadcast.thread;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.wtu.broadcast.entity.PassbackBodyData;
import cn.wtu.broadcast.entity.PassbackHeadData;
import cn.wtu.broadcast.entity.PassbackTotalData;
import cn.wtu.broadcast.entity.body.PassbackBody0x11Data;
import cn.wtu.broadcast.entity.body.PassbackBody0x11Data.queryContext;
import cn.wtu.broadcast.entity.body.PassbackBody0x11Data.queryContext.frequencyList;
import cn.wtu.broadcast.openapi.api.BDeviceInfoService;
import cn.wtu.broadcast.openapi.api.ReplyInstructionService;
import cn.wtu.broadcast.openapi.model.BDeviceReturnInfo;
import cn.wtu.broadcast.openapi.util.UDPUtil;
import cn.wtu.broadcast.openapi.vo.ReplyInstructionVO;
import cn.wtu.broadcast.util.PassbackParsingUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.ReferenceCountUtil;
import net.sf.json.JSONObject;

@Component
public class PassbackServerHandler extends ChannelInboundHandlerAdapter {

	private static Logger logger = LoggerFactory.getLogger(PassbackServerHandler.class);

	public static PassbackServerHandler echoTCPServerHandler;

	/**
	 * 1.正常注入[记得主类也需要使用@Component注解]
	 */
	@Autowired
	private BDeviceInfoService bdeviceInfoService;
	
	/**
	 * 回传服务器存库接口
	 */
	@Autowired
	private ReplyInstructionService replyInstructionService;

	/**
	 * 2.初始化构造方法一定要有
	 */
	public PassbackServerHandler() {
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
			buf.readBytes(receiveMsgBytes);
			String answer = UDPUtil.byteToHex(receiveMsgBytes);
			logger.info("服务器收到客服端数据:" + answer);
			if ("8888".equals(answer.substring(0, 4))) {
				// 管理web平台心跳处理
				ctx.channel().writeAndFlush(UDPUtil.hexToByte("8888"));
			} else {
				// 设备交互相关数据处理
				PassbackTotalData parseData = PassbackParsingUtil.parseData(receiveMsgBytes);
				passbackTotalDataToVo(parseData);
				PassbackBodyData body = parseData.getBody();
				if(Integer.valueOf(body.getDataType()) == 0x11){
					//封装BDeviceRetrunInfo,并调用接口
					dataRespondToBDeviceRetrunInfo(body);
				}
			}
		} finally {
			ReferenceCountUtil.release(buf);
		}
	}
	
	/**
	 * 功能:把数据封装到replyInstructionVO中
	 */
	public void passbackTotalDataToVo(PassbackTotalData parseData){
		//准备传递回复VO
		ReplyInstructionVO replyInstructionVO = new ReplyInstructionVO();
		//取出消息头
		PassbackHeadData head = parseData.getHead();
		//包头标记
		replyInstructionVO.setfHeadmark(head.getHeadMark());
		//协议版本号
		replyInstructionVO.setfVersion(head.getVersion());
		//会话标识
		replyInstructionVO.setfTag(head.getTag());
		//数据包类型
		replyInstructionVO.setfPacktype(head.getPackType());
		
		//取出消息体
		PassbackBodyData body = parseData.getBody();
		//数据源对象编码
		replyInstructionVO.setfSource(body.getSource());
		//业务数据类型
		replyInstructionVO.setfDatatype(body.getDataType());
		
		//字符串格式下的json数据
		replyInstructionVO.setfRespondInstructions(JSONObject.fromObject(parseData).toString());
		
		//调用回复指令接口
		try {
			replyInstructionService.addReplyInstructionToStorage(replyInstructionVO);			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * 功能：将查询指令应答消息体的数据封装BDeviceRetrunInfo
	 */
	public void dataRespondToBDeviceRetrunInfo(PassbackBodyData body){
		PassbackBody0x11Data data = (PassbackBody0x11Data)body;
		List<queryContext> context = data.getContext();
		//首先需要进行删除操作,以便数据保持最新状态
		try {
			replyInstructionService.deleteDataByResourceCode(data.getSource());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		for (queryContext queryContext : context) {
			BDeviceReturnInfo bDeviceReturnInfo = new BDeviceReturnInfo();
			//1.数据源对象编码
			bDeviceReturnInfo.setfResourceCode(data.getSource());
			//2.终端音量
			bDeviceReturnInfo.setfTerminalVolume(queryContext.getLocalVolume());
			//3.本地地址(通过指令解析拼接获得)
			String localAddress = queryContext.getLocalIpaddr() + ":" + queryContext.getLocalNetmask() + ":" + queryContext.getLocalGateway();
			bDeviceReturnInfo.setfLocalAddress(localAddress);
			//4.回传地址(通过判断的方式获得)
			if (Integer.valueOf(queryContext.getAddressType()) == 0x01) {
				//如果第一个 字节 为 0x01 ，表示 采用方式一， IPIP 4 字节 端口(2字节)
				String returnAddress = queryContext.getBackPort() + ":" + queryContext.getBackIpaddr();
				bDeviceReturnInfo.setfReturnAddress(returnAddress);
			}else if (Integer.valueOf(queryContext.getAddressType()) == 0x02) {
				//采用方式 二 第二个 字节 标记域名长度 n 域名 n
				bDeviceReturnInfo.setfReturnAddress(queryContext.getBackHost());
			}else if (Integer.valueOf(queryContext.getAddressType()) == 0x03) {
				//方式三，随后的第二字节表示短信号码的长度
				bDeviceReturnInfo.setfReturnAddress(queryContext.getBackPhone());
			}
			//5.终端资源编码
			bDeviceReturnInfo.setfTerminalResourceCode(queryContext.getLocalSource());
			//6.物理地址编码
			bDeviceReturnInfo.setfPhysicalAddressCode(queryContext.getLocalPhysicsAddress());
			//7.工作状态
			bDeviceReturnInfo.setfWorkingCondition(queryContext.getLocalWorkState());
			//8.故障代码
			bDeviceReturnInfo.setfFaultCode(queryContext.getFaultCode());
			//9.设备类型 10.硬件版本号 11.软件版本号 指令没有给出相应字段
			//12.调频信号状态 13.有线信号状态 14.地面无线信号状态
			String fmSignalStatus = queryContext.getSignalStrength() + ":" + queryContext.getSignalQuality();
			bDeviceReturnInfo.setfFmSignalStatus(fmSignalStatus);
			//15.有线频率 16.地面无线频率
			bDeviceReturnInfo.setfCableFrequency(queryContext.getFrequency());
			//17.FM频点扫描列表
			List<frequencyList> frequencyList = queryContext.getFrequencyList();
			String totalList = "";
			for (frequencyList list : frequencyList) {
				String oneList = list.getFrequencyIndex() + ":" + list.getFrequencyPriority();
				totalList += oneList + ";";
			}
			totalList = totalList.substring(0, totalList.length()-1);
			bDeviceReturnInfo.setfFmFrequencyScanList(totalList);
			//18.FM当前频点
			String point = queryContext.getFrequencyContrl() + ":" + queryContext.getFrequencyChannel();
			bDeviceReturnInfo.setfFmCurrentFrequencyPoint(point);
			//19.FM维持指令模式
			String mode = queryContext.getKeepEnable() + ":" + queryContext.getKeepCycle();
			bDeviceReturnInfo.setfFmMaintenanceInstructionMode(mode);
			
			//封装完毕，调用存库接口
			try {
				replyInstructionService.addReplyInstructionToDeviceReturnInfo(bDeviceReturnInfo);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
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
				break;
			default:
				break;
			}
		}
	}
}

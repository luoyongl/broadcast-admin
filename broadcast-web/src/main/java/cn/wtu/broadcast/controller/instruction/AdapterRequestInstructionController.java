package cn.wtu.broadcast.controller.instruction;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wtu.broadcast.openapi.protocol.SendProtocolTools;
import cn.wtu.broadcast.openapi.protocol.body.adapter.control.Protocol0x0CBody;
import cn.wtu.broadcast.openapi.protocol.body.adapter.control.Protocol0x0DBody;
import cn.wtu.broadcast.openapi.protocol.body.adapter.control.Protocol0x0EBody;
import cn.wtu.broadcast.openapi.protocol.body.adapter.control.Protocol0x0FBody;
import cn.wtu.broadcast.openapi.protocol.body.adapter.control.Protocol0x10Body;
import cn.wtu.broadcast.openapi.protocol.body.adapter.control.Protocol0x11Body;
import cn.wtu.broadcast.openapi.protocol.body.adapter.control.Protocol0x41Body;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.parent.vo.cmd.CertificateIssueVo;

/**
 * 适配器请求指令Controller 平台发指令给适配器
 *
 * @since 2019-07-15
 */
@Controller
@RequestMapping("adapter/instruction")
public class AdapterRequestInstructionController {

	/**
	 * 白名单更新(0x0C)
	 */
	@RequestMapping("/updateWhiteList")
	@ResponseBody
	public BroadcastResult updateWhiteList() {
		Protocol0x0CBody protocol0x0CBody = new Protocol0x0CBody();

		// TODO 遍历赋值
		Protocol0x0CBody.WhiteList whiteList = null;
		try {
			whiteList = new Protocol0x0CBody.WhiteList((byte) 1, "17763066834".getBytes(),
					SendProtocolTools.string2Unicode("小李子"), (byte) 3);
		} catch (UnsupportedEncodingException e) {
			// 日志
		}
		whiteList.setPermissionAreaCodes(Arrays.asList("06341523100000,06341523100000".split(",")));
		protocol0x0CBody.whiteListInfos.add(whiteList);

		return null;
	}

	/**
	 * 回传参数设置(0x0D)
	 */
	@RequestMapping("/setAdapterReturnParameter")
	@ResponseBody
	public BroadcastResult setAdapterReturnParameter() {
		Protocol0x0DBody protocol0x0DBody = new Protocol0x0DBody(100000,"192.168.3.143",10086);

		return null;
	}

	/**
	 * 输出通道查询(0x0E)
	 */
	@RequestMapping("/outputChannelQuery")
	@ResponseBody
	public BroadcastResult outputChannelQuery() {
		Protocol0x0EBody protocol0x0EBody = new Protocol0x0EBody("43415230000000314010201", (byte) 1, (byte) 1);

		return null;
	}

	/**
	 * 输入通道查询(0x0F)
	 */
	@RequestMapping("/inputChannelQuery")
	@ResponseBody
	public BroadcastResult inputChannelQuery() {
		Protocol0x0FBody protocol0x0FBody = new Protocol0x0FBody("43415230000000314010201", (byte) 1, (byte) 1);

		return null;
	}

	/**
	 * 播发记录查询(0x10)
	 */
	@RequestMapping("/broadcastRecordQuery")
	@ResponseBody
	public BroadcastResult broadcastRecordQuery() {
		Protocol0x10Body protocol0x10Body = new Protocol0x10Body("43415230000000314010201",
				"FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF", (byte) 1, new Date(), new Date());
		return null;
	}
	
	/**
	 * 故障详情查询（0x11）
	 */
	@RequestMapping("/faultDetailQuery")
	@ResponseBody
	public BroadcastResult faultDetailQuery() {
		Protocol0x11Body protocol0x11Body = new Protocol0x11Body("43415230000000314010201");
		return null;
	}
	
	/**
	 * 适配器证书更新指令（0x41）
	 */
	@RequestMapping("/setAdapterUpdateCertificate")
	@ResponseBody
	public BroadcastResult setAdapterUpdateCertificate(){
		
		//终端证书下发 0x40
		Protocol0x41Body protocol0x41Body = new Protocol0x41Body();
		CertificateIssueVo certificateIssueVo = null;
		
		//path和SMSN从页面获取,且格式如下
		String path = "00000000131D.00000000131E";
		String SMSN = "00000000131C";
		try {
			certificateIssueVo = IssueCertificateTool.getCertificateIssueVo(path,SMSN);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        //获取证书链列表
		for (String string : certificateIssueVo.getCertificateLIST()) {
			byte[] certauth = SendProtocolTools.hexStringToByte(string);
			Protocol0x41Body.CertauthInfo certauthInfo = new Protocol0x41Body.CertauthInfo(certauth);
			protocol0x41Body.certauthInfos.add(certauthInfo);
		}
		
		//获取证书列表
		for (String string : certificateIssueVo.getCertCtx()) {
			byte[] certh = SendProtocolTools.hexStringToByte(string);
			Protocol0x41Body.CerthInfo certhInfo = new Protocol0x41Body.CerthInfo(certh);
			protocol0x41Body.certhInfos.add(certhInfo);
		}
				
		return null;
	}
}

package cn.wtu.broadcast.openapi.provider;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wtu.broadcast.openapi.api.TDictionaryService;
import cn.wtu.broadcast.openapi.api.ThirdBroadcastDataService;
import cn.wtu.broadcast.openapi.dao.TAdministrativeDivisionMapper;
import cn.wtu.broadcast.openapi.dao.extend.BBroadcastDataExtMapper;
import cn.wtu.broadcast.openapi.model.TAdministrativeDivision;
import cn.wtu.broadcast.openapi.model.TDictionary;
import cn.wtu.broadcast.openapi.util.UDPUtil;
import cn.wtu.broadcast.parent.vo.IpVO;

@Service("thirdBroadcastDataService")
public class ThirdBroadcastDataServiceImpl implements ThirdBroadcastDataService {
	@Autowired
	private BBroadcastDataExtMapper broadcastDataExtMapper;
	@Autowired
	private TDictionaryService tDictionaryService;
	@Autowired
	private TAdministrativeDivisionMapper administrativeDivisionMapper;
	
	
	@Override
	public IpVO getIpModelByBroadcastTypeAndId(Integer broadcastType, Integer fId) {
		IpVO ipvo = new IpVO();
		ipvo = broadcastDataExtMapper.queryIpvoData(fId);
		
		//TODO 如果节目信息是县级平台 或文转语 或话筒线路 则将BroadcastAudioUrl设为空  因为此时以上sql查出的节目音频信息是有问题的
		//00县级平台 01话筒线路 02文转语
		List<TDictionary> programChannelList = tDictionaryService.selectListByCriteria("program_channel");
		for (int i = 0; i < programChannelList.size(); i++){
			if("01".equals(programChannelList.get(i).getfThirdCode()) || "02".equals(programChannelList.get(i).getfThirdCode())
					|| "00".equals(programChannelList.get(i).getfThirdCode())){
				if(ipvo.getfProgramPass().equals(programChannelList.get(i).getfId().toString())){
					ipvo.setBroadcastAudioUrl(null);
				}
			}
		}
		String audioUrl = "";
		if(!ipvo.getfBroadcastStyle()){
			 audioUrl = "rtp://"+ipvo.getServiceIp()+":" +ipvo.getIpPlayPort() +"/vlc";
		}
		// 音频地址
		// String audioUrl = "rtsp://"+ipvo.getServiceIp()+":" +ipvo.getIpPlayPort() +"/vlc";
		ipvo.setAudioURL(audioUrl);
		ipvo.setBroadCastType("0" + ipvo.getBroadCastType());
		ipvo.setEventLevel("0" + ipvo.getEventLevel());
		// 用于存放 三方区域编码 
		List<String> resourceCodeList = new ArrayList<String>();
		if((ipvo.getEBM_resource_codes()) != null && StringUtils.isNotBlank(ipvo.getEBM_resource_codes())){
			// 将区域的id映射成 编码
			String[] strCodes = ipvo.getEBM_resource_codes().split(",");
			// 遍历strCodes,查询出 所有的编码	6	+ 410704000000	+0314	+01	+02	+01
			for (String str : strCodes) {
				TAdministrativeDivision division = administrativeDivisionMapper
						.selectByPrimaryKey(Integer.parseInt(str.trim()));
				resourceCodeList.add("6" + division.getfCode() + "0314" + "01" + "04" + "00");
			}
		}
		ipvo.setResourceCodeList(resourceCodeList);
		ipvo.setEventType(UDPUtil.stringToAscii(ipvo.getEventType()));
		
		String asciiUrl = UDPUtil.stringToAscii(audioUrl);
		int ascLen = asciiUrl.length();
		String len = getRealLenth(Integer.toHexString(ascLen / 2));
		ipvo.setLen(len);
		return ipvo;
	}
	public static String getRealLenth(String len) {
		if (len.length() == 1) {
			return "000" + len;
		} else if (len.length() == 2) {
			return "00" + len;
		} else if (len.length() == 3) {
			return "0" + len;
		} else {
			return len;
		}
	}

	
}

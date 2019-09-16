package cn.wtu.broadcast.openapi.provider;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.api.StaticticalTableService;
import cn.wtu.broadcast.openapi.dao.BBroadcastDataMapper;
import cn.wtu.broadcast.openapi.dao.extend.BBroadcastDataExtMapper;
import cn.wtu.broadcast.openapi.vo.BroadcastingVO;
import cn.wtu.broadcast.parent.utils.DateUtil;

@Service("staticticalTableService")
public class StaticticalTableServiceImpl implements StaticticalTableService {
	
	private static Logger logger = LoggerFactory.getLogger(StaticticalTableServiceImpl.class);
    @SuppressWarnings("unused")
	@Autowired
    private BBroadcastDataMapper bBroadcastDataMapper;

	@Autowired
	private BBroadcastDataExtMapper bBroadcastDataExtMapper;

/*    @Autowired
    private TDictionaryMapper tDictionaryMapper;
    @Autowired
    private BDeviceInfoMapper bDeviceInfoMapper;
    @Autowired
    private BCallandsmsRecordMapper bCallandsmsRecordMapper;*/
    
	@Override
	public Map<String, String[]> getBroTypePieInfo() {
		// TODO Auto-generated method stub
		Map<String, String[]> map= new HashMap<String,String[]>();
		String[] names = {"应急广播","日常广播","广播演练"};
		String[] values = new String[3];
		values[0] = String.valueOf(bBroadcastDataExtMapper.selectBroadcastTypeNum(4));		
		values[1] = String.valueOf(bBroadcastDataExtMapper.selectBroadcastTypeNum(5));
		values[2] = String.valueOf(bBroadcastDataExtMapper.selectBroadcastTypeNum(1)+bBroadcastDataExtMapper.selectBroadcastTypeNum(2)+bBroadcastDataExtMapper.selectBroadcastTypeNum(3));
		map.put("names", names);
		map.put("values", values);
		return map;
	}

	@Override
	public Map<String, String[]> getAveCoverageBarInfo() {
		// TODO Auto-generated method stub
		Map<String, String[]> map= new HashMap<String,String[]>();
		String[] names = {"一级","二级","三级","四级"};
		String[] values = new String[4];
		try {
			for(int i=0;i<4;i++){
				double value = bBroadcastDataExtMapper.sumResponceBroDeviceNumByMessageLevel(i+12)*100.0/bBroadcastDataExtMapper.sumBroDeviceNumByMessageLevel(i+12);
				if(Double.isNaN(value)||value==0){
					values[i] = "0";
				}else{
					DecimalFormat df = new DecimalFormat("#.00");
					values[i] = String.valueOf(df.format(value));
				}
			
			}		
			map.put("names", names);
			map.put("values", values);
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		
		return map;
	}

	@Override
	public Map<String, String[]> getAveAnswerTimeBarInfo() {
		// TODO Auto-generated method stub
		Map<String, String[]> map= new HashMap<String,String[]>();
		String[] names = {"一级","二级","三级","四级"};
		String[] values = new String[4];
		try {
			for(int i=0;i<4;i++){
				double value = bBroadcastDataExtMapper.sumTotalAnswerTimeByMessageLevel(i+12)*0.001/bBroadcastDataExtMapper.sumResponceBroDeviceNumByMessageLevel(i+12);
				if(Double.isNaN(value)||value==0){
					values[i] = "0";
				}else{
					DecimalFormat df = new DecimalFormat("#.00");
					values[i] = String.valueOf(df.format(value));
				}
			
			}		
			map.put("names", names);
			map.put("values", values);
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
		
		return map;
	}

	@Override
	public Map<String, String[]> getRealtimeBroInfo() {
		// TODO Auto-generated method stub
		Map<String, String[]> map= new HashMap<String,String[]>();
		String[] names = {"0时", "2时","4时","6时","8时","10时","12时","14时","16时","18时","20时","22时","24时"};
		String[] values = new String[13];
        values[0] = "0";
        int count=1;
        try {
    	    for (int index=0;index<24;index+=2){          
               values[count]=String.valueOf(bBroadcastDataExtMapper.sumBroNumBySendTime(DateUtil.getCustomTime(index), DateUtil.getCustomTime(index+2)));
               count++;
            }
            map.put("names", names);
       	    map.put("values", values);
		} catch (Exception e) {
			logger.error(e.getMessage() + e);
		}
     
		return map;
	}

	@Override
	public PageInfo<BroadcastingVO> getBroadcastingInfo(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
	    PageInfo<BroadcastingVO> result = null;
        try {
            PageHelper.startPage((Integer) paramMap.get("pageNumber"), (Integer) paramMap.get("pageSize"));
            List<BroadcastingVO> dataList = bBroadcastDataExtMapper.selectBroadcastingInfo(paramMap);
            if (dataList != null) {
                result = new PageInfo<>(dataList);
            }
        } catch (Exception e) {
            logger.error(e.getMessage() + e);
        }
        return result;
	}
    
	/*@Override
    public Map<String, String> selectStatisticalAllTab() {
        Map<String, String> map = new HashMap<>();

        //初始化map中的值
        map.put("Microphone",0+","+0);
        map.put("Line",0+","+0);
        map.put("UDisk",0+","+0);
        map.put("FrequencyModulation",0+","+0);
        map.put("TelephoneMessage",0+","+0);
        map.put("TextToLanguageConversion",0+","+0);
        //得到所有的设备通道编号
        TDictionaryExample tDictionaryExample = new TDictionaryExample();
        TDictionaryExample.Criteria criteria = tDictionaryExample.createCriteria();
        criteria.andFDictionaryCodeEqualTo("device_channel");
        criteria.andFDeleteFlagEqualTo(false);
        List<TDictionary> lDictionaryas = tDictionaryMapper.selectByExample(tDictionaryExample);
        //List<Integer> integerList = new ArrayList<>();

        //储存字典表中设备通道的三方回传编码
        //List<String> list5 = new ArrayList<>();
        Map<Integer, String> tMap = new HashMap<>();
        Iterator iterator = lDictionaryas.iterator();

        while (iterator.hasNext()){
            TDictionary tDictionary = new TDictionary();
            tDictionary = (TDictionary) iterator.next();
            tMap.put(tDictionary.getfId(), tDictionary.getfThirdCode());
            //list5.add(tDictionary.getfDictionaryCode());
            //integerList.add(tDictionary.getfId());
        }
        tMap.remove(43);

        Set setTDics = tMap.keySet();
        Iterator iterator6 = setTDics.iterator();
        List<BBroadcastData> listLines = new ArrayList<>(); //线路
        List<BBroadcastData> listFMs = new ArrayList<>(); //调频
        while(iterator6.hasNext()) {
            //字典表中的f_id
            Integer fId = (Integer) iterator6.next();
            //字典表中的f_third_code
            String thirdCode = tMap.get(fId);

            if(thirdCode.equals(String.valueOf(DeviceChannelThirdCodeEnum.Microphone.getCode()))){
                //话筒
                //查播发区域

                //广播数据表
                BBroadcastDataExample bBroadcastDataExample = new BBroadcastDataExample();
                BBroadcastDataExample.Criteria criteria1 = bBroadcastDataExample.createCriteria();
                criteria1.andFDeleteFlagEqualTo(false);
                criteria1.andFStateEqualTo((byte) BroadcastStateEnum.broadcasted.getCode());
                criteria1.andFPassSelectEqualTo(fId);
                List<BBroadcastData> list1 = bBroadcastDataMapper.selectByExample(bBroadcastDataExample);
                Iterator iterator1 = list1.iterator();

                //list2是存储广播数据表响应设备通道的播发区域（目前是查询设备通道为话筒的）
                List<String> list2 = new ArrayList<>();
                List<String> list3 = new ArrayList<>();

                while(iterator1.hasNext()){
                    BBroadcastData bBroadcastData = (BBroadcastData) iterator1.next();
                    list2.add(bBroadcastData.getfBroadcastArea());
                }

                Iterator iterator2 = list2.iterator();
                while(iterator2.hasNext()){
                    String l = (String) iterator2.next();
                    String [] m = l.split(",");
                    for (int i=0; i<m.length; i++){
                        list3.add(m[i]);
                    }
                }

                //定时广播表
                BBroadcastTimingExample bBroadcastTimingExample = new BBroadcastTimingExample();
                BBroadcastTimingExample.Criteria criteria6 = bBroadcastTimingExample.createCriteria();
                criteria6.andFDeleteFlagEqualTo(false);
                criteria6.andFDeviceChannelEqualTo(fId);
                // TODO 定时广播表状态的问题

                //list4 得到了所有的以话筒为设备通道的所有的播发区域，并去重、单个
                List<String> list4 = removeDuplicate(list3);

                //根据list中的每个区域对应找该区域的设备
                Iterator iterator3 = list4.iterator();
                int size = 0;
                int exceptionSize = 0;
                while(iterator3.hasNext()){
                    String area = (String) iterator3.next();
                    BDeviceInfoExample bDeviceInfoExample = new BDeviceInfoExample();
                    BDeviceInfoExample.Criteria criteria2 = bDeviceInfoExample.createCriteria();
                    criteria2.andFLocationEqualTo(Integer.valueOf(area));
                    //criteria2.andFEnableStateNotEqualTo(true);
                    //criteria2.andFEnableStateEqualTo(true);
                    criteria2.andFDeviceTypeEqualTo((byte) DeviceTypeEnum.terminalDevice.getCode());
                    List<BDeviceInfo> bDeviceInfos = bDeviceInfoMapper.selectByExample(bDeviceInfoExample);

                    //在该区域的异常设备数量
                    BDeviceInfoExample bDeviceInfoExample1 = new BDeviceInfoExample();
                    BDeviceInfoExample.Criteria criteria3 = bDeviceInfoExample1.createCriteria();
                    criteria3.andFLocationEqualTo(Integer.valueOf(area));
                    criteria3.andFEnableStateNotEqualTo(true);
                    criteria3.andFDeviceStateEqualTo((byte) DeviceStateEnum.malfunction.getCode());
                    BDeviceInfoExample.Criteria criteria4 = bDeviceInfoExample1.or();
                    criteria4.andFLocationEqualTo(Integer.valueOf(area));
                    criteria4.andFEnableStateNotEqualTo(true);
                    criteria4.andFDeviceStateEqualTo((byte) DeviceStateEnum.powerOutage.getCode());
                    List<BDeviceInfo> bDeviceInfos1 = bDeviceInfoMapper.selectByExample(bDeviceInfoExample1);
                    exceptionSize += bDeviceInfos1.size();


                    size += bDeviceInfos.size();
                }
                map.put("Microphone", (size+","+exceptionSize));
            }else if(thirdCode.equals(DeviceChannelThirdCodeEnum.LineOne.getCode()) || thirdCode.equals(DeviceChannelThirdCodeEnum.LineTwo.getCode())){
                //线路
                //查播发区域

                //广播数据表
                if(thirdCode.equals(DeviceChannelThirdCodeEnum.LineOne.getCode())){
                    BBroadcastDataExample bBroadcastDataExample = new BBroadcastDataExample();
                    BBroadcastDataExample.Criteria criteria1 = bBroadcastDataExample.createCriteria();
                    criteria1.andFDeleteFlagEqualTo(false);
                    criteria1.andFStateEqualTo((byte) BroadcastStateEnum.broadcasted.getCode());
                    criteria1.andFPassSelectEqualTo(fId);
                    List<BBroadcastData> list2 = bBroadcastDataMapper.selectByExample(bBroadcastDataExample);
                    listLines.addAll(list2);
                }else if(thirdCode.equals(DeviceChannelThirdCodeEnum.LineTwo.getCode())){
                    BBroadcastDataExample bBroadcastDataExample = new BBroadcastDataExample();
                    BBroadcastDataExample.Criteria criteria1 = bBroadcastDataExample.createCriteria();
                    criteria1.andFDeleteFlagEqualTo(false);
                    criteria1.andFStateEqualTo((byte) BroadcastStateEnum.broadcasted.getCode());
                    criteria1.andFPassSelectEqualTo(fId);
                    List<BBroadcastData> list3 = bBroadcastDataMapper.selectByExample(bBroadcastDataExample);
                    listLines.addAll(list3);
                }

                Iterator iterator1 = listLines.iterator();

                //list2是存储广播数据表响应设备通道的播发区域（目前是查询设备通道为话筒的）
                List<String> list2 = new ArrayList<>();
                List<String> list3 = new ArrayList<>();

                while(iterator1.hasNext()){
                    BBroadcastData bBroadcastData = (BBroadcastData) iterator1.next();
                    list2.add(bBroadcastData.getfBroadcastArea());
                }

                Iterator iterator2 = list2.iterator();
                while(iterator2.hasNext()){
                    String l = (String) iterator2.next();
                    String [] m = l.split(",");
                    for (int i=0; i<m.length; i++){
                        list3.add(m[i]);
                    }
                }

                //定时广播表
                BBroadcastTimingExample bBroadcastTimingExample = new BBroadcastTimingExample();
                BBroadcastTimingExample.Criteria criteria6 = bBroadcastTimingExample.createCriteria();
                criteria6.andFDeleteFlagEqualTo(false);
                criteria6.andFDeviceChannelEqualTo(fId);
                // TODO 定时广播表状态的问题

                //list4 得到了所有的以话筒为设备通道的所有的播发区域，并去重、单个
                List<String> list4 = removeDuplicate(list3);

                //根据list中的每个区域对应找该区域的设备
                Iterator iterator3 = list4.iterator();
                int size = 0;
                int exceptionSize = 0;
                while(iterator3.hasNext()){
                    String area = (String) iterator3.next();
                    BDeviceInfoExample bDeviceInfoExample = new BDeviceInfoExample();
                    BDeviceInfoExample.Criteria criteria2 = bDeviceInfoExample.createCriteria();
                    criteria2.andFLocationEqualTo(Integer.valueOf(area));
                    criteria2.andFDeviceTypeEqualTo((byte) DeviceTypeEnum.terminalDevice.getCode());
                    List<BDeviceInfo> bDeviceInfos = bDeviceInfoMapper.selectByExample(bDeviceInfoExample);

                    //在该区域的异常设备数量
                    BDeviceInfoExample bDeviceInfoExample1 = new BDeviceInfoExample();
                    BDeviceInfoExample.Criteria criteria3 = bDeviceInfoExample1.createCriteria();
                    criteria3.andFLocationEqualTo(Integer.valueOf(area));
                    criteria3.andFEnableStateNotEqualTo(true);
                    criteria3.andFDeviceStateEqualTo((byte) DeviceStateEnum.malfunction.getCode());
                    BDeviceInfoExample.Criteria criteria4 = bDeviceInfoExample1.or();
                    criteria4.andFLocationEqualTo(Integer.valueOf(area));
                    criteria4.andFEnableStateNotEqualTo(true);
                    criteria4.andFDeviceStateEqualTo((byte) DeviceStateEnum.powerOutage.getCode());
                    List<BDeviceInfo> bDeviceInfos1 = bDeviceInfoMapper.selectByExample(bDeviceInfoExample1);
                    exceptionSize += bDeviceInfos1.size();

                    size += bDeviceInfos.size();
                }
                map.put("Line", (size+","+exceptionSize));
            }else if(thirdCode.equals(DeviceChannelThirdCodeEnum.UDisk.getCode())){
                //U盘
                //查播发区域

                //广播数据表
                BBroadcastDataExample bBroadcastDataExample = new BBroadcastDataExample();
                BBroadcastDataExample.Criteria criteria1 = bBroadcastDataExample.createCriteria();
                criteria1.andFDeleteFlagEqualTo(false);
                criteria1.andFStateEqualTo((byte) BroadcastStateEnum.broadcasted.getCode());
                criteria1.andFPassSelectEqualTo(fId);
                List<BBroadcastData> list1 = bBroadcastDataMapper.selectByExample(bBroadcastDataExample);
                Iterator iterator1 = list1.iterator();

                //list2是存储广播数据表响应设备通道的播发区域（目前是查询设备通道为话筒的）
                List<String> list2 = new ArrayList<>();
                List<String> list3 = new ArrayList<>();

                while(iterator1.hasNext()){
                    BBroadcastData bBroadcastData = (BBroadcastData) iterator1.next();
                    list2.add(bBroadcastData.getfBroadcastArea());
                }

                Iterator iterator2 = list2.iterator();
                while(iterator2.hasNext()){
                    String l = (String) iterator2.next();
                    String [] m = l.split(",");
                    for (int i=0; i<m.length; i++){
                        list3.add(m[i]);
                    }
                }

                //定时广播表
                BBroadcastTimingExample bBroadcastTimingExample = new BBroadcastTimingExample();
                BBroadcastTimingExample.Criteria criteria6 = bBroadcastTimingExample.createCriteria();
                criteria6.andFDeleteFlagEqualTo(false);
                criteria6.andFDeviceChannelEqualTo(fId);
                // TODO 定时广播表状态的问题

                //list4 得到了所有的以话筒为设备通道的所有的播发区域，并去重、单个
                List<String> list4 = removeDuplicate(list3);

                //根据list中的每个区域对应找该区域的设备
                Iterator iterator3 = list4.iterator();
                int size = 0;
                int exceptionSize = 0;
                while(iterator3.hasNext()){
                    String area = (String) iterator3.next();
                    BDeviceInfoExample bDeviceInfoExample = new BDeviceInfoExample();
                    BDeviceInfoExample.Criteria criteria2 = bDeviceInfoExample.createCriteria();
                    criteria2.andFLocationEqualTo(Integer.valueOf(area));
                    criteria2.andFDeviceTypeEqualTo((byte) DeviceTypeEnum.terminalDevice.getCode());
                    List<BDeviceInfo> bDeviceInfos = bDeviceInfoMapper.selectByExample(bDeviceInfoExample);

                    //在该区域的异常设备数量
                    BDeviceInfoExample bDeviceInfoExample1 = new BDeviceInfoExample();
                    BDeviceInfoExample.Criteria criteria3 = bDeviceInfoExample1.createCriteria();
                    criteria3.andFLocationEqualTo(Integer.valueOf(area));
                    criteria3.andFEnableStateNotEqualTo(true);
                    criteria3.andFDeviceStateEqualTo((byte) DeviceStateEnum.malfunction.getCode());
                    BDeviceInfoExample.Criteria criteria4 = bDeviceInfoExample1.or();
                    criteria4.andFLocationEqualTo(Integer.valueOf(area));
                    criteria4.andFEnableStateNotEqualTo(true);
                    criteria4.andFDeviceStateEqualTo((byte) DeviceStateEnum.powerOutage.getCode());
                    List<BDeviceInfo> bDeviceInfos1 = bDeviceInfoMapper.selectByExample(bDeviceInfoExample1);
                    exceptionSize += bDeviceInfos1.size();

                    size += bDeviceInfos.size();

                }

                if(size == 0){
                    map.put("UDisk", (0+","+0));
                }else {
                    map.put("UDisk", (size+","+exceptionSize));
                }
            }else if(thirdCode.equals(DeviceChannelThirdCodeEnum.FrequencyModulationOne.getCode()) || thirdCode.equals(DeviceChannelThirdCodeEnum.FrequencyModulationTwo.getCode())){
                //调频
                //查播发区域

                //广播数据表
                if(thirdCode.equals(DeviceChannelThirdCodeEnum.LineOne.getCode())){
                    BBroadcastDataExample bBroadcastDataExample = new BBroadcastDataExample();
                    BBroadcastDataExample.Criteria criteria1 = bBroadcastDataExample.createCriteria();
                    criteria1.andFDeleteFlagEqualTo(false);
                    criteria1.andFStateEqualTo((byte) BroadcastStateEnum.broadcasted.getCode());
                    criteria1.andFPassSelectEqualTo(fId);
                    List<BBroadcastData> list2 = bBroadcastDataMapper.selectByExample(bBroadcastDataExample);
                    listFMs.addAll(list2);
                }else if(thirdCode.equals(DeviceChannelThirdCodeEnum.LineTwo.getCode())){
                    BBroadcastDataExample bBroadcastDataExample = new BBroadcastDataExample();
                    BBroadcastDataExample.Criteria criteria1 = bBroadcastDataExample.createCriteria();
                    criteria1.andFDeleteFlagEqualTo(false);
                    criteria1.andFStateEqualTo((byte) BroadcastStateEnum.broadcasted.getCode());
                    criteria1.andFPassSelectEqualTo(fId);
                    List<BBroadcastData> list3 = bBroadcastDataMapper.selectByExample(bBroadcastDataExample);
                    listFMs.addAll(list3);
                }

                Iterator iterator1 = listFMs.iterator();

                //list2是存储广播数据表响应设备通道的播发区域（目前是查询设备通道为话筒的）
                List<String> list2 = new ArrayList<>();
                List<String> list3 = new ArrayList<>();

                while(iterator1.hasNext()){
                    BBroadcastData bBroadcastData = (BBroadcastData) iterator1.next();
                    list2.add(bBroadcastData.getfBroadcastArea());
                }

                Iterator iterator2 = list2.iterator();
                while(iterator2.hasNext()){
                    String l = (String) iterator2.next();
                    String [] m = l.split(",");
                    for (int i=0; i<m.length; i++){
                        list3.add(m[i]);
                    }
                }

                //定时广播表
                BBroadcastTimingExample bBroadcastTimingExample = new BBroadcastTimingExample();
                BBroadcastTimingExample.Criteria criteria6 = bBroadcastTimingExample.createCriteria();
                criteria6.andFDeleteFlagEqualTo(false);
                criteria6.andFDeviceChannelEqualTo(fId);
                // TODO 定时广播表状态的问题

                //list4 得到了所有的以话筒为设备通道的所有的播发区域，并去重、单个
                List<String> list4 = removeDuplicate(list3);

                //根据list中的每个区域对应找该区域的设备
                Iterator iterator3 = list4.iterator();
                int size = 0;
                int exceptionSize=0;
                while(iterator3.hasNext()){
                    String area = (String) iterator3.next();
                    BDeviceInfoExample bDeviceInfoExample = new BDeviceInfoExample();
                    BDeviceInfoExample.Criteria criteria2 = bDeviceInfoExample.createCriteria();
                    criteria2.andFLocationEqualTo(Integer.valueOf(area));
                    criteria2.andFDeviceTypeEqualTo((byte) DeviceTypeEnum.terminalDevice.getCode());
                    List<BDeviceInfo> bDeviceInfos = bDeviceInfoMapper.selectByExample(bDeviceInfoExample);

                    //在该区域的异常设备数量
                    BDeviceInfoExample bDeviceInfoExample1 = new BDeviceInfoExample();
                    BDeviceInfoExample.Criteria criteria3 = bDeviceInfoExample1.createCriteria();
                    criteria3.andFLocationEqualTo(Integer.valueOf(area));
                    criteria3.andFEnableStateNotEqualTo(true);
                    criteria3.andFDeviceStateEqualTo((byte) DeviceStateEnum.malfunction.getCode());
                    BDeviceInfoExample.Criteria criteria4 = bDeviceInfoExample1.or();
                    criteria4.andFLocationEqualTo(Integer.valueOf(area));
                    criteria4.andFEnableStateNotEqualTo(true);
                    criteria4.andFDeviceStateEqualTo((byte) DeviceStateEnum.powerOutage.getCode());
                    List<BDeviceInfo> bDeviceInfos1 = bDeviceInfoMapper.selectByExample(bDeviceInfoExample1);
                    exceptionSize += bDeviceInfos1.size();

                    size += bDeviceInfos.size();
                }
                if(size == 0){
                    map.put("FrequencyModulation", (0+","+0));
                }else {
                    map.put("FrequencyModulation", (size+","+exceptionSize));
                }

            }else if(thirdCode.equals(DeviceChannelThirdCodeEnum.TelephoneMessage.getCode())){
                //电话短信
                BCallandsmsRecordExample bCallandsmsRecordExample = new BCallandsmsRecordExample();
                BCallandsmsRecordExample.Criteria criteria1 = bCallandsmsRecordExample.createCriteria();
                criteria1.andFDeleteFlagEqualTo(false);
                List<BCallandsmsRecord> list = bCallandsmsRecordMapper.selectByExample(bCallandsmsRecordExample);

                Iterator iterator1 = list.iterator();
                List<String> list1 = new ArrayList<>();
                List<String> list3 = new ArrayList<>();
                while(iterator1.hasNext()) {
                    BCallandsmsRecord bCallandsmsRecord = (BCallandsmsRecord) iterator.next();
                    String area = String.valueOf(bCallandsmsRecord.getfArea());
                    list1.add(area);
                }

                Iterator iterator2 = list1.iterator();
                while(iterator2.hasNext()){
                    String l = (String) iterator2.next();
                    String [] m = l.split(",");
                    for (int i=0; i<m.length; i++){
                        list3.add(m[i]);
                    }
                }

                //list4 得到了所有的以话筒为设备通道的所有的播发区域，并去重、单个
                List<String> list4 = removeDuplicate(list3);

                //根据list中的每个区域对应找该区域的设备
                Iterator iterator3 = list4.iterator();
                int size = 0;
                int exceptionSize=0;
                while(iterator3.hasNext()){
                    String area = (String) iterator3.next();
                    BDeviceInfoExample bDeviceInfoExample = new BDeviceInfoExample();
                    BDeviceInfoExample.Criteria criteria2 = bDeviceInfoExample.createCriteria();
                    criteria2.andFLocationEqualTo(Integer.valueOf(area));
                    criteria2.andFDeviceTypeEqualTo((byte) DeviceTypeEnum.terminalDevice.getCode());
                    List<BDeviceInfo> bDeviceInfos = bDeviceInfoMapper.selectByExample(bDeviceInfoExample);

                    //在该区域的异常设备数量
                    BDeviceInfoExample bDeviceInfoExample1 = new BDeviceInfoExample();
                    BDeviceInfoExample.Criteria criteria3 = bDeviceInfoExample1.createCriteria();
                    criteria3.andFLocationEqualTo(Integer.valueOf(area));
                    criteria3.andFEnableStateNotEqualTo(true);
                    criteria3.andFDeviceStateEqualTo((byte) DeviceStateEnum.malfunction.getCode());
                    BDeviceInfoExample.Criteria criteria4 = bDeviceInfoExample1.or();
                    criteria4.andFLocationEqualTo(Integer.valueOf(area));
                    criteria4.andFEnableStateNotEqualTo(true);
                    criteria4.andFDeviceStateEqualTo((byte) DeviceStateEnum.powerOutage.getCode());
                    List<BDeviceInfo> bDeviceInfos1 = bDeviceInfoMapper.selectByExample(bDeviceInfoExample1);
                    exceptionSize += bDeviceInfos1.size();

                    size += bDeviceInfos.size();
                }
                if(size == 0){
                    map.put("TelephoneMessage", (0+","+0));
                }else {
                    map.put("TelephoneMessage", (size+","+exceptionSize));
                }

            }else if(thirdCode.equals(DeviceChannelThirdCodeEnum.TextToLanguageConversion.getCode())){
                //文本
                //查播发区域

                //广播数据表
                BBroadcastDataExample bBroadcastDataExample = new BBroadcastDataExample();
                BBroadcastDataExample.Criteria criteria1 = bBroadcastDataExample.createCriteria();
                criteria1.andFDeleteFlagEqualTo(false);
                criteria1.andFStateEqualTo((byte) BroadcastStateEnum.broadcasted.getCode());
                criteria1.andFPassSelectEqualTo(fId);
                List<BBroadcastData> list1 = bBroadcastDataMapper.selectByExample(bBroadcastDataExample);
                Iterator iterator1 = list1.iterator();

                //list2是存储广播数据表响应设备通道的播发区域（目前是查询设备通道为话筒的）
                List<String> list2 = new ArrayList<>();
                List<String> list3 = new ArrayList<>();

                while(iterator1.hasNext()){
                    BBroadcastData bBroadcastData = (BBroadcastData) iterator1.next();
                    list2.add(bBroadcastData.getfBroadcastArea());
                }

                Iterator iterator2 = list2.iterator();
                while(iterator2.hasNext()){
                    String l = (String) iterator2.next();
                    String [] m = l.split(",");
                    for (int i=0; i<m.length; i++){
                        list3.add(m[i]);
                    }
                }

                //定时广播表
                BBroadcastTimingExample bBroadcastTimingExample = new BBroadcastTimingExample();
                BBroadcastTimingExample.Criteria criteria6 = bBroadcastTimingExample.createCriteria();
                criteria6.andFDeleteFlagEqualTo(false);
                criteria6.andFDeviceChannelEqualTo(fId);
                // TODO 定时广播表状态的问题

                //list4 得到了所有的以话筒为设备通道的所有的播发区域，并去重、单个
                List<String> list4 = removeDuplicate(list3);

                //根据list中的每个区域对应找该区域的设备
                Iterator iterator3 = list4.iterator();
                int size = 0;
                int exceptionSize = 0;
                while(iterator3.hasNext()){
                    String area = (String) iterator3.next();
                    BDeviceInfoExample bDeviceInfoExample = new BDeviceInfoExample();
                    BDeviceInfoExample.Criteria criteria2 = bDeviceInfoExample.createCriteria();
                    criteria2.andFLocationEqualTo(Integer.valueOf(area));
                    criteria2.andFDeviceTypeEqualTo((byte) DeviceTypeEnum.terminalDevice.getCode());
                    List<BDeviceInfo> bDeviceInfos = bDeviceInfoMapper.selectByExample(bDeviceInfoExample);

                    //在该区域的异常设备数量
                    BDeviceInfoExample bDeviceInfoExample1 = new BDeviceInfoExample();
                    BDeviceInfoExample.Criteria criteria3 = bDeviceInfoExample1.createCriteria();
                    criteria3.andFLocationEqualTo(Integer.valueOf(area));
                    criteria3.andFEnableStateNotEqualTo(true);
                    criteria3.andFDeviceStateEqualTo((byte) DeviceStateEnum.malfunction.getCode());
                    BDeviceInfoExample.Criteria criteria4 = bDeviceInfoExample1.or();
                    criteria4.andFLocationEqualTo(Integer.valueOf(area));
                    criteria4.andFEnableStateNotEqualTo(true);
                    criteria4.andFDeviceStateEqualTo((byte) DeviceStateEnum.powerOutage.getCode());
                    List<BDeviceInfo> bDeviceInfos1 = bDeviceInfoMapper.selectByExample(bDeviceInfoExample1);
                    exceptionSize += bDeviceInfos1.size();

                    size += bDeviceInfos.size();
                }

                if(size == 0){
                    map.put("TextToLanguageConversion", (0+","+0));
                }else {
                    map.put("TextToLanguageConversion", (size+","+exceptionSize));
                }

            }
        }

        return map;
    }

	@SuppressWarnings("unused")
	@Override
    public int[][] selectStatisticalAllCharts(String[] dates) {
        int[][] newDatas = new int[6][7];

        //得到所有的设备通道编号
        TDictionaryExample tDictionaryExample = new TDictionaryExample();
        TDictionaryExample.Criteria criteria = tDictionaryExample.createCriteria();
        criteria.andFDictionaryCodeEqualTo("device_channel");
        criteria.andFDeleteFlagEqualTo(false);
        List<TDictionary> lDictionaryas = tDictionaryMapper.selectByExample(tDictionaryExample);
        //List<Integer> integerList = new ArrayList<>();

        //储存字典表中设备通道的三方回传编码
        //List<String> list5 = new ArrayList<>();
        Map<Integer, String> tMap = new HashMap<>();
        Iterator iterator = lDictionaryas.iterator();

        while (iterator.hasNext()){
            TDictionary tDictionary = new TDictionary();
            tDictionary = (TDictionary) iterator.next();
            tMap.put(tDictionary.getfId(), tDictionary.getfThirdCode());
            //list5.add(tDictionary.getfDictionaryCode());
            //integerList.add(tDictionary.getfId());
        }
        tMap.remove(43);

        Set setTDics = tMap.keySet();
        Iterator iterator6 = setTDics.iterator();
        List<BBroadcastData> listLines = new ArrayList<>(); //线路
        List<BBroadcastData> listFMs = new ArrayList<>(); //调频
        while(iterator6.hasNext()) {
            //字典表中的f_id
            Integer fId = (Integer) iterator6.next();
            //字典表中的f_third_code
            String thirdCode = tMap.get(fId);

            if(thirdCode.equals(String.valueOf(DeviceChannelThirdCodeEnum.Microphone.getCode()))){
                //话筒

                for (int i=0; i<dates.length; i++) {
                    //查播发区域

                    //广播数据表
                    BBroadcastDataExample bBroadcastDataExample = new BBroadcastDataExample();
                    BBroadcastDataExample.Criteria criteria1 = bBroadcastDataExample.createCriteria();
                    criteria1.andFDeleteFlagEqualTo(false);
                    criteria1.andFStateEqualTo((byte) BroadcastStateEnum.broadcasted.getCode());
                    criteria1.andFPassSelectEqualTo(fId);

                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                    Date date1 = null;
                    try {
                        date1 = format.parse(dates[i]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    criteria1.andFCreateTimeEqualTo(date1);
                    List<BBroadcastData> list1 = bBroadcastDataMapper.selectByExample(bBroadcastDataExample);

                    Iterator iterator1 = list1.iterator();

                    //list2是存储广播数据表响应设备通道的播发区域（目前是查询设备通道为话筒的）
                    List<String> list2 = new ArrayList<>();
                    List<String> list3 = new ArrayList<>();

                    while(iterator1.hasNext()){
                        BBroadcastData bBroadcastData = (BBroadcastData) iterator1.next();
                        list2.add(bBroadcastData.getfBroadcastArea());
                    }

                    Iterator iterator2 = list2.iterator();
                    while(iterator2.hasNext()){
                        String l = (String) iterator2.next();
                        String [] m = l.split(",");
                        for (int j=0; j<m.length; j++){
                            list3.add(m[j]);
                        }
                    }

                    //定时广播表
                    BBroadcastTimingExample bBroadcastTimingExample = new BBroadcastTimingExample();
                    BBroadcastTimingExample.Criteria criteria6 = bBroadcastTimingExample.createCriteria();
                    criteria6.andFDeleteFlagEqualTo(false);
                    criteria6.andFDeviceChannelEqualTo(fId);
                    // TODO 定时广播表状态的问题

                    //list4 得到了所有的以话筒为设备通道的所有的播发区域，并去重、单个
                    List<String> list4 = removeDuplicate(list3);

                    //根据list中的每个区域对应找该区域的设备
                    Iterator iterator3 = list4.iterator();
                    int size = 0;
                    while(iterator3.hasNext()){
                        String area = (String) iterator3.next();
                        BDeviceInfoExample bDeviceInfoExample = new BDeviceInfoExample();
                        BDeviceInfoExample.Criteria criteria2 = bDeviceInfoExample.createCriteria();
                        criteria2.andFLocationEqualTo(Integer.valueOf(area));
                        criteria2.andFDeviceTypeEqualTo((byte) DeviceTypeEnum.terminalDevice.getCode());
                        List<BDeviceInfo> bDeviceInfos = bDeviceInfoMapper.selectByExample(bDeviceInfoExample);

                        //在该区域的异常设备数量
                        BDeviceInfoExample bDeviceInfoExample1 = new BDeviceInfoExample();
                        BDeviceInfoExample.Criteria criteria3 = bDeviceInfoExample1.createCriteria();
                        criteria3.andFLocationEqualTo(Integer.valueOf(area));
                        criteria3.andFEnableStateNotEqualTo(true);
                        criteria3.andFDeviceStateEqualTo((byte) DeviceStateEnum.malfunction.getCode());
                        BDeviceInfoExample.Criteria criteria4 = bDeviceInfoExample1.or();
                        criteria4.andFLocationEqualTo(Integer.valueOf(area));
                        criteria4.andFEnableStateNotEqualTo(true);
                        criteria4.andFDeviceStateEqualTo((byte) DeviceStateEnum.powerOutage.getCode());
                        List<BDeviceInfo> bDeviceInfos1 = bDeviceInfoMapper.selectByExample(bDeviceInfoExample1);

                        size += bDeviceInfos.size();

                    }

                    if(size == 0){
                        newDatas[0][i]=0;
                    }else {
                        newDatas[0][i]=size;
                    }
                }
            }else if(thirdCode.equals(String.valueOf(DeviceChannelThirdCodeEnum.LineOne.getCode())) || thirdCode.equals(String.valueOf(DeviceChannelThirdCodeEnum.LineTwo.getCode()))){
                //线路

                for (int i=0; i<dates.length; i++) {
                    //查播发区域

                    //广播数据表
                    if(thirdCode.equals(DeviceChannelThirdCodeEnum.LineOne.getCode())){
                        BBroadcastDataExample bBroadcastDataExample = new BBroadcastDataExample();
                        BBroadcastDataExample.Criteria criteria1 = bBroadcastDataExample.createCriteria();
                        criteria1.andFDeleteFlagEqualTo(false);
                        criteria1.andFStateEqualTo((byte) BroadcastStateEnum.broadcasted.getCode());
                        criteria1.andFPassSelectEqualTo(fId);

                        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                        Date date1 = null;
                        try {
                            date1 = format.parse(dates[i]);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        criteria1.andFCreateTimeEqualTo(date1);
                        List<BBroadcastData> list1 = bBroadcastDataMapper.selectByExample(bBroadcastDataExample);
                        listLines.addAll(list1);
                    }else if(thirdCode.equals(DeviceChannelThirdCodeEnum.LineTwo.getCode())){
                        BBroadcastDataExample bBroadcastDataExample = new BBroadcastDataExample();
                        BBroadcastDataExample.Criteria criteria1 = bBroadcastDataExample.createCriteria();
                        criteria1.andFDeleteFlagEqualTo(false);
                        criteria1.andFStateEqualTo((byte) BroadcastStateEnum.broadcasted.getCode());
                        criteria1.andFPassSelectEqualTo(fId);

                        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                        Date date1 = null;
                        try {
                            date1 = format.parse(dates[i]);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        criteria1.andFCreateTimeEqualTo(date1);
                        List<BBroadcastData> list1 = bBroadcastDataMapper.selectByExample(bBroadcastDataExample);
                        listLines.addAll(list1);
                    }

                    Iterator iterator1 = listLines.iterator();

                    //list2是存储广播数据表响应设备通道的播发区域（目前是查询设备通道为话筒的）
                    List<String> list2 = new ArrayList<>();
                    List<String> list3 = new ArrayList<>();

                    while(iterator1.hasNext()){
                        BBroadcastData bBroadcastData = (BBroadcastData) iterator1.next();
                        list2.add(bBroadcastData.getfBroadcastArea());
                    }

                    Iterator iterator2 = list2.iterator();
                    while(iterator2.hasNext()){
                        String l = (String) iterator2.next();
                        String [] m = l.split(",");
                        for (int j=0; j<m.length; j++){
                            list3.add(m[j]);
                        }
                    }

                    //定时广播表
                    BBroadcastTimingExample bBroadcastTimingExample = new BBroadcastTimingExample();
                    BBroadcastTimingExample.Criteria criteria6 = bBroadcastTimingExample.createCriteria();
                    criteria6.andFDeleteFlagEqualTo(false);
                    criteria6.andFDeviceChannelEqualTo(fId);
                    // TODO 定时广播表状态的问题

                    //list4 得到了所有的以话筒为设备通道的所有的播发区域，并去重、单个
                    List<String> list4 = removeDuplicate(list3);

                    //根据list中的每个区域对应找该区域的设备
                    Iterator iterator3 = list4.iterator();
                    int size = 0;
                    while(iterator3.hasNext()){
                        String area = (String) iterator3.next();
                        BDeviceInfoExample bDeviceInfoExample = new BDeviceInfoExample();
                        BDeviceInfoExample.Criteria criteria2 = bDeviceInfoExample.createCriteria();
                        criteria2.andFLocationEqualTo(Integer.valueOf(area));
                        criteria2.andFDeviceTypeEqualTo((byte) DeviceTypeEnum.terminalDevice.getCode());
                        List<BDeviceInfo> bDeviceInfos = bDeviceInfoMapper.selectByExample(bDeviceInfoExample);

                        //在该区域的异常设备数量
                        BDeviceInfoExample bDeviceInfoExample1 = new BDeviceInfoExample();
                        BDeviceInfoExample.Criteria criteria3 = bDeviceInfoExample1.createCriteria();
                        criteria3.andFLocationEqualTo(Integer.valueOf(area));
                        criteria3.andFEnableStateNotEqualTo(true);
                        criteria3.andFDeviceStateEqualTo((byte) DeviceStateEnum.malfunction.getCode());
                        BDeviceInfoExample.Criteria criteria4 = bDeviceInfoExample1.or();
                        criteria4.andFLocationEqualTo(Integer.valueOf(area));
                        criteria4.andFEnableStateNotEqualTo(true);
                        criteria4.andFDeviceStateEqualTo((byte) DeviceStateEnum.powerOutage.getCode());
                        List<BDeviceInfo> bDeviceInfos1 = bDeviceInfoMapper.selectByExample(bDeviceInfoExample1);

                        size += bDeviceInfos1.size();

                    }

                    if(size == 0){
                        newDatas[1][i]=0;
                    }else {
                        newDatas[1][i]=size;
                    }
                }
            }else if(thirdCode.equals(String.valueOf(DeviceChannelThirdCodeEnum.TextToLanguageConversion.getCode()))){
                //文本

                for (int i=0; i<dates.length; i++) {
                    //查播发区域

                    //广播数据表
                    BBroadcastDataExample bBroadcastDataExample = new BBroadcastDataExample();
                    BBroadcastDataExample.Criteria criteria1 = bBroadcastDataExample.createCriteria();
                    criteria1.andFDeleteFlagEqualTo(false);
                    criteria1.andFStateEqualTo((byte) BroadcastStateEnum.broadcasted.getCode());
                    criteria1.andFPassSelectEqualTo(fId);

                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                    Date date1 = null;
                    try {
                        date1 = format.parse(dates[i]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    criteria1.andFCreateTimeEqualTo(date1);
                    List<BBroadcastData> list1 = bBroadcastDataMapper.selectByExample(bBroadcastDataExample);




                    Iterator iterator1 = list1.iterator();

                    //list2是存储广播数据表响应设备通道的播发区域（目前是查询设备通道为话筒的）
                    List<String> list2 = new ArrayList<>();
                    List<String> list3 = new ArrayList<>();

                    while(iterator1.hasNext()){
                        BBroadcastData bBroadcastData = (BBroadcastData) iterator1.next();
                        list2.add(bBroadcastData.getfBroadcastArea());
                    }

                    Iterator iterator2 = list2.iterator();
                    while(iterator2.hasNext()){
                        String l = (String) iterator2.next();
                        String [] m = l.split(",");
                        for (int j=0; j<m.length; j++){
                            list3.add(m[j]);
                        }
                    }

                    //定时广播表
                    BBroadcastTimingExample bBroadcastTimingExample = new BBroadcastTimingExample();
                    BBroadcastTimingExample.Criteria criteria6 = bBroadcastTimingExample.createCriteria();
                    criteria6.andFDeleteFlagEqualTo(false);
                    criteria6.andFDeviceChannelEqualTo(fId);
                    // TODO 定时广播表状态的问题

                    //list4 得到了所有的以话筒为设备通道的所有的播发区域，并去重、单个
                    List<String> list4 = removeDuplicate(list3);

                    //根据list中的每个区域对应找该区域的设备
                    Iterator iterator3 = list4.iterator();
                    int size = 0;
                    while(iterator3.hasNext()){
                        String area = (String) iterator3.next();
                        BDeviceInfoExample bDeviceInfoExample = new BDeviceInfoExample();
                        BDeviceInfoExample.Criteria criteria2 = bDeviceInfoExample.createCriteria();
                        criteria2.andFLocationEqualTo(Integer.valueOf(area));
                        criteria2.andFDeviceTypeEqualTo((byte) DeviceTypeEnum.terminalDevice.getCode());
                        List<BDeviceInfo> bDeviceInfos = bDeviceInfoMapper.selectByExample(bDeviceInfoExample);

                        //在该区域的异常设备数量
                        BDeviceInfoExample bDeviceInfoExample1 = new BDeviceInfoExample();
                        BDeviceInfoExample.Criteria criteria3 = bDeviceInfoExample1.createCriteria();
                        criteria3.andFLocationEqualTo(Integer.valueOf(area));
                        criteria3.andFEnableStateNotEqualTo(true);
                        criteria3.andFDeviceStateEqualTo((byte) DeviceStateEnum.malfunction.getCode());
                        BDeviceInfoExample.Criteria criteria4 = bDeviceInfoExample1.or();
                        criteria4.andFLocationEqualTo(Integer.valueOf(area));
                        criteria4.andFEnableStateNotEqualTo(true);
                        criteria4.andFDeviceStateEqualTo((byte) DeviceStateEnum.powerOutage.getCode());
                        List<BDeviceInfo> bDeviceInfos1 = bDeviceInfoMapper.selectByExample(bDeviceInfoExample1);

                        size += bDeviceInfos.size();

                    }

                    if(size == 0){
                        newDatas[2][i]=0;
                    }else {
                        newDatas[2][i]=size;
                    }
                }
            }else if(thirdCode.equals(String.valueOf(DeviceChannelThirdCodeEnum.FrequencyModulationOne.getCode())) || thirdCode.equals(String.valueOf(DeviceChannelThirdCodeEnum.FrequencyModulationTwo.getCode()))){
                //调频

                for (int i=0; i<dates.length; i++) {
                    //查播发区域

                    //广播数据表
                    if(thirdCode.equals(DeviceChannelThirdCodeEnum.FrequencyModulationOne.getCode())){
                        BBroadcastDataExample bBroadcastDataExample = new BBroadcastDataExample();
                        BBroadcastDataExample.Criteria criteria1 = bBroadcastDataExample.createCriteria();
                        criteria1.andFDeleteFlagEqualTo(false);
                        criteria1.andFStateEqualTo((byte) BroadcastStateEnum.broadcasted.getCode());
                        criteria1.andFPassSelectEqualTo(fId);

                        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                        Date date1 = null;
                        try {
                            date1 = format.parse(dates[i]);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        criteria1.andFCreateTimeEqualTo(date1);
                        List<BBroadcastData> list1 = bBroadcastDataMapper.selectByExample(bBroadcastDataExample);
                        listFMs.addAll(list1);
                    }else if(thirdCode.equals(DeviceChannelThirdCodeEnum.FrequencyModulationOne.getCode())){
                        BBroadcastDataExample bBroadcastDataExample = new BBroadcastDataExample();
                        BBroadcastDataExample.Criteria criteria1 = bBroadcastDataExample.createCriteria();
                        criteria1.andFDeleteFlagEqualTo(false);
                        criteria1.andFStateEqualTo((byte) BroadcastStateEnum.broadcasted.getCode());
                        criteria1.andFPassSelectEqualTo(fId);

                        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                        Date date1 = null;
                        try {
                            date1 = format.parse(dates[i]);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        criteria1.andFCreateTimeEqualTo(date1);
                        List<BBroadcastData> list1 = bBroadcastDataMapper.selectByExample(bBroadcastDataExample);
                        listFMs.addAll(list1);
                    }


                    Iterator iterator1 = listFMs.iterator();

                    //list2是存储广播数据表响应设备通道的播发区域（目前是查询设备通道为话筒的）
                    List<String> list2 = new ArrayList<>();
                    List<String> list3 = new ArrayList<>();

                    while(iterator1.hasNext()){
                        BBroadcastData bBroadcastData = (BBroadcastData) iterator1.next();
                        list2.add(bBroadcastData.getfBroadcastArea());
                    }

                    Iterator iterator2 = list2.iterator();
                    while(iterator2.hasNext()){
                        String l = (String) iterator2.next();
                        String [] m = l.split(",");
                        for (int j=0; j<m.length; j++){
                            list3.add(m[j]);
                        }
                    }

                    //定时广播表
                    BBroadcastTimingExample bBroadcastTimingExample = new BBroadcastTimingExample();
                    BBroadcastTimingExample.Criteria criteria6 = bBroadcastTimingExample.createCriteria();
                    criteria6.andFDeleteFlagEqualTo(false);
                    criteria6.andFDeviceChannelEqualTo(fId);
                    // TODO 定时广播表状态的问题

                    //list4 得到了所有的以话筒为设备通道的所有的播发区域，并去重、单个
                    List<String> list4 = removeDuplicate(list3);

                    //根据list中的每个区域对应找该区域的设备
                    Iterator iterator3 = list4.iterator();
                    int size = 0;
                    while(iterator3.hasNext()){
                        String area = (String) iterator3.next();
                        BDeviceInfoExample bDeviceInfoExample = new BDeviceInfoExample();
                        BDeviceInfoExample.Criteria criteria2 = bDeviceInfoExample.createCriteria();
                        criteria2.andFLocationEqualTo(Integer.valueOf(area));
                        criteria2.andFDeviceTypeEqualTo((byte) DeviceTypeEnum.terminalDevice.getCode());
                        List<BDeviceInfo> bDeviceInfos = bDeviceInfoMapper.selectByExample(bDeviceInfoExample);

                        //在该区域的异常设备数量
                        BDeviceInfoExample bDeviceInfoExample1 = new BDeviceInfoExample();
                        BDeviceInfoExample.Criteria criteria3 = bDeviceInfoExample1.createCriteria();
                        criteria3.andFLocationEqualTo(Integer.valueOf(area));
                        criteria3.andFEnableStateNotEqualTo(true);
                        criteria3.andFDeviceStateEqualTo((byte) DeviceStateEnum.malfunction.getCode());
                        BDeviceInfoExample.Criteria criteria4 = bDeviceInfoExample1.or();
                        criteria4.andFLocationEqualTo(Integer.valueOf(area));
                        criteria4.andFEnableStateNotEqualTo(true);
                        criteria4.andFDeviceStateEqualTo((byte) DeviceStateEnum.powerOutage.getCode());
                        List<BDeviceInfo> bDeviceInfos1 = bDeviceInfoMapper.selectByExample(bDeviceInfoExample1);

                        size += bDeviceInfos.size();

                    }

                    if(size == 0){
                        newDatas[3][i]=0;
                    }else {
                        newDatas[3][i]=size;
                    }
                }
            }else if(thirdCode.equals(String.valueOf(DeviceChannelThirdCodeEnum.TelephoneMessage.getCode())) ){
                //电话短信

                for (int i=0; i<dates.length; i++) {
                    //查播发区域

                    //广播数据表
                    BBroadcastDataExample bBroadcastDataExample = new BBroadcastDataExample();
                    BBroadcastDataExample.Criteria criteria1 = bBroadcastDataExample.createCriteria();
                    criteria1.andFDeleteFlagEqualTo(false);
                    criteria1.andFStateEqualTo((byte) BroadcastStateEnum.broadcasted.getCode());
                    criteria1.andFPassSelectEqualTo(fId);

                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                    Date date1 = null;
                    try {
                        date1 = format.parse(dates[i]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    criteria1.andFCreateTimeEqualTo(date1);
                    List<BBroadcastData> list1 = bBroadcastDataMapper.selectByExample(bBroadcastDataExample);




                    Iterator iterator1 = list1.iterator();

                    //list2是存储广播数据表响应设备通道的播发区域（目前是查询设备通道为话筒的）
                    List<String> list2 = new ArrayList<>();
                    List<String> list3 = new ArrayList<>();

                    while(iterator1.hasNext()){
                        BBroadcastData bBroadcastData = (BBroadcastData) iterator1.next();
                        list2.add(bBroadcastData.getfBroadcastArea());
                    }

                    Iterator iterator2 = list2.iterator();
                    while(iterator2.hasNext()){
                        String l = (String) iterator2.next();
                        String [] m = l.split(",");
                        for (int j=0; j<m.length; j++){
                            list3.add(m[j]);
                        }
                    }

                    //定时广播表
                    BBroadcastTimingExample bBroadcastTimingExample = new BBroadcastTimingExample();
                    BBroadcastTimingExample.Criteria criteria6 = bBroadcastTimingExample.createCriteria();
                    criteria6.andFDeleteFlagEqualTo(false);
                    criteria6.andFDeviceChannelEqualTo(fId);

                    List<String> list4 = removeDuplicate(list3);

                    //根据list中的每个区域对应找该区域的设备
                    Iterator iterator3 = list4.iterator();
                    int size = 0;
                    while(iterator3.hasNext()){
                        String area = (String) iterator3.next();
                        BDeviceInfoExample bDeviceInfoExample = new BDeviceInfoExample();
                        BDeviceInfoExample.Criteria criteria2 = bDeviceInfoExample.createCriteria();
                        criteria2.andFLocationEqualTo(Integer.valueOf(area));
                        criteria2.andFDeviceTypeEqualTo((byte) DeviceTypeEnum.terminalDevice.getCode());
                        List<BDeviceInfo> bDeviceInfos = bDeviceInfoMapper.selectByExample(bDeviceInfoExample);

                        //在该区域的异常设备数量
                        BDeviceInfoExample bDeviceInfoExample1 = new BDeviceInfoExample();
                        BDeviceInfoExample.Criteria criteria3 = bDeviceInfoExample1.createCriteria();
                        criteria3.andFLocationEqualTo(Integer.valueOf(area));
                        criteria3.andFEnableStateNotEqualTo(true);
                        criteria3.andFDeviceStateEqualTo((byte) DeviceStateEnum.malfunction.getCode());
                        BDeviceInfoExample.Criteria criteria4 = bDeviceInfoExample1.or();
                        criteria4.andFLocationEqualTo(Integer.valueOf(area));
                        criteria4.andFEnableStateNotEqualTo(true);
                        criteria4.andFDeviceStateEqualTo((byte) DeviceStateEnum.powerOutage.getCode());
                        List<BDeviceInfo> bDeviceInfos1 = bDeviceInfoMapper.selectByExample(bDeviceInfoExample1);

                        size += bDeviceInfos.size();

                    }

                    if(size == 0){
                        newDatas[4][i]=0;
                    }else {
                        newDatas[4][i]=size;
                    }
                }
            }else if(thirdCode.equals(String.valueOf(DeviceChannelThirdCodeEnum.UDisk.getCode())) ){
                //u盘

                for (int i=0; i<dates.length; i++) {
                    //查播发区域

                    //广播数据表
                    BBroadcastDataExample bBroadcastDataExample = new BBroadcastDataExample();
                    BBroadcastDataExample.Criteria criteria1 = bBroadcastDataExample.createCriteria();
                    criteria1.andFDeleteFlagEqualTo(false);
                    criteria1.andFStateEqualTo((byte) BroadcastStateEnum.broadcasted.getCode());
                    criteria1.andFPassSelectEqualTo(fId);

                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

                    Date date1 = null;
                    try {
                        date1 = format.parse(dates[i]);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    criteria1.andFCreateTimeEqualTo(date1);
                    List<BBroadcastData> list1 = bBroadcastDataMapper.selectByExample(bBroadcastDataExample);




                    Iterator iterator1 = list1.iterator();

                    //list2是存储广播数据表响应设备通道的播发区域（目前是查询设备通道为话筒的）
                    List<String> list2 = new ArrayList<>();
                    List<String> list3 = new ArrayList<>();

                    while(iterator1.hasNext()){
                        BBroadcastData bBroadcastData = (BBroadcastData) iterator1.next();
                        list2.add(bBroadcastData.getfBroadcastArea());
                    }

                    Iterator iterator2 = list2.iterator();
                    while(iterator2.hasNext()){
                        String l = (String) iterator2.next();
                        String [] m = l.split(",");
                        for (int j=0; j<m.length; j++){
                            list3.add(m[j]);
                        }
                    }

                    //定时广播表
                    BBroadcastTimingExample bBroadcastTimingExample = new BBroadcastTimingExample();
                    BBroadcastTimingExample.Criteria criteria6 = bBroadcastTimingExample.createCriteria();
                    criteria6.andFDeleteFlagEqualTo(false);
                    criteria6.andFDeviceChannelEqualTo(fId);
                    // TODO 定时广播表状态的问题

                    //list4 得到了所有的以话筒为设备通道的所有的播发区域，并去重、单个
                    List<String> list4 = removeDuplicate(list3);

                    //根据list中的每个区域对应找该区域的设备
                    Iterator iterator3 = list4.iterator();
                    int size = 0;
                    while(iterator3.hasNext()){
                        String area = (String) iterator3.next();
                        BDeviceInfoExample bDeviceInfoExample = new BDeviceInfoExample();
                        BDeviceInfoExample.Criteria criteria2 = bDeviceInfoExample.createCriteria();
                        criteria2.andFLocationEqualTo(Integer.valueOf(area));
                        criteria2.andFDeviceTypeEqualTo((byte) DeviceTypeEnum.terminalDevice.getCode());
                        List<BDeviceInfo> bDeviceInfos = bDeviceInfoMapper.selectByExample(bDeviceInfoExample);

                        //在该区域的异常设备数量
                        BDeviceInfoExample bDeviceInfoExample1 = new BDeviceInfoExample();
                        BDeviceInfoExample.Criteria criteria3 = bDeviceInfoExample1.createCriteria();
                        criteria3.andFLocationEqualTo(Integer.valueOf(area));
                        criteria3.andFEnableStateNotEqualTo(true);
                        criteria3.andFDeviceStateEqualTo((byte) DeviceStateEnum.malfunction.getCode());
                        BDeviceInfoExample.Criteria criteria4 = bDeviceInfoExample1.or();
                        criteria4.andFLocationEqualTo(Integer.valueOf(area));
                        criteria4.andFEnableStateNotEqualTo(true);
                        criteria4.andFDeviceStateEqualTo((byte) DeviceStateEnum.powerOutage.getCode());
                        List<BDeviceInfo> bDeviceInfos1 = bDeviceInfoMapper.selectByExample(bDeviceInfoExample1);

                        size += bDeviceInfos.size();

                    }

                    if(size == 0){
                        newDatas[5][i]=0;
                    }else {
                        newDatas[5][i]=size;
                    }
                }
            }
        }

        return newDatas;
    }

    @Override
    public Map<String, String> selectStatisticalAllTabForTimes(String fStartTime, String fEndTime) throws ParseException {
        Map<String, String> map = new HashMap<>();

        //初始化map中的值
        map.put("Microphone",0+","+0);
        map.put("Line",0+","+0);
        map.put("UDisk",0+","+0);
        map.put("FrequencyModulation",0+","+0);
        map.put("TelephoneMessage",0+","+0);
        map.put("TextToLanguageConversion",0+","+0);
        //得到所有的设备通道编号
        TDictionaryExample tDictionaryExample = new TDictionaryExample();
        TDictionaryExample.Criteria criteria = tDictionaryExample.createCriteria();
        criteria.andFDictionaryCodeEqualTo("device_channel");
        criteria.andFDeleteFlagEqualTo(false);
        List<TDictionary> lDictionaryas = tDictionaryMapper.selectByExample(tDictionaryExample);
        //List<Integer> integerList = new ArrayList<>();

        //储存字典表中设备通道的三方回传编码
        //List<String> list5 = new ArrayList<>();
        Map<Integer, String> tMap = new HashMap<>();
        Iterator iterator = lDictionaryas.iterator();

        while (iterator.hasNext()){
            TDictionary tDictionary = new TDictionary();
            tDictionary = (TDictionary) iterator.next();
            tMap.put(tDictionary.getfId(), tDictionary.getfThirdCode());
            //list5.add(tDictionary.getfDictionaryCode());
            //integerList.add(tDictionary.getfId());
        }
        tMap.remove(43);

        Set setTDics = tMap.keySet();
        Iterator iterator6 = setTDics.iterator();
        List<BBroadcastData> listLines = new ArrayList<>(); //线路
        List<BBroadcastData> listFMs = new ArrayList<>(); //调频
        while(iterator6.hasNext()) {
            //字典表中的f_id
            Integer fId = (Integer) iterator6.next();
            //字典表中的f_third_code
            String thirdCode = tMap.get(fId);

            if(thirdCode.equals(String.valueOf(DeviceChannelThirdCodeEnum.Microphone.getCode()))){
                //话筒
                //查播发区域

                //广播数据表
                BBroadcastDataExample bBroadcastDataExample = new BBroadcastDataExample();
                BBroadcastDataExample.Criteria criteria1 = bBroadcastDataExample.createCriteria();
                criteria1.andFDeleteFlagEqualTo(false);
                criteria1.andFStateEqualTo((byte) BroadcastStateEnum.broadcasted.getCode());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                //System.out.println("++++++++++++++++++++++"+strToDateFormat(fStartTime));
                //System.out.println("++++++++++++++++++++++"+simpleDateFormat.parse(fStartTime));
                criteria1.andFCreateTimeBetween(simpleDateFormat.parse(fStartTime+" 00:00:00"), simpleDateFormat.parse(fEndTime+" 59:59:59"));
                criteria1.andFPassSelectEqualTo(fId);
                List<BBroadcastData> list1 = bBroadcastDataMapper.selectByExample(bBroadcastDataExample);
                Iterator iterator1 = list1.iterator();

                //list2是存储广播数据表响应设备通道的播发区域（目前是查询设备通道为话筒的）
                List<String> list2 = new ArrayList<>();
                List<String> list3 = new ArrayList<>();

                while(iterator1.hasNext()){
                    BBroadcastData bBroadcastData = (BBroadcastData) iterator1.next();
                    list2.add(bBroadcastData.getfBroadcastArea());
                }

                Iterator iterator2 = list2.iterator();
                while(iterator2.hasNext()){
                    String l = (String) iterator2.next();
                    String [] m = l.split(",");
                    for (int i=0; i<m.length; i++){
                        list3.add(m[i]);
                    }
                }


                //定时广播表
                BBroadcastTimingExample bBroadcastTimingExample = new BBroadcastTimingExample();
                BBroadcastTimingExample.Criteria criteria6 = bBroadcastTimingExample.createCriteria();
                criteria6.andFDeleteFlagEqualTo(false);
                criteria6.andFDeviceChannelEqualTo(fId);
                // TODO 定时广播表状态的问题

                //list4 得到了所有的以话筒为设备通道的所有的播发区域，并去重、单个
                List<String> list4 = removeDuplicate(list3);

                //根据list中的每个区域对应找该区域的设备
                Iterator iterator3 = list4.iterator();
                int size = 0;
                int exceptionSize = 0;
                while(iterator3.hasNext()){
                    String area = (String) iterator3.next();
                    BDeviceInfoExample bDeviceInfoExample = new BDeviceInfoExample();
                    BDeviceInfoExample.Criteria criteria2 = bDeviceInfoExample.createCriteria();
                    criteria2.andFLocationEqualTo(Integer.valueOf(area));
                    criteria2.andFEnableStateNotEqualTo(true);
                    criteria2.andFDeviceTypeEqualTo((byte) DeviceTypeEnum.terminalDevice.getCode());
                    List<BDeviceInfo> bDeviceInfos = bDeviceInfoMapper.selectByExample(bDeviceInfoExample);

                    //在该区域的异常设备数量
                    BDeviceInfoExample bDeviceInfoExample1 = new BDeviceInfoExample();
                    BDeviceInfoExample.Criteria criteria3 = bDeviceInfoExample1.createCriteria();
                    criteria3.andFLocationEqualTo(Integer.valueOf(area));
                    criteria3.andFEnableStateNotEqualTo(true);
                    criteria3.andFDeviceStateEqualTo((byte) DeviceStateEnum.malfunction.getCode());
                    BDeviceInfoExample.Criteria criteria4 = bDeviceInfoExample1.or();
                    criteria4.andFLocationEqualTo(Integer.valueOf(area));
                    criteria4.andFEnableStateNotEqualTo(true);
                    criteria4.andFDeviceStateEqualTo((byte) DeviceStateEnum.powerOutage.getCode());
                    List<BDeviceInfo> bDeviceInfos1 = bDeviceInfoMapper.selectByExample(bDeviceInfoExample1);
                    exceptionSize += bDeviceInfos1.size();


                    size += bDeviceInfos.size();
                }
                map.put("Microphone", (size+","+exceptionSize));
            }else if(thirdCode.equals(DeviceChannelThirdCodeEnum.LineOne.getCode()) || thirdCode.equals(DeviceChannelThirdCodeEnum.LineTwo.getCode())){
                //线路
                //查播发区域

                //广播数据表
                if(thirdCode.equals(DeviceChannelThirdCodeEnum.LineOne.getCode())){
                    BBroadcastDataExample bBroadcastDataExample = new BBroadcastDataExample();
                    BBroadcastDataExample.Criteria criteria1 = bBroadcastDataExample.createCriteria();
                    criteria1.andFDeleteFlagEqualTo(false);
                    criteria1.andFStateEqualTo((byte) BroadcastStateEnum.broadcasted.getCode());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    criteria1.andFCreateTimeBetween(simpleDateFormat.parse(fStartTime+" 00:00:00"), simpleDateFormat.parse(fEndTime+" 59:59:59"));
                    criteria1.andFPassSelectEqualTo(fId);
                    List<BBroadcastData> list2 = bBroadcastDataMapper.selectByExample(bBroadcastDataExample);
                    listLines.addAll(list2);
                }else if(thirdCode.equals(DeviceChannelThirdCodeEnum.LineTwo.getCode())){
                    BBroadcastDataExample bBroadcastDataExample = new BBroadcastDataExample();
                    BBroadcastDataExample.Criteria criteria1 = bBroadcastDataExample.createCriteria();
                    criteria1.andFDeleteFlagEqualTo(false);
                    criteria1.andFStateEqualTo((byte) BroadcastStateEnum.broadcasted.getCode());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    criteria1.andFCreateTimeBetween(simpleDateFormat.parse(fStartTime+" 00:00:00"), simpleDateFormat.parse(fEndTime+" 59:59:59"));
                    criteria1.andFPassSelectEqualTo(fId);
                    List<BBroadcastData> list3 = bBroadcastDataMapper.selectByExample(bBroadcastDataExample);
                    listLines.addAll(list3);
                }

                Iterator iterator1 = listLines.iterator();

                //list2是存储广播数据表响应设备通道的播发区域（目前是查询设备通道为话筒的）
                List<String> list2 = new ArrayList<>();
                List<String> list3 = new ArrayList<>();

                while(iterator1.hasNext()){
                    BBroadcastData bBroadcastData = (BBroadcastData) iterator1.next();
                    list2.add(bBroadcastData.getfBroadcastArea());
                }

                Iterator iterator2 = list2.iterator();
                while(iterator2.hasNext()){
                    String l = (String) iterator2.next();
                    String [] m = l.split(",");
                    for (int i=0; i<m.length; i++){
                        list3.add(m[i]);
                    }
                }

                //定时广播表
                BBroadcastTimingExample bBroadcastTimingExample = new BBroadcastTimingExample();
                BBroadcastTimingExample.Criteria criteria6 = bBroadcastTimingExample.createCriteria();
                criteria6.andFDeleteFlagEqualTo(false);
                criteria6.andFDeviceChannelEqualTo(fId);
                // TODO 定时广播表状态的问题

                //list4 得到了所有的以话筒为设备通道的所有的播发区域，并去重、单个
                List<String> list4 = removeDuplicate(list3);

                //根据list中的每个区域对应找该区域的设备
                Iterator iterator3 = list4.iterator();
                int size = 0;
                int exceptionSize = 0;
                while(iterator3.hasNext()){
                    String area = (String) iterator3.next();
                    BDeviceInfoExample bDeviceInfoExample = new BDeviceInfoExample();
                    BDeviceInfoExample.Criteria criteria2 = bDeviceInfoExample.createCriteria();
                    criteria2.andFLocationEqualTo(Integer.valueOf(area));
                    criteria2.andFDeviceTypeEqualTo((byte) DeviceTypeEnum.terminalDevice.getCode());
                    List<BDeviceInfo> bDeviceInfos = bDeviceInfoMapper.selectByExample(bDeviceInfoExample);

                    //在该区域的异常设备数量
                    BDeviceInfoExample bDeviceInfoExample1 = new BDeviceInfoExample();
                    BDeviceInfoExample.Criteria criteria3 = bDeviceInfoExample1.createCriteria();
                    criteria3.andFLocationEqualTo(Integer.valueOf(area));
                    criteria3.andFEnableStateNotEqualTo(true);
                    criteria3.andFDeviceStateEqualTo((byte) DeviceStateEnum.malfunction.getCode());
                    BDeviceInfoExample.Criteria criteria4 = bDeviceInfoExample1.or();
                    criteria4.andFLocationEqualTo(Integer.valueOf(area));
                    criteria4.andFEnableStateNotEqualTo(true);
                    criteria4.andFDeviceStateEqualTo((byte) DeviceStateEnum.powerOutage.getCode());
                    List<BDeviceInfo> bDeviceInfos1 = bDeviceInfoMapper.selectByExample(bDeviceInfoExample1);
                    exceptionSize += bDeviceInfos1.size();

                    size += bDeviceInfos.size();
                }
                map.put("Line", (size+","+exceptionSize));
            }else if(thirdCode.equals(DeviceChannelThirdCodeEnum.UDisk.getCode())){
                //U盘
                //查播发区域

                //广播数据表
                BBroadcastDataExample bBroadcastDataExample = new BBroadcastDataExample();
                BBroadcastDataExample.Criteria criteria1 = bBroadcastDataExample.createCriteria();
                criteria1.andFDeleteFlagEqualTo(false);
                criteria1.andFStateEqualTo((byte) BroadcastStateEnum.broadcasted.getCode());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                criteria1.andFCreateTimeBetween(simpleDateFormat.parse(fStartTime+" 00:00:00"), simpleDateFormat.parse(fEndTime+" 59:59:59"));
                criteria1.andFPassSelectEqualTo(fId);
                List<BBroadcastData> list1 = bBroadcastDataMapper.selectByExample(bBroadcastDataExample);
                Iterator iterator1 = list1.iterator();

                //list2是存储广播数据表响应设备通道的播发区域（目前是查询设备通道为话筒的）
                List<String> list2 = new ArrayList<>();
                List<String> list3 = new ArrayList<>();

                while(iterator1.hasNext()){
                    BBroadcastData bBroadcastData = (BBroadcastData) iterator1.next();
                    list2.add(bBroadcastData.getfBroadcastArea());
                }

                Iterator iterator2 = list2.iterator();
                while(iterator2.hasNext()){
                    String l = (String) iterator2.next();
                    String [] m = l.split(",");
                    for (int i=0; i<m.length; i++){
                        list3.add(m[i]);
                    }
                }

                //定时广播表
                BBroadcastTimingExample bBroadcastTimingExample = new BBroadcastTimingExample();
                BBroadcastTimingExample.Criteria criteria6 = bBroadcastTimingExample.createCriteria();
                criteria6.andFDeleteFlagEqualTo(false);
                criteria6.andFDeviceChannelEqualTo(fId);
                // TODO 定时广播表状态的问题

                //list4 得到了所有的以话筒为设备通道的所有的播发区域，并去重、单个
                List<String> list4 = removeDuplicate(list3);

                //根据list中的每个区域对应找该区域的设备
                Iterator iterator3 = list4.iterator();
                int size = 0;
                int exceptionSize = 0;
                while(iterator3.hasNext()){
                    String area = (String) iterator3.next();
                    BDeviceInfoExample bDeviceInfoExample = new BDeviceInfoExample();
                    BDeviceInfoExample.Criteria criteria2 = bDeviceInfoExample.createCriteria();
                    criteria2.andFLocationEqualTo(Integer.valueOf(area));
                    criteria2.andFDeviceTypeEqualTo((byte) DeviceTypeEnum.terminalDevice.getCode());
                    List<BDeviceInfo> bDeviceInfos = bDeviceInfoMapper.selectByExample(bDeviceInfoExample);

                    //在该区域的异常设备数量
                    BDeviceInfoExample bDeviceInfoExample1 = new BDeviceInfoExample();
                    BDeviceInfoExample.Criteria criteria3 = bDeviceInfoExample1.createCriteria();
                    criteria3.andFLocationEqualTo(Integer.valueOf(area));
                    criteria3.andFEnableStateNotEqualTo(true);
                    criteria3.andFDeviceStateEqualTo((byte) DeviceStateEnum.malfunction.getCode());
                    BDeviceInfoExample.Criteria criteria4 = bDeviceInfoExample1.or();
                    criteria4.andFLocationEqualTo(Integer.valueOf(area));
                    criteria4.andFEnableStateNotEqualTo(true);
                    criteria4.andFDeviceStateEqualTo((byte) DeviceStateEnum.powerOutage.getCode());
                    List<BDeviceInfo> bDeviceInfos1 = bDeviceInfoMapper.selectByExample(bDeviceInfoExample1);
                    exceptionSize += bDeviceInfos1.size();

                    size += bDeviceInfos.size();

                }

                if(size == 0){
                    map.put("UDisk", (0+","+0));
                }else {
                    map.put("UDisk", (size+","+exceptionSize));
                }
            }else if(thirdCode.equals(DeviceChannelThirdCodeEnum.FrequencyModulationOne.getCode()) || thirdCode.equals(DeviceChannelThirdCodeEnum.FrequencyModulationTwo.getCode())){
                //调频
                //查播发区域

                //广播数据表
                if(thirdCode.equals(DeviceChannelThirdCodeEnum.LineOne.getCode())){
                    BBroadcastDataExample bBroadcastDataExample = new BBroadcastDataExample();
                    BBroadcastDataExample.Criteria criteria1 = bBroadcastDataExample.createCriteria();
                    criteria1.andFDeleteFlagEqualTo(false);
                    criteria1.andFStateEqualTo((byte) BroadcastStateEnum.broadcasted.getCode());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    criteria1.andFCreateTimeBetween(simpleDateFormat.parse(fStartTime+" 00:00:00"), simpleDateFormat.parse(fEndTime+" 59:59:59"));
                    criteria1.andFPassSelectEqualTo(fId);
                    List<BBroadcastData> list2 = bBroadcastDataMapper.selectByExample(bBroadcastDataExample);
                    listFMs.addAll(list2);
                }else if(thirdCode.equals(DeviceChannelThirdCodeEnum.LineTwo.getCode())){
                    BBroadcastDataExample bBroadcastDataExample = new BBroadcastDataExample();
                    BBroadcastDataExample.Criteria criteria1 = bBroadcastDataExample.createCriteria();
                    criteria1.andFDeleteFlagEqualTo(false);
                    criteria1.andFStateEqualTo((byte) BroadcastStateEnum.broadcasted.getCode());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    criteria1.andFCreateTimeBetween(simpleDateFormat.parse(fStartTime+" 00:00:00"), simpleDateFormat.parse(fEndTime+" 59:59:59"));
                    criteria1.andFPassSelectEqualTo(fId);
                    List<BBroadcastData> list3 = bBroadcastDataMapper.selectByExample(bBroadcastDataExample);
                    listFMs.addAll(list3);
                }

                Iterator iterator1 = listFMs.iterator();

                //list2是存储广播数据表响应设备通道的播发区域（目前是查询设备通道为话筒的）
                List<String> list2 = new ArrayList<>();
                List<String> list3 = new ArrayList<>();

                while(iterator1.hasNext()){
                    BBroadcastData bBroadcastData = (BBroadcastData) iterator1.next();
                    list2.add(bBroadcastData.getfBroadcastArea());
                }

                Iterator iterator2 = list2.iterator();
                while(iterator2.hasNext()){
                    String l = (String) iterator2.next();
                    String [] m = l.split(",");
                    for (int i=0; i<m.length; i++){
                        list3.add(m[i]);
                    }
                }

                //定时广播表
                BBroadcastTimingExample bBroadcastTimingExample = new BBroadcastTimingExample();
                BBroadcastTimingExample.Criteria criteria6 = bBroadcastTimingExample.createCriteria();
                criteria6.andFDeleteFlagEqualTo(false);
                criteria6.andFDeviceChannelEqualTo(fId);
                // TODO 定时广播表状态的问题

                //list4 得到了所有的以话筒为设备通道的所有的播发区域，并去重、单个
                List<String> list4 = removeDuplicate(list3);

                //根据list中的每个区域对应找该区域的设备
                Iterator iterator3 = list4.iterator();
                int size = 0;
                int exceptionSize=0;
                while(iterator3.hasNext()){
                    String area = (String) iterator3.next();
                    BDeviceInfoExample bDeviceInfoExample = new BDeviceInfoExample();
                    BDeviceInfoExample.Criteria criteria2 = bDeviceInfoExample.createCriteria();
                    criteria2.andFLocationEqualTo(Integer.valueOf(area));
                    criteria2.andFDeviceTypeEqualTo((byte) DeviceTypeEnum.terminalDevice.getCode());
                    List<BDeviceInfo> bDeviceInfos = bDeviceInfoMapper.selectByExample(bDeviceInfoExample);

                    //在该区域的异常设备数量
                    BDeviceInfoExample bDeviceInfoExample1 = new BDeviceInfoExample();
                    BDeviceInfoExample.Criteria criteria3 = bDeviceInfoExample1.createCriteria();
                    criteria3.andFLocationEqualTo(Integer.valueOf(area));
                    criteria3.andFEnableStateNotEqualTo(true);
                    criteria3.andFDeviceStateEqualTo((byte) DeviceStateEnum.malfunction.getCode());
                    BDeviceInfoExample.Criteria criteria4 = bDeviceInfoExample1.or();
                    criteria4.andFLocationEqualTo(Integer.valueOf(area));
                    criteria4.andFEnableStateNotEqualTo(true);
                    criteria4.andFDeviceStateEqualTo((byte) DeviceStateEnum.powerOutage.getCode());
                    List<BDeviceInfo> bDeviceInfos1 = bDeviceInfoMapper.selectByExample(bDeviceInfoExample1);
                    exceptionSize += bDeviceInfos1.size();

                    size += bDeviceInfos.size();
                }
                if(size == 0){
                    map.put("FrequencyModulation", (0+","+0));
                }else {
                    map.put("FrequencyModulation", (size+","+exceptionSize));
                }

            }else if(thirdCode.equals(DeviceChannelThirdCodeEnum.TelephoneMessage.getCode())){
                //电话短信
                BCallandsmsRecordExample bCallandsmsRecordExample = new BCallandsmsRecordExample();
                BCallandsmsRecordExample.Criteria criteria1 = bCallandsmsRecordExample.createCriteria();
                criteria1.andFDeleteFlagEqualTo(false);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                criteria1.andFCreateTimeBetween(simpleDateFormat.parse(fStartTime+" 00:00:00"), simpleDateFormat.parse(fEndTime+" 59:59:59"));

                List<BCallandsmsRecord> list = bCallandsmsRecordMapper.selectByExample(bCallandsmsRecordExample);

                Iterator iterator1 = list.iterator();
                List<String> list1 = new ArrayList<>();
                List<String> list3 = new ArrayList<>();
                while(iterator1.hasNext()) {
                    BCallandsmsRecord bCallandsmsRecord = (BCallandsmsRecord) iterator.next();
                    String area = String.valueOf(bCallandsmsRecord.getfArea());
                    list1.add(area);
                }

                Iterator iterator2 = list1.iterator();
                while(iterator2.hasNext()){
                    String l = (String) iterator2.next();
                    String [] m = l.split(",");
                    for (int i=0; i<m.length; i++){
                        list3.add(m[i]);
                    }
                }

                //list4 得到了所有的以话筒为设备通道的所有的播发区域，并去重、单个
                List<String> list4 = removeDuplicate(list3);

                //根据list中的每个区域对应找该区域的设备
                Iterator iterator3 = list4.iterator();
                int size = 0;
                int exceptionSize=0;
                while(iterator3.hasNext()){
                    String area = (String) iterator3.next();
                    BDeviceInfoExample bDeviceInfoExample = new BDeviceInfoExample();
                    BDeviceInfoExample.Criteria criteria2 = bDeviceInfoExample.createCriteria();
                    criteria2.andFLocationEqualTo(Integer.valueOf(area));
                    criteria2.andFDeviceTypeEqualTo((byte) DeviceTypeEnum.terminalDevice.getCode());
                    List<BDeviceInfo> bDeviceInfos = bDeviceInfoMapper.selectByExample(bDeviceInfoExample);

                    //在该区域的异常设备数量
                    BDeviceInfoExample bDeviceInfoExample1 = new BDeviceInfoExample();
                    BDeviceInfoExample.Criteria criteria3 = bDeviceInfoExample1.createCriteria();
                    criteria3.andFLocationEqualTo(Integer.valueOf(area));
                    criteria3.andFEnableStateNotEqualTo(true);
                    criteria3.andFDeviceStateEqualTo((byte) DeviceStateEnum.malfunction.getCode());
                    BDeviceInfoExample.Criteria criteria4 = bDeviceInfoExample1.or();
                    criteria4.andFLocationEqualTo(Integer.valueOf(area));
                    criteria4.andFEnableStateNotEqualTo(true);
                    criteria4.andFDeviceStateEqualTo((byte) DeviceStateEnum.powerOutage.getCode());
                    List<BDeviceInfo> bDeviceInfos1 = bDeviceInfoMapper.selectByExample(bDeviceInfoExample1);
                    exceptionSize += bDeviceInfos1.size();

                    size += bDeviceInfos.size();
                }
                if(size == 0){
                    map.put("TelephoneMessage", (0+","+0));
                }else {
                    map.put("TelephoneMessage", (size+","+exceptionSize));
                }

            }else if(thirdCode.equals(DeviceChannelThirdCodeEnum.TextToLanguageConversion.getCode())){
                //文本
                //查播发区域

                //广播数据表
                BBroadcastDataExample bBroadcastDataExample = new BBroadcastDataExample();
                BBroadcastDataExample.Criteria criteria1 = bBroadcastDataExample.createCriteria();
                criteria1.andFDeleteFlagEqualTo(false);
                criteria1.andFStateEqualTo((byte) BroadcastStateEnum.broadcasted.getCode());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                criteria1.andFCreateTimeBetween(simpleDateFormat.parse(fStartTime+" 00:00:00"), simpleDateFormat.parse(fEndTime+" 59:59:59"));
                criteria1.andFPassSelectEqualTo(fId);
                List<BBroadcastData> list1 = bBroadcastDataMapper.selectByExample(bBroadcastDataExample);
                Iterator iterator1 = list1.iterator();

                //list2是存储广播数据表响应设备通道的播发区域（目前是查询设备通道为话筒的）
                List<String> list2 = new ArrayList<>();
                List<String> list3 = new ArrayList<>();

                while(iterator1.hasNext()){
                    BBroadcastData bBroadcastData = (BBroadcastData) iterator1.next();
                    list2.add(bBroadcastData.getfBroadcastArea());
                }

                Iterator iterator2 = list2.iterator();
                while(iterator2.hasNext()){
                    String l = (String) iterator2.next();
                    String [] m = l.split(",");
                    for (int i=0; i<m.length; i++){
                        list3.add(m[i]);
                    }
                }

                //定时广播表
                BBroadcastTimingExample bBroadcastTimingExample = new BBroadcastTimingExample();
                BBroadcastTimingExample.Criteria criteria6 = bBroadcastTimingExample.createCriteria();
                criteria6.andFDeleteFlagEqualTo(false);
                criteria6.andFDeviceChannelEqualTo(fId);
                // TODO 定时广播表状态的问题

                //list4 得到了所有的以话筒为设备通道的所有的播发区域，并去重、单个
                List<String> list4 = removeDuplicate(list3);

                //根据list中的每个区域对应找该区域的设备
                Iterator iterator3 = list4.iterator();
                int size = 0;
                int exceptionSize = 0;
                while(iterator3.hasNext()){
                    String area = (String) iterator3.next();
                    BDeviceInfoExample bDeviceInfoExample = new BDeviceInfoExample();
                    BDeviceInfoExample.Criteria criteria2 = bDeviceInfoExample.createCriteria();
                    criteria2.andFLocationEqualTo(Integer.valueOf(area));
                    criteria2.andFDeviceTypeEqualTo((byte) DeviceTypeEnum.terminalDevice.getCode());
                    List<BDeviceInfo> bDeviceInfos = bDeviceInfoMapper.selectByExample(bDeviceInfoExample);

                    //在该区域的异常设备数量
                    BDeviceInfoExample bDeviceInfoExample1 = new BDeviceInfoExample();
                    BDeviceInfoExample.Criteria criteria3 = bDeviceInfoExample1.createCriteria();
                    criteria3.andFLocationEqualTo(Integer.valueOf(area));
                    criteria3.andFEnableStateNotEqualTo(true);
                    criteria3.andFDeviceStateEqualTo((byte) DeviceStateEnum.malfunction.getCode());
                    BDeviceInfoExample.Criteria criteria4 = bDeviceInfoExample1.or();
                    criteria4.andFLocationEqualTo(Integer.valueOf(area));
                    criteria4.andFEnableStateNotEqualTo(true);
                    criteria4.andFDeviceStateEqualTo((byte) DeviceStateEnum.powerOutage.getCode());
                    List<BDeviceInfo> bDeviceInfos1 = bDeviceInfoMapper.selectByExample(bDeviceInfoExample1);
                    exceptionSize += bDeviceInfos1.size();

                    size += bDeviceInfos.size();
                }

                if(size == 0){
                    map.put("TextToLanguageConversion", (0+","+0));
                }else {
                    map.put("TextToLanguageConversion", (size+","+exceptionSize));
                }

            }
        }

        Iterator<Map.Entry<String,String>> it=map.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("=========================> key=" + entry.getKey() + "," + "value=" + entry.getValue());
        }

        return map;
    }

    *//**
     * @Description 给字符串List去重
     * @Author LiLinFeng
     * @param list
     * @return
     *//*
    private static List removeDuplicate(List list) {
        HashSet h = new HashSet(list);
        list.clear();
        list.addAll(h);
        return list;
    }

    *//**
     *将字符串格式yyyyMMdd的字符串转为日期，格式"yyyy-MM-dd"
     *
     * @param date 日期字符串
     * @return 返回格式化的日期
     * @throws ParseException 分析时意外地出现了错误异常
     * @author lilinfeng
     * @date 2019-02-15
     *//*
    public static String strToDateFormat(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        formatter.setLenient(false);
        Date newDate= formatter.parse(date);
        formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(newDate);
    }

    public static void main(String[] args) throws ParseException {
        String date = "2019-02-23 00:00:00";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.parse(date));
    }
*/
}

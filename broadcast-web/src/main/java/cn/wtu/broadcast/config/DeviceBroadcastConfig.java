package cn.wtu.broadcast.config;

import cn.wtu.broadcast.openapi.api.BDeviceInfoService;
import cn.wtu.broadcast.openapi.model.BDeviceInfo;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created on 2019/4/7 13:48
 *
 * @author LY
 */
@Component
public class DeviceBroadcastConfig implements InitializingBean {
    private static BDeviceInfoService bDeviceInfoService;

    @Autowired
    public DeviceBroadcastConfig(BDeviceInfoService bDeviceInfoService) {
        DeviceBroadcastConfig.bDeviceInfoService = bDeviceInfoService;
    }

    public  static Map<Integer,Map<String,String>> map=new HashMap<>();

    public static Map<Integer,Map<String,String>>getDeviceForRegion(){
        reload();
        return map;
    }

    public synchronized static void reload() {
        map.clear();
        List<BDeviceInfo> list = bDeviceInfoService.listAll();
        for (BDeviceInfo bDeviceInfo : list) {
            Map<String,String> info=new HashMap<>();
            info.put("name",bDeviceInfo.getfDeviceName());
            info.put("location",bDeviceInfo.getfLocation().toString());
            map.put(bDeviceInfo.getfId(),info);
        }
    }
    @Override
    public void afterPropertiesSet() {
        reload();
    }
}


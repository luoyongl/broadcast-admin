package cn.wtu.broadcast.config;

import cn.wtu.broadcast.openapi.api.TDictionaryService;
import cn.wtu.broadcast.openapi.model.TDictionary;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 数据字典
 *
 * @author lxg
 * @since 2018-12-20
 */
@Component
public class DictionaryConfig implements InitializingBean {

    private static Map<String, String> map = new HashMap<>();
    
    private static Map<String, List<TDictionary>> listMap = new HashMap<>();

    private static TDictionaryService dictionaryService;

    @Autowired
    public DictionaryConfig(TDictionaryService dictionaryService) {
        DictionaryConfig.dictionaryService = dictionaryService;
    }

    /**
     * 设置值
     */
    public synchronized static void set(String fId, String fDictionaryContent) {
        map.replace(fId, fDictionaryContent);
    }

    /**
     * 获取值
     */
    public static String get(String fId) {
        return map.get(fId);
    }
   

    /**
     * 获取全部配置
     */

    public static Map<String, String> getAllMap(){
        return map;
    }
    public static void getMap(HttpServletRequest request) {
        JSONObject json = JSONObject.fromObject(map);
        request.setAttribute("dictionary", json.toString());
    }

    public static Map<String, List<TDictionary>> getListMap() {
        return listMap;
    }

    /**
     * 刷新配置map
     */
    public synchronized static void reload() {
        map.clear();
        List<TDictionary> list = dictionaryService.selectList();
        for (TDictionary tDictionary : list) {
            map.put(tDictionary.getfId().toString(), tDictionary.getfDictionaryContent());
        }
        listMap.clear();
        listMap = list.stream().collect(Collectors.groupingBy(TDictionary::getfDictionaryCode));
    }

    @Override
    public void afterPropertiesSet() {
        reload();
    }
}
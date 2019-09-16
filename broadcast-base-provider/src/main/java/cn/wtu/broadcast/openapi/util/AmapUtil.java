package cn.wtu.broadcast.openapi.util;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.client.RestTemplate;

/**
 * 高德地图工具类
 *
 * @author sueua
 * @since 2018-12-22
 */
public class AmapUtil {

    private static final String BASE_URL = "https://restapi.amap.com/v3/";

    /**
     * 行政区域api地址
     */
    private static final String DISTRICT_API_URL = BASE_URL + "config/district?keywords=%s&subdistrict=%d&key=%s";

    private static RestTemplate restTemplate = new RestTemplate();

    private AmapUtil() {
    }

    /**
     * 行政区域查询
     */
    public static JsonNode getDistrict(String countyName, int subDistrict, String key) {
        return restTemplate.getForObject(String.format(DISTRICT_API_URL, countyName, subDistrict, key), JsonNode.class);
    }
}

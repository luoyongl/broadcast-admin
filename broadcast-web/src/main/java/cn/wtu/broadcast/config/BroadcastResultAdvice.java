package cn.wtu.broadcast.config;

import cn.wtu.broadcast.parent.exceptions.BizException;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/**
 * 通用结果处理
 *
 * @author sueua
 * @since 2018-12-23
 */
@SuppressWarnings("rawtypes")
@ControllerAdvice
public class BroadcastResultAdvice implements ResponseBodyAdvice {

    /**
     * Whether this component supports the given controller method return type
     * and the selected {@code HttpMessageConverter} type.
     *
     * @param returnType    the return type
     * @param converterType the selected converter type
     * @return {@code true} if {@link #beforeBodyWrite} should be invoked;
     * {@code false} otherwise
     */
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return returnType.getGenericParameterType().equals(BroadcastResult.class);
    }

    /**
     * Invoked after an {@code HttpMessageConverter} is selected and just before
     * its write method is invoked.
     *
     * @param body                  the body to be written
     * @param returnType            the return type of the controller method
     * @param selectedContentType   the content type selected through content negotiation
     * @param selectedConverterType the converter type selected to write to the response
     * @param request               the current request
     * @param response              the current response
     * @return the body that was passed in or a modified (possibly new) instance
     */
    @Override
    @SuppressWarnings("unchecked")
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        BroadcastResult broadcastResult = (BroadcastResult) body;
        Object data = broadcastResult.getData();
        if (data instanceof List) {
            //返回list
            List list = (List) data;
            broadcastResult.setData(toFormatterList(list));
        } else if (data instanceof PageInfo) {
            //返回分页
            PageInfo pageInfo = (PageInfo) data;
            List list = pageInfo.getList();
            pageInfo.setList(toFormatterList(list));
        }
        return body;
    }

    @SuppressWarnings("all")
    private List<Map<String, Object>> toFormatterList(List list) {
        ConcurrentMap<Integer, String> userMap = UserData.getMap();
        List<Map<String, Object>> resultList = new ArrayList<>();
        for (Object item : list) {
            if (item instanceof Map) {
                return list;
            } else {
                Class<?> clazz = item.getClass();
                Field[] fields = FieldUtils.getAllFields(clazz);
                Map<String, Object> map = new HashMap<>(8);
                for (Field field : fields) {
                    field.setAccessible(true);
                    String fieldName = field.getName();
                    try {
                        Object value = field.get(item);
                        if ("fCreatorId".equals(fieldName)) {
                            if (value != null) {
                                map.put("creator", userMap.get(value));
                            } else {
                                map.put("creator", null);
                            }
                        } else if ("fOperatorId".equals(fieldName)) {
                            if (value != null) {
                                map.put("operator", userMap.get(value));
                            } else {
                                map.put("operator", null);
                            }
                        } else if ("serialVersionUID".equals(fieldName)) {
                            continue;
                        }
                        map.put(fieldName, value);
                    } catch (Exception e) {
                        throw new BizException(e.getMessage());
                    }
                }
                resultList.add(map);
            }
        }
        return resultList;
    }
}

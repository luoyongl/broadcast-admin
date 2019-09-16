package cn.wtu.broadcast.exception;

import cn.wtu.broadcast.parent.exceptions.BizException;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局处理异常
 *
 * @author sueua
 * @date 2018-12-22
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 缺少参数异常
     */
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public ModelAndView missingServletRequestParameterException(MissingServletRequestParameterException ex, HttpServletRequest request) {
        log.info("缺少参数:{}", ex.getParameterName());
        ModelAndView modelAndView = getModelAndView(request, "error/info");
        modelAndView.addAllObjects(broadcastResult2Map(BroadcastResult.fail("缺少参数:" + ex.getParameterName())));
        return modelAndView;
    }

    /**
     * 自定义运行异常
     */
    @ExceptionHandler({BizException.class})
    public ModelAndView baseRuntimeException(BizException ex, HttpServletRequest request) {
        log.debug(ex.getMessage(), ex);
        ModelAndView modelAndView = getModelAndView(request, "error/info");
        modelAndView.addAllObjects(broadcastResult2Map(BroadcastResult.fail(ex.getMessage())));
        return modelAndView;
    }

    /**
     * 运行异常
     */
    @ExceptionHandler({RuntimeException.class})
    public ModelAndView runtimeException(RuntimeException ex, HttpServletRequest request) {
        log.error(ex.getMessage(), ex);
        ModelAndView modelAndView = getModelAndView(request);
        modelAndView.addAllObjects(broadcastResult2Map(BroadcastResult.fail(ex.getMessage())));
        return modelAndView;
    }

    /**
     * 适配请求方式,json或普通web请求
     *
     * @param viewName 视图
     */
    private ModelAndView getModelAndView(HttpServletRequest request, String viewName) {
        boolean isAjax = request.getHeader("accept") == null || !request.getHeader("accept").contains("text/html,application/xhtml+xml");
        if (isAjax) {
            return new ModelAndView(new MappingJackson2JsonView());
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName(viewName);
            return modelAndView;
        }
    }

    /**
     * 适配请求方式,json或普通web请求
     */
    private ModelAndView getModelAndView(HttpServletRequest request) {
        return getModelAndView(request, "error/error");
    }

    private Map<String, Object> broadcastResult2Map(BroadcastResult broadcastResult) {
        Map<String, Object> map = new HashMap<>(5);
        map.put("status", broadcastResult.getStatus());
        map.put("msg", broadcastResult.getMsg());
        map.put("data", broadcastResult.getData());
        return map;
    }
}

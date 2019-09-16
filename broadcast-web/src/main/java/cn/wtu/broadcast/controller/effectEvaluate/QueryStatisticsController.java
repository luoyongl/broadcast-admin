package cn.wtu.broadcast.controller.effectEvaluate;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.collect.Maps;

import cn.wtu.broadcast.openapi.api.BBroadcastDataService;
import cn.wtu.broadcast.openapi.api.TAdministrativeDivisionService;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.parent.constant.Constant;
import cn.wtu.broadcast.parent.enums.BroadcastStateEnum;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;

/**
 * @Description 查询统计
 * @author yinjie
 * @FromDate 2019-06-30
 */
@Controller
@RequestMapping("/effectEvaluate/queryStatistics")
public class QueryStatisticsController {
	
	@Autowired
    private TAdministrativeDivisionService tAdministrativeDivisionService;
	
	@Autowired
	private BBroadcastDataService bbroadcastDataService;

	/**
	 * 页面展示
	 * @return
	 */
	@RequestMapping("")
	public String ui(HttpServletRequest request){
		return "effectEvaluate/queryStatistics";
	}
	
	/**
	 * 执行复杂查询
	 * @param sortOrder
	 * @param sortName
	 * @param searchText
	 * @param pageNumber
	 * @param pageSize
	 * @param session
	 * @return
	 */
	@RequestMapping("/implementComplexQuery")
	@ResponseBody
	public BroadcastResult implementComplexQuery(@RequestParam(defaultValue = "desc", required = false) String sortOrder,
            @RequestParam(defaultValue = "f_id", required = false) String sortName,
            @RequestParam(defaultValue = "searchText", required = false) List<String> searchText,
            @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
            @RequestParam(defaultValue = "10", required = false) Integer pageSize,
            HttpSession session) throws Exception{
		Map<String,Object> paramMap = Maps.newHashMap();
		
		paramMap.put("pageNumber", pageNumber);
        paramMap.put("pageSize", pageSize);
        
        Map<String, String> searchMap = Maps.newHashMap();
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        
        //List<ComplexQueryListVO> searchText = listDto.getSearchText();
        if (searchText != null) {
        	//List<ComplexQueryListVO> searchText = listDto.getSearchText();
        	for (String str : searchText) {
    			String[] split = str.split(";");
    			if (split.length <= 1) {
    				searchMap.put(split[0] , null);
				}else{
					searchMap.put(split[0], split[1]);					
				}
    		}
            
            Set<String> keySet = searchMap.keySet();
            Iterator<String> iterator = keySet.iterator();
            while (iterator.hasNext()) {
    			String key = iterator.next();
    			if (key.equals("广播类型")) {
    				paramMap.put("fBroadcastType", searchMap.get(key));
    			}else if (key.equals("有效起始时间")) {
    				if (searchMap.get(key) != null) {
    					paramMap.put("effectiveStartTime", format.parse(searchMap.get(key)));
					}
    			}else if (key.equals("有效结束时间")) {
    				if (searchMap.get(key) != null) {
    					paramMap.put("effectiveEndTime", format.parse(searchMap.get(key)));
					}
    			}else if (key.equals("消息级别")) {
    				paramMap.put("messageLevel", searchMap.get(key));
    			}else if (key.equals("消息类型")) {
    				paramMap.put("messageType", searchMap.get(key));
    			}else if (key.equals("消息来源")) {
    				paramMap.put("messageSource", searchMap.get(key));
    			}else if (key.equals("操作者")) {
    				paramMap.put("operate", searchMap.get(key));
    			}else if (key.equals("播发区域")) {
    				paramMap.put("BroadcastArea", searchMap.get(key));
    			}
    			
    			else if (key.equals("状态")) {
    				if (searchMap.get(key) != null) {
    					if (searchMap.get(key).equals("待审核")) {
        		            paramMap.put("searchEq", BroadcastStateEnum.waitReview.getCode());
        		        } else if (searchMap.get(key).equals("待播发")||searchMap.get(key).equals("已审核")) {
        		            paramMap.put("searchEq", BroadcastStateEnum.waitBroadcast.getCode());
        		        } else if (searchMap.get(key).equals("未开播")) {
        		            paramMap.put("searchEq", String.valueOf(BroadcastStateEnum.no.getCode()));
        		        } else if (searchMap.get(key).equals("正在播")) {
        		            paramMap.put("searchEq", BroadcastStateEnum.broadcasting.getCode());
        		        } else if (searchMap.get(key).equals("已播发")) {
        		            paramMap.put("searchEq", BroadcastStateEnum.broadcasted.getCode());
        		        } else if (searchMap.get(key).equals("未通过")) {
        		            paramMap.put("searchEq", BroadcastStateEnum.reviewFail.getCode());
        		        } else if (searchMap.get(key).equals("不通过")) {
        					paramMap.put("searchEq", BroadcastStateEnum.reviewFail.getCode());
        		        } else if (searchMap.get(key).equals("已过期")) {
        		            paramMap.put("searchEq", BroadcastStateEnum.userDefined.getCode());
        		        } 
					}
    			}
    		}
		}
        
        paramMap.put("sortOrder", sortOrder);
        if (sortName.equals("fRealMessageLevel")) {
            paramMap.put("sortName", "f_message_level");
        } else if (sortName.equals("fState")) {
            paramMap.put("sortName", "f_state");
        } else if (sortName.equals("fEffectiveTime")) {
            paramMap.put("sortName", "f_effective_time");
        } else if (sortName.equals("fRealMessageSource")) {
            paramMap.put("sortName", "f_message_source");
        } else {
            paramMap.put("sortName", "f_id");
        }
        
        //根据用户所在区域查询
        TUser tUser = (TUser) session.getAttribute(Constant.CURRENT_USER);
        int parentNode=tAdministrativeDivisionService.selectByPrimaryKey(tUser.getfRespectiveRegion()).getfParentNode();
        paramMap.put("reviewRegion",tUser.getfRespectiveRegion());
        paramMap.put("parentNode",parentNode);
		return BroadcastResult.ok(bbroadcastDataService.queryPageByBroadcastStatistics(paramMap));
	}
	
}

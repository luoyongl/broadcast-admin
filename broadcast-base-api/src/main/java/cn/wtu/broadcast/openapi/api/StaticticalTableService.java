package cn.wtu.broadcast.openapi.api;

import java.util.Map;

import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.openapi.vo.BroadcastingVO;

public interface StaticticalTableService {
	
	/**
	 * @return 历史播发任务广播类型
	 */
	Map<String, String[]> getBroTypePieInfo();
	
	Map<String, String[]> getAveCoverageBarInfo();
	
	Map<String, String[]> getAveAnswerTimeBarInfo();
	
	Map<String, String[]> getRealtimeBroInfo();
	
	PageInfo<BroadcastingVO> getBroadcastingInfo(Map<String, Object> paramMap);
    /**
     * @Description 查询数据并显示在表格中
     * @return
     */
   // Map<String, String>  selectStatisticalAllTab();

    /**
     * @Description 统计相应的数据并显示在图表中
     * @param dates
     * @return
     */
    //int[][] selectStatisticalAllCharts(String[] dates);

    /**
     * @Description 依据时间段查询数据并显示在表格中
     * @param fStartTime
     * @param fEndTime
     * @return
     */
    //Map<String, String>  selectStatisticalAllTabForTimes(String fStartTime, String fEndTime) throws ParseException;


}

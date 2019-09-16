package cn.wtu.broadcast.controller.effectEvaluate;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wtu.broadcast.openapi.api.StaticticalTableService;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;

/**
 * @Description 统计报表
 * @Author LiLinFeng
 * @FromDate 2019-01-20
 */
@Controller
@RequestMapping("effectEvaluate/statisticalTable")
public class StatisticalTableController {

	@Autowired
	private StaticticalTableService staticticalTableService;

	@GetMapping
	public String ui(HttpServletRequest request){

		return "effectEvaluate/statisticalTable";
	}

	@RequestMapping("/showBroTypePie")
	@ResponseBody
	public BroadcastResult showBroTypePie(){
		Map<String, String[]> map= new HashMap<String,String[]>();
		map = staticticalTableService.getBroTypePieInfo();
		return BroadcastResult.ok(map);
	}
	
	@RequestMapping("/showAveCoverageBar")
	@ResponseBody
	public BroadcastResult showAveCoverageBar(){
		Map<String, String[]> map= new HashMap<String,String[]>();
		map = staticticalTableService.getAveCoverageBarInfo();
		return BroadcastResult.ok(map);
	}
	
	@RequestMapping("/showAveAnswerTimeBar")
	@ResponseBody
	public BroadcastResult showAveAnswerTimeBar(){
		Map<String, String[]> map= new HashMap<String,String[]>();
		map = staticticalTableService.getAveAnswerTimeBarInfo();
		return BroadcastResult.ok(map);
	}
	
	@RequestMapping("/showRealtimeBroInfoLine")
	@ResponseBody
	public BroadcastResult showRealtimeBroInfoLine(){
		Map<String, String[]> map= new HashMap<String,String[]>();
		map = staticticalTableService.getRealtimeBroInfo();
		return BroadcastResult.ok(map);
	}
	
	@RequestMapping("/selectBroadcastingInfo")
	@ResponseBody
    public BroadcastResult selectBroadcastingInfo(
            @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
            @RequestParam(defaultValue = "5", required = false) Integer pageSize) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("pageNumber", pageNumber);
        paramMap.put("pageSize", pageSize);

        return BroadcastResult.ok(staticticalTableService.getBroadcastingInfo(paramMap));
    }
/*	*//**
	 * @Description 查询所有的数据并展示到图中
	 * @param fStartTime
	 * @return
	 * @throws ParseException
	 *//*
	@SuppressWarnings("unused")
	@RequestMapping("/selectPieAllList/{fStartTime}")
	@ResponseBody
	public String selectPieAllList(@PathVariable String fStartTime) throws ParseException {

		String title = "";
		Object[] types = {"线路","话筒","文本","调频","电话","U盘"};
		int[][] datas = {
				{0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0}
		};
		String []dates = new String[7];
		if (fStartTime.equals("1")){
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			String format1 = format.format(date);
			Date date1 = format.parse(format1);
			Calendar instance = Calendar.getInstance();
			instance.setTime(date1);
			instance.add(Calendar.DAY_OF_MONTH,-8);
			Date time1 = instance.getTime();

			Calendar instance1 = Calendar.getInstance();
			instance.setTime(time1);
			instance.add(Calendar.DAY_OF_MONTH,1);

			dates[0] = new SimpleDateFormat("yyyy-MM-dd").format(time1);
			for(int i=1; i<=6; i++){
				instance.add(Calendar.DAY_OF_MONTH,1);
				dates[i] = new SimpleDateFormat("yyyy-MM-dd").format(instance.getTime());
			}

			//int[][] newDatas = new int[7][6];
			int[][] newDatas = staticticalTableService.selectStatisticalAllCharts(dates);

			for(int i=0; i<6; i++){
				for (int j=0; j<7; j++){
					datas[i][j] = newDatas[i][j];
				}
			}

		} else {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(fStartTime);
			Calendar instance = Calendar.getInstance();
			instance.setTime(date);

			dates[0] = new SimpleDateFormat("yyyy-MM-dd").format(date);
			for(int i=1; i<=6; i++){
				instance.add(Calendar.DAY_OF_MONTH,1);
				dates[i] = new SimpleDateFormat("yyyy-MM-dd").format(instance.getTime());
			}

			//int[][] newDatas = new int[7][6];
			int[][] newDatas = staticticalTableService.selectStatisticalAllCharts(dates);

			for(int i=0; i<6; i++){
				for (int j=0; j<7; j++){
					datas[i][j] = newDatas[i][j];
				}
			}
		}

		Object[] weeks ={dates[0],dates[1],dates[2],dates[3],dates[4],dates[5],dates[6]};

		Option option = new GsonOption();

		//option.title().text(title).x("left");
		option.legend().data(types).x("left");

		option.tooltip().show(true);
		option.toolbox().show(true).feature(Tool.magicType, Tool.saveAsImage);

		CategoryAxis categoryAxis = new CategoryAxis();

		categoryAxis.data(weeks);
		option.xAxis(categoryAxis);
		option.yAxis(new ValueAxis());
		//循环为了获取多条折线数据
		for(int i =0;i< types.length;i++){

			//创建line对象
			Line line = new Line();
			String type = String.valueOf(types[i]);
			line.name(type);
			for(int j = 0; j<weeks.length;j++){

				line.data(datas[i][j]);

			}
			option.series(line);
		}
		return option.toString();
	}

	*//**
	 * @Description 查询所有的数据并展示到表格
	 * @return
	 * @throws ParseException
	 *//*
	@RequestMapping("/selectAllTabList")
	@ResponseBody
	public BroadcastResult selectAllTabList(){
		Map<String, String> map= staticticalTableService.selectStatisticalAllTab();
		return BroadcastResult.ok(map);
	}

	*//**
	 * @Description 按时间段查询数据并显示到表格中
	 * @param fStartTime
	 * @param fEndTime
	 * @return
	 *//*
	@RequestMapping("/selectAllTabListForTimes/{fStartTime}/{fEndTime}")
	@ResponseBody
	public BroadcastResult selectAllTabListForTimes(@PathVariable String fStartTime, @PathVariable String fEndTime) throws ParseException {
		Map<String, String> map= staticticalTableService.selectStatisticalAllTabForTimes(fStartTime, fEndTime);
		return BroadcastResult.ok(map);
	}*/
}

package cn.wtu.broadcast.controller.system;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.afterturn.easypoi.cache.manager.POICacheManager;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.wtu.broadcast.config.DictionaryConfig;
import cn.wtu.broadcast.config.RegionData;
import cn.wtu.broadcast.controller.BaseController;
import cn.wtu.broadcast.openapi.api.ManufacturerService;
import cn.wtu.broadcast.openapi.api.ModulationService;
import cn.wtu.broadcast.openapi.api.RegionService;
import cn.wtu.broadcast.openapi.api.TDictionaryService;
import cn.wtu.broadcast.openapi.model.TAdministrativeDivision;
import cn.wtu.broadcast.openapi.model.TDictionary;
import cn.wtu.broadcast.openapi.model.TManufacturer;
import cn.wtu.broadcast.openapi.model.TModulation;
import cn.wtu.broadcast.openapi.vo.RegionVO;
import cn.wtu.broadcast.parent.pojo.BroadcastResult;
import cn.wtu.broadcast.parent.vo.ModulationParameter;

/**
 * 基础数据控制器
 *
 * @author sueua
 * @since 2018-12-20
 */
@Controller
@RequestMapping("systemManage/baseData")
public class BaseDataController extends BaseController {

	private final TDictionaryService tDictionaryService;

	private final RegionService regionService;

	private final ManufacturerService manufacturerService;

	private final ModulationService modulationService;

	@Autowired
	public BaseDataController(TDictionaryService tDictionaryService, RegionService regionService,
			ManufacturerService manufacturerService, ModulationService modulationService) {
		this.tDictionaryService = tDictionaryService;
		this.regionService = regionService;
		this.manufacturerService = manufacturerService;
		this.modulationService = modulationService;
	}

	/**
	 * 基础数据页面
	 */
	@GetMapping
	public String ui(Model model) {
		model.addAttribute("dictCategories", tDictionaryService.selectDictCategory());
		return "systemManage/baseData";
	}

	/**
	 * 字典数据
	 */
	@GetMapping("dict")
	@ResponseBody
	public BroadcastResult dictList(@RequestParam String code) {
		List<TDictionary> tDictionaryList = tDictionaryService.selectListByCriteria(code);
		if (tDictionaryList == null) {
			tDictionaryList = Collections.emptyList();
		}
		return BroadcastResult.ok(tDictionaryList);
	}

	/**
	 * 保存字典
	 *
	 * @param tDictionary
	 *            字典
	 */
	@PostMapping("dict")
	@ResponseBody
	public BroadcastResult saveDict(TDictionary tDictionary) {
		if (tDictionaryService.save(tDictionary)) {
			// 刷新字典
			DictionaryConfig.reload();
			return BroadcastResult.ok();
		} else {
			return BroadcastResult.fail();
		}
	}

	/**
	 * 批量删除字典
	 *
	 * @param dictIdList
	 *            字典id列表
	 */
	@DeleteMapping("dict")
	@ResponseBody
	public BroadcastResult deleteBatchDict(@RequestParam(value = "dictId") List<Integer> dictIdList) {
		int result = tDictionaryService.deleteBatch(dictIdList);
		if (result > 0) {
			// 刷新字典
			DictionaryConfig.reload();
		}
		return BroadcastResult.build(200, "删除了" + result + "条记录");
	}

	/**
	 * 初始化行政区域
	 */
	@PostMapping("region/init")
	@ResponseBody
	public BroadcastResult initArea() {
		if (regionService.init()) {
			RegionData.reload();
			return BroadcastResult.ok();
		} else {
			return BroadcastResult.fail();
		}
	}

	/**
	 * 下载导入模板
	 */
	@GetMapping("region/template")
	public ResponseEntity<byte[]> regionTemplate() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		InputStream inputStream = POICacheManager.getFile("excel/region_template.xlsx");
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment",
				new String("行政区域模板.xlsx".getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
		return new ResponseEntity<>(IOUtils.toByteArray(inputStream), headers, HttpStatus.CREATED);
	}

	/**
	 * 导入行政数据
	 */
	@SuppressWarnings("deprecation")
	@PostMapping("region/import")
	@ResponseBody
	public BroadcastResult regionImport(@RequestParam MultipartFile file) {
		try {
			ImportParams params = new ImportParams();
			params.setTitleRows(1);
			params.setHeadRows(1);
			params.setKeyIndex(0);
			List<RegionVO> list = ExcelImportUtil.importExcel(file.getInputStream(), RegionVO.class, params);
			if (regionService.importData(list)) {
				RegionData.reload();
				return BroadcastResult.ok("导入成功");
			}
		} catch (Exception e) {
			return BroadcastResult.fail(e.getMessage());
		}
		return BroadcastResult.fail();
	}

	/**
	 * 行政区域数据
	 */
	@GetMapping("region")
	@ResponseBody
	public BroadcastResult regionList() {
		return BroadcastResult.ok(regionService.selectList());
	}

	/**
	 * 保存行政区域
	 *
	 * @param tAdministrativeDivision
	 *            行政区域
	 */
	@PostMapping("region")
	@ResponseBody
	public BroadcastResult save(TAdministrativeDivision tAdministrativeDivision) {
		if (regionService.save(tAdministrativeDivision)) {
			RegionData.reload();
			return BroadcastResult.ok();
		} else {
			return BroadcastResult.fail();
		}
	}

	/**
	 * 批量删除行政区域
	 *
	 * @param regionIdList
	 *            行政区域id列表
	 */
	@DeleteMapping("region")
	@ResponseBody
	public BroadcastResult deleteBatchRegion(@RequestParam(value = "regionId") List<Integer> regionIdList) {
		int result = regionService.deleteBatch(regionIdList);
		if (result > 0) {
			RegionData.reload();
		}
		return BroadcastResult.build(200, "删除了" + result + "条记录");
	}

	/**
	 * 厂商数据
	 */
	@GetMapping("manufacturer")
	@ResponseBody
	public BroadcastResult manufacturerList(@RequestParam(defaultValue = "1", required = false) Integer pageNumber,
			@RequestParam(defaultValue = "10", required = false) Integer pageSize) {
		Map<String, Object> paramMap = new HashMap<>(4);
		paramMap.put("pageNo", pageNumber);
		paramMap.put("pageSize", pageSize);
		return BroadcastResult.ok(manufacturerService.queryPageByParam(paramMap));
	}

	/**
	 * 保存厂商
	 *
	 * @param tManufacturer
	 *            厂商
	 */
	@PostMapping("manufacturer")
	@ResponseBody
	public BroadcastResult save(TManufacturer tManufacturer) {
		if (manufacturerService.save(tManufacturer)) {
			return BroadcastResult.ok();
		} else {
			return BroadcastResult.fail();
		}
	}

	/**
	 * 批量删除厂商
	 *
	 * @param manufacturerIdList
	 *            厂商id列表
	 */
	@DeleteMapping("manufacturer")
	@ResponseBody
	public BroadcastResult deleteBatchManufacturer(
			@RequestParam(value = "manufacturerId") List<Integer> manufacturerIdList) {
		int result = manufacturerService.deleteBatch(manufacturerIdList);
		return BroadcastResult.build(200, "删除了" + result + "条记录");
	}

	/**
	 * 1.保存调制方式 modulationMode
	 * 2.生成调制参数 并保存到  基础数据-调制参数
	 * @author lxg
	 * @since 2019/02/24
	 * @param modulation
	 */
	@PostMapping("modulationMode")
	@ResponseBody
	public BroadcastResult saveModulationMode(TModulation modulation) {
		//调制参数 按照 文档格式 封装 13字节 26位 hex
		if (modulationService.update(modulation)) {
			// 保存之后 将数据封装为特定格式
			// 1.封装DTMB调制参数   13字节 =26位hex 去掉前缀5A0B 剩余22位hex 8+1+1+1+1+1+9=17+5=22 	
			//注意modulation.getfDtmbCentreFrequency() 的范围为  44-999
			String Centre_frequency = "0" + modulation.getfDtmbCentreFrequency() + "0000";// 8位hex
			String FEC = modulation.getfDtmbFec();// 1位hex
			String dtmbModulation = modulation.getfDtmbModulation();// 1位hex
			String Number_of_subcarrier = modulation.getfDtmbNumberOfSubcarrier();// 1位hex
			String Other_frequency_flag = modulation.getfDtmbOtherFrequencyFlag();// 1位hex
			String Sfn_mfn_flag = modulation.getfDtmbSfnMfnFlag();// 1位hex
			String dtmbReserved = "3FFFFFFFF";//34位2进制 前面补2个0  36/4=9位hex

			String dtmbParameter = Centre_frequency + FEC + dtmbModulation + Number_of_subcarrier + Other_frequency_flag
					+ Sfn_mfn_flag + dtmbReserved;
			
			// 2.封装DVB-C调制参数   13字节 =26位hex 去掉前缀440B 剩余22位hex  8+3+1+2+7+1=22
			//注意  modulation.getfDvbcFrequency()范围在    符号率odulation.getfDvbcSymbolRate() 4位 6875
			String dvbcFrequency="0"+modulation.getfDvbcFrequency()+"0000";// 8位hex
			String dvbcReserved="FFF";// 3位hex
			String FEC_outer=modulation.getfDvbcFecOuter();// 1位hex
			String dvbcModulation="0"+modulation.getfDvbcModulation();// 2位hex
			String Symbol_rate=modulation.getfDvbcSymbolRate()+"000";// 7位hex
			String FEC_inner =modulation.getfDvbcFecInner();// 1位hex
			
			String dvbcParameter = dvbcFrequency+dvbcReserved+FEC_outer+dvbcModulation+Symbol_rate+FEC_inner;
			System.out.println("dtmbParameter:"+dtmbParameter);
			System.out.println("dvbcParameter:"+dvbcParameter);
			// 将数据更新到 基础数据-》调制参数
			//ServiceID  PCRPID DTMB DVB-C
			ModulationParameter modulationParameter=new ModulationParameter(modulation.getfServiceId(), modulation.getfPcrPid(), dtmbParameter, dvbcParameter);
			modulationService.updateModulation(modulationParameter);
			return BroadcastResult.ok();
		} else {
			return BroadcastResult.fail();
		}
	}
}

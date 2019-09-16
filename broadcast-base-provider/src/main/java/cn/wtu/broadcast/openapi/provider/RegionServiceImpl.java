package cn.wtu.broadcast.openapi.provider;

import cn.wtu.broadcast.openapi.api.RegionService;
import cn.wtu.broadcast.openapi.dao.TAdministrativeDivisionMapper;
import cn.wtu.broadcast.openapi.model.TAdministrativeDivision;
import cn.wtu.broadcast.openapi.model.TAdministrativeDivisionExample;
import cn.wtu.broadcast.openapi.model.TUser;
import cn.wtu.broadcast.openapi.util.AmapUtil;
import cn.wtu.broadcast.openapi.vo.RegionVO;
import cn.wtu.broadcast.parent.db.api.DBInterface;
import cn.wtu.broadcast.parent.enums.OperationLogTypeEnum;
import cn.wtu.broadcast.parent.exceptions.BizException;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/**
 * 行政区域service接口实现
 *
 * @author sueua
 * @since 2018-12-22
 */
@Service("regionService")
public class RegionServiceImpl extends ParentServiceImpl<TAdministrativeDivision> implements RegionService {

    private final TAdministrativeDivisionMapper tAdministrativeDivisionMapper;

    private final String countyRegex = "\\d{6}000000";

    private final String townRegex = "\\d{9}000";

    @Autowired
    public RegionServiceImpl(TAdministrativeDivisionMapper tAdministrativeDivisionMapper) {
        this.tAdministrativeDivisionMapper = tAdministrativeDivisionMapper;
    }

    /**
     * 获取数据操作实例,不能为空,子类必须实现该方法
     */
    @Override
    protected DBInterface<TAdministrativeDivision> getDao() {
        return tAdministrativeDivisionMapper;
    }

    /**
     * 初始化行政区域
     *
     * @return 成功或失败
     */
    @Override
    public boolean init() {
        String countyName = getSystemConfig("county_name");
        if (countyName == null) {
            throw new BizException("系统配置中区县名称为空或未保存");
        } else {
            TAdministrativeDivisionExample example = new TAdministrativeDivisionExample();
            example.createCriteria().andFDeleteFlagEqualTo(false);
            List<TAdministrativeDivision> list = tAdministrativeDivisionMapper.selectByExample(example);
            if (list.size() > 0) {
                throw new BizException("行政区域已初始化,禁止重复执行");
            } else {
                Date time = new Date();
                TUser sessionUser = getSessionUser();
                try {
                    JsonNode rootNode = AmapUtil.getDistrict(countyName, 1, getSystemConfig("amap_web_key"));
                    JsonNode countyNode = rootNode.get("districts").get(0);
                    TAdministrativeDivision county = jsonNode2Division(countyNode, time, sessionUser.getfId(), 0);
                    tAdministrativeDivisionMapper.insert(county);
                    JsonNode districts = countyNode.get("districts");
                    if (districts.isArray()) {
                        byte sort = 0;
                        for (JsonNode district : districts) {
                            TAdministrativeDivision division = jsonNode2Division(district, time, sessionUser.getfId(), county.getfId());
                            division.setfSort(sort++);
                            tAdministrativeDivisionMapper.insert(division);
                        }
                    }
                    insertLog(OperationLogTypeEnum.INSERT, "初始化行政区域", "成功");
                    return true;
                } catch (Exception e) {
                    throw new BizException("地图解析失败");
                }
            }
        }
    }

    private TAdministrativeDivision jsonNode2Division(JsonNode jsonNode, Date time, Integer creatorId, Integer parentNode) {
        TAdministrativeDivision division = new TAdministrativeDivision();
        division.setfCreateTime(time);
        division.setfCreatorId(creatorId);
        division.setfParentNode(parentNode);
        division.setfDeleteFlag(false);
        division.setfName(jsonNode.get("name").asText());
        division.setfCode(jsonNode.get("adcode").asText() + "000000");
        String[] location = jsonNode.get("center").asText().split(",");
        division.setfLongitude(location[0]);
        division.setfLatitude(location[1]);
        return division;
    }

    /**
     * 查询所有区域
     *
     * @return 全部区域list
     */
    @Override
    public List<TAdministrativeDivision> selectList() {
        TAdministrativeDivisionExample example = new TAdministrativeDivisionExample();
        example.createCriteria().andFDeleteFlagEqualTo(false);
        example.setOrderByClause("f_sort");
        return tAdministrativeDivisionMapper.selectByExample(example);
    }

    /**
     * 保存区域
     *
     * @param tAdministrativeDivision 行政区域
     * @return 影响的行数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean save(TAdministrativeDivision tAdministrativeDivision) {
        Date time = new Date();
        TUser sessionUser = getSessionUser();
        int result;
        if (tAdministrativeDivision.getfId() != null) {
            tAdministrativeDivision.setfOperatorId(sessionUser.getfId());
            tAdministrativeDivision.setfUpdateTime(time);
            if (checkCodeIsExist(tAdministrativeDivision.getfCode(), tAdministrativeDivision.getfId())) {
                throw new BizException("编码[" + tAdministrativeDivision.getfCode() + "]:编码重复");
            }
            result = tAdministrativeDivisionMapper.updateByPrimaryKeySelective(tAdministrativeDivision);
            insertLog(OperationLogTypeEnum.UPDATE, "修改行政区域", result > 0 ? "成功" : "失败");
        } else {
            tAdministrativeDivision.setfCreatorId(sessionUser.getfId());
            tAdministrativeDivision.setfCreateTime(time);
            tAdministrativeDivision.setfDeleteFlag(false);
            if (checkCodeIsExist(tAdministrativeDivision.getfCode(), null)) {
                throw new BizException("编码[" + tAdministrativeDivision.getfCode() + "]:编码重复");
            }
            result = tAdministrativeDivisionMapper.insert(tAdministrativeDivision);
            insertLog(OperationLogTypeEnum.INSERT, "新增行政区域", result > 0 ? "成功" : "失败");
        }
        return result > 0;
    }

    /**
     * 批量删除行政区域
     *
     * @param regionIdList 行政区域列表
     * @return 删除的记录数
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteBatch(List<Integer> regionIdList) {
        int result = 0;
        Date time = new Date();
        TUser sessionUser = getSessionUser();
        for (Integer regionId : regionIdList) {
            TAdministrativeDivision region = new TAdministrativeDivision();
            region.setfDeleteFlag(true);
            region.setfId(regionId);
            region.setfUpdateTime(time);
            region.setfOperatorId(sessionUser.getfId());
            result = result + tAdministrativeDivisionMapper.updateByPrimaryKeySelective(region);
        }
        insertLog(OperationLogTypeEnum.DELETE, "删除行政区域", "删除了" + result + "条记录");
        return result;
    }

    /**
     * 导入数据
     *
     * @param list list数据
     * @return 导入结果
     */
    @Override
    public boolean importData(List<RegionVO> list) {
        List<TAdministrativeDivision> regionList = regionVo2region(list);
        AtomicInteger result = new AtomicInteger();
        regionList.forEach(region -> {
            String code = region.getfCode();
            if (checkCodeIsExist(code, null)) {
                throw new BizException("编码[" + code + "]:编码重复");
            }
            if (!Pattern.matches(countyRegex, code)) {
                Integer pid = getPid(code);
                if (pid == null) {
                    throw new BizException("编码[" + code + "]:没有上级行政区域");
                } else {
                    region.setfParentNode(pid);
                }
            }
            result.addAndGet(tAdministrativeDivisionMapper.insert(region));
        });
        insertLog(OperationLogTypeEnum.INSERT, "导入了" + result + "条记录", result.intValue() > 0 ? "成功" : "失败");
        return true;
    }

    /**
     * 校验
     */
    private List<TAdministrativeDivision> regionVo2region(List<RegionVO> list) {
        Date createTime = new Date();
        TUser user = getSessionUser();
        final int codeLength = 12;
        final int nameMaxLength = 40;
        final int sortMaxValue = 255;
        final int sortMinValue = 0;
        List<TAdministrativeDivision> regionList = new ArrayList<>();
        list.forEach(regionVO -> {
            String code = regionVO.getCode();
            if (StringUtils.isBlank(code)) {
                throw new BizException("编码不能为空");
            } else {
                if (code.length() != codeLength) {
                    throw new BizException("编码[" + code + "]:编码必须为12位");
                }
            }
            TAdministrativeDivision region = new TAdministrativeDivision();
            region.setfCode(code);
            region.setfCreateTime(createTime);
            region.setfCreatorId(user.getfId());
            String longitude = regionVO.getLongitude();
            if (longitude != null) {
                if (longitude.length() < nameMaxLength && isNumeric(longitude)) {
                    region.setfLongitude(longitude);
                } else {
                    throw new BizException("编码[" + code + "]:经度填写错误");
                }
            }
            String latitude = regionVO.getLatitude();
            if (latitude != null) {
                if (latitude.length() < nameMaxLength && isNumeric(latitude)) {
                    region.setfLatitude(latitude);
                } else {
                    throw new BizException("编码[" + code + "]:纬度填写错误");
                }
            }
            Integer sort = regionVO.getSort();
            if (sort != null) {
                if (sort >= sortMinValue && sort <= sortMaxValue) {
                    region.setfSort(sort.byteValue());
                } else {
                    throw new BizException("编码[" + code + "]:排序填写错误");
                }
            }
            if (Pattern.matches(countyRegex, code)) {
                String county = regionVO.getCounty();
                if (StringUtils.isNotBlank(county)) {
                    if (county.length() < nameMaxLength) {
                        region.setfName(county);
                        region.setfParentNode(0);
                    } else {
                        throw new BizException("编码[" + code + "]:县区名称不能填写错误");
                    }
                } else {
                    throw new BizException("编码[" + code + "]:县区名称不能为空");
                }
            } else if (Pattern.matches(townRegex, code)) {
                String town = regionVO.getTown();
                if (StringUtils.isNotBlank(town)) {
                    if (town.length() < nameMaxLength) {
                        region.setfName(town);
                    } else {
                        throw new BizException("编码[" + code + "]:乡镇名称不能填写错误");
                    }
                } else {
                    throw new BizException("编码[" + code + "]:乡镇名称不能为空");
                }
            } else {
                String village = regionVO.getVillage();
                if (StringUtils.isNotBlank(village)) {
                    if (village.length() < nameMaxLength) {
                        region.setfName(village);
                    } else {
                        throw new BizException("编码[" + code + "]:村名称不能填写错误");
                    }
                } else {
                    throw new BizException("编码[" + code + "]:村名称不能为空");
                }
            }
            region.setfDeleteFlag(false);
            regionList.add(region);
        });
        regionList.sort(Comparator.comparing(TAdministrativeDivision::getfCode));
        return regionList;
    }

    /**
     * 检查编码是否重复
     *
     * @param code 编码
     * @param id   修改时的主键
     * @return 是否重复
     */
    private boolean checkCodeIsExist(String code, Integer id) {
        if (StringUtils.isBlank(code)) {
            return true;
        }
        TAdministrativeDivisionExample example = new TAdministrativeDivisionExample();
        TAdministrativeDivisionExample.Criteria criteria = example.createCriteria();
        criteria.andFCodeEqualTo(code).andFDeleteFlagEqualTo(false);
        if (id != null) {
            criteria.andFIdNotEqualTo(id);
        }
        return tAdministrativeDivisionMapper.countByExample(example) > 0;
    }

    /**
     * 查询父类ID
     *
     * @param code 编码
     * @return 是否重复
     */
    private Integer getPid(String code) {
        String parentCode;
        if (Pattern.matches(townRegex, code)) {
            parentCode = code.substring(0, 6) + "000000";
        } else {
            parentCode = code.substring(0, 9) + "000";
        }
        TAdministrativeDivisionExample example = new TAdministrativeDivisionExample();
        example.createCriteria().andFDeleteFlagEqualTo(false).andFCodeEqualTo(parentCode);
        List<TAdministrativeDivision> list = tAdministrativeDivisionMapper.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0).getfId();
        }
        return null;
    }

    private boolean isNumeric(String str) {
        return str.matches("^-?\\d+(\\.\\d+)?$");
    }
}

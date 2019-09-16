package cn.wtu.broadcast.openapi.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * 行政区域
 * 验证需要框架支持
 */
public class RegionVO implements Serializable {
    private static final long serialVersionUID = 5603636679419168489L;

    /**
     * 编码
     */
    @Excel(name = "编码",width = 12)
    private String code;

    /**
     * 省
     */
    @Excel(name = "省",orderNum="1",width = 40)
    private String province;

    /**
     * 市
     */
    @Excel(name = "市",orderNum="2",width = 40)
    private String city;

    /**
     * 县区
     */
    @Excel(name = "县区",orderNum="3",width = 40)
    private String county;

    /**
     * 镇
     */
    @Excel(name = "乡镇",orderNum="4",width = 40)
    private String town;

    /**
     * 村
     */
    @Excel(name = "村",orderNum="5",width = 40)
    private String village;

    /**
     * 经度
     */
    @Excel(name = "经度",orderNum="6",width = 40)
    private String longitude;

    /**
     * 纬度
     */
    @Excel(name = "纬度",orderNum="7",width = 40)
    private String latitude;

    /**
     * 排序
     */
    @Excel(name = "排序",orderNum="8")
    @Max(value = 255,message = "排序最大值不能大于255")
    @Min(value = 0,message = "排序最小值不能小于过0")
    private Integer sort;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}

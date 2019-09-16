package cn.wtu.broadcast.openapi.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 *
 * @author sueua
 * @since 2019-01-01
 */
public class UserVO implements Serializable {

    private static final long serialVersionUID = -1088326284549146922L;

    private Integer fId;

    @Excel(name = "账号", orderNum = "1")
    private String fAccount;

    @Excel(name = "用户名", orderNum = "2")
    private String fUsername;

    @Excel(name = "所属区域", orderNum = "3")
    private Integer fRespectiveRegion;

    @Excel(name = "单位", orderNum = "4")
    private String fSubordinateUnit;

    @Excel(name = "职位", orderNum = "5")
    private String fDuties;

    @Excel(name = "电话", orderNum = "6")
    private String fTel;

    @Excel(name = "自动审核", orderNum = "7", replace = {"是_true", "否_false"})
    private Boolean fIsAuditAutomatic;

    @Excel(name = "是否有效", orderNum = "8", replace = {"是_true", "否_false"})
    private Boolean fIsEffective;

    @Excel(name = "排序", orderNum = "9")
    private Byte fSort;

    @Excel(name = "创建时间", orderNum = "10", exportFormat = "yyyy-MM-dd HH:mm:ss")
    private Date fCreateTime;

    @Excel(name = "创建人", orderNum = "11")
    private Integer fCreatorId;

    @Excel(name = "修改时间", orderNum = "12", exportFormat = "yyyy-MM-dd HH:mm:ss")
    private Date fUpdateTime;

    @Excel(name = "修改人", orderNum = "13")
    private Integer fOperatorId;

    /**
     * 角色id
     */
    @Excel(name = "角色", orderNum = "14")
    private Integer roleId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfAccount() {
        return fAccount;
    }

    public void setfAccount(String fAccount) {
        this.fAccount = fAccount;
    }

    public String getfUsername() {
        return fUsername;
    }

    public void setfUsername(String fUsername) {
        this.fUsername = fUsername;
    }

    public Integer getfRespectiveRegion() {
        return fRespectiveRegion;
    }

    public void setfRespectiveRegion(Integer fRespectiveRegion) {
        this.fRespectiveRegion = fRespectiveRegion;
    }

    public String getfSubordinateUnit() {
        return fSubordinateUnit;
    }

    public void setfSubordinateUnit(String fSubordinateUnit) {
        this.fSubordinateUnit = fSubordinateUnit;
    }

    public String getfDuties() {
        return fDuties;
    }

    public void setfDuties(String fDuties) {
        this.fDuties = fDuties;
    }

    public String getfTel() {
        return fTel;
    }

    public void setfTel(String fTel) {
        this.fTel = fTel;
    }

    public Boolean getfIsAuditAutomatic() {
        return fIsAuditAutomatic;
    }

    public void setfIsAuditAutomatic(Boolean fIsAuditAutomatic) {
        this.fIsAuditAutomatic = fIsAuditAutomatic;
    }

    public Boolean getfIsEffective() {
        return fIsEffective;
    }

    public void setfIsEffective(Boolean fIsEffective) {
        this.fIsEffective = fIsEffective;
    }

    public Byte getfSort() {
        return fSort;
    }

    public void setfSort(Byte fSort) {
        this.fSort = fSort;
    }

    public Date getfCreateTime() {
        return fCreateTime;
    }

    public void setfCreateTime(Date fCreateTime) {
        this.fCreateTime = fCreateTime;
    }

    public Integer getfCreatorId() {
        return fCreatorId;
    }

    public void setfCreatorId(Integer fCreatorId) {
        this.fCreatorId = fCreatorId;
    }

    public Date getfUpdateTime() {
        return fUpdateTime;
    }

    public void setfUpdateTime(Date fUpdateTime) {
        this.fUpdateTime = fUpdateTime;
    }

    public Integer getfOperatorId() {
        return fOperatorId;
    }

    public void setfOperatorId(Integer fOperatorId) {
        this.fOperatorId = fOperatorId;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "fId=" + fId +
                ", fAccount='" + fAccount + '\'' +
                ", fUsername='" + fUsername + '\'' +
                ", fRespectiveRegion=" + fRespectiveRegion +
                ", fSubordinateUnit='" + fSubordinateUnit + '\'' +
                ", fDuties='" + fDuties + '\'' +
                ", fTel='" + fTel + '\'' +
                ", fIsAuditAutomatic=" + fIsAuditAutomatic +
                ", fIsEffective=" + fIsEffective +
                ", fSort=" + fSort +
                ", fCreateTime=" + fCreateTime +
                ", fCreatorId=" + fCreatorId +
                ", fUpdateTime=" + fUpdateTime +
                ", fOperatorId=" + fOperatorId +
                ", roleId=" + roleId +
                '}';
    }
}

package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class TUser implements Serializable {
    private Integer fId;

    private String fAccount;

    private String fUsername;

    private String fPassword;

    private Integer fRespectiveRegion;

    private String fSubordinateUnit;

    private String fDuties;

    private String fTel;

    private Boolean fIsAuditAutomatic;

    private Boolean fIsLinkman;

    private Boolean fIsEffective;

    private Byte fSort;

    private Date fCreateTime;

    private Integer fCreatorId;

    private Date fUpdateTime;

    private Integer fOperatorId;

    private Boolean fDeleteFlag;

    private static final long serialVersionUID = 1L;

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
        this.fAccount = fAccount == null ? null : fAccount.trim();
    }

    public String getfUsername() {
        return fUsername;
    }

    public void setfUsername(String fUsername) {
        this.fUsername = fUsername == null ? null : fUsername.trim();
    }

    public String getfPassword() {
        return fPassword;
    }

    public void setfPassword(String fPassword) {
        this.fPassword = fPassword == null ? null : fPassword.trim();
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
        this.fSubordinateUnit = fSubordinateUnit == null ? null : fSubordinateUnit.trim();
    }

    public String getfDuties() {
        return fDuties;
    }

    public void setfDuties(String fDuties) {
        this.fDuties = fDuties == null ? null : fDuties.trim();
    }

    public String getfTel() {
        return fTel;
    }

    public void setfTel(String fTel) {
        this.fTel = fTel == null ? null : fTel.trim();
    }

    public Boolean getfIsAuditAutomatic() {
        return fIsAuditAutomatic;
    }

    public void setfIsAuditAutomatic(Boolean fIsAuditAutomatic) {
        this.fIsAuditAutomatic = fIsAuditAutomatic;
    }

    public Boolean getfIsLinkman() {
        return fIsLinkman;
    }

    public void setfIsLinkman(Boolean fIsLinkman) {
        this.fIsLinkman = fIsLinkman;
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

    public Boolean getfDeleteFlag() {
        return fDeleteFlag;
    }

    public void setfDeleteFlag(Boolean fDeleteFlag) {
        this.fDeleteFlag = fDeleteFlag;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TUser other = (TUser) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfAccount() == null ? other.getfAccount() == null : this.getfAccount().equals(other.getfAccount()))
            && (this.getfUsername() == null ? other.getfUsername() == null : this.getfUsername().equals(other.getfUsername()))
            && (this.getfPassword() == null ? other.getfPassword() == null : this.getfPassword().equals(other.getfPassword()))
            && (this.getfRespectiveRegion() == null ? other.getfRespectiveRegion() == null : this.getfRespectiveRegion().equals(other.getfRespectiveRegion()))
            && (this.getfSubordinateUnit() == null ? other.getfSubordinateUnit() == null : this.getfSubordinateUnit().equals(other.getfSubordinateUnit()))
            && (this.getfDuties() == null ? other.getfDuties() == null : this.getfDuties().equals(other.getfDuties()))
            && (this.getfTel() == null ? other.getfTel() == null : this.getfTel().equals(other.getfTel()))
            && (this.getfIsAuditAutomatic() == null ? other.getfIsAuditAutomatic() == null : this.getfIsAuditAutomatic().equals(other.getfIsAuditAutomatic()))
            && (this.getfIsLinkman() == null ? other.getfIsLinkman() == null : this.getfIsLinkman().equals(other.getfIsLinkman()))
            && (this.getfIsEffective() == null ? other.getfIsEffective() == null : this.getfIsEffective().equals(other.getfIsEffective()))
            && (this.getfSort() == null ? other.getfSort() == null : this.getfSort().equals(other.getfSort()))
            && (this.getfCreateTime() == null ? other.getfCreateTime() == null : this.getfCreateTime().equals(other.getfCreateTime()))
            && (this.getfCreatorId() == null ? other.getfCreatorId() == null : this.getfCreatorId().equals(other.getfCreatorId()))
            && (this.getfUpdateTime() == null ? other.getfUpdateTime() == null : this.getfUpdateTime().equals(other.getfUpdateTime()))
            && (this.getfOperatorId() == null ? other.getfOperatorId() == null : this.getfOperatorId().equals(other.getfOperatorId()))
            && (this.getfDeleteFlag() == null ? other.getfDeleteFlag() == null : this.getfDeleteFlag().equals(other.getfDeleteFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfAccount() == null) ? 0 : getfAccount().hashCode());
        result = prime * result + ((getfUsername() == null) ? 0 : getfUsername().hashCode());
        result = prime * result + ((getfPassword() == null) ? 0 : getfPassword().hashCode());
        result = prime * result + ((getfRespectiveRegion() == null) ? 0 : getfRespectiveRegion().hashCode());
        result = prime * result + ((getfSubordinateUnit() == null) ? 0 : getfSubordinateUnit().hashCode());
        result = prime * result + ((getfDuties() == null) ? 0 : getfDuties().hashCode());
        result = prime * result + ((getfTel() == null) ? 0 : getfTel().hashCode());
        result = prime * result + ((getfIsAuditAutomatic() == null) ? 0 : getfIsAuditAutomatic().hashCode());
        result = prime * result + ((getfIsLinkman() == null) ? 0 : getfIsLinkman().hashCode());
        result = prime * result + ((getfIsEffective() == null) ? 0 : getfIsEffective().hashCode());
        result = prime * result + ((getfSort() == null) ? 0 : getfSort().hashCode());
        result = prime * result + ((getfCreateTime() == null) ? 0 : getfCreateTime().hashCode());
        result = prime * result + ((getfCreatorId() == null) ? 0 : getfCreatorId().hashCode());
        result = prime * result + ((getfUpdateTime() == null) ? 0 : getfUpdateTime().hashCode());
        result = prime * result + ((getfOperatorId() == null) ? 0 : getfOperatorId().hashCode());
        result = prime * result + ((getfDeleteFlag() == null) ? 0 : getfDeleteFlag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fId=").append(fId);
        sb.append(", fAccount=").append(fAccount);
        sb.append(", fUsername=").append(fUsername);
        sb.append(", fPassword=").append(fPassword);
        sb.append(", fRespectiveRegion=").append(fRespectiveRegion);
        sb.append(", fSubordinateUnit=").append(fSubordinateUnit);
        sb.append(", fDuties=").append(fDuties);
        sb.append(", fTel=").append(fTel);
        sb.append(", fIsAuditAutomatic=").append(fIsAuditAutomatic);
        sb.append(", fIsLinkman=").append(fIsLinkman);
        sb.append(", fIsEffective=").append(fIsEffective);
        sb.append(", fSort=").append(fSort);
        sb.append(", fCreateTime=").append(fCreateTime);
        sb.append(", fCreatorId=").append(fCreatorId);
        sb.append(", fUpdateTime=").append(fUpdateTime);
        sb.append(", fOperatorId=").append(fOperatorId);
        sb.append(", fDeleteFlag=").append(fDeleteFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
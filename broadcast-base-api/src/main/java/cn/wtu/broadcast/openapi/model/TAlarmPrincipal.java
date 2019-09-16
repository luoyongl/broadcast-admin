package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class TAlarmPrincipal implements Serializable {
    private Integer fId;

    private String fPrincipal;

    private Integer fArea;

    private String fCareer;

    private String fTelephone;

    private Byte fSort;

    private Date fCreateTime;

    private Integer fCreateId;

    private Date fUpdtateTime;

    private Integer fOperatorId;

    private Boolean fDeleteFlag;

    private static final long serialVersionUID = 1L;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfPrincipal() {
        return fPrincipal;
    }

    public void setfPrincipal(String fPrincipal) {
        this.fPrincipal = fPrincipal == null ? null : fPrincipal.trim();
    }

    public Integer getfArea() {
        return fArea;
    }

    public void setfArea(Integer fArea) {
        this.fArea = fArea;
    }

    public String getfCareer() {
        return fCareer;
    }

    public void setfCareer(String fCareer) {
        this.fCareer = fCareer == null ? null : fCareer.trim();
    }

    public String getfTelephone() {
        return fTelephone;
    }

    public void setfTelephone(String fTelephone) {
        this.fTelephone = fTelephone == null ? null : fTelephone.trim();
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

    public Integer getfCreateId() {
        return fCreateId;
    }

    public void setfCreateId(Integer fCreateId) {
        this.fCreateId = fCreateId;
    }

    public Date getfUpdtateTime() {
        return fUpdtateTime;
    }

    public void setfUpdtateTime(Date fUpdtateTime) {
        this.fUpdtateTime = fUpdtateTime;
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
        TAlarmPrincipal other = (TAlarmPrincipal) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfPrincipal() == null ? other.getfPrincipal() == null : this.getfPrincipal().equals(other.getfPrincipal()))
            && (this.getfArea() == null ? other.getfArea() == null : this.getfArea().equals(other.getfArea()))
            && (this.getfCareer() == null ? other.getfCareer() == null : this.getfCareer().equals(other.getfCareer()))
            && (this.getfTelephone() == null ? other.getfTelephone() == null : this.getfTelephone().equals(other.getfTelephone()))
            && (this.getfSort() == null ? other.getfSort() == null : this.getfSort().equals(other.getfSort()))
            && (this.getfCreateTime() == null ? other.getfCreateTime() == null : this.getfCreateTime().equals(other.getfCreateTime()))
            && (this.getfCreateId() == null ? other.getfCreateId() == null : this.getfCreateId().equals(other.getfCreateId()))
            && (this.getfUpdtateTime() == null ? other.getfUpdtateTime() == null : this.getfUpdtateTime().equals(other.getfUpdtateTime()))
            && (this.getfOperatorId() == null ? other.getfOperatorId() == null : this.getfOperatorId().equals(other.getfOperatorId()))
            && (this.getfDeleteFlag() == null ? other.getfDeleteFlag() == null : this.getfDeleteFlag().equals(other.getfDeleteFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getfId() == null) ? 0 : getfId().hashCode());
        result = prime * result + ((getfPrincipal() == null) ? 0 : getfPrincipal().hashCode());
        result = prime * result + ((getfArea() == null) ? 0 : getfArea().hashCode());
        result = prime * result + ((getfCareer() == null) ? 0 : getfCareer().hashCode());
        result = prime * result + ((getfTelephone() == null) ? 0 : getfTelephone().hashCode());
        result = prime * result + ((getfSort() == null) ? 0 : getfSort().hashCode());
        result = prime * result + ((getfCreateTime() == null) ? 0 : getfCreateTime().hashCode());
        result = prime * result + ((getfCreateId() == null) ? 0 : getfCreateId().hashCode());
        result = prime * result + ((getfUpdtateTime() == null) ? 0 : getfUpdtateTime().hashCode());
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
        sb.append(", fPrincipal=").append(fPrincipal);
        sb.append(", fArea=").append(fArea);
        sb.append(", fCareer=").append(fCareer);
        sb.append(", fTelephone=").append(fTelephone);
        sb.append(", fSort=").append(fSort);
        sb.append(", fCreateTime=").append(fCreateTime);
        sb.append(", fCreateId=").append(fCreateId);
        sb.append(", fUpdtateTime=").append(fUpdtateTime);
        sb.append(", fOperatorId=").append(fOperatorId);
        sb.append(", fDeleteFlag=").append(fDeleteFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
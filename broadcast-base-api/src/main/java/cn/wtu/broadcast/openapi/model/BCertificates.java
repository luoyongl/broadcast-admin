package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class BCertificates implements Serializable {
    private Integer fId;

    private Integer fDeviceId;

    private String fCertificatesNumber;

    private Date fStartDateOfValidity;

    private Date fEndDateOfValidity;

    private String fPrivateKey;

    private String fPublicKey;

    private String fRemark;

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

    public Integer getfDeviceId() {
        return fDeviceId;
    }

    public void setfDeviceId(Integer fDeviceId) {
        this.fDeviceId = fDeviceId;
    }

    public String getfCertificatesNumber() {
        return fCertificatesNumber;
    }

    public void setfCertificatesNumber(String fCertificatesNumber) {
        this.fCertificatesNumber = fCertificatesNumber == null ? null : fCertificatesNumber.trim();
    }

    public Date getfStartDateOfValidity() {
        return fStartDateOfValidity;
    }

    public void setfStartDateOfValidity(Date fStartDateOfValidity) {
        this.fStartDateOfValidity = fStartDateOfValidity;
    }

    public Date getfEndDateOfValidity() {
        return fEndDateOfValidity;
    }

    public void setfEndDateOfValidity(Date fEndDateOfValidity) {
        this.fEndDateOfValidity = fEndDateOfValidity;
    }

    public String getfPrivateKey() {
        return fPrivateKey;
    }

    public void setfPrivateKey(String fPrivateKey) {
        this.fPrivateKey = fPrivateKey == null ? null : fPrivateKey.trim();
    }

    public String getfPublicKey() {
        return fPublicKey;
    }

    public void setfPublicKey(String fPublicKey) {
        this.fPublicKey = fPublicKey == null ? null : fPublicKey.trim();
    }

    public String getfRemark() {
        return fRemark;
    }

    public void setfRemark(String fRemark) {
        this.fRemark = fRemark == null ? null : fRemark.trim();
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
        BCertificates other = (BCertificates) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfDeviceId() == null ? other.getfDeviceId() == null : this.getfDeviceId().equals(other.getfDeviceId()))
            && (this.getfCertificatesNumber() == null ? other.getfCertificatesNumber() == null : this.getfCertificatesNumber().equals(other.getfCertificatesNumber()))
            && (this.getfStartDateOfValidity() == null ? other.getfStartDateOfValidity() == null : this.getfStartDateOfValidity().equals(other.getfStartDateOfValidity()))
            && (this.getfEndDateOfValidity() == null ? other.getfEndDateOfValidity() == null : this.getfEndDateOfValidity().equals(other.getfEndDateOfValidity()))
            && (this.getfPrivateKey() == null ? other.getfPrivateKey() == null : this.getfPrivateKey().equals(other.getfPrivateKey()))
            && (this.getfPublicKey() == null ? other.getfPublicKey() == null : this.getfPublicKey().equals(other.getfPublicKey()))
            && (this.getfRemark() == null ? other.getfRemark() == null : this.getfRemark().equals(other.getfRemark()))
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
        result = prime * result + ((getfDeviceId() == null) ? 0 : getfDeviceId().hashCode());
        result = prime * result + ((getfCertificatesNumber() == null) ? 0 : getfCertificatesNumber().hashCode());
        result = prime * result + ((getfStartDateOfValidity() == null) ? 0 : getfStartDateOfValidity().hashCode());
        result = prime * result + ((getfEndDateOfValidity() == null) ? 0 : getfEndDateOfValidity().hashCode());
        result = prime * result + ((getfPrivateKey() == null) ? 0 : getfPrivateKey().hashCode());
        result = prime * result + ((getfPublicKey() == null) ? 0 : getfPublicKey().hashCode());
        result = prime * result + ((getfRemark() == null) ? 0 : getfRemark().hashCode());
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
        sb.append(", fDeviceId=").append(fDeviceId);
        sb.append(", fCertificatesNumber=").append(fCertificatesNumber);
        sb.append(", fStartDateOfValidity=").append(fStartDateOfValidity);
        sb.append(", fEndDateOfValidity=").append(fEndDateOfValidity);
        sb.append(", fPrivateKey=").append(fPrivateKey);
        sb.append(", fPublicKey=").append(fPublicKey);
        sb.append(", fRemark=").append(fRemark);
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
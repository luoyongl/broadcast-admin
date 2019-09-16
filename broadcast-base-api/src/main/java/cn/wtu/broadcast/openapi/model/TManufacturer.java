package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class TManufacturer implements Serializable {
    private Integer fId;

    private String fManufacturerNo;

    private String fManufacturerName;

    private String fManufacturerAddress;

    private String fLinkman;

    private String fTel;

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

    public String getfManufacturerNo() {
        return fManufacturerNo;
    }

    public void setfManufacturerNo(String fManufacturerNo) {
        this.fManufacturerNo = fManufacturerNo == null ? null : fManufacturerNo.trim();
    }

    public String getfManufacturerName() {
        return fManufacturerName;
    }

    public void setfManufacturerName(String fManufacturerName) {
        this.fManufacturerName = fManufacturerName == null ? null : fManufacturerName.trim();
    }

    public String getfManufacturerAddress() {
        return fManufacturerAddress;
    }

    public void setfManufacturerAddress(String fManufacturerAddress) {
        this.fManufacturerAddress = fManufacturerAddress == null ? null : fManufacturerAddress.trim();
    }

    public String getfLinkman() {
        return fLinkman;
    }

    public void setfLinkman(String fLinkman) {
        this.fLinkman = fLinkman == null ? null : fLinkman.trim();
    }

    public String getfTel() {
        return fTel;
    }

    public void setfTel(String fTel) {
        this.fTel = fTel == null ? null : fTel.trim();
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
        TManufacturer other = (TManufacturer) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfManufacturerNo() == null ? other.getfManufacturerNo() == null : this.getfManufacturerNo().equals(other.getfManufacturerNo()))
            && (this.getfManufacturerName() == null ? other.getfManufacturerName() == null : this.getfManufacturerName().equals(other.getfManufacturerName()))
            && (this.getfManufacturerAddress() == null ? other.getfManufacturerAddress() == null : this.getfManufacturerAddress().equals(other.getfManufacturerAddress()))
            && (this.getfLinkman() == null ? other.getfLinkman() == null : this.getfLinkman().equals(other.getfLinkman()))
            && (this.getfTel() == null ? other.getfTel() == null : this.getfTel().equals(other.getfTel()))
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
        result = prime * result + ((getfManufacturerNo() == null) ? 0 : getfManufacturerNo().hashCode());
        result = prime * result + ((getfManufacturerName() == null) ? 0 : getfManufacturerName().hashCode());
        result = prime * result + ((getfManufacturerAddress() == null) ? 0 : getfManufacturerAddress().hashCode());
        result = prime * result + ((getfLinkman() == null) ? 0 : getfLinkman().hashCode());
        result = prime * result + ((getfTel() == null) ? 0 : getfTel().hashCode());
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
        sb.append(", fManufacturerNo=").append(fManufacturerNo);
        sb.append(", fManufacturerName=").append(fManufacturerName);
        sb.append(", fManufacturerAddress=").append(fManufacturerAddress);
        sb.append(", fLinkman=").append(fLinkman);
        sb.append(", fTel=").append(fTel);
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
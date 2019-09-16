package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class TDictionary implements Serializable {
    private Integer fId;

    private Integer fDictionaryType;

    private String fDictionaryCode;

    private String fThirdCode;

    private String fDictionaryContent;

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

    public Integer getfDictionaryType() {
        return fDictionaryType;
    }

    public void setfDictionaryType(Integer fDictionaryType) {
        this.fDictionaryType = fDictionaryType;
    }

    public String getfDictionaryCode() {
        return fDictionaryCode;
    }

    public void setfDictionaryCode(String fDictionaryCode) {
        this.fDictionaryCode = fDictionaryCode == null ? null : fDictionaryCode.trim();
    }

    public String getfThirdCode() {
        return fThirdCode;
    }

    public void setfThirdCode(String fThirdCode) {
        this.fThirdCode = fThirdCode == null ? null : fThirdCode.trim();
    }

    public String getfDictionaryContent() {
        return fDictionaryContent;
    }

    public void setfDictionaryContent(String fDictionaryContent) {
        this.fDictionaryContent = fDictionaryContent == null ? null : fDictionaryContent.trim();
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
        TDictionary other = (TDictionary) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfDictionaryType() == null ? other.getfDictionaryType() == null : this.getfDictionaryType().equals(other.getfDictionaryType()))
            && (this.getfDictionaryCode() == null ? other.getfDictionaryCode() == null : this.getfDictionaryCode().equals(other.getfDictionaryCode()))
            && (this.getfThirdCode() == null ? other.getfThirdCode() == null : this.getfThirdCode().equals(other.getfThirdCode()))
            && (this.getfDictionaryContent() == null ? other.getfDictionaryContent() == null : this.getfDictionaryContent().equals(other.getfDictionaryContent()))
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
        result = prime * result + ((getfDictionaryType() == null) ? 0 : getfDictionaryType().hashCode());
        result = prime * result + ((getfDictionaryCode() == null) ? 0 : getfDictionaryCode().hashCode());
        result = prime * result + ((getfThirdCode() == null) ? 0 : getfThirdCode().hashCode());
        result = prime * result + ((getfDictionaryContent() == null) ? 0 : getfDictionaryContent().hashCode());
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
        sb.append(", fDictionaryType=").append(fDictionaryType);
        sb.append(", fDictionaryCode=").append(fDictionaryCode);
        sb.append(", fThirdCode=").append(fThirdCode);
        sb.append(", fDictionaryContent=").append(fDictionaryContent);
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
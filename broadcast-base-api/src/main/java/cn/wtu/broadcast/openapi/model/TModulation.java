package cn.wtu.broadcast.openapi.model;

import java.io.Serializable;
import java.util.Date;

public class TModulation implements Serializable {
    private Integer fId;

    private String fServiceId;

    private String fPcrPid;

    private String fDtmbCentreFrequency;

    private String fDtmbFec;

    private String fDtmbModulation;

    private String fDtmbNumberOfSubcarrier;

    private String fDtmbFrameHeaderMode;

    private String fDtmbInterleavingMode;

    private String fDtmbOtherFrequencyFlag;

    private String fDtmbSfnMfnFlag;

    private String fDvbcFrequency;

    private String fDvbcFecOuter;

    private String fDvbcFecInner;

    private String fDvbcModulation;

    private String fDvbcSymbolRate;

    private String fDtmbModulationParameter;

    private String fDvbcModulationParameter;

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

    public String getfServiceId() {
        return fServiceId;
    }

    public void setfServiceId(String fServiceId) {
        this.fServiceId = fServiceId == null ? null : fServiceId.trim();
    }

    public String getfPcrPid() {
        return fPcrPid;
    }

    public void setfPcrPid(String fPcrPid) {
        this.fPcrPid = fPcrPid == null ? null : fPcrPid.trim();
    }

    public String getfDtmbCentreFrequency() {
        return fDtmbCentreFrequency;
    }

    public void setfDtmbCentreFrequency(String fDtmbCentreFrequency) {
        this.fDtmbCentreFrequency = fDtmbCentreFrequency == null ? null : fDtmbCentreFrequency.trim();
    }

    public String getfDtmbFec() {
        return fDtmbFec;
    }

    public void setfDtmbFec(String fDtmbFec) {
        this.fDtmbFec = fDtmbFec == null ? null : fDtmbFec.trim();
    }

    public String getfDtmbModulation() {
        return fDtmbModulation;
    }

    public void setfDtmbModulation(String fDtmbModulation) {
        this.fDtmbModulation = fDtmbModulation == null ? null : fDtmbModulation.trim();
    }

    public String getfDtmbNumberOfSubcarrier() {
        return fDtmbNumberOfSubcarrier;
    }

    public void setfDtmbNumberOfSubcarrier(String fDtmbNumberOfSubcarrier) {
        this.fDtmbNumberOfSubcarrier = fDtmbNumberOfSubcarrier == null ? null : fDtmbNumberOfSubcarrier.trim();
    }

    public String getfDtmbFrameHeaderMode() {
        return fDtmbFrameHeaderMode;
    }

    public void setfDtmbFrameHeaderMode(String fDtmbFrameHeaderMode) {
        this.fDtmbFrameHeaderMode = fDtmbFrameHeaderMode == null ? null : fDtmbFrameHeaderMode.trim();
    }

    public String getfDtmbInterleavingMode() {
        return fDtmbInterleavingMode;
    }

    public void setfDtmbInterleavingMode(String fDtmbInterleavingMode) {
        this.fDtmbInterleavingMode = fDtmbInterleavingMode == null ? null : fDtmbInterleavingMode.trim();
    }

    public String getfDtmbOtherFrequencyFlag() {
        return fDtmbOtherFrequencyFlag;
    }

    public void setfDtmbOtherFrequencyFlag(String fDtmbOtherFrequencyFlag) {
        this.fDtmbOtherFrequencyFlag = fDtmbOtherFrequencyFlag == null ? null : fDtmbOtherFrequencyFlag.trim();
    }

    public String getfDtmbSfnMfnFlag() {
        return fDtmbSfnMfnFlag;
    }

    public void setfDtmbSfnMfnFlag(String fDtmbSfnMfnFlag) {
        this.fDtmbSfnMfnFlag = fDtmbSfnMfnFlag == null ? null : fDtmbSfnMfnFlag.trim();
    }

    public String getfDvbcFrequency() {
        return fDvbcFrequency;
    }

    public void setfDvbcFrequency(String fDvbcFrequency) {
        this.fDvbcFrequency = fDvbcFrequency == null ? null : fDvbcFrequency.trim();
    }

    public String getfDvbcFecOuter() {
        return fDvbcFecOuter;
    }

    public void setfDvbcFecOuter(String fDvbcFecOuter) {
        this.fDvbcFecOuter = fDvbcFecOuter == null ? null : fDvbcFecOuter.trim();
    }

    public String getfDvbcFecInner() {
        return fDvbcFecInner;
    }

    public void setfDvbcFecInner(String fDvbcFecInner) {
        this.fDvbcFecInner = fDvbcFecInner == null ? null : fDvbcFecInner.trim();
    }

    public String getfDvbcModulation() {
        return fDvbcModulation;
    }

    public void setfDvbcModulation(String fDvbcModulation) {
        this.fDvbcModulation = fDvbcModulation == null ? null : fDvbcModulation.trim();
    }

    public String getfDvbcSymbolRate() {
        return fDvbcSymbolRate;
    }

    public void setfDvbcSymbolRate(String fDvbcSymbolRate) {
        this.fDvbcSymbolRate = fDvbcSymbolRate == null ? null : fDvbcSymbolRate.trim();
    }

    public String getfDtmbModulationParameter() {
        return fDtmbModulationParameter;
    }

    public void setfDtmbModulationParameter(String fDtmbModulationParameter) {
        this.fDtmbModulationParameter = fDtmbModulationParameter == null ? null : fDtmbModulationParameter.trim();
    }

    public String getfDvbcModulationParameter() {
        return fDvbcModulationParameter;
    }

    public void setfDvbcModulationParameter(String fDvbcModulationParameter) {
        this.fDvbcModulationParameter = fDvbcModulationParameter == null ? null : fDvbcModulationParameter.trim();
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
        TModulation other = (TModulation) that;
        return (this.getfId() == null ? other.getfId() == null : this.getfId().equals(other.getfId()))
            && (this.getfServiceId() == null ? other.getfServiceId() == null : this.getfServiceId().equals(other.getfServiceId()))
            && (this.getfPcrPid() == null ? other.getfPcrPid() == null : this.getfPcrPid().equals(other.getfPcrPid()))
            && (this.getfDtmbCentreFrequency() == null ? other.getfDtmbCentreFrequency() == null : this.getfDtmbCentreFrequency().equals(other.getfDtmbCentreFrequency()))
            && (this.getfDtmbFec() == null ? other.getfDtmbFec() == null : this.getfDtmbFec().equals(other.getfDtmbFec()))
            && (this.getfDtmbModulation() == null ? other.getfDtmbModulation() == null : this.getfDtmbModulation().equals(other.getfDtmbModulation()))
            && (this.getfDtmbNumberOfSubcarrier() == null ? other.getfDtmbNumberOfSubcarrier() == null : this.getfDtmbNumberOfSubcarrier().equals(other.getfDtmbNumberOfSubcarrier()))
            && (this.getfDtmbFrameHeaderMode() == null ? other.getfDtmbFrameHeaderMode() == null : this.getfDtmbFrameHeaderMode().equals(other.getfDtmbFrameHeaderMode()))
            && (this.getfDtmbInterleavingMode() == null ? other.getfDtmbInterleavingMode() == null : this.getfDtmbInterleavingMode().equals(other.getfDtmbInterleavingMode()))
            && (this.getfDtmbOtherFrequencyFlag() == null ? other.getfDtmbOtherFrequencyFlag() == null : this.getfDtmbOtherFrequencyFlag().equals(other.getfDtmbOtherFrequencyFlag()))
            && (this.getfDtmbSfnMfnFlag() == null ? other.getfDtmbSfnMfnFlag() == null : this.getfDtmbSfnMfnFlag().equals(other.getfDtmbSfnMfnFlag()))
            && (this.getfDvbcFrequency() == null ? other.getfDvbcFrequency() == null : this.getfDvbcFrequency().equals(other.getfDvbcFrequency()))
            && (this.getfDvbcFecOuter() == null ? other.getfDvbcFecOuter() == null : this.getfDvbcFecOuter().equals(other.getfDvbcFecOuter()))
            && (this.getfDvbcFecInner() == null ? other.getfDvbcFecInner() == null : this.getfDvbcFecInner().equals(other.getfDvbcFecInner()))
            && (this.getfDvbcModulation() == null ? other.getfDvbcModulation() == null : this.getfDvbcModulation().equals(other.getfDvbcModulation()))
            && (this.getfDvbcSymbolRate() == null ? other.getfDvbcSymbolRate() == null : this.getfDvbcSymbolRate().equals(other.getfDvbcSymbolRate()))
            && (this.getfDtmbModulationParameter() == null ? other.getfDtmbModulationParameter() == null : this.getfDtmbModulationParameter().equals(other.getfDtmbModulationParameter()))
            && (this.getfDvbcModulationParameter() == null ? other.getfDvbcModulationParameter() == null : this.getfDvbcModulationParameter().equals(other.getfDvbcModulationParameter()))
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
        result = prime * result + ((getfServiceId() == null) ? 0 : getfServiceId().hashCode());
        result = prime * result + ((getfPcrPid() == null) ? 0 : getfPcrPid().hashCode());
        result = prime * result + ((getfDtmbCentreFrequency() == null) ? 0 : getfDtmbCentreFrequency().hashCode());
        result = prime * result + ((getfDtmbFec() == null) ? 0 : getfDtmbFec().hashCode());
        result = prime * result + ((getfDtmbModulation() == null) ? 0 : getfDtmbModulation().hashCode());
        result = prime * result + ((getfDtmbNumberOfSubcarrier() == null) ? 0 : getfDtmbNumberOfSubcarrier().hashCode());
        result = prime * result + ((getfDtmbFrameHeaderMode() == null) ? 0 : getfDtmbFrameHeaderMode().hashCode());
        result = prime * result + ((getfDtmbInterleavingMode() == null) ? 0 : getfDtmbInterleavingMode().hashCode());
        result = prime * result + ((getfDtmbOtherFrequencyFlag() == null) ? 0 : getfDtmbOtherFrequencyFlag().hashCode());
        result = prime * result + ((getfDtmbSfnMfnFlag() == null) ? 0 : getfDtmbSfnMfnFlag().hashCode());
        result = prime * result + ((getfDvbcFrequency() == null) ? 0 : getfDvbcFrequency().hashCode());
        result = prime * result + ((getfDvbcFecOuter() == null) ? 0 : getfDvbcFecOuter().hashCode());
        result = prime * result + ((getfDvbcFecInner() == null) ? 0 : getfDvbcFecInner().hashCode());
        result = prime * result + ((getfDvbcModulation() == null) ? 0 : getfDvbcModulation().hashCode());
        result = prime * result + ((getfDvbcSymbolRate() == null) ? 0 : getfDvbcSymbolRate().hashCode());
        result = prime * result + ((getfDtmbModulationParameter() == null) ? 0 : getfDtmbModulationParameter().hashCode());
        result = prime * result + ((getfDvbcModulationParameter() == null) ? 0 : getfDvbcModulationParameter().hashCode());
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
        sb.append(", fServiceId=").append(fServiceId);
        sb.append(", fPcrPid=").append(fPcrPid);
        sb.append(", fDtmbCentreFrequency=").append(fDtmbCentreFrequency);
        sb.append(", fDtmbFec=").append(fDtmbFec);
        sb.append(", fDtmbModulation=").append(fDtmbModulation);
        sb.append(", fDtmbNumberOfSubcarrier=").append(fDtmbNumberOfSubcarrier);
        sb.append(", fDtmbFrameHeaderMode=").append(fDtmbFrameHeaderMode);
        sb.append(", fDtmbInterleavingMode=").append(fDtmbInterleavingMode);
        sb.append(", fDtmbOtherFrequencyFlag=").append(fDtmbOtherFrequencyFlag);
        sb.append(", fDtmbSfnMfnFlag=").append(fDtmbSfnMfnFlag);
        sb.append(", fDvbcFrequency=").append(fDvbcFrequency);
        sb.append(", fDvbcFecOuter=").append(fDvbcFecOuter);
        sb.append(", fDvbcFecInner=").append(fDvbcFecInner);
        sb.append(", fDvbcModulation=").append(fDvbcModulation);
        sb.append(", fDvbcSymbolRate=").append(fDvbcSymbolRate);
        sb.append(", fDtmbModulationParameter=").append(fDtmbModulationParameter);
        sb.append(", fDvbcModulationParameter=").append(fDvbcModulationParameter);
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
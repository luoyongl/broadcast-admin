package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;
import java.util.Date;

public class BWhitelistNewVO implements Serializable {
	
	private static final long serialVersionUID = -5053053326958616222L;

	private Integer fId;

    private String fAssociatedId;

    private Integer fOperType;

    private String fName;

    private String fTelephoneNumber;

    private Integer fControlDevice;

    private Byte fPermit;

    private Integer fWhitelistLocation;

    private String fPermissionAreaCode;

    private String fResourceCode;

    private Date fCreateTime;

    private Date fUpdateTime;

    private Integer fCreatorId;

    private Integer fOperatorId;

    private Boolean fDeleteFlag;
	
	private String fRealArea;
	
	private String creator;
	
	private String operator;
	
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

	public Integer getfId() {
		return fId;
	}

	public void setfId(Integer fId) {
		this.fId = fId;
	}

	public String getfAssociatedId() {
		return fAssociatedId;
	}

	public void setfAssociatedId(String fAssociatedId) {
		this.fAssociatedId = fAssociatedId;
	}

	public Integer getfOperType() {
		return fOperType;
	}

	public void setfOperType(Integer fOperType) {
		this.fOperType = fOperType;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfTelephoneNumber() {
		return fTelephoneNumber;
	}

	public void setfTelephoneNumber(String fTelephoneNumber) {
		this.fTelephoneNumber = fTelephoneNumber;
	}

	public Integer getfControlDevice() {
		return fControlDevice;
	}

	public void setfControlDevice(Integer fControlDevice) {
		this.fControlDevice = fControlDevice;
	}

	public Byte getfPermit() {
		return fPermit;
	}

	public void setfPermit(Byte fPermit) {
		this.fPermit = fPermit;
	}

	public Integer getfWhitelistLocation() {
		return fWhitelistLocation;
	}

	public void setfWhitelistLocation(Integer fWhitelistLocation) {
		this.fWhitelistLocation = fWhitelistLocation;
	}

	public String getfPermissionAreaCode() {
		return fPermissionAreaCode;
	}

	public void setfPermissionAreaCode(String fPermissionAreaCode) {
		this.fPermissionAreaCode = fPermissionAreaCode;
	}

	public String getfResourceCode() {
		return fResourceCode;
	}

	public void setfResourceCode(String fResourceCode) {
		this.fResourceCode = fResourceCode;
	}

	public Date getfCreateTime() {
		return fCreateTime;
	}

	public void setfCreateTime(Date fCreateTime) {
		this.fCreateTime = fCreateTime;
	}

	public Date getfUpdateTime() {
		return fUpdateTime;
	}

	public void setfUpdateTime(Date fUpdateTime) {
		this.fUpdateTime = fUpdateTime;
	}

	public Integer getfCreatorId() {
		return fCreatorId;
	}

	public void setfCreatorId(Integer fCreatorId) {
		this.fCreatorId = fCreatorId;
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

	public String getfRealArea() {
		return fRealArea;
	}

	public void setfRealArea(String fRealArea) {
		this.fRealArea = fRealArea;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
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

	public String getfPassword() {
		return fPassword;
	}

	public void setfPassword(String fPassword) {
		this.fPassword = fPassword;
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

	@Override
	public String toString() {
		return "BWhitelistNewVO [fId=" + fId + ", fAssociatedId=" + fAssociatedId + ", fOperType=" + fOperType
				+ ", fName=" + fName + ", fTelephoneNumber=" + fTelephoneNumber + ", fControlDevice=" + fControlDevice
				+ ", fPermit=" + fPermit + ", fWhitelistLocation=" + fWhitelistLocation + ", fPermissionAreaCode="
				+ fPermissionAreaCode + ", fResourceCode=" + fResourceCode + ", fCreateTime=" + fCreateTime
				+ ", fUpdateTime=" + fUpdateTime + ", fCreatorId=" + fCreatorId + ", fOperatorId=" + fOperatorId
				+ ", fDeleteFlag=" + fDeleteFlag + ", fRealArea=" + fRealArea + ", creator=" + creator + ", operator="
				+ operator + ", fAccount=" + fAccount + ", fUsername=" + fUsername + ", fPassword=" + fPassword
				+ ", fRespectiveRegion=" + fRespectiveRegion + ", fSubordinateUnit=" + fSubordinateUnit + ", fDuties="
				+ fDuties + ", fTel=" + fTel + ", fIsAuditAutomatic=" + fIsAuditAutomatic + ", fIsLinkman=" + fIsLinkman
				+ ", fIsEffective=" + fIsEffective + "]";
	}

}

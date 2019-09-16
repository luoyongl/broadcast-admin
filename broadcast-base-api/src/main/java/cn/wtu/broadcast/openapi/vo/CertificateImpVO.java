package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class CertificateImpVO implements Serializable{

		/**
	 * 
	 */
	@Excel(name = "设备名称", orderNum = "0")
	 private String fDeviceName;
	@Excel(name = "证书编号", orderNum = "1")
	 private String fCertificatesNumber;
	@Excel(name = "证书有效期", orderNum = "2")
	 private String fDateOfValidity;
	@Excel(name = "私钥", orderNum = "3")
	  private String fPrivateKey;
	@Excel(name = "公钥", orderNum = "4")
	  private String fPublicKey;
	@Excel(name = "备注", orderNum = "5")
	    private String fRemark;
	
	private static final long serialVersionUID = 1L;
		public String getfDeviceName() {
			return fDeviceName;
		}
		public void setfDeviceName(String fDeviceName) {
			this.fDeviceName = fDeviceName;
		}
		public String getfCertificatesNumber() {
			return fCertificatesNumber;
		}
		public void setfCertificatesNumber(String fCertificatesNumber) {
			this.fCertificatesNumber = fCertificatesNumber;
		}
		public String getfDateOfValidity() {
			return fDateOfValidity;
		}
		public void setfDateOfValidity(String fDateOfValidity) {
			this.fDateOfValidity = fDateOfValidity;
		}
		public String getfPrivateKey() {
			return fPrivateKey;
		}
		public void setfPrivateKey(String fPrivateKey) {
			this.fPrivateKey = fPrivateKey;
		}
		public String getfPublicKey() {
			return fPublicKey;
		}
		public void setfPublicKey(String fPublicKey) {
			this.fPublicKey = fPublicKey;
		}
		public String getfRemark() {
			return fRemark;
		}
		public void setfRemark(String fRemark) {
			this.fRemark = fRemark;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
}

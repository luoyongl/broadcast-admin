package cn.wtu.broadcast.openapi.vo;

import java.io.Serializable;

import cn.afterturn.easypoi.excel.annotation.Excel;

public class TerminalDeviceExportVO extends FrontDeviceExportVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// 厂商信息
	@Excel(name = "厂商信息", orderNum = "17")
	private String fRealFacture;

	public String getfRealFacture() {
		return fRealFacture;
	}

	public void setfRealFacture(String fRealFacture) {
		this.fRealFacture = fRealFacture;
	}

}
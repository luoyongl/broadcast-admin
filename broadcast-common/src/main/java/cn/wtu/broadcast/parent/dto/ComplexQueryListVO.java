package cn.wtu.broadcast.parent.dto;

import java.io.Serializable;

public class ComplexQueryListVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2744142020444991159L;
	
	private String listItem;

	public String getListItem() {
		return listItem;
	}

	public void setListItem(String listItem) {
		this.listItem = listItem;
	}

	@Override
	public String toString() {
		return "ComplexQueryListVO [listItem=" + listItem + "]";
	}

}

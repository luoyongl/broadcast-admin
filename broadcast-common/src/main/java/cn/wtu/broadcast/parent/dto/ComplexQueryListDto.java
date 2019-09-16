package cn.wtu.broadcast.parent.dto;

import java.io.Serializable;
import java.util.List;


public class ComplexQueryListDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6446935020423509934L;
	
	private List<ComplexQueryListVO> searchText;

	public List<ComplexQueryListVO> getSearchText() {
		return searchText;
	}

	public void setSearchText(List<ComplexQueryListVO> searchText) {
		this.searchText = searchText;
	}

	@Override
	public String toString() {
		return "ComplexQueryListDto [searchText=" + searchText + "]";
	}
	
}

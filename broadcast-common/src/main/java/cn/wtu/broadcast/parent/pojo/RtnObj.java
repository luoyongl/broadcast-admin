package cn.wtu.broadcast.parent.pojo;

import java.util.List;

public class RtnObj implements java.io.Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	|--当前页
	//	|--总页数
	//	|--是否有下一页
	//	|--数据集
	private boolean hasNextPage ;
	private Integer currentPage =1 ;
	private Integer totalPage = null;
	private List<?> list = null;
	public boolean isHasNextPage() {
		return hasNextPage;
	}
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
 
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
}

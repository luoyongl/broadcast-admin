
package cn.wtu.broadcast.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.github.pagehelper.PageInfo;

import cn.wtu.broadcast.parent.pojo.BroadcastResult;

/**
 * 
    * @ClassName: ResultData
    * @Description: 消息对象
    * @author huangjiakui
    * @date 2018年12月04日
    *
    * @param <T>
 */
public class ResultData<T> {

	public ResultData() {
		this.isSuccess = true;
		this.msg = "操作成功";
	}
	public ResultData(HttpServletRequest req, Object obj, long count) {
		this.isSuccess = true;
		this.msg = "操作成功";
		this.url = req.getServletPath();
		this.object = obj;
		if(obj instanceof PageInfo){
		    PageInfo<?> page = (PageInfo<?>)obj;
		    this.currentPage = page.getPageNum();
		    this.totalPage = page.getPages();
		    this.limit = page.getPageSize();
		    this.total = page.getTotal();
	        this.pageSize =  page.getPageSize();
		}
	}
	
	public ResultData(HttpServletRequest req,PageInfo<?> page,Map<String,Object> attrMap) {
	    this.isSuccess = true;
	    this.msg = "操作成功";
	    this.url = req.getServletPath();
	    this.object = page;
	    this.total = page.getTotal();
        this.currentPage = page.getPageNum();
        this.totalPage = page.getPages();
        this.limit = page.getPageSize();
        this.pageSize =  page.getPageSize();
        for(Map.Entry<String, Object> entry:attrMap.entrySet()){
            req.setAttribute(entry.getKey(), entry.getValue());
        }
	}
	
	public ResultData(HttpServletRequest req, PageInfo<?> page) {
	    this.isSuccess = true;
	    this.msg = "操作成功";
	    this.url = req.getServletPath();
	    this.object = page;
	    this.total = page.getTotal();
	    this.currentPage = page.getPageNum();
	    this.totalPage = page.getPages();
	    this.limit = page.getPageSize();
        this.pageSize =  page.getPageSize();
        this.start = page.getPageNum();
	}
	
	public static BroadcastResult ok(Object data) {
        return new BroadcastResult(data);
    }

	/**
	 * 结果对象
	 */
	private Object object;
	
	/**
	 * 是否成功
	 */
	private boolean isSuccess;
	
	private long totalPage;
	
	private int currentPage;
	
	private int pageSize;
	
	private int start;
	
	private int limit;
	
	private long total;

	private String url;
	/**
	 * 成功或错误信息
	 */
	private String msg;
	
	public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getStart() {
        return start;
    }
    public void setStart(int start) {
        this.start = start;
    }
    public int getLimit() {
        return limit;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }	
}
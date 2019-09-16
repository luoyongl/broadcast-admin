package cn.wtu.broadcast.parent.exceptions;

/**
 * 系统业务级异常，包含异常编码、异常信息以及异常标题
 * 
 * @author win
 * @version 1.0
 */
public class BusinessException extends Exception {
	private static final long serialVersionUID = 8109303352556055331L;

	private String code;
	private String message;
	private String title;

	/**
	 * constructor
	 * 
	 * @param code
	 *            error code
	 * @param title
	 *            title
	 * @param message
	 *            message
	 */
	public BusinessException(String code, String title, String message) {
		super(title);
		this.code = code;
		this.title = title;
		this.message = message;
	}

	/**
	 * constructor with the code for UNKNOW_ERROR, and the title for "系统出错了"
	 * 
	 * @param message
	 *            message
	 */
	public BusinessException(String message) {
		super(message);
		this.code = ErrorCode.UNKNOW_ERROR;
		this.message = message;
		this.title = "系统出错了！";
	}

	/**
	 * constructor with the code for UNKNOW_ERROR
	 * 
	 * @param title
	 *            title
	 * @param message
	 *            message
	 */
	public BusinessException(String title, String message) {
		super(message);
		this.code = ErrorCode.UNKNOW_ERROR;
		this.message = message;
		this.title = title;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}

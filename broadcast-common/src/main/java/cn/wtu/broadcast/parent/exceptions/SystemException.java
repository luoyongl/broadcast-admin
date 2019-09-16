package cn.wtu.broadcast.parent.exceptions;

import java.io.Serializable;

/**
 * 系统异常
 * 
 * @author win
 * @version 1.0
 */
public class SystemException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 3787730660315875183L;
	private Exception exception;
	private String message;
	private String code;
	private String title = "系统出错了！";

	/**
	 * constructor
	 * 
	 * @param code
	 *            code
	 * @param message
	 *            message
	 * @param e
	 *            Exception
	 */
	public SystemException(String code, String message, Exception e) {
		super(message);
		this.message = message;
		this.code = code;
		this.exception = e;
	}

	/**
	 * constructor
	 * 
	 * @param code
	 *            code
	 * @param title
	 *            title
	 * @param message
	 *            message
	 * @param e
	 *            Exception
	 */
	public SystemException(String code, String title, String message, Exception e) {
		super(message);
		this.message = message;
		this.code = code;
		this.exception = e;
		this.title = title;
	}

	/**
	 * constructor
	 * 
	 * @param message
	 *            message
	 * @param e
	 *            Exception
	 */
	public SystemException(String message, Exception e) {
		super(message);
		this.code = ErrorCode.UNKNOW_ERROR;
		this.exception = e;
	}

	public String getTitle() {
		if ((null == title) || "".equals(title)) {
			return "系统异常！";
		} else {
			return title;
		}
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}

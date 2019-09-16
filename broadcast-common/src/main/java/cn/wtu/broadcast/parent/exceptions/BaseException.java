package cn.wtu.broadcast.parent.exceptions;


import java.io.Serializable;

/**
 * 异常基类
 * 
 * @author win
 *
 */
public abstract class BaseException extends RuntimeException implements Serializable {
	private static final long serialVersionUID = 1311416870635146320L;
	protected Exception exception;
	protected String message;
	protected String code;
	protected String title = "系统出错了！";

	protected abstract String getTitle();

	/**
	 * Constructor with parameter message
	 * 
	 * @param message 消息
	 */
	public BaseException(String message) {
		super(message);
	}

	/**
	 * getException
	 * 
	 * @return
	 */
	public Exception getException() {
		return exception;
	}

	/**
	 * setException
	 * 
	 * @param exception Exception
	 */
	public void setException(Exception exception) {
		this.exception = exception;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return message;
	}

	/**
	 * setMessage
	 * 
	 * @param message message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * getCode
	 * 
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * setCode
	 * 
	 * @param code error code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * setTitle
	 * 
	 * @param title title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

}

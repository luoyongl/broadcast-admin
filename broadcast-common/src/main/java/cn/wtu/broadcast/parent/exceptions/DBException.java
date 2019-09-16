package cn.wtu.broadcast.parent.exceptions;
/**
 * DBException.
 * 
 * @author win
 *
 */
public class DBException extends RuntimeException {
	private static final long serialVersionUID = 3787730660315875183L;

	public DBException() {
		super();
	}

	public DBException(String message) {
		super(message);
	}

	public DBException(Throwable cause) {
		super(cause);
	}

	public DBException(String message, Throwable cause) {
		super(message, cause);
	}

}

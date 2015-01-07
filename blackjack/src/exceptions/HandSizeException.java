package exceptions;

public class HandSizeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HandSizeException() {
		// TODO Auto-generated constructor stub
	}

	public HandSizeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public HandSizeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public HandSizeException(int size, String message) {
		super(message);
	}

	public HandSizeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public HandSizeException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}

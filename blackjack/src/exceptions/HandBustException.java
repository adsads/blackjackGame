package exceptions;

public class HandBustException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int score;

	public HandBustException() {
		// TODO Auto-generated constructor stub
	}

	public HandBustException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public HandBustException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public HandBustException(int score, String message) {
		super(message);
		this.score= score;
	}

	public HandBustException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public HandBustException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}

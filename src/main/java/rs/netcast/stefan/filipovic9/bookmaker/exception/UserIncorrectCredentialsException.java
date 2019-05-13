package rs.netcast.stefan.filipovic9.bookmaker.exception;

public class UserIncorrectCredentialsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UserIncorrectCredentialsException(String message) {
		super(message);
	}

}

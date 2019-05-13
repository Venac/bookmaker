package rs.netcast.stefan.filipovic9.bookmaker.exception;

public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UserNotFoundException(int id) {
		super("User with id " + id + " not found");
	}

	public UserNotFoundException(String message) {
		super(message);
	}
	
}

package rs.netcast.stefan.filipovic9.bookmaker.exception;

public class OperatorNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public OperatorNotFoundException(int id) {
		super("Operator with id " + id + " not found");
	}

	public OperatorNotFoundException(String message) {
		super(message);
	}
	
}

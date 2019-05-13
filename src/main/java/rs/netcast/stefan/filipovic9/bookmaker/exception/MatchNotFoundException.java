package rs.netcast.stefan.filipovic9.bookmaker.exception;

public class MatchNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public MatchNotFoundException(int id) {
		super("Match with id " + id + " not found");
	}

	public MatchNotFoundException(String message) {
		super(message);
	}
	
}

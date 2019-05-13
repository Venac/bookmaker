package rs.netcast.stefan.filipovic9.bookmaker.exception;

public class TeamNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public TeamNotFoundException(int id) {
		super("Team with id " + id + " not found");
	}
}

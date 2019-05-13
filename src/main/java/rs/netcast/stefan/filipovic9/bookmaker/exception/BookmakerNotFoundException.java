package rs.netcast.stefan.filipovic9.bookmaker.exception;

public class BookmakerNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public BookmakerNotFoundException(int id) {
		super("Boommaker with id " + id + " not found");
	}
	
}

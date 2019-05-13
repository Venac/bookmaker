package rs.netcast.stefan.filipovic9.bookmaker.exception;

public class TicketNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public TicketNotFoundException(int id) {
		super("Ticket with id " + id + " not found");
	}

	public TicketNotFoundException(String message) {
		super(message);
	}
}

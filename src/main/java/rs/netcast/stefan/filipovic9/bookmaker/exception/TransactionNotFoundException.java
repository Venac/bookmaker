package rs.netcast.stefan.filipovic9.bookmaker.exception;

public class TransactionNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public TransactionNotFoundException(int id) {
		super("Transaction with id " + id + " not found");
	}
}

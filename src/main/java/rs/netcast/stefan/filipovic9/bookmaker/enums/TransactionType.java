package rs.netcast.stefan.filipovic9.bookmaker.enums;

public enum TransactionType {
	TICKET_PLAYED(1), TICKET_WON(2), PAY_OUT(3), PAY_IN(4);
	private final int value;

	private TransactionType(int value) {
		this.value = value;
	}

	public int value() {
		return value;
	}
}

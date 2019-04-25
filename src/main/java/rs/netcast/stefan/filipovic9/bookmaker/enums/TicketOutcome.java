package rs.netcast.stefan.filipovic9.bookmaker.enums;

public enum TicketOutcome {
	UNCHECKED(0), LOST(1), WON(2);
	
	private final int value;

	private TicketOutcome(int value) {
		this.value = value;
	}
	
	public int value() {
		return value;
	}
}

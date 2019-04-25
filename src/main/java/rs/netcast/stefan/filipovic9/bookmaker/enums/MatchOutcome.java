package rs.netcast.stefan.filipovic9.bookmaker.enums;

public enum MatchOutcome {
	SCHEDULED(0), HOME_WIN(1), AWAY_WIN(2), DRAW(3);

	private final int value;

	private MatchOutcome(int value) {
		this.value = value;
	}

	public int value() {
		return value;
	}
}

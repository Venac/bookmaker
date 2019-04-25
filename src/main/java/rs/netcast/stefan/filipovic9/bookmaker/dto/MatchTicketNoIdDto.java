package rs.netcast.stefan.filipovic9.bookmaker.dto;

public class MatchTicketNoIdDto {
//	private TicketFullDto ticket;
	private MatchNoOpDto match;
	private int outcomePrediction;

	public MatchTicketNoIdDto() {
	}

	public MatchTicketNoIdDto(MatchNoOpDto match, int outcomePrediction) {
		this.match = match;
		this.outcomePrediction = outcomePrediction;
	}

//	public MatchTicketNoIdDto(TicketFullDto ticket, MatchFullDto match, int outcomePrediction) {
//		this.ticket = ticket;
//		this.match = match;
//		this.outcomePrediction = outcomePrediction;
//	}

//	public TicketFullDto getTicket() {
//		return ticket;
//	}
//
//	public void setTicket(TicketFullDto ticket) {
//		this.ticket = ticket;
//	}

	public MatchNoOpDto getMatch() {
		return match;
	}

	public void setMatch(MatchNoOpDto match) {
		this.match = match;
	}

	public int getOutcomePrediction() {
		return outcomePrediction;
	}

	public void setOutcomePrediction(int outcomePrediction) {
		this.outcomePrediction = outcomePrediction;
	}

	@Override
	public String toString() {
		return "MatchTicketNoIdDto [match=" + match + ", outcomePrediction=" + outcomePrediction + "]";
	}

//	@Override
//	public String toString() {
//		return "MatchTicketInitialDto [ticket=" + ticket + ", match=" + match + ", outcomePrediction="
//				+ outcomePrediction + "]";
//	}

}

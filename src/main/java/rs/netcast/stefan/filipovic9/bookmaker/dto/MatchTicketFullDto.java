package rs.netcast.stefan.filipovic9.bookmaker.dto;

public class MatchTicketFullDto {
	private int id;
	private int outcomePrediction;
//	private TicketFullDto ticket;
	private MatchNoOpDto match;
	
	public MatchTicketFullDto() {
		// TODO Auto-generated constructor stub
	}

	public MatchTicketFullDto(int id, int outcomePrediction, MatchNoOpDto match) {
		this.id = id;
		this.outcomePrediction = outcomePrediction;
		this.match = match;
	}

//	public MatchTicketFullDto(int id, int outcomePrediction, TicketFullDto ticket, MatchFullDto match) {
//		this.id = id;
//		this.outcomePrediction = outcomePrediction;
//		this.ticket = ticket;
//		this.match = match;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
		return "MatchTicketFullDto [id=" + id + ", outcomePrediction=" + outcomePrediction + ", match=" + match + "]";
	}

//	@Override
//	public String toString() {
//		return "MatchTicketFullDto [id=" + id + ", ticket=" + ticket + ", match=" + match + ", outcomePrediction="
//				+ outcomePrediction + "]";
//	}
	
}

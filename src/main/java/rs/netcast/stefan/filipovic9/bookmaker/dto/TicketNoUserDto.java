package rs.netcast.stefan.filipovic9.bookmaker.dto;

import java.util.ArrayList;
import java.util.List;

public class TicketNoUserDto {
	private int id;
	private double betAmount;
	private int won;
	private List<MatchTicketFullDto> matchesTickets;
	
	public TicketNoUserDto() {
		matchesTickets = new ArrayList<MatchTicketFullDto>();
	}
	
	public TicketNoUserDto(int id, double betAmount, int won, List<MatchTicketFullDto> matchesTickets) {
		this.id = id;
		this.betAmount = betAmount;
		this.won = won;
		this.matchesTickets = matchesTickets;
		matchesTickets = new ArrayList<MatchTicketFullDto>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBetAmount() {
		return betAmount;
	}

	public void setBetAmount(double betAmount) {
		this.betAmount = betAmount;
	}

	public int getWon() {
		return won;
	}

	public void setWon(int won) {
		this.won = won;
	}

	public List<MatchTicketFullDto> getMatchesTickets() {
		return matchesTickets;
	}

	public void setMatchesTickets(List<MatchTicketFullDto> matchesTickets) {
		this.matchesTickets = matchesTickets;
	}

	@Override
	public String toString() {
		return "TicketNoUserDto [id=" + id + ", betAmount=" + betAmount + ", won=" + won + ", matchesTickets="
				+ matchesTickets + "]";
	}
	
}

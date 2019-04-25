package rs.netcast.stefan.filipovic9.bookmaker.dto;

import java.util.ArrayList;
import java.util.List;

public class TicketNoIdDto {
	private double betAmount;
	private int won;
	private UserNoPassDto user;
	private List<MatchTicketNoIdDto> matchesTickets;
	
	public TicketNoIdDto() {
		matchesTickets = new ArrayList<MatchTicketNoIdDto>();
	}

	public TicketNoIdDto(double betAmount, int won, List<MatchTicketNoIdDto> matchesTickets, UserNoPassDto user) {
		this.betAmount = betAmount;
		this.won = won;
		this.matchesTickets = matchesTickets;
		this.user = user;
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

	public List<MatchTicketNoIdDto> getMatchesTickets() {
		return matchesTickets;
	}

	public void setMatchesTickets(List<MatchTicketNoIdDto> matchesTickets) {
		this.matchesTickets = matchesTickets;
	}

	public UserNoPassDto getUser() {
		return user;
	}

	public void setUser(UserNoPassDto user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "TicketNoIdDto [betAmount=" + betAmount + ", won=" + won + ", matchesTickets=" + matchesTickets
				+ ", user=" + user + "]";
	}
	
}

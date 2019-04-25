package rs.netcast.stefan.filipovic9.bookmaker.dto;

import java.util.ArrayList;
import java.util.List;

public class TicketFullDto {
	private int id;
	private double betAmount;
	private int won;
	private UserNoPassDto user;
	private List<MatchTicketFullDto> matchesTickets;
	
	public TicketFullDto() {
		matchesTickets = new ArrayList<MatchTicketFullDto>();
	}

	public TicketFullDto(int id, double betAmount, int won, List<MatchTicketFullDto> matchesTickets,
			UserNoPassDto user) {
		this.id = id;
		this.betAmount = betAmount;
		this.won = won;
		this.matchesTickets = matchesTickets;
		this.user = user;
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

	public UserNoPassDto getUser() {
		return user;
	}

	public void setUser(UserNoPassDto user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "TicketFullDto [id=" + id + ", betAmount=" + betAmount + ", won=" + won + ", matchesTickets="
				+ matchesTickets + ", user=" + user + "]";
	}
	
}

package rs.netcast.stefan.filipovic9.bookmaker.dto;

import java.util.Date;

import rs.netcast.stefan.filipovic9.bookmaker.domain.Team;

public class MatchNoOutcomeDto {
	private int id;
	private Date matchDate;
	private Team homeTeam;
	private Team visitingTeam;
	
	public MatchNoOutcomeDto() {
		// TODO Auto-generated constructor stub
	}

	public MatchNoOutcomeDto(int id, Date matchDate, Team homeTeam, Team visitingTeam) {
		this.id = id;
		this.matchDate = matchDate;
		this.homeTeam = homeTeam;
		this.visitingTeam = visitingTeam;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Team getVisitingTeam() {
		return visitingTeam;
	}

	public void setVisitingTeam(Team visitingTeam) {
		this.visitingTeam = visitingTeam;
	}

	@Override
	public String toString() {
		return "MatchNoOutcomeDto [id=" + id + ", matchDate=" + matchDate + ", homeTeam=" + homeTeam + ", visitingTeam="
				+ visitingTeam + "]";
	}
	
}

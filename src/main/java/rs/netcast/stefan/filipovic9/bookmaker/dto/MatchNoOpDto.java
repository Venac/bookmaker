package rs.netcast.stefan.filipovic9.bookmaker.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import rs.netcast.stefan.filipovic9.bookmaker.domain.Team;

public class MatchNoOpDto {
	private int id;
	private int outcome;
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
	private Date matchDate;
	private Team homeTeam;
	private Team visitingTeam;

	public MatchNoOpDto() {
		// TODO Auto-generated constructor stub
	}

	public MatchNoOpDto(int id, int outcome, Date matchDate, Team homeTeam, Team visitingTeam) {
		this.id = id;
		this.outcome = outcome;
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

	public int getOutcome() {
		return outcome;
	}

	public void setOutcome(int outcome) {
		this.outcome = outcome;
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
		return "MatchNoOpDto [id=" + id + ", outcome=" + outcome + ", matchDate=" + matchDate + ", homeTeam=" + homeTeam
				+ ", visitingTeam=" + visitingTeam + "]";
	}
	
}

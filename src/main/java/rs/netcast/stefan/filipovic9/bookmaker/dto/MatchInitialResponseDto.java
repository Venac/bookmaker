package rs.netcast.stefan.filipovic9.bookmaker.dto;

import java.util.Date;

import rs.netcast.stefan.filipovic9.bookmaker.domain.Team;

public class MatchInitialResponseDto {
	private int id;
	private Date date;
	private Team homeTeam;
	private Team visitingTeam;
	
	public MatchInitialResponseDto() {
		// TODO Auto-generated constructor stub
	}

	public MatchInitialResponseDto(int id, Date date, Team homeTeam, Team visitingTeam) {
		this.id = id;
		this.date = date;
		this.homeTeam = homeTeam;
		this.visitingTeam = visitingTeam;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
		return "MatchInitialRepsonseDto [id=" + id + ", date=" + date + ", homeTeam=" + homeTeam + ", visitingTeam="
				+ visitingTeam + "]";
	}
	
}

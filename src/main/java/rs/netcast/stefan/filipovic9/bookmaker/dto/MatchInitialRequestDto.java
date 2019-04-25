package rs.netcast.stefan.filipovic9.bookmaker.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import rs.netcast.stefan.filipovic9.bookmaker.domain.Team;

public class MatchInitialRequestDto {
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
//	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date matchDate;
	private Team homeTeam;
	private Team visitingTeam;
	private OperatorFullNoMatches operator;
	
	public MatchInitialRequestDto() {
		// TODO Auto-generated constructor stub
	}
	
	public MatchInitialRequestDto(Date matchDate, Team homeTeam, Team visitingTeam, OperatorFullNoMatches operator) {
		this.matchDate = matchDate;
		this.homeTeam = homeTeam;
		this.visitingTeam = visitingTeam;
		this.operator = operator;
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

	public OperatorFullNoMatches getOperator() {
		return operator;
	}

	public void setOperator(OperatorFullNoMatches operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "MatchInitialRequestDto [matchDate=" + matchDate + ", homeTeam=" + homeTeam + ", visitingTeam="
				+ visitingTeam + "]";
	}
	
}

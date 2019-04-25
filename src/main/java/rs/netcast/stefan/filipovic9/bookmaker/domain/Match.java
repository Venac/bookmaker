package rs.netcast.stefan.filipovic9.bookmaker.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "matches")
public class Match {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "outcome")
	private int outcome;
	@Column(name = "match_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date matchDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "home_team_id")
	private Team homeTeam;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "visiting_team_id")
	private Team visitingTeam;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Operator operator;

	@OneToMany(mappedBy = "match")
	private List<MatchTicket> matchesTickets;
	
	public Match() {
		matchesTickets = new ArrayList<MatchTicket>();
	}
	
	public Match(Date matchDate, Team homeTeam, Team visitingTeam) {
		this.matchDate = matchDate;
		this.homeTeam = homeTeam;
		this.visitingTeam = visitingTeam;
		matchesTickets = new ArrayList<MatchTicket>();
	}

	public Match(Date matchDate, Team homeTeam, Team visitingTeam, Operator operator) {
		this.matchDate = matchDate;
		this.homeTeam = homeTeam;
		this.visitingTeam = visitingTeam;
		this.operator = operator;
		matchesTickets = new ArrayList<MatchTicket>();
	}

	public Match(int id, int outcome, Date matchDate, Team homeTeam, Team visitingTeam) {
		this.id = id;
		this.outcome = outcome;
		this.matchDate = matchDate;
		this.homeTeam = homeTeam;
		this.visitingTeam = visitingTeam;
		matchesTickets = new ArrayList<MatchTicket>();
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

	public Date getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(Date date) {
		this.matchDate = date;
	}

	public List<MatchTicket> getMatchesTickets() {
		return matchesTickets;
	}

	public void setMatchesTickets(List<MatchTicket> matchesTickets) {
		this.matchesTickets = matchesTickets;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public String avoidRecursion() {
		return "Match [id=" + id + ", outcome=" + outcome + ", date=" + matchDate + "]";
	}

	@Override
	public String toString() {
		return "Match [id=" + id + ", outcome=" + outcome + ", date=" + matchDate + ", homeTeam=" + homeTeam
				+ ", visitingTeam=" + visitingTeam + "]";
	}
	
}

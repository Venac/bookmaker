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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
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
	private List<MatchTicket> matchesTickets = new ArrayList<MatchTicket>();

	public String avoidRecursion() {
		return "Match [id=" + id + ", outcome=" + outcome + ", date=" + matchDate + "]";
	}

	@Override
	public String toString() {
		return "Match [id=" + id + ", outcome=" + outcome + ", date=" + matchDate + ", homeTeam=" + homeTeam
				+ ", visitingTeam=" + visitingTeam + "]";
	}
	
}

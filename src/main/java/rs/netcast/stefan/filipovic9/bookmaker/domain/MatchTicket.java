package rs.netcast.stefan.filipovic9.bookmaker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "matches_tickets")
public class MatchTicket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "outcome_prediction")
	private int outcomePrediction;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "match_id")
	private Match match;

	public MatchTicket() {

	}

	public MatchTicket(int outcomePrediction) {
		this.outcomePrediction = outcomePrediction;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOutcomePrediction() {
		return outcomePrediction;
	}

	public void setOutcomePrediction(int outcomePrediction) {
		this.outcomePrediction = outcomePrediction;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public String avoidRecursion() {
		return "MatchTicket [id=" + id + ", outcomePrediction=" + outcomePrediction + "]";
	}

	@Override
	public String toString() {
		return "MatchTicket [id=" + id + ", outcomePrediction=" + outcomePrediction + /*", ticket=" + ticket +*/ ", match="
				+ match + "]";
	}
	
}

package rs.netcast.stefan.filipovic9.bookmaker.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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

@Entity
@Table(name = "tickets")
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "bet_amount")
	private double betAmount;
	@Column(name = "won")
	private int won;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "ticket_id")
	private List<MatchTicket> matchesTickets;

	public Ticket() {
		matchesTickets = new ArrayList<MatchTicket>();
	}

	public Ticket(double betAmount, User user) {
		this.betAmount = betAmount;
		this.user = user;
		matchesTickets = new ArrayList<MatchTicket>();
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<MatchTicket> getMatchesTickets() {
		return matchesTickets;
	}

	public void setMatchesTickets(List<MatchTicket> matchesTickets) {
		this.matchesTickets = matchesTickets;
	}

	public String avoidRecursion() {
		return "Ticket [id=" + id + ", betAmount=" + betAmount + ", won=" + won + "]";
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", betAmount=" + betAmount + ", won=" + won + ", user=" + user.avoidRecursion() + ", matchesTickets="
				+ matchesTickets.size() + "]";
	}	
	
}

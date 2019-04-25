package rs.netcast.stefan.filipovic9.bookmaker.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="teams")
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "homeTeam", cascade = CascadeType.REMOVE)
	private List<Match> homeMatches;
	
	@OneToMany(mappedBy = "visitingTeam", cascade = CascadeType.REMOVE)
	private List<Match> visitingMatches;

	public Team() {
		homeMatches = new ArrayList<Match>();
		visitingMatches = new ArrayList<Match>();
	}

	public Team(String name) {
		this.name = name;
		homeMatches = new ArrayList<Match>();
		visitingMatches = new ArrayList<Match>();
	}

	public Team(int id, String name) {
		this.id = id;
		this.name = name;
		homeMatches = new ArrayList<Match>();
		visitingMatches = new ArrayList<Match>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}

	
}

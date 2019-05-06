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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
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
	private List<Match> homeMatches = new ArrayList<Match>();
	
	@OneToMany(mappedBy = "visitingTeam", cascade = CascadeType.REMOVE)
	private List<Match> visitingMatches = new ArrayList<Match>();

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}
	
}

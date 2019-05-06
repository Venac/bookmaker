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
@Table(name = "bookmakers")
public class Bookmaker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "balance")
	private double balance;
	
	@OneToMany(mappedBy = "bookmaker", cascade = CascadeType.ALL)
	private List<Operator> operators = new ArrayList<Operator>();
	
	@OneToMany(mappedBy = "bookmaker", cascade = CascadeType.ALL)
	private List<User> users = new ArrayList<User>();
	
	@OneToMany(mappedBy = "bookmaker", cascade = CascadeType.ALL)
	private List<Transaction> transactions = new ArrayList<Transaction>();
	
	public String avoidRecursion() {
		return "Bookmaker [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}

	@Override
	public String toString() {
		return "Bookmaker [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}
	
}

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
	private List<Operator> operators;
	
	@OneToMany(mappedBy = "bookmaker", cascade = CascadeType.ALL)
	private List<User> users;
	
	@OneToMany(mappedBy = "bookmaker", cascade = CascadeType.ALL)
	private List<Transaction> transactions;

	public Bookmaker() {
		operators = new ArrayList<Operator>();
		users = new ArrayList<User>();
		transactions = new ArrayList<Transaction>();
	}

	public Bookmaker(String name, double balance) {
		this.name = name;
		this.balance = balance;
		operators = new ArrayList<Operator>();
		users = new ArrayList<User>();
		transactions = new ArrayList<Transaction>();
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

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Operator> getOperators() {
		return operators;
	}

	public void setOperators(List<Operator> operators) {
		this.operators = operators;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public String avoidRecursion() {
		return "Bookmaker [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}

	@Override
	public String toString() {
		return "Bookmaker [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}
	
}

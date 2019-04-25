package rs.netcast.stefan.filipovic9.bookmaker.dto;

import java.util.ArrayList;
import java.util.List;

public class UserWithTicketsDto {
	private int id;
	private double balance;
	private String firstName;
	private String lastName;
	private String email;
	private List<TicketNoUserDto> tickets;
	
	public UserWithTicketsDto() {
		tickets = new ArrayList<TicketNoUserDto>();
	}

	public UserWithTicketsDto(int id, double balance, String firstName, String lastName, String email) {
		this.id = id;
		this.balance = balance;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		tickets = new ArrayList<TicketNoUserDto>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<TicketNoUserDto> getTickets() {
		return tickets;
	}

	public void setTickets(List<TicketNoUserDto> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "UserWithTicketsDto [id=" + id + ", balance=" + balance + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + "]";
	}
	
}

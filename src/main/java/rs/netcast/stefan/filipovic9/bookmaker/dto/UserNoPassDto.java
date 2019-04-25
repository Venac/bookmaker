package rs.netcast.stefan.filipovic9.bookmaker.dto;

public class UserNoPassDto {
	private int id;
	private double balance;
	private String firstName;
	private String lastName;
	private String email;
	
	public UserNoPassDto() {
	}

	public UserNoPassDto(int id, double balance, String firstName, String lastName, String email) {
		this.id = id;
		this.balance = balance;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
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

	@Override
	public String toString() {
		return "UserNoPassDto [id=" + id + ", balance=" + balance + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + "]";
	}
		
}

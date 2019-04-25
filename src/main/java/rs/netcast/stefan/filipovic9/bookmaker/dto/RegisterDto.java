package rs.netcast.stefan.filipovic9.bookmaker.dto;

import rs.netcast.stefan.filipovic9.bookmaker.domain.Bookmaker;

public class RegisterDto {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Bookmaker bookmaker;

	public RegisterDto() {
		// TODO Auto-generated constructor stub
	}

	public RegisterDto(String firstName, String lastName, String email, String password, Bookmaker bookmaker) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.bookmaker = bookmaker;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Bookmaker getBookmaker() {
		return bookmaker;
	}

	public void setBookmaker(Bookmaker bookmaker) {
		this.bookmaker = bookmaker;
	}

	@Override
	public String toString() {
		return "RegisterDto [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", bookmaker=" + bookmaker + "]";
	}

}

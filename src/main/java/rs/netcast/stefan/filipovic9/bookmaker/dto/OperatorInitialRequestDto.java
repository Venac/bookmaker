package rs.netcast.stefan.filipovic9.bookmaker.dto;

public class OperatorInitialRequestDto {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private BookmakerFullDto bookmaker;

	public OperatorInitialRequestDto() {
		// TODO Auto-generated constructor stub
	}

	public OperatorInitialRequestDto(String firstName, String lastName, String email, String password,
			BookmakerFullDto bookmaker) {
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

	public BookmakerFullDto getBookmaker() {
		return bookmaker;
	}

	public void setBookmaker(BookmakerFullDto bookmaker) {
		this.bookmaker = bookmaker;
	}

	@Override
	public String toString() {
		return "OperatorInitialRequestDto [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", bookmaker=" + bookmaker + "]";
	}

}

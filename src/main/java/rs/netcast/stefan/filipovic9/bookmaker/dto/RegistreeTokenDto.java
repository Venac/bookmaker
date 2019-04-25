package rs.netcast.stefan.filipovic9.bookmaker.dto;

public class RegistreeTokenDto {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String token;
	
	public RegistreeTokenDto() {
		// TODO Auto-generated constructor stub
	}

	public RegistreeTokenDto(int id, String firstName, String lastName, String email, String token) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.token = token;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "RegistreeTokenDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", token=" + token + "]";
	}
	
}

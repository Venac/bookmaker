package rs.netcast.stefan.filipovic9.bookmaker.dto;

public class RegistreeLogInDto {
	private String email;
	private String password;
	
	public RegistreeLogInDto() {
		// TODO Auto-generated constructor stub
	}
	
	public RegistreeLogInDto(String email, String password) {
		this.email = email;
		this.password = password;
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

	@Override
	public String toString() {
		return "RegistreeLogInDto [email=" + email + ", password=" + password + "]";
	}
	
}

package rs.netcast.stefan.filipovic9.bookmaker.dto;

public class OperatorPassDto {
	private String password;

	public OperatorPassDto() {
		// TODO Auto-generated constructor stub
	}

	public OperatorPassDto(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "OperatorPassDto [password=" + password + "]";
	}

}

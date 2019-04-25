package rs.netcast.stefan.filipovic9.bookmaker.dto;

public class TeamNoIdDto {
	private String name;

	public TeamNoIdDto() {
		// TODO Auto-generated constructor stub
	}

	public TeamNoIdDto(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "TeamNoIdDto [name=" + name + "]";
	}
	
}

package rs.netcast.stefan.filipovic9.bookmaker.dto;

public class TeamNoMatchesDto {
	private int id;
	private String name;
	
	public TeamNoMatchesDto() {
		// TODO Auto-generated constructor stub
	}
	public TeamNoMatchesDto(int id, String name) {
		this.id = id;
		this.name = name;
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
	@Override
	public String toString() {
		return "TeamNoMatches [id=" + id + ", name=" + name + "]";
	}
	
}

package rs.netcast.stefan.filipovic9.bookmaker.dto;

import java.util.ArrayList;
import java.util.List;

public class OperatorFullWithMatches {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private BookmakerFullDto bookmaker;
	private List<MatchNoOpDto> matches;
	
	public OperatorFullWithMatches() {
		matches = new ArrayList<MatchNoOpDto>();
	}

	public OperatorFullWithMatches(int id, String firstName, String lastName, String email, BookmakerFullDto bookmaker) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.bookmaker = bookmaker;
		matches = new ArrayList<MatchNoOpDto>();
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

	public BookmakerFullDto getBookmaker() {
		return bookmaker;
	}

	public void setBookmaker(BookmakerFullDto bookmaker) {
		this.bookmaker = bookmaker;
	}

	public List<MatchNoOpDto> getMatches() {
		return matches;
	}

	public void setMatches(List<MatchNoOpDto> matches) {
		this.matches = matches;
	}

	@Override
	public String toString() {
		return "OperatorFullWithMatches [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", bookmaker=" + bookmaker + ", matches=" + matches + "]";
	}
	
}

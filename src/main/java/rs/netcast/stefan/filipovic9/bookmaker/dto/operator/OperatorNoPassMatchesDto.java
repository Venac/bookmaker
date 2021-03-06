package rs.netcast.stefan.filipovic9.bookmaker.dto.operator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.netcast.stefan.filipovic9.bookmaker.dto.bookmaker.BookmakerOnlyIdDto;

@Data @AllArgsConstructor @NoArgsConstructor
public class OperatorNoPassMatchesDto {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	BookmakerOnlyIdDto bookmaker;
}

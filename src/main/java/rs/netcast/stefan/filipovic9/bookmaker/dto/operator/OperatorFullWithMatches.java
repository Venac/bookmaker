package rs.netcast.stefan.filipovic9.bookmaker.dto.operator;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.netcast.stefan.filipovic9.bookmaker.dto.match.MatchNoOpDto;

@Data @AllArgsConstructor @NoArgsConstructor
public class OperatorFullWithMatches {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private List<MatchNoOpDto> matches;
}

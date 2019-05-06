package rs.netcast.stefan.filipovic9.bookmaker.dto.match;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.netcast.stefan.filipovic9.bookmaker.domain.Team;

@Data @AllArgsConstructor @NoArgsConstructor
public class MatchNoOutcomeDto {
	private int id;
	private Date matchDate;
	private Team homeTeam;
	private Team visitingTeam;
}

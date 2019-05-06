package rs.netcast.stefan.filipovic9.bookmaker.dto.match;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.netcast.stefan.filipovic9.bookmaker.dto.operator.OperatorOnlyIdDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.team.TeamNoMatchesDto;

@Data @AllArgsConstructor @NoArgsConstructor
public class MatchInitialResponseDto {
	private int id;
	private Date matchDate;
	private TeamNoMatchesDto homeTeam;
	private TeamNoMatchesDto visitingTeam;
	private OperatorOnlyIdDto operator;
}

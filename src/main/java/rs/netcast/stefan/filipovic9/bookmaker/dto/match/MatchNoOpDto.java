package rs.netcast.stefan.filipovic9.bookmaker.dto.match;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.netcast.stefan.filipovic9.bookmaker.dto.team.TeamNoMatchesDto;

@Data @AllArgsConstructor @NoArgsConstructor
public class MatchNoOpDto {
	private int id;
	private int outcome;
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
	private Date matchDate;
	private TeamNoMatchesDto homeTeam;
	private TeamNoMatchesDto visitingTeam;
}

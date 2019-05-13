package rs.netcast.stefan.filipovic9.bookmaker.dto.match;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.netcast.stefan.filipovic9.bookmaker.dto.operator.OperatorOnlyIdDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.team.TeamNoMatchesDto;

@Data @AllArgsConstructor @NoArgsConstructor
public class MatchNoIdDto {
	@Min(0)
	private int outcome;
	@NotNull
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
	private Date matchDate;
	@NotNull
	private TeamNoMatchesDto homeTeam;
	@NotNull
	private TeamNoMatchesDto visitingTeam;
	@NotNull
	private OperatorOnlyIdDto operator;	
}

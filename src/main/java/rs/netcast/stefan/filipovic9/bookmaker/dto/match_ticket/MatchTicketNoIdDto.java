package rs.netcast.stefan.filipovic9.bookmaker.dto.match_ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.netcast.stefan.filipovic9.bookmaker.dto.match.MatchOnlyIdDto;

@Data @AllArgsConstructor @NoArgsConstructor
public class MatchTicketNoIdDto {
	private MatchOnlyIdDto match;
	private int outcomePrediction;
}

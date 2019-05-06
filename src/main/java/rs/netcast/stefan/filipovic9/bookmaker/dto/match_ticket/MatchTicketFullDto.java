package rs.netcast.stefan.filipovic9.bookmaker.dto.match_ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.netcast.stefan.filipovic9.bookmaker.dto.match.MatchNoOpDto;

@Data @AllArgsConstructor @NoArgsConstructor
public class MatchTicketFullDto {
	private int id;
	private int outcomePrediction;
	private MatchNoOpDto match;
}

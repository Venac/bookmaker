package rs.netcast.stefan.filipovic9.bookmaker.dto.ticket;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.netcast.stefan.filipovic9.bookmaker.dto.match_ticket.MatchTicketNoIdDto;

@Data @AllArgsConstructor @NoArgsConstructor
public class TicketNoIdDto {
	@Min(20)
	private double betAmount;
	@NotNull
	private List<MatchTicketNoIdDto> matchesTickets;
}

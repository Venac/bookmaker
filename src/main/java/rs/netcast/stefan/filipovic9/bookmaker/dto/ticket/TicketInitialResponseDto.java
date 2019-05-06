package rs.netcast.stefan.filipovic9.bookmaker.dto.ticket;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.netcast.stefan.filipovic9.bookmaker.dto.match_ticket.MatchTicketNoIdDto;

@Data @AllArgsConstructor @NoArgsConstructor
public class TicketInitialResponseDto {
	private int id;
	private double amount;
	private List<MatchTicketNoIdDto> matchesTickets;
}

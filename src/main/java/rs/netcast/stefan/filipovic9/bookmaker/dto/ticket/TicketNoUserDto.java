package rs.netcast.stefan.filipovic9.bookmaker.dto.ticket;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.netcast.stefan.filipovic9.bookmaker.dto.match_ticket.MatchTicketFullDto;

@Data @AllArgsConstructor @NoArgsConstructor
public class TicketNoUserDto {
	private int id;
	private double betAmount;
	private int won;
	private List<MatchTicketFullDto> matchesTickets;
}

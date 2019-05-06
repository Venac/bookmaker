package rs.netcast.stefan.filipovic9.bookmaker.dto.ticket;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.netcast.stefan.filipovic9.bookmaker.dto.match_ticket.MatchTicketFullDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.user.UserOnlyIdDto;

@Data @AllArgsConstructor @NoArgsConstructor
public class TicketFullDto {
	private int id;
	private double betAmount;
	private int won;
	private UserOnlyIdDto user;
	private List<MatchTicketFullDto> matchesTickets;
}

package rs.netcast.stefan.filipovic9.bookmaker.dto.ticket;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.netcast.stefan.filipovic9.bookmaker.dto.match_ticket.MatchTicketNoIdDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.user.UserNoPassDto;

@Data @AllArgsConstructor @NoArgsConstructor
public class TicketNoIdDto {
	private double betAmount;
	private int won;
	private UserNoPassDto user;
	private List<MatchTicketNoIdDto> matchesTickets;
}

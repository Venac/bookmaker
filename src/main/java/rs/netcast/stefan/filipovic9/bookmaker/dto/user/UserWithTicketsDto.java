package rs.netcast.stefan.filipovic9.bookmaker.dto.user;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.netcast.stefan.filipovic9.bookmaker.dto.ticket.TicketNoUserDto;

@Data @AllArgsConstructor @NoArgsConstructor
public class UserWithTicketsDto {
	private int id;
	private double balance;
	private String firstName;
	private String lastName;
	private String email;
	private List<TicketNoUserDto> tickets;
}

package rs.netcast.stefan.filipovic9.bookmaker.dto.ticket;

import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class TicketOnlyWonDto {
	@Min(0)
	private int won;
}

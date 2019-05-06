package rs.netcast.stefan.filipovic9.bookmaker.dto.bookmaker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class BookmakerNoIdDto {
	private String name;
	private double balance;
}

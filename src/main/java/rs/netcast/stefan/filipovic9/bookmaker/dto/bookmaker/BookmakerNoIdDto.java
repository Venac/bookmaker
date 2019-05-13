package rs.netcast.stefan.filipovic9.bookmaker.dto.bookmaker;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class BookmakerNoIdDto {
	@NotBlank
	private String name;
	@Min(0)
	private double balance;
}

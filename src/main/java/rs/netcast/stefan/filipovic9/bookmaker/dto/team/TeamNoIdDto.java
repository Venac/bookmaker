package rs.netcast.stefan.filipovic9.bookmaker.dto.team;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class TeamNoIdDto {
	@NotBlank
	private String name;
}

package rs.netcast.stefan.filipovic9.bookmaker.dto.register;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class RegistreeTokenDto {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String token;
}

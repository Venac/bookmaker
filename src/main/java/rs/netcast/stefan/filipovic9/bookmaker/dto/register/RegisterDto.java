package rs.netcast.stefan.filipovic9.bookmaker.dto.register;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.netcast.stefan.filipovic9.bookmaker.domain.Bookmaker;

@Data @AllArgsConstructor @NoArgsConstructor
public class RegisterDto {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Bookmaker bookmaker;
}

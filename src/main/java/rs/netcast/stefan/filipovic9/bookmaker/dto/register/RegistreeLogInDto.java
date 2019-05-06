package rs.netcast.stefan.filipovic9.bookmaker.dto.register;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class RegistreeLogInDto {
	private String email;
	private String password;
}

package rs.netcast.stefan.filipovic9.bookmaker.dto.misc;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class PasswordDto {
	@Size(min = 8, message = "password be must be at least 8 characters long")
	@NotBlank(message = "password be must be at least 8 characters long")
	private String password;
}

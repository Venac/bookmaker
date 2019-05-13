package rs.netcast.stefan.filipovic9.bookmaker.dto.operator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class OperatorInitialRequestDto {
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@Email(message = "email must be properly formatted")
	@NotBlank(message = "email must be properly formatted")
	private String email;
	@Size(min = 8, message = "password be must be at least 8 characters long")
	@NotBlank(message = "password be must be at least 8 characters long")
	private String password;
}

package rs.netcast.stefan.filipovic9.bookmaker.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class UserNoPassDto {
	private int id;
	private double balance;
	private String firstName;
	private String lastName;
	private String email;
}

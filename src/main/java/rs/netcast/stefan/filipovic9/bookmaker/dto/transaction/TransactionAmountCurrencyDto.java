package rs.netcast.stefan.filipovic9.bookmaker.dto.transaction;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class TransactionAmountCurrencyDto {
	@Min(1)
	private double amount;
	@NotBlank
	private String currency;
}

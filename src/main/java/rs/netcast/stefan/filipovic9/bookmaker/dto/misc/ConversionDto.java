package rs.netcast.stefan.filipovic9.bookmaker.dto.misc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ConversionDto {
	private double rate;
	private double amount;
	private double converted;
}

package rs.netcast.stefan.filipovic9.bookmaker.dto.transaction;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.netcast.stefan.filipovic9.bookmaker.dto.bookmaker.BookmakerFullDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.user.UserNoPassDto;

@Data @AllArgsConstructor @NoArgsConstructor
public class TransactionInitialDto {
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
	private Date transactionDate;
	private double amount;
	private int transactionType;
	private BookmakerFullDto bookmaker;
	private UserNoPassDto user;
}

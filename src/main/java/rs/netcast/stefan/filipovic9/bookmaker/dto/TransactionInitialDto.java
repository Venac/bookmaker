package rs.netcast.stefan.filipovic9.bookmaker.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class TransactionInitialDto {
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
	private Date transactionDate;
	private double amount;
	private int transactionType;
	private BookmakerFullDto bookmaker;
	private UserNoPassDto user;
	
	public TransactionInitialDto() {
		// TODO Auto-generated constructor stub
	}
	
	public TransactionInitialDto(Date transactionDate, double amount, int transactionType, BookmakerFullDto bookmaker,
			UserNoPassDto user) {
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.transactionType = transactionType;
		this.bookmaker = bookmaker;
		this.user = user;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(int transactionType) {
		this.transactionType = transactionType;
	}

	public BookmakerFullDto getBookmaker() {
		return bookmaker;
	}

	public void setBookmaker(BookmakerFullDto bookmaker) {
		this.bookmaker = bookmaker;
	}

	public UserNoPassDto getUser() {
		return user;
	}

	public void setUser(UserNoPassDto user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "TransactionInitialDto [transactionDate=" + transactionDate + ", amount=" + amount + ", transactionType="
				+ transactionType + ", bookmaker=" + bookmaker + ", user=" + user + "]";
	}
	
}

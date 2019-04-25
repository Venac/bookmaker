package rs.netcast.stefan.filipovic9.bookmaker.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class TransactionFullDto {
	private int id;
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
	private Date transactionDate;
	private double amount;
	private int transactionType;
//	private BookmakerFullDto bookmaker;
	private UserNoPassDto user;

	public TransactionFullDto() {
		// TODO Auto-generated constructor stub
	}

	public TransactionFullDto(int id, Date transactionDate, double amount, int transactionType, UserNoPassDto user) {
		this.id = id;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.transactionType = transactionType;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public UserNoPassDto getUser() {
		return user;
	}

	public void setUser(UserNoPassDto user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "TransactionFullDto [id=" + id + ", transactionDate=" + transactionDate + ", amount=" + amount
				+ ", transactionType=" + transactionType + ", user=" + user + "]";
	}

}

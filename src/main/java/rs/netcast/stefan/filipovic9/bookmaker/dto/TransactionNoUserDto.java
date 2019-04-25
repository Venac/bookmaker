package rs.netcast.stefan.filipovic9.bookmaker.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class TransactionNoUserDto {
	private int id;
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
//	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date transactionDate;
	private double amount;
	private int transactionType;
	
	public TransactionNoUserDto() {
		// TODO Auto-generated constructor stub
	}

	public TransactionNoUserDto(int id, Date transactionDate, double amount, int transactionType) {
		this.id = id;
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.transactionType = transactionType;
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

	@Override
	public String toString() {
		return "TransactionNoUserDto [id=" + id + ", transactionDate=" + transactionDate + ", amount=" + amount
				+ ", transactionType=" + transactionType + "]";
	}
	
}

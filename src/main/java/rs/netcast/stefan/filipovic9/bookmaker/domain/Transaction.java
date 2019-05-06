package rs.netcast.stefan.filipovic9.bookmaker.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
@Entity
@Table(name = "transactions")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "transaction_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionDate;
	@Column(name = "amount")
	private double amount;
	@Column(name = "transaction_type")
	private int transactionType;
	@Column(name = "currency")
	private String currency;
	@Column(name = "rate")
	private double rate;
	@Column(name = "conversion_log")
	private String conversionLog;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bookmaker_id")
	private Bookmaker bookmaker;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	public Transaction(Date transactionDate, double amount, int transactionType, Bookmaker bookmaker, User user) {
		super();
		this.transactionDate = transactionDate;
		this.amount = amount;
		this.transactionType = transactionType;
		this.bookmaker = bookmaker;
		this.user = user;
		this.currency = "RSD";
		this.rate = 1;
		this.conversionLog = "No conversion";
	}

	public String avoidRecursion() {
		return "Transaction [id=" + id + ", transactionDate=" + transactionDate + ", amount=" + amount
				+ ", transactionType=" + transactionType + ", currency=" + currency + ", rate=" + rate
				+ ", conversionLog=" + conversionLog + "]";
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", transactionDate=" + transactionDate + ", amount=" + amount
				+ ", transactionType=" + transactionType + ", currency=" + currency + ", rate=" + rate
				+ ", conversionLog=" + conversionLog + ", bookmaker=" + bookmaker.avoidRecursion() + ", user=" + user.avoidRecursion() + "]";
	}
	
}

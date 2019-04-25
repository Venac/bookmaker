package rs.netcast.stefan.filipovic9.bookmaker.dto;

public class TransactionAmCurrDto {
	private double amount;
	private String currency;
	
	public TransactionAmCurrDto() {
		// TODO Auto-generated constructor stub
	}

	public TransactionAmCurrDto(double amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "TransactionAmCurrDto [amount=" + amount + ", currency=" + currency + "]";
	}
	
}

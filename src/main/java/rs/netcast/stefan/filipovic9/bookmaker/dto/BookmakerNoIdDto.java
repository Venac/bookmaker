package rs.netcast.stefan.filipovic9.bookmaker.dto;

public class BookmakerNoIdDto {
	private String name;
	private double balance;
	
	public BookmakerNoIdDto() {
		// TODO Auto-generated constructor stub
	}
	public BookmakerNoIdDto(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "BookmakerNoIdDto [name=" + name + ", balance=" + balance + "]";
	}
	
}

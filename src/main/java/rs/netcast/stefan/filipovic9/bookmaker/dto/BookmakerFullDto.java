package rs.netcast.stefan.filipovic9.bookmaker.dto;

public class BookmakerFullDto {
	private int id;
	private String name;
	private double balance;
	
	public BookmakerFullDto() {
		// TODO Auto-generated constructor stub
	}
	public BookmakerFullDto(int id, String name, double balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "BookmakerFullDto [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}

}

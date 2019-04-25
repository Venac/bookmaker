package rs.netcast.stefan.filipovic9.bookmaker.dto;

public class ConversionDto {
	private double rate;
	private double amount;
	private double converted;

	public ConversionDto() {
		// TODO Auto-generated constructor stub
	}

	public ConversionDto(double rate, double amount, double converted) {
		this.rate = rate;
		this.amount = amount;
		this.converted = converted;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getConverted() {
		return converted;
	}

	public void setConverted(double converted) {
		this.converted = converted;
	}

	@Override
	public String toString() {
		return "ConversionDto [rate=" + rate + ", amount=" + amount + ", converted=" + converted + "]";
	}

}

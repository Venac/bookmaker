package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.io.IOException;

import rs.netcast.stefan.filipovic9.bookmaker.dto.ConversionDto;

public interface ConversionService {
	public ConversionDto toRSD(double amount, String currency) throws IOException;
	public double convertInitial(double amount) throws IOException;
	public void getExchangeRates() throws IOException;
}

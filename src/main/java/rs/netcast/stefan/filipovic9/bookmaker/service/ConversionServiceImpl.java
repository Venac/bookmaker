package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import rs.netcast.stefan.filipovic9.bookmaker.dto.misc.ConversionDto;

@Service
public class ConversionServiceImpl implements ConversionService {
	private static final Set<String> currencies = new HashSet<String>();
	private Map<String, Double> rates;
	private String key = "d67cb9e96d0d3eca1b97";
	
	static {
		currencies.add("EUR");
		currencies.add("USD");
		currencies.add("CHF");
	}

	@Transactional
	@Override
	public ConversionDto toRSD(double amount, String currency) throws IOException {
		Double converted = round(amount * rates.get(currency));
		return new ConversionDto(rates.get(currency), amount, converted);
	}

	@Override
	public double convertInitial(double amount) throws IOException {
		return round(rates.get("EUR") * amount);
	}

	public double getRate(String currency) throws IOException {
		String urlString = "https://free.currencyconverterapi.com/api/v6/convert?q=" + currency
				+ "_RSD&compact=ultra&apiKey=" + key;
		URL url = new URL(urlString);
		try {
		System.out.println(urlString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.connect();
		JsonObject json = new JsonParser().parse(new InputStreamReader((InputStream) conn.getContent()))
				.getAsJsonObject();
		return json.get(currency + "_RSD").getAsDouble();
		} catch (IOException e) {
			double test = 100;
			System.out.println("Obtaining exchange rate for " + currency + " has failed...");
			System.out.println("Setting test exchange rate for " + currency + " too " + test);
			return test;
		}
	}
	
	public void getExchangeRates() throws IOException {
		rates = new HashMap<String, Double>();
		for (String s : currencies) {
			double rate = getRate(s);
			rates.put(s, rate);
		}
		for (Map.Entry<String, Double> entry : rates.entrySet()) {
			System.out.println(entry);
		}
	}

	public double round(double d) {
		d = (double) Math.round(d * 100);
		return d / 100;
	}

}

package rs.netcast.stefan.filipovic9.bookmaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import rs.netcast.stefan.filipovic9.bookmaker.service.ConversionService;

@SpringBootApplication
@EnableScheduling
@Import(org.modelmapper.ModelMapper.class)
public class BookmakerApplication implements ApplicationRunner{
	@Autowired
	private ConversionService conversionService;
	
	public static void main(String[] args) {
		SpringApplication.run(BookmakerApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		conversionService.getExchangeRates();
	}

}

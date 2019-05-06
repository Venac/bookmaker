package rs.netcast.stefan.filipovic9.bookmaker.scheduler;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import rs.netcast.stefan.filipovic9.bookmaker.domain.Ticket;
import rs.netcast.stefan.filipovic9.bookmaker.dto.ticket.TicketFullDto;
import rs.netcast.stefan.filipovic9.bookmaker.service.ConversionService;
import rs.netcast.stefan.filipovic9.bookmaker.service.EmailService;
import rs.netcast.stefan.filipovic9.bookmaker.service.MatchService;
import rs.netcast.stefan.filipovic9.bookmaker.service.TicketService;

@Component
public class ScheduledTasks {
	@Autowired
	private TicketService ticketService;
	@Autowired
	private EmailService emailService;
	@Autowired
	private MatchService matchService;
	@Autowired
	private ConversionService conversionService;
	@Autowired
	private ModelMapper mapper;
	
//	@Scheduled(cron = "0 0 * * * *") // at 00:00
	// shorter period for testing purpose
	@Scheduled(initialDelay = 3000, fixedDelay = 3600000)
	@Transactional
	public void resolveMatches() {
		System.out.println("RESOLVING MATCHES");
		matchService.generateOutcome();
	}
	
//	@Scheduled(cron = "30 0 * * * *") // at 00:30
	// shorter period for testing purpose
	@Scheduled(initialDelay = 5000, fixedDelay = 3600000)
	@Transactional
	public List<TicketFullDto> resolveTickets() throws ParseException {
		System.out.println("RESOLVING TICKETS");
		List<Ticket> tickets = ticketService.resolveTickets();
		emailService.sendTicketEmails(tickets);
		List<TicketFullDto> result = new ArrayList<TicketFullDto>();
		for (Ticket t : tickets) {
			result.add(mapper.map(t, TicketFullDto.class));
		}
		return result;
	}
	
	@Scheduled(cron = "0 0 * * * *") // at 00:00
	public void getExchangeRates() throws IOException {
		conversionService.getExchangeRates();
	}

}

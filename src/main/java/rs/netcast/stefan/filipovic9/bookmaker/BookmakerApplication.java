package rs.netcast.stefan.filipovic9.bookmaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import rs.netcast.stefan.filipovic9.bookmaker.dao.MatchDAO;
import rs.netcast.stefan.filipovic9.bookmaker.dao.TicketDAO;
import rs.netcast.stefan.filipovic9.bookmaker.dao.TransactionDAO;

@SpringBootApplication
@EnableScheduling
public class BookmakerApplication implements ApplicationRunner{
	@Autowired
	private TicketDAO ticketDAO;
	@Autowired
	private MatchDAO matchDAO;
	@Autowired
	private TransactionDAO transactionDAO;
	
	public static void main(String[] args) {
		SpringApplication.run(BookmakerApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
////		List<Ticket> tickets = ticketDAO.findByMatchesTickets_MatchOutcome(1);
////		for (int i = 0; i < tickets.size(); i++) {
////			System.out.println(tickets.get(i));
////		}
//		List<Match> matches = matchDAO.findByOperator_Id(1);
//		for (Match m : matches) {
//			System.out.println(m);
//		}
//		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date start = formater.parse("2019-04-14 00:00:00");
//		Date end = formater.parse("2019-04-15 00:00:00");
//		List<Transaction> trs = transactionDAO.findByTransactionDateBetweenAndUser_id(start, end, 1);
//		System.out.println("trs: " + trs.size());
//		for (Transaction t : trs) {
//			System.out.println(trs);
//		}
		
//		List<Ticket> retrieved = ticketDAO.findByWon(MatchOutcome.SCHEDULED.value());
//		System.out.println("retrieved: " + retrieved.size());
//		for (Ticket t : retrieved) {
//			System.out.println(t);
//		}
	}

}

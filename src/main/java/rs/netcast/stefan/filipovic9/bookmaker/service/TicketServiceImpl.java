package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.netcast.stefan.filipovic9.bookmaker.dao.BookmakerDAO;
import rs.netcast.stefan.filipovic9.bookmaker.dao.TicketDAO;
import rs.netcast.stefan.filipovic9.bookmaker.dao.TransactionDAO;
import rs.netcast.stefan.filipovic9.bookmaker.dao.UserDAO;
import rs.netcast.stefan.filipovic9.bookmaker.domain.Bookmaker;
import rs.netcast.stefan.filipovic9.bookmaker.domain.Match;
import rs.netcast.stefan.filipovic9.bookmaker.domain.MatchTicket;
import rs.netcast.stefan.filipovic9.bookmaker.domain.Ticket;
import rs.netcast.stefan.filipovic9.bookmaker.domain.Transaction;
import rs.netcast.stefan.filipovic9.bookmaker.domain.User;
import rs.netcast.stefan.filipovic9.bookmaker.dto.MatchTicketFullDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.MatchTicketNoIdDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.TicketFullDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.TicketNoIdDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.TicketNoUserDto;
import rs.netcast.stefan.filipovic9.bookmaker.enums.MatchOutcome;
import rs.netcast.stefan.filipovic9.bookmaker.enums.TicketOutcome;
import rs.netcast.stefan.filipovic9.bookmaker.enums.TransactionType;

@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	private TicketDAO ticketDAO;
	@Autowired
	private MatchService matchService;
	@Autowired
	private UserService userService;
	@Autowired
	private TransactionDAO transactionDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private BookmakerDAO bookmakerDAO;

	public static final double ODDS = 1.5;

	@Override
	public List<TicketFullDto> findTickets() throws ParseException {
		List<Ticket> tickets = ticketDAO.findAll();
		List<TicketFullDto> response = new ArrayList<TicketFullDto>();
		for (Ticket t : tickets) {
			response.add(mapDomainToFullDto(t));
		}
		return response;
	}

	@Transactional
	@Override
	public TicketFullDto saveTicket(TicketNoIdDto ticket, int idUser) throws ParseException {
		User user = userDAO.findById(idUser).get();
		if (user.getBalance() >= ticket.getBetAmount()) {
			Ticket t = mapNoIdToDomain(ticket);
			t.setUser(user);
			Ticket s = ticketDAO.save(t);
			Transaction transaction = new Transaction(new Date(), s.getBetAmount(),
					TransactionType.TICKET_PLAYED.value(), s.getUser().getBookmaker(), s.getUser());
			transaction.setCurrency("RSD");
			transaction.setRate(1);
			transaction.setConversionLog("No conversion");
			transactionDAO.save(transaction);
			user.setBalance(user.getBalance() - ticket.getBetAmount());
//			Ticket full = ticketDAO.save(s);
//			userDAO.save(user);
			return mapDomainToFullDto(s);
		}
		return null;
	}

	@Override
	public TicketFullDto findTicket(int id) throws ParseException {
		Ticket t = ticketDAO.findById(id).get();
		System.out.println("ticket: " + t);
		System.out.println("combinaions: " + t.getMatchesTickets().size());
		return mapDomainToFullDto(t);
	}

	@Override
	public TicketFullDto updateTicket(int id, String won) throws ParseException {
		Ticket t = ticketDAO.findById(id).get();
		System.out.println(t);
		System.out.println(won);
		if (t.getWon() == TicketOutcome.UNCHECKED.value()) {
			t.setWon(Integer.parseInt(won));
			Ticket saved = ticketDAO.save(t);
			return mapDomainToFullDto(saved);
		}
		return mapDomainToFullDto(t);
	}

	@Override
	public TicketFullDto deleteTicket(int id) throws ParseException {
		Ticket t = ticketDAO.findById(id).get();
		ticketDAO.delete(t);
		return mapDomainToFullDto(t);
	}

	@Override
	@Transactional
	public List<Ticket> resolveTickets() throws ParseException {
		List<Ticket> retrieved = ticketDAO.findByWon(MatchOutcome.SCHEDULED.value());
		List<Ticket> result = new ArrayList<Ticket>();
		for (Ticket t : retrieved) {
			result.add(checkTicketOutcome(t));
		}
		return result;
	}

	@Override
	public Ticket checkTicketOutcome(Ticket t) throws ParseException {
		User u = t.getUser();
		Bookmaker b = bookmakerDAO.findById(t.getUser().getBookmaker().getId()).get();
		for (MatchTicket mt : t.getMatchesTickets()) {
			Match m = mt.getMatch();
			if (m.getOutcome() != mt.getOutcomePrediction()) {
				t.setWon(TicketOutcome.LOST.value());
				return t;
			}
		}
		t.setWon(TicketOutcome.WON.value());
		double prize = t.getBetAmount() * Math.pow(ODDS, t.getMatchesTickets().size());
		Transaction tr = new Transaction();
		tr.setTransactionType(TransactionType.TICKET_WON.value());
		tr.setBookmaker(b);
		tr.setUser(u);
		tr.setTransactionDate(new Date());
		tr.setAmount(prize);
		tr.setCurrency("RSD");
		tr.setRate(1);
		tr.setConversionLog("No conversion");
		u.setBalance(u.getBalance() + prize);
		transactionDAO.save(tr);
		return t;
	}

	@Override
	public List<TicketFullDto> findByUser(int idUser) throws ParseException {
		List<Ticket> retrieved = ticketDAO.findByUser_Id(idUser);
		List<TicketFullDto> result = new ArrayList<TicketFullDto>();
		for (Ticket t : retrieved) {
			result.add(mapDomainToFullDto(t));
		}
		return result;
	}

	// helper method(s)

	@Override
	public TicketFullDto mapDomainToFullDto(Ticket t) throws ParseException {
		TicketFullDto response = new TicketFullDto();
		System.out.println("user: " + t.getUser());
		response.setId(t.getId());
		response.setBetAmount(t.getBetAmount());
		response.setWon(t.getWon());
		response.setUser(userService.mapDomainToNoPass(t.getUser()));
		for (MatchTicket m : t.getMatchesTickets()) {
			response.getMatchesTickets().add(mapDomainToFullMT(m));
		}
		return response;
	}

	@Override
	public Ticket mapNoIdToDomain(TicketNoIdDto t) throws ParseException {
		Ticket response = new Ticket();
		response.setBetAmount(t.getBetAmount());
		response.setWon(t.getWon());
		if (t.getUser() != null) {
			response.setUser(userService.mapNoPassToDomain(t.getUser()));
		}
		for (MatchTicketNoIdDto mt : t.getMatchesTickets()) {
			response.getMatchesTickets().add(mapNoIdToDomainMT(mt));
		}
		return response;
	}

	@Override
	public TicketNoUserDto mapDomainToNoUserDto(Ticket t) throws ParseException {
		TicketNoUserDto response = new TicketNoUserDto();
		response.setId(t.getId());
		response.setBetAmount(t.getBetAmount());
		response.setWon(t.getWon());
		System.out.println("matches tickets: " + t.getMatchesTickets().size());
		for (MatchTicket m : t.getMatchesTickets()) {
			response.getMatchesTickets().add(mapDomainToFullMT(m));
		}
		return response;
	}

	@Override
	public MatchTicket mapNoIdToDomainMT(MatchTicketNoIdDto mt) throws ParseException {
		MatchTicket response = new MatchTicket();
		response.setOutcomePrediction(mt.getOutcomePrediction());
		response.setMatch(matchService.mapNoOpDtoToDomain(mt.getMatch()));
		return response;
	}

	@Override
	public MatchTicketFullDto mapDomainToFullMT(MatchTicket mt) throws ParseException {
		MatchTicketFullDto response = new MatchTicketFullDto();
		response.setOutcomePrediction(mt.getOutcomePrediction());
		response.setMatch(matchService.mapDomainToNoOpDto(mt.getMatch()));
		System.out.println("response match: " + response.getMatch());
		return response;
	}

}

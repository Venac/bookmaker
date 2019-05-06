package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
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
import rs.netcast.stefan.filipovic9.bookmaker.dto.ticket.TicketFullDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.ticket.TicketInitialResponseDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.ticket.TicketNoIdDto;
import rs.netcast.stefan.filipovic9.bookmaker.enums.MatchOutcome;
import rs.netcast.stefan.filipovic9.bookmaker.enums.TicketOutcome;
import rs.netcast.stefan.filipovic9.bookmaker.enums.TransactionType;

@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	private TicketDAO ticketDAO;
	@Autowired
	private TransactionDAO transactionDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private BookmakerDAO bookmakerDAO;
	@Autowired
	private ModelMapper mapper;

	public static final double ODDS = 1.5;

	@Override
	public List<TicketFullDto> findTickets() throws ParseException {
		List<Ticket> tickets = ticketDAO.findAll();
		List<TicketFullDto> response = new ArrayList<TicketFullDto>();
		for (Ticket t : tickets) {
			response.add(mapper.map(t, TicketFullDto.class));
		}
		return response;
	}

	@Transactional
	@Override
	public TicketInitialResponseDto saveTicket(TicketNoIdDto ticket, int idUser) throws ParseException {
		User user = userDAO.findById(idUser).get();
		if (user.getBalance() >= ticket.getBetAmount()) {
			Ticket t = mapper.map(ticket, Ticket.class);
			t.setUser(user);
			Ticket saved = ticketDAO.save(t);
			Transaction transaction = new Transaction(new Date(), saved.getBetAmount(),
					TransactionType.TICKET_PLAYED.value(), user.getBookmaker(), user);
			transactionDAO.save(transaction);
			user.setBalance(user.getBalance() - ticket.getBetAmount());
			return mapper.map(saved, TicketInitialResponseDto.class);
		}
		return null;
	}

	@Override
	public TicketFullDto findTicket(int id) throws ParseException {
		try {
			return mapper.map(ticketDAO.findById(id).get(), TicketFullDto.class);
		} catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public TicketFullDto updateTicket(int id, String won) throws ParseException {
		try {
			Ticket t = mapper.map(findTicket(id), Ticket.class);
			if (t.getWon() == TicketOutcome.UNCHECKED.value()) {
				t.setWon(Integer.parseInt(won));
				return mapper.map(ticketDAO.save(t), TicketFullDto.class);
			}
			return findTicket(id);
		} catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public TicketFullDto deleteTicket(int id) throws ParseException {
		try {
			TicketFullDto response = findTicket(id);
			ticketDAO.deleteById(id);
			return response;
		} catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		}
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
	@Transactional
	public Ticket checkTicketOutcome(Ticket t) throws ParseException {
		User user = t.getUser();
		Bookmaker bookmaker = bookmakerDAO.findById(t.getUser().getBookmaker().getId()).get();
		for (MatchTicket mt : t.getMatchesTickets()) {
			Match m = mt.getMatch();
			if (m.getOutcome() != mt.getOutcomePrediction()) {
				t.setWon(TicketOutcome.LOST.value());
				return t;
			}
		}
		t.setWon(TicketOutcome.WON.value());
		double prize = t.getBetAmount() * Math.pow(ODDS, t.getMatchesTickets().size());
		Transaction transaction = new Transaction(new Date(), prize, TransactionType.TICKET_WON.value(), bookmaker, user);
		user.setBalance(user.getBalance() + prize);
		transactionDAO.save(transaction);
		return t;
	}

	@Override
	public List<TicketFullDto> findByUser(int idUser) throws ParseException {
		List<Ticket> retrieved = ticketDAO.findByUser_Id(idUser);
		List<TicketFullDto> result = new ArrayList<TicketFullDto>();
		for (Ticket t : retrieved) {
			result.add(mapper.map(t, TicketFullDto.class));
		}
		return result;
	}
}

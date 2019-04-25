package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.netcast.stefan.filipovic9.bookmaker.dao.TransactionDAO;
import rs.netcast.stefan.filipovic9.bookmaker.dao.UserDAO;
import rs.netcast.stefan.filipovic9.bookmaker.domain.Transaction;
import rs.netcast.stefan.filipovic9.bookmaker.domain.User;
import rs.netcast.stefan.filipovic9.bookmaker.dto.ConversionDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.TimePeriodDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.TransactionAmCurrDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.TransactionFullDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.TransactionInitialDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.TransactionNoUserDto;
import rs.netcast.stefan.filipovic9.bookmaker.enums.TransactionType;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionDAO transactionDAO;
	@Autowired
	private BookmakerService bookmakerService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private ConversionService conversionService;

	@Override
	public List<TransactionFullDto> getTransaction() {
		List<Transaction> retrieved = transactionDAO.findAll();
		List<TransactionFullDto> response = new ArrayList<TransactionFullDto>();
		for (Transaction t : retrieved) {
			response.add(mapDomainToFullDto(t));
		}
		return response;
	}

	@Override
	public TransactionFullDto addTransaction(TransactionInitialDto t) {
		Transaction s = mapInitialDtoToDomain(t);
		Transaction saved = transactionDAO.save(s);
		return mapDomainToFullDto(saved);
	}

	@Override
	public TransactionFullDto getTransaction(int id) {
		Transaction retrieved = transactionDAO.findById(id).get();
		return mapDomainToFullDto(retrieved);
	}

	@Override
	public TransactionFullDto deleteTransaction(int id) {
		Transaction retrieved = transactionDAO.findById(id).get();
		TransactionFullDto response = mapDomainToFullDto(retrieved);
		transactionDAO.deleteById(id);
		return response;
	}

	@Override
	public TransactionFullDto updateTransaction(int id, TransactionFullDto t) {
		Transaction s = mapFullDtoToDomain(t);
		s.setId(id);
		Transaction saved = transactionDAO.save(s);
		return mapDomainToFullDto(saved);
	}

	@Transactional
	@Override
	public TransactionNoUserDto payIn(TransactionAmCurrDto transaction, int idUser) throws IOException {
		User user = userDAO.findById(idUser).get();
		Transaction t = new Transaction(new Date(), transaction.getAmount(), TransactionType.PAY_IN.value(),
				user.getBookmaker(), user);
		t.setCurrency(transaction.getCurrency());
		return performTransaction(t);
	}

	@Transactional
	@Override
	public TransactionNoUserDto payOut(TransactionAmCurrDto transaction, int idUser)
			throws IOException {
		User user = userDAO.findById(idUser).get();
		if (transaction.getCurrency() == "RSD") {
			if (user.getBalance() >= transaction.getAmount()) {
				Transaction t = new Transaction(new Date(), transaction.getAmount(), TransactionType.PAY_OUT.value(),
						user.getBookmaker(), user);
				t.setCurrency(transaction.getCurrency());
				return performTransaction(t);
			}
			return null;
		} else {
			Transaction t = new Transaction(new Date(), transaction.getAmount(), TransactionType.PAY_OUT.value(),
					user.getBookmaker(), user);
			t.setCurrency(transaction.getCurrency());
			ConversionDto c = conversionService.toRSD(t.getAmount(), t.getCurrency());
			if (t.getUser().getBalance() >= c.getConverted()) {
				String log = generateConversionLog(t, c.getRate(), c.getAmount());
				t.setRate(c.getRate());
				t.setAmount(c.getConverted());
				t.setConversionLog(log);
				return performTransaction(t);
			}
		}
		return null;
	}

	@Override
	public List<TransactionNoUserDto> viewTransactionsBetween(TimePeriodDto p, int idUser) {
		List<Transaction> retrieved = transactionDAO.findByTransactionDateBetweenAndUser_id(p.getStart(), p.getEnd(),
				idUser);
		List<TransactionNoUserDto> result = new ArrayList<>();
		for (Transaction t : retrieved) {
			result.add(mapDomainToNoUser(t));
		}
		return result;
	}

	// helper method(s)

	@Transactional
	@Override
	public TransactionNoUserDto performTransaction(Transaction t) throws IOException {
		if (t.getTransactionType() == TransactionType.PAY_IN.value()) {
			if (t.getCurrency() != "RSD") {
				ConversionDto c = conversionService.toRSD(t.getAmount(), t.getCurrency());
				String log = generateConversionLog(t, c.getRate(), c.getAmount());
				t.setRate(c.getRate());
				t.setAmount(c.getConverted());
				t.setConversionLog(log);
				t.getUser().setBalance(t.getUser().getBalance() + t.getAmount());
			}
		} else if (t.getTransactionType() == TransactionType.PAY_OUT.value()) {
			System.out.println("To check user: " + t);
			t.getUser().setBalance(t.getUser().getBalance() - t.getAmount());
		}
//		User saved = userDAO.save(t.getUser());
//		t.setUser(saved);
		Transaction st = transactionDAO.save(t);
		/*
		 * manually cause exception to check for rollback
		 */
//		User u = null;
//		u.setBalance(1000);
		return mapDomainToNoUser(st);
	}
	
	@Override
	public String generateConversionLog(Transaction t, double rate, double converted) {
		return "Paid in " + t.getCurrency() + " (" + converted + "), at a rate of " + rate;
	}

	@Override
	public TransactionFullDto mapDomainToFullDto(Transaction t) {
		TransactionFullDto response = new TransactionFullDto();
		response.setId(t.getId());
		response.setTransactionDate(t.getTransactionDate());
		response.setAmount(t.getAmount());
		response.setTransactionType(t.getTransactionType());
		response.setUser(userService.mapDomainToNoPass(t.getUser()));
		return response;
	}

	@Override
	public Transaction mapFullDtoToDomain(TransactionFullDto t) {
		Transaction response = new Transaction();
		response.setId(t.getId());
		response.setTransactionDate(t.getTransactionDate());
		response.setAmount(t.getAmount());
		response.setTransactionType(t.getTransactionType());
		response.setUser(userService.mapNoPassToDomain(t.getUser()));
		return response;
	}

	@Override
	public Transaction mapInitialDtoToDomain(TransactionInitialDto t) {
		Transaction response = new Transaction();
		response.setAmount(t.getAmount());
		response.setTransactionDate(t.getTransactionDate());
		response.setTransactionType(t.getTransactionType());
		response.setBookmaker(bookmakerService.mapFullDtoToDomain(t.getBookmaker()));
		response.setUser(userService.mapNoPassToDomain(t.getUser()));
		return response;
	}

	@Override
	public TransactionNoUserDto mapDomainToNoUser(Transaction t) {
		return new TransactionNoUserDto(t.getId(), t.getTransactionDate(), t.getAmount(), t.getTransactionType());
	}

}

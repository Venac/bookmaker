package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.netcast.stefan.filipovic9.bookmaker.dao.TransactionDAO;
import rs.netcast.stefan.filipovic9.bookmaker.dao.UserDAO;
import rs.netcast.stefan.filipovic9.bookmaker.domain.Transaction;
import rs.netcast.stefan.filipovic9.bookmaker.domain.User;
import rs.netcast.stefan.filipovic9.bookmaker.dto.misc.ConversionDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.misc.TimePeriodDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.transaction.TransactionAmountCurrencyDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.transaction.TransactionFullDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.transaction.TransactionNoUserDto;
import rs.netcast.stefan.filipovic9.bookmaker.enums.TransactionType;
import rs.netcast.stefan.filipovic9.bookmaker.exception.TransactionNotFoundException;
import rs.netcast.stefan.filipovic9.bookmaker.exception.UserNotFoundException;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private TransactionDAO transactionDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private ConversionService conversionService;
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<TransactionFullDto> findTransactions() {
		List<Transaction> retrieved = transactionDAO.findAll();
		List<TransactionFullDto> response = new ArrayList<TransactionFullDto>();
		for (Transaction t : retrieved) {
			response.add(mapper.map(t, TransactionFullDto.class));
		}
		return response;
	}

	@Override
	public TransactionFullDto findTransaction(int id) {
		return mapper.map(transactionDAO.findById(id).orElseThrow(() -> new TransactionNotFoundException(id)), TransactionFullDto.class);
	}

	@Transactional
	@Override
	public TransactionNoUserDto addFunds(TransactionAmountCurrencyDto transaction, int idUser) throws IOException {
		User user = userDAO.findById(idUser).orElseThrow(() -> new UserNotFoundException(idUser));
		Transaction t = new Transaction(new Date(), transaction.getAmount(), TransactionType.PAY_IN.value(),
				user.getBookmaker(), user);
		t.setCurrency(transaction.getCurrency());
		return performTransaction(t);
	}

	@Transactional
	@Override
	public TransactionNoUserDto withdrawFunds(TransactionAmountCurrencyDto transaction, int idUser)
			throws IOException {
		User user = userDAO.findById(idUser).orElseThrow(() -> new UserNotFoundException(idUser));
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
			result.add(mapper.map(t, TransactionNoUserDto.class));
		}
		return result;
	}

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
			t.getUser().setBalance(t.getUser().getBalance() - t.getAmount());
		}
		/*
		 * manually cause exception to check for transactional rollback
		 */
//		User u = null;
//		u.setBalance(1000);
		return mapper.map(transactionDAO.save(t), TransactionNoUserDto.class);
	}
	
	@Override
	public String generateConversionLog(Transaction t, double rate, double converted) {
		return "Paid in " + t.getCurrency() + " (" + converted + "), at a rate of " + rate;
	}
}

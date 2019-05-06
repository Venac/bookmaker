package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.io.IOException;
import java.util.List;

import rs.netcast.stefan.filipovic9.bookmaker.domain.Transaction;
import rs.netcast.stefan.filipovic9.bookmaker.dto.misc.TimePeriodDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.transaction.TransactionAmountCurrencyDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.transaction.TransactionFullDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.transaction.TransactionNoUserDto;

public interface TransactionService {
	public List<TransactionFullDto> findTransactions();
	public TransactionFullDto findTransaction(int id);
	public TransactionNoUserDto addFunds(TransactionAmountCurrencyDto t, int idUser) throws IOException;
	public TransactionNoUserDto withdrawFunds(TransactionAmountCurrencyDto t, int idUser) throws IOException;
	public List<TransactionNoUserDto> viewTransactionsBetween(TimePeriodDto p, int idUser);
	public TransactionNoUserDto performTransaction(Transaction t) throws IOException;
	public String generateConversionLog(Transaction t, double rate, double converted);
}

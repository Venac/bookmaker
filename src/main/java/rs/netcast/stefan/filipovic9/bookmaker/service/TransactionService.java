package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.io.IOException;
import java.util.List;

import rs.netcast.stefan.filipovic9.bookmaker.domain.Transaction;
import rs.netcast.stefan.filipovic9.bookmaker.dto.TimePeriodDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.TransactionAmCurrDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.TransactionFullDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.TransactionInitialDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.TransactionNoUserDto;

public interface TransactionService {
	public List<TransactionFullDto> getTransaction();
	public TransactionFullDto addTransaction(TransactionInitialDto t);
	public TransactionFullDto getTransaction(int id);
	public TransactionFullDto deleteTransaction(int id);
	public TransactionFullDto updateTransaction(int id, TransactionFullDto t);
	public TransactionNoUserDto payIn(TransactionAmCurrDto t, int idUser) throws IOException;
	public TransactionNoUserDto payOut(TransactionAmCurrDto t, int idUser) throws IOException;
	public List<TransactionNoUserDto> viewTransactionsBetween(TimePeriodDto p, int idUser);
	// helper methods
	public TransactionFullDto mapDomainToFullDto(Transaction t);
	public  Transaction mapFullDtoToDomain(TransactionFullDto t);
	public Transaction mapInitialDtoToDomain(TransactionInitialDto t);
	public TransactionNoUserDto mapDomainToNoUser(Transaction t);
	public TransactionNoUserDto performTransaction(Transaction t) throws IOException;
	public String generateConversionLog(Transaction t, double rate, double converted);
}

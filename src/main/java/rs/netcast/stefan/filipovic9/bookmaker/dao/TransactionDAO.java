package rs.netcast.stefan.filipovic9.bookmaker.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.netcast.stefan.filipovic9.bookmaker.domain.Transaction;

public interface TransactionDAO extends JpaRepository<Transaction, Integer>{
	public List<Transaction> findByTransactionDateBetweenAndUser_id(Date start, Date end, int id);
}
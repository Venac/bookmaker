package rs.netcast.stefan.filipovic9.bookmaker;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import rs.netcast.stefan.filipovic9.bookmaker.dao.TransactionDAO;
import rs.netcast.stefan.filipovic9.bookmaker.domain.Transaction;
import rs.netcast.stefan.filipovic9.bookmaker.dto.TransactionAmCurrDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.TransactionNoUserDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.UserNoPassDto;
import rs.netcast.stefan.filipovic9.bookmaker.service.TransactionService;
import rs.netcast.stefan.filipovic9.bookmaker.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookmakerApplicationTests {
	@Autowired
	private UserService userService;
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private TransactionDAO transactionDAO;
	
	@Test
	public void testFindAll() {
		List<UserNoPassDto> users = userService.findUsers();
		assertEquals(4, users.size());
	}
	
	@Test
	public void testPayIn() throws IOException, ParseException {
		TransactionAmCurrDto t = new TransactionAmCurrDto(10, "EUR");
		TransactionNoUserDto transaction = transactionService.payIn(t, 1);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("**********");
		System.out.println(transaction);
		Transaction retrieved = transactionDAO.findById(transaction.getId()).get();
		TransactionNoUserDto check = transactionService.mapDomainToNoUser(retrieved);
		String dateStr = format.format(check.getTransactionDate());
		System.out.println(dateStr);
		Date date = format.parse(dateStr);
		System.out.println(date);
		check.setTransactionDate(format.parse(dateStr));
		System.out.println(check);
		assertEquals(transaction.getId(), check.getId());
		Assert.assertEquals(transaction.getAmount(), check.getAmount(), 0.01);
		assertEquals(transaction.getId(), check.getId());
		assertEquals(transaction.getId(), check.getId());
	}

	@Test
	public void contextLoads() {
	}

}

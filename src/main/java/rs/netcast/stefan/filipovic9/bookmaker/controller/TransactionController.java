package rs.netcast.stefan.filipovic9.bookmaker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.netcast.stefan.filipovic9.bookmaker.dto.transaction.TransactionFullDto;
import rs.netcast.stefan.filipovic9.bookmaker.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/findAll")
	public List<TransactionFullDto> findTransactions() {
		return transactionService.findTransactions();
	}
	
	@GetMapping(value = "/find/{id}")
	public TransactionFullDto getTransaction(@PathVariable int id) {
		return transactionService.findTransaction(id);
	}

	/*
	 * other transaction operations are performed at other controllers 
	 */
}

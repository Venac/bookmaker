package rs.netcast.stefan.filipovic9.bookmaker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.netcast.stefan.filipovic9.bookmaker.dto.TransactionFullDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.TransactionInitialDto;
import rs.netcast.stefan.filipovic9.bookmaker.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/findAll")
	public List<TransactionFullDto> getTransactions() {
		return transactionService.getTransaction();
	}
	
	@PostMapping
	public TransactionFullDto addTransaction(@RequestBody TransactionInitialDto t) {
		return transactionService.addTransaction(t);
	}
	
	@GetMapping(value = "/{id}")
	public TransactionFullDto getTransaction(@PathVariable int id) {
		return transactionService.getTransaction(id);
	}
	
	// for demonstration only
	@PutMapping(value = "/{id}")
	public TransactionFullDto updateTransaction(@PathVariable int id, @RequestBody TransactionFullDto t) {
		return transactionService.updateTransaction(id, t);
	}
	
	// for demonstration only
	@DeleteMapping(value = "/{id}")
	public TransactionFullDto deleteTransaction(@PathVariable int id) {
		return transactionService.deleteTransaction(id);
	}
	
}

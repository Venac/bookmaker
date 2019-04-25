package rs.netcast.stefan.filipovic9.bookmaker.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.netcast.stefan.filipovic9.bookmaker.dto.TimePeriodDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.TransactionAmCurrDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.TransactionNoUserDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.UserNoIdDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.UserNoPassDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.UserWithTicketsDto;
import rs.netcast.stefan.filipovic9.bookmaker.service.TransactionService;
import rs.netcast.stefan.filipovic9.bookmaker.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/findAll")
	public List<UserNoPassDto> findUsersNoPass() {
		return userService.findUsers();
	}
	
	@PostMapping("/save")
	public UserNoPassDto saveUser(@RequestBody UserNoIdDto user) throws IOException {
		return userService.saveUser(user);
	}
	
	// fetches user's tickets as well
	@GetMapping("/find/{id}")
	public UserWithTicketsDto findUser(@PathVariable int id) throws ParseException {
		return userService.findUser(id);
	}
	
	@PutMapping("/update")
	public String updateUser(@RequestBody String password, HttpServletRequest request) {
		int idUser = (int) request.getAttribute("id");
		return userService.updateUser(idUser, password);
	}
	
	@DeleteMapping("/delete/{id}")
	public UserWithTicketsDto deleteUser(@PathVariable int id) throws ParseException {
		return userService.deleteUser(id);
	}
	
	@PostMapping("/payin")
	public TransactionNoUserDto payIn(@RequestBody TransactionAmCurrDto t, HttpServletRequest request) throws IOException {
		int idUser = (int) request.getAttribute("id");
		return transactionService.payIn(t, idUser);
	}
	
	@PostMapping("/payout")	
	public TransactionNoUserDto payOut(@RequestBody TransactionAmCurrDto t, HttpServletRequest request) throws IOException {
		int idUser = (int) request.getAttribute("id");
		return transactionService.payOut(t, idUser);
	}
	
	@PostMapping("/period")
	public List<TransactionNoUserDto> viewTransactionsBetween(@RequestBody TimePeriodDto p, HttpServletRequest request) {
		int idUser = (int) request.getAttribute("id");
		return transactionService.viewTransactionsBetween(p, idUser);
	}
	
}

package rs.netcast.stefan.filipovic9.bookmaker.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.netcast.stefan.filipovic9.bookmaker.dto.RegistreeLogInDto;
import rs.netcast.stefan.filipovic9.bookmaker.security.Access;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private Access access;
	
	@PostMapping("/user")
	public String generateUserJWT(@RequestBody RegistreeLogInDto user, HttpServletRequest request) {
		return access.generateLogInJWT(user, request);
	}
	
	@PostMapping("/operator")
	public String generateOperatorJWT(@RequestBody RegistreeLogInDto operator, HttpServletRequest request) {
		return access.generateLogInJWT(operator, request);
	}
}

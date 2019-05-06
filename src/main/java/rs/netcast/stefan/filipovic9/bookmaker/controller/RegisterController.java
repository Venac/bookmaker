package rs.netcast.stefan.filipovic9.bookmaker.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.netcast.stefan.filipovic9.bookmaker.dto.register.RegisterDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.register.RegistreeTokenDto;
import rs.netcast.stefan.filipovic9.bookmaker.security.Access;

@RestController
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	private Access access;
	
	@PostMapping("/user")
	public RegistreeTokenDto generateUserJWT(@RequestBody RegisterDto r, HttpServletRequest request) throws IOException {
		return access.generateRegisterJWT(r, request);
	}
	
}

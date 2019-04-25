package rs.netcast.stefan.filipovic9.bookmaker.controller;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import rs.netcast.stefan.filipovic9.bookmaker.dto.UserNoPassDto;
import rs.netcast.stefan.filipovic9.bookmaker.service.UserService;

public class UserControllerTest {
	private UserService userService;
	
	public UserControllerTest(UserService userService) {
		this.userService = userService;
	}

	@Test
	public void testFindAll() {
		List<UserNoPassDto> users = userService.findUsers();
		assertEquals(4, users.size());
	}
}

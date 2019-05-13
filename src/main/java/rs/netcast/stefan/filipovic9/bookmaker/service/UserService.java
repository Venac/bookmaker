package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import rs.netcast.stefan.filipovic9.bookmaker.dto.misc.PasswordDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.user.UserNoIdDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.user.UserNoPassDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.user.UserWithTicketsDto;

public interface UserService {
	public List<UserNoPassDto> findUsers();
	public UserNoPassDto saveUser(UserNoIdDto userNoIdDto) throws IOException;
	public UserWithTicketsDto findUser(int id) throws ParseException;
	public PasswordDto updateUser(int idUser, PasswordDto password);
	public UserWithTicketsDto deleteUser(int id) throws ParseException;
}

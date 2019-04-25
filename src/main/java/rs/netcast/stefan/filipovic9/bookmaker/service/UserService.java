package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import rs.netcast.stefan.filipovic9.bookmaker.domain.User;
import rs.netcast.stefan.filipovic9.bookmaker.dto.UserNoIdDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.UserNoPassDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.UserWithTicketsDto;

public interface UserService {
	public List<UserNoPassDto> findUsers();
	public UserNoPassDto saveUser(UserNoIdDto userNoIdDto) throws IOException;
	public UserWithTicketsDto findUser(int id) throws ParseException;
	public String updateUser(int idUser, String password);
	public UserWithTicketsDto deleteUser(int id) throws ParseException;
	// helper method(s)
	public User mapNoIdToDomain(UserNoIdDto u);
	public UserNoPassDto mapDomainToNoPass(User u);
	public User mapNoPassToDomain(UserNoPassDto u);
	public UserWithTicketsDto mapDomainToWithTickets(User u) throws ParseException;
}

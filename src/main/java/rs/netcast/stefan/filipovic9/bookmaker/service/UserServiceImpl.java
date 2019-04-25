package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.netcast.stefan.filipovic9.bookmaker.dao.UserDAO;
import rs.netcast.stefan.filipovic9.bookmaker.domain.Ticket;
import rs.netcast.stefan.filipovic9.bookmaker.domain.User;
import rs.netcast.stefan.filipovic9.bookmaker.dto.UserNoIdDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.UserNoPassDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.UserWithTicketsDto;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private TicketService ticketService;
	@Autowired
	private ConversionService conversionService;

	@Override
	public List<UserNoPassDto> findUsers() {
		List<User> users = userDAO.findAll();
		List<UserNoPassDto> retrievedUsers = new ArrayList<UserNoPassDto>();
		for (User u : users) {
			retrievedUsers.add(mapDomainToNoPass(u));
		}
		return retrievedUsers;
	}

	@Override
	public UserNoPassDto saveUser(UserNoIdDto userNoIdDto) throws IOException {
		User user = mapNoIdToDomain(userNoIdDto);
		user.setBalance(conversionService.convertInitial(5));
		User saved = userDAO.save(user);
		return mapDomainToNoPass(saved);
	}
	
	@Override
	public UserWithTicketsDto findUser(int id) throws ParseException {
		User u = userDAO.findById(id).get();
		return mapDomainToWithTickets(u);
	}
	
	@Override
	public String updateUser(int idUser, String password) {
		User u = userDAO.findById(idUser).get();
		u.setPassword(password);
		userDAO.save(u);
		return "Password successfully changed";
	}

	@Override
	public UserWithTicketsDto deleteUser(int id) throws ParseException {
		UserWithTicketsDto response = findUser(id);
		userDAO.deleteById(id);
		return response;
	}
	
	// helper method(s)

	@Override
	public User mapNoIdToDomain(UserNoIdDto u) {
		User user = new User();
		user.setBalance(5);
		user.setFirstName(u.getFirstName());
		user.setLastName(u.getLastName());
		user.setEmail(u.getEmail());
		user.setPassword(u.getPassword());
		return user;
	}
	
	@Override
	public UserNoPassDto mapDomainToNoPass(User u) {
		System.out.println("mapping user: " + u);
		UserNoPassDto user = new UserNoPassDto();
		user.setId(u.getId());
		user.setBalance(u.getBalance());
		user.setFirstName(u.getFirstName());
		user.setLastName(u.getLastName());
		user.setEmail(u.getEmail());
		return user;
	}
	
	@Override
	public User mapNoPassToDomain(UserNoPassDto u) {
		System.out.println("mapping user: " + u);
		User user = new User();
		user.setId(u.getId());
		user.setBalance(u.getBalance());
		user.setFirstName(u.getFirstName());
		user.setLastName(u.getLastName());
		user.setEmail(u.getEmail());
		return user;
	}
	
	@Override
	public UserWithTicketsDto mapDomainToWithTickets(User u) throws ParseException {
		UserWithTicketsDto response = new UserWithTicketsDto();
		response.setId(u.getId());
		response.setBalance(u.getBalance());
		response.setFirstName(u.getFirstName());
		response.setLastName(u.getFirstName());
		response.setEmail(u.getEmail());
		for (Ticket t : u.getTickets()) {
			response.getTickets().add(ticketService.mapDomainToNoUserDto(t));
		}
		return response;
	}
}

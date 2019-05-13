package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.netcast.stefan.filipovic9.bookmaker.dao.UserDAO;
import rs.netcast.stefan.filipovic9.bookmaker.domain.User;
import rs.netcast.stefan.filipovic9.bookmaker.dto.misc.PasswordDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.user.UserNoIdDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.user.UserNoPassDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.user.UserWithTicketsDto;
import rs.netcast.stefan.filipovic9.bookmaker.exception.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private ConversionService conversionService;
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<UserNoPassDto> findUsers() {
		List<User> users = userDAO.findAll();
		List<UserNoPassDto> retrievedUsers = new ArrayList<UserNoPassDto>();
		for (User u : users) {
			retrievedUsers.add(mapper.map(u, UserNoPassDto.class));
		}
		return retrievedUsers;
	}

	@Override
	public UserNoPassDto saveUser(UserNoIdDto userNoIdDto) throws IOException {
		User user = mapper.map(userNoIdDto, User.class);
		user.setBalance(conversionService.convertInitial(5));
		return mapper.map(userDAO.save(user), UserNoPassDto.class);
	}

	@Override
	public UserWithTicketsDto findUser(int id) throws ParseException {
		return mapper.map(userDAO.findById(id).orElseThrow(() -> new UserNotFoundException(id)),
				UserWithTicketsDto.class);
	}

	@Override
	public PasswordDto updateUser(int idUser, PasswordDto password) {
		User u = userDAO.findById(idUser).orElseThrow(() -> new UserNotFoundException(idUser));
		u.setPassword(password.getPassword());
		userDAO.save(u);
		return new PasswordDto("successfully changed");
	}

	@Override
	public UserWithTicketsDto deleteUser(int id) throws ParseException {
		UserWithTicketsDto user = findUser(id);
		userDAO.deleteById(id);
		return user;
	}
}

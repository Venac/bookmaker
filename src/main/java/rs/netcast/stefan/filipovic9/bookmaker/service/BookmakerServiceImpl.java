package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.netcast.stefan.filipovic9.bookmaker.dao.BookmakerDAO;
import rs.netcast.stefan.filipovic9.bookmaker.domain.Bookmaker;
import rs.netcast.stefan.filipovic9.bookmaker.dto.bookmaker.BookmakerFullDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.bookmaker.BookmakerNoIdDto;
import rs.netcast.stefan.filipovic9.bookmaker.exception.BookmakerNotFoundException;

@Service
public class BookmakerServiceImpl implements BookmakerService {
	@Autowired
	private BookmakerDAO bookmakerDAO;
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<BookmakerFullDto> findBookmakers() {
		List<Bookmaker> bookmakers = bookmakerDAO.findAll();
		List<BookmakerFullDto> response = new ArrayList<BookmakerFullDto>();
		for (Bookmaker b : bookmakers) {
			response.add(mapper.map(b, BookmakerFullDto.class));
		}
		return response;
	}

	@Override
	public BookmakerFullDto saveBookmaker(BookmakerNoIdDto bookmaker) {
		return mapper.map(bookmakerDAO.save(mapper.map(bookmaker, Bookmaker.class)), BookmakerFullDto.class);
	}

	@Override
	public BookmakerFullDto findBookmaker(int id) {
		return mapper.map(bookmakerDAO.findById(id).orElseThrow(() -> new BookmakerNotFoundException(id)),
				BookmakerFullDto.class);
	}

	@Override
	public BookmakerFullDto updateBookmaker(int id, BookmakerNoIdDto b) {
		Bookmaker bookmaker = bookmakerDAO.findById(id).orElseThrow(() -> new BookmakerNotFoundException(id));
		bookmaker = mapper.map(b, Bookmaker.class);
		bookmaker.setId(id);
		return mapper.map(bookmaker, BookmakerFullDto.class);
	}

	@Override
	public BookmakerFullDto deleteBookmaker(int id) {
		BookmakerFullDto bookmaker = findBookmaker(id);
		bookmakerDAO.deleteById(id);
		return bookmaker;
	}
}

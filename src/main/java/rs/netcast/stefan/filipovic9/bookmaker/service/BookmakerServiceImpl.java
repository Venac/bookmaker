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
		try {
			return mapper.map(bookmakerDAO.findById(id).get(), BookmakerFullDto.class);
		} catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public BookmakerFullDto updateBookmaker(int id, BookmakerFullDto b) {
		try {
			b.setId(id);
			return mapper.map(bookmakerDAO.save(mapper.map(b, Bookmaker.class)), BookmakerFullDto.class);
		} catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public BookmakerFullDto deleteBookmaker(int id) {
		try {
			BookmakerFullDto bookmaker = findBookmaker(id);
			bookmakerDAO.deleteById(id);
			return bookmaker;
		} catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		}
	}
}

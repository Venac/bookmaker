package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.netcast.stefan.filipovic9.bookmaker.dao.BookmakerDAO;
import rs.netcast.stefan.filipovic9.bookmaker.domain.Bookmaker;
import rs.netcast.stefan.filipovic9.bookmaker.dto.BookmakerFullDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.BookmakerNoIdDto;

@Service
public class BookmakerServiceImpl implements BookmakerService {
	@Autowired
	private BookmakerDAO bookmakerDAO;

	@Override
	public List<BookmakerFullDto> getMatches() {
		List<Bookmaker> bookmakers = bookmakerDAO.findAll();
		List<BookmakerFullDto> response = new ArrayList<BookmakerFullDto>();
		for (Bookmaker b : bookmakers) {
			response.add(mapDomainToFullDto(b));
		}
		return response;
	}

	@Override
	public BookmakerFullDto addBookmaker(BookmakerNoIdDto bookmaker) {
		System.out.println("entered: " + bookmaker);
		Bookmaker b = mapInitialDtoToDomain(bookmaker);
		System.out.println("mapped: " + b);
		Bookmaker saved = bookmakerDAO.save(b);
		System.out.println("saved: " + saved);
		return mapDomainToFullDto(saved);
	}

	@Override
	public BookmakerFullDto findBookmaker(int id) {
		Bookmaker r = bookmakerDAO.findById(id).get();
		return mapDomainToFullDto(r);
	}

	@Override
	public BookmakerFullDto updateBookmaker(int id, BookmakerFullDto b) {
		b.setId(id);
		Bookmaker u = mapFullDtoToDomain(b);
		Bookmaker saved = bookmakerDAO.save(u);
		return mapDomainToFullDto(saved);
	}
	
	@Override
	public BookmakerFullDto deleteBookmaker(int id) {
		Bookmaker b = bookmakerDAO.findById(id).get();
		bookmakerDAO.deleteById(id);
		return mapDomainToFullDto(b);
	}

	// helper method(s)
	
	@Override
	public BookmakerFullDto mapDomainToFullDto(Bookmaker b) {
		BookmakerFullDto response = new BookmakerFullDto();
		response.setId(b.getId());
		response.setName(b.getName());
		response.setBalance(b.getBalance());
		return response;
	}

	@Override
	public Bookmaker mapFullDtoToDomain(BookmakerFullDto b) {
		Bookmaker response = new Bookmaker();
		response.setId(b.getId());
		response.setName(b.getName());
		response.setBalance(b.getBalance());
		return response;
	}

	@Override
	public Bookmaker mapInitialDtoToDomain(BookmakerNoIdDto b) {
		Bookmaker response = new Bookmaker();
		response.setName(b.getName());
		response.setBalance(b.getBalance());
		return response;
	}
}

package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.util.List;

import rs.netcast.stefan.filipovic9.bookmaker.domain.Bookmaker;
import rs.netcast.stefan.filipovic9.bookmaker.dto.BookmakerFullDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.BookmakerNoIdDto;

public interface BookmakerService {
	public List<BookmakerFullDto> getMatches();
	public BookmakerFullDto addBookmaker(BookmakerNoIdDto b);
	public BookmakerFullDto findBookmaker(int id);
	public BookmakerFullDto updateBookmaker(int id, BookmakerFullDto b);
	public BookmakerFullDto deleteBookmaker(int id);
	// helper method(s)
	public BookmakerFullDto mapDomainToFullDto(Bookmaker b);
	public Bookmaker mapFullDtoToDomain(BookmakerFullDto b);
	public Bookmaker mapInitialDtoToDomain(BookmakerNoIdDto b);
}

package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.util.List;

import rs.netcast.stefan.filipovic9.bookmaker.dto.bookmaker.BookmakerFullDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.bookmaker.BookmakerNoIdDto;

public interface BookmakerService {
	public List<BookmakerFullDto> findBookmakers();
	public BookmakerFullDto saveBookmaker(BookmakerNoIdDto b);
	public BookmakerFullDto findBookmaker(int id);
	public BookmakerFullDto updateBookmaker(int id, BookmakerNoIdDto b);
	public BookmakerFullDto deleteBookmaker(int id);
}

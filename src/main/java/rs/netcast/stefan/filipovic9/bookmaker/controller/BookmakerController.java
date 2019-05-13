package rs.netcast.stefan.filipovic9.bookmaker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.netcast.stefan.filipovic9.bookmaker.dto.bookmaker.BookmakerFullDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.bookmaker.BookmakerNoIdDto;
import rs.netcast.stefan.filipovic9.bookmaker.service.BookmakerService;

/*
 * Bookmaker Controller is for testing and demonstration purposes 
 */

@RestController
@RequestMapping("/bookmakers")
public class BookmakerController {
	@Autowired
	private BookmakerService bookmakerService;
	
	@GetMapping("/findAll")
	public List<BookmakerFullDto> getBookmakers() {
		return bookmakerService.findBookmakers();
	}
	
	@PostMapping("/save")
	public BookmakerFullDto addBookmaker(@Valid @RequestBody BookmakerNoIdDto b) {
		return bookmakerService.saveBookmaker(b);
	}
	
	@GetMapping("/find/{id}")
	public BookmakerFullDto findUser(@PathVariable int id) {
		return bookmakerService.findBookmaker(id);
	}
	
	@PutMapping("update/{id}")
	public BookmakerFullDto updateBookmaker(@PathVariable int id, @Valid @RequestBody BookmakerNoIdDto b) {
		return bookmakerService.updateBookmaker(id, b);
	}
	
	@DeleteMapping("delete/{id}")
	public BookmakerFullDto deleteBookmaker(@PathVariable int id) {
		return bookmakerService.deleteBookmaker(id);
	}
}

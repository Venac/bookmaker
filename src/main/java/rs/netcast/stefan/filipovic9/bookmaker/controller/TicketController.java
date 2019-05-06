package rs.netcast.stefan.filipovic9.bookmaker.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.netcast.stefan.filipovic9.bookmaker.dto.ticket.TicketFullDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.ticket.TicketInitialResponseDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.ticket.TicketNoIdDto;
import rs.netcast.stefan.filipovic9.bookmaker.service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {
	@Autowired
	private TicketService ticketService;
	
	@GetMapping("/findAll")
	public List<TicketFullDto> findTickets() throws ParseException {
		return ticketService.findTickets();
	}
	
	@PostMapping("/save")
	public TicketInitialResponseDto saveTicket(@RequestBody TicketNoIdDto ticket, HttpServletRequest request) throws ParseException {
		int idUser = (int)request.getAttribute("id");
		return ticketService.saveTicket(ticket, idUser);
	}
	
	@GetMapping("/find/{id}")
	public TicketFullDto findTicket(@PathVariable int id) throws ParseException {
		return ticketService.findTicket(id);
	}
	
	@GetMapping("/findByUser")
	public List<TicketFullDto> findByUser(HttpServletRequest request) throws ParseException {
		int idUser = (int)request.getAttribute("id");
		return ticketService.findByUser(idUser);
	}
	
	@PutMapping("update/{id}")
	public TicketFullDto updateTicket(@PathVariable int id, @RequestBody String won) throws ParseException {
		System.out.println("update called");
		return ticketService.updateTicket(id, won);
	}
	
	@DeleteMapping("delete/{id}")
	public TicketFullDto deleteTicket(@PathVariable int id) throws ParseException {
		return ticketService.deleteTicket(id);
	}
	
}

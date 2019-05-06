package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.text.ParseException;
import java.util.List;

import rs.netcast.stefan.filipovic9.bookmaker.domain.Ticket;
import rs.netcast.stefan.filipovic9.bookmaker.dto.ticket.TicketFullDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.ticket.TicketInitialResponseDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.ticket.TicketNoIdDto;

public interface TicketService {
	public List<TicketFullDto> findTickets() throws ParseException;
	public TicketInitialResponseDto saveTicket(TicketNoIdDto ticket, int idUser) throws ParseException;
	public TicketFullDto findTicket(int id) throws ParseException;
	public TicketFullDto updateTicket(int id, String won) throws ParseException;
	public TicketFullDto deleteTicket(int id) throws ParseException;
	public Ticket checkTicketOutcome(Ticket t) throws ParseException;
	public List<Ticket> resolveTickets() throws ParseException;
	public List<TicketFullDto> findByUser(int idUser) throws ParseException;
}

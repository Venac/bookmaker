package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.text.ParseException;
import java.util.List;

import rs.netcast.stefan.filipovic9.bookmaker.domain.MatchTicket;
import rs.netcast.stefan.filipovic9.bookmaker.domain.Ticket;
import rs.netcast.stefan.filipovic9.bookmaker.dto.MatchTicketFullDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.MatchTicketNoIdDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.TicketFullDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.TicketNoIdDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.TicketNoUserDto;

public interface TicketService {
	public List<TicketFullDto> findTickets() throws ParseException;
	public TicketFullDto saveTicket(TicketNoIdDto ticket, int idUser) throws ParseException;
	public TicketFullDto findTicket(int id) throws ParseException;
	public TicketFullDto updateTicket(int id, String won) throws ParseException;
	public TicketFullDto deleteTicket(int id) throws ParseException;
	public Ticket checkTicketOutcome(Ticket t) throws ParseException;
	public List<Ticket> resolveTickets() throws ParseException;
	public List<TicketFullDto> findByUser(int idUser) throws ParseException;
	// helper method(s)
	public TicketNoUserDto mapDomainToNoUserDto(Ticket t) throws ParseException;
	public TicketFullDto mapDomainToFullDto(Ticket t) throws ParseException;
	public Ticket mapNoIdToDomain(TicketNoIdDto t) throws ParseException;
	public MatchTicket mapNoIdToDomainMT(MatchTicketNoIdDto mt) throws ParseException;
	public MatchTicketFullDto mapDomainToFullMT(MatchTicket mt) throws ParseException;
	
}

package rs.netcast.stefan.filipovic9.bookmaker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.netcast.stefan.filipovic9.bookmaker.domain.Ticket;

public interface TicketDAO extends JpaRepository<Ticket, Integer>{
	public List<Ticket> findAllTicketsByMatchesTickets_MatchOutcome(int i);
	public List<Ticket> findByWon(int i);
	public List<Ticket> findByUser_Id(int i);
}

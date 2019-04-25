package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.util.List;

import rs.netcast.stefan.filipovic9.bookmaker.domain.Ticket;

public interface EmailService {
	public String sendTicketEmails(List<Ticket> tickets);
}

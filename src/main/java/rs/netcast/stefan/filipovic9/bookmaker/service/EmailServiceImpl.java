package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import rs.netcast.stefan.filipovic9.bookmaker.domain.MatchTicket;
import rs.netcast.stefan.filipovic9.bookmaker.domain.Ticket;
import rs.netcast.stefan.filipovic9.bookmaker.enums.MatchOutcome;
import rs.netcast.stefan.filipovic9.bookmaker.enums.TicketOutcome;

@Service
public class EmailServiceImpl implements EmailService {
	@Autowired
	private JavaMailSender sender;

	@Override
	public String sendTicketEmails(List<Ticket> tickets) {
		for (Ticket t : tickets) {
			sender.send(composeTicketEmail(t));
		}
		return "Emails successfully sent";
	}
	
	public SimpleMailMessage composeTicketEmail(Ticket t) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(t.getUser().getEmail());
		if (t.getWon() == TicketOutcome.WON.value()) {
			mail.setSubject("Congratulations! Your ticket No. " + t.getId() + " has passed");
		} else if (t.getWon() == TicketOutcome.LOST.value()) {
			mail.setSubject("Sorry! Your ticket No. " + t.getId() + " has failed");
		}
		String text = combinationsEmailTemplate(t.getMatchesTickets());
		if (t.getWon() == TicketOutcome.WON.value()) {
			double prize = t.getBetAmount() * Math.pow(TicketServiceImpl.ODDS, t.getMatchesTickets().size());
			text += "Winnings: " + prize;
		}
		mail.setText(text);
		return mail;
	}
	
	public String combinationsEmailTemplate(List<MatchTicket> combinations) {
		String text = "List of matches:\n";
		String outcome = "";
		for (MatchTicket mt : combinations) {
			if (mt.getMatch().getOutcome() == MatchOutcome.HOME_WIN.value()) {
				outcome = "Home team won";
			} else if (mt.getMatch().getOutcome() == MatchOutcome.AWAY_WIN.value()) {
				outcome = "Visiting team won";
			} else if (mt.getMatch().getOutcome() == MatchOutcome.DRAW.value()) {
				outcome = "Draw";
			}
			text += "Home team: " + mt.getMatch().getHomeTeam().getName() + ", Visiting team: "
					+ mt.getMatch().getVisitingTeam().getName() + " - " + outcome + "\n";
		}
		return text;
	}

}

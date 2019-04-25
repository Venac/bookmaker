package rs.netcast.stefan.filipovic9.bookmaker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.netcast.stefan.filipovic9.bookmaker.domain.Match;

public interface MatchDAO extends JpaRepository<Match, Integer> {
	List<Match> findByOutcome(int i);
	List<Match> findByOperator_Id(int i);
}

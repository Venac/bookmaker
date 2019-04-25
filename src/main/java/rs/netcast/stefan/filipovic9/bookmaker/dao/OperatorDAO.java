package rs.netcast.stefan.filipovic9.bookmaker.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.netcast.stefan.filipovic9.bookmaker.domain.Operator;

public interface OperatorDAO extends JpaRepository<Operator, Integer>{
	public Operator findByEmail(String email);
	public Operator findByEmailAndPassword(String email, String password);
}

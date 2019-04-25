package rs.netcast.stefan.filipovic9.bookmaker.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.netcast.stefan.filipovic9.bookmaker.domain.User;

public interface UserDAO extends JpaRepository<User, Integer> {
	public User findByEmail(String email);
	public User findByEmailAndPassword(String email, String password);
}

package rs.netcast.stefan.filipovic9.bookmaker.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import rs.netcast.stefan.filipovic9.bookmaker.domain.Bookmaker;

public interface BookmakerDAO extends JpaRepository<Bookmaker, Integer>{

}

package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.text.ParseException;
import java.util.List;

import rs.netcast.stefan.filipovic9.bookmaker.dto.match.MatchFullDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.match.MatchInitialRequestDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.match.MatchInitialResponseDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.match.MatchNoIdDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.match.MatchNoOpDto;

public interface MatchService {
	public List<MatchFullDto> findMatches();
	public MatchInitialResponseDto saveMatch(MatchInitialRequestDto match, int idOperator) throws ParseException;
	public MatchFullDto findMatch(int id);
	public MatchFullDto updateMatch(int idMatch, MatchNoIdDto match, int idOperator) throws ParseException;
	public MatchFullDto deleteMatch(int id);
	public List<MatchFullDto> findBettableMatches();
	public List<MatchNoOpDto> findByOperator(int id);
	public List<MatchFullDto> generateOutcome();
}
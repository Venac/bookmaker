package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.text.ParseException;
import java.util.List;

import rs.netcast.stefan.filipovic9.bookmaker.domain.Match;
import rs.netcast.stefan.filipovic9.bookmaker.dto.MatchFullDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.MatchInitialRequestDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.MatchInitialResponseDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.MatchNoOpDto;

public interface MatchService {
	public List<MatchFullDto> findMatches();
	public MatchInitialResponseDto saveMatch(MatchInitialRequestDto match, int idOperator) throws ParseException;
	public MatchFullDto findMatchById(int id);
	public MatchFullDto updateMatch(int idMatch, MatchFullDto match, int idOperator) throws ParseException;
	public MatchFullDto deleteMatch(int id);
	public List<MatchFullDto> findBettableMatches();
	public List<MatchFullDto> findByOperator(int id);
	public List<MatchFullDto> generateOutcome();
	// helper methods
	public MatchFullDto mapDomainToFullDto(Match m);
	public MatchNoOpDto mapDomainToNoOpDto(Match m);
	public Match mapNoOpDtoToDomain(MatchNoOpDto m);
	public Match mapFullDtoToDomain(MatchFullDto m) throws ParseException;
	public Match mapInitialRequestToDomain(MatchInitialRequestDto m);
	public MatchInitialResponseDto mapDomainToInitialResponse(Match m);
}
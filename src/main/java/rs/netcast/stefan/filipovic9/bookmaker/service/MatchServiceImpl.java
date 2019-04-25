package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.netcast.stefan.filipovic9.bookmaker.dao.MatchDAO;
import rs.netcast.stefan.filipovic9.bookmaker.domain.Match;
import rs.netcast.stefan.filipovic9.bookmaker.dto.MatchFullDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.MatchInitialRequestDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.MatchInitialResponseDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.MatchNoOpDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.OperatorFullNoMatches;
import rs.netcast.stefan.filipovic9.bookmaker.enums.MatchOutcome;

@Service
public class MatchServiceImpl implements MatchService {
	@Autowired
	private MatchDAO matchDAO;
	@Autowired
	private OperatorService operatorService;

	@Override
	public List<MatchFullDto> findMatches() {
		List<Match> matches = matchDAO.findAll();
		List<MatchFullDto> retrieved = new ArrayList<MatchFullDto>();
		for (Match match : matches) {
			retrieved.add(mapDomainToFullDto(match));
		}
		return retrieved;
	}

	@Override
	public MatchInitialResponseDto saveMatch(MatchInitialRequestDto m, int idOperator) throws ParseException {
		OperatorFullNoMatches o = new OperatorFullNoMatches();
		o.setId(idOperator);
		m.setOperator(o);
		Match match = mapInitialRequestToDomain(m);
		Match s = matchDAO.save(match);
		return mapDomainToInitialResponse(s);
	}

	@Override
	public MatchFullDto findMatchById(int id) {
		Match match = matchDAO.findById(id).get();
		return mapDomainToFullDto(match);
	}

	@Override
	public MatchFullDto updateMatch(int id, MatchFullDto m, int idOperator) throws ParseException {
		OperatorFullNoMatches o = new OperatorFullNoMatches();
		o.setId(idOperator);
		m.setOperator(o);
		Match match = mapFullDtoToDomain(m);
		match.setId(id);
		Match saved = matchDAO.save(match);
		return mapDomainToFullDto(saved);
	}

	@Override
	public MatchFullDto deleteMatch(int id) {
		Match m = matchDAO.findById(id).get();
		matchDAO.deleteById(id);
		return mapDomainToFullDto(m);
	}
	
	@Override
	public List<MatchFullDto> findBettableMatches() {
		List<Match> matches = matchDAO.findByOutcome(MatchOutcome.SCHEDULED.value());
		List<MatchFullDto> retrieved = new ArrayList<MatchFullDto>();
		for (Match m : matches) {
			retrieved.add(mapDomainToFullDto(m));
		}
		return retrieved;
	}
	
	@Override
	public List<MatchFullDto> findByOperator(int id) {
		List<Match> matches = matchDAO.findByOperator_Id(id);
		List<MatchFullDto> result = new ArrayList<MatchFullDto>();
		for (Match m : matches) {
			result.add(mapDomainToFullDto(m));
		}
		return result;
	}

	@Override
	@Transactional
	public List<MatchFullDto> generateOutcome() {
		List<Match> retrieved = matchDAO.findByOutcome(MatchOutcome.SCHEDULED.value());
		List<MatchFullDto> result = new ArrayList<MatchFullDto>();
		for (Match m : retrieved) {
			m.setOutcome(new Random().nextInt(2)+1);
//			matchDAO.save(m);
		}
		for (Match m : retrieved) {
			result.add(mapDomainToFullDto(m));
		}
		return result;
	}

	// helper method(s)	

	@Override
	public MatchFullDto mapDomainToFullDto(Match m) {
		MatchFullDto match = new MatchFullDto();
		match.setId(m.getId());
		match.setOutcome(m.getOutcome());
		match.setMatchDate(m.getMatchDate());
		match.setHomeTeam(m.getHomeTeam());
		match.setVisitingTeam(m.getVisitingTeam());
		match.setOperator(operatorService.mapDomainToFullNoMatches(m.getOperator()));
		return match;
	}
	
	@Override
	public Match mapFullDtoToDomain(MatchFullDto m) throws ParseException {
		Match match = new Match();
		match.setId(m.getId());
		match.setOutcome(m.getOutcome());
		match.setMatchDate(m.getMatchDate());
		match.setHomeTeam(m.getHomeTeam());
		match.setVisitingTeam(m.getVisitingTeam());
		match.setOperator(operatorService.mapFullNoMatchesToDomain(m.getOperator()));
		return match;
	}

	@Override
	public MatchNoOpDto mapDomainToNoOpDto(Match m) {
		MatchNoOpDto result = new MatchNoOpDto();
		result.setId(m.getId());
		result.setOutcome(m.getOutcome());
		result.setMatchDate(m.getMatchDate());
		result.setHomeTeam(m.getHomeTeam());
		result.setVisitingTeam(m.getVisitingTeam());
		return result;
	}
	
	@Override
	public Match mapNoOpDtoToDomain(MatchNoOpDto m) {
		Match result = new Match();
		result.setId(m.getId());
		result.setMatchDate(m.getMatchDate());
		result.setOutcome(m.getOutcome());
		result.setHomeTeam(m.getHomeTeam());
		result.setVisitingTeam(m.getVisitingTeam());
		return result;
	}

	@Override
	public Match mapInitialRequestToDomain(MatchInitialRequestDto m) {
		Match match = new Match();
		match.setMatchDate(m.getMatchDate());
		match.setHomeTeam(m.getHomeTeam());
		match.setVisitingTeam(m.getVisitingTeam());
		match.setOperator(operatorService.mapFullNoMatchesToDomain(m.getOperator()));
		return match;
	}

	@Override
	public MatchInitialResponseDto mapDomainToInitialResponse(Match m) {
		return new MatchInitialResponseDto(m.getId(), m.getMatchDate(), m.getHomeTeam(), m.getVisitingTeam());
	}

}

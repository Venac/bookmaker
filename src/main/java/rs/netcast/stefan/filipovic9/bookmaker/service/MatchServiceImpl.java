package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.netcast.stefan.filipovic9.bookmaker.dao.MatchDAO;
import rs.netcast.stefan.filipovic9.bookmaker.dao.OperatorDAO;
import rs.netcast.stefan.filipovic9.bookmaker.domain.Match;
import rs.netcast.stefan.filipovic9.bookmaker.dto.match.MatchFullDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.match.MatchInitialRequestDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.match.MatchInitialResponseDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.match.MatchNoIdDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.match.MatchNoOpDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.operator.OperatorOnlyIdDto;
import rs.netcast.stefan.filipovic9.bookmaker.enums.MatchOutcome;
import rs.netcast.stefan.filipovic9.bookmaker.exception.MatchNotFoundException;
import rs.netcast.stefan.filipovic9.bookmaker.exception.OperatorNotFoundException;

@Service
public class MatchServiceImpl implements MatchService {
	@Autowired
	private MatchDAO matchDAO;
	@Autowired
	private OperatorDAO operatorDAO;
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<MatchFullDto> findMatches() {
		List<Match> matches = matchDAO.findAll();
		List<MatchFullDto> retrieved = new ArrayList<MatchFullDto>();
		for (Match match : matches) {
			retrieved.add(mapper.map(match, MatchFullDto.class));
		}
		return retrieved;
	}

	@Override
	public MatchInitialResponseDto saveMatch(MatchInitialRequestDto m, int idOperator) throws ParseException {
		OperatorOnlyIdDto o = new OperatorOnlyIdDto();
		o.setId(idOperator);
		m.setOperator(o);
		return mapper.map(matchDAO.save(mapper.map(m, Match.class)), MatchInitialResponseDto.class);
	}

	@Override
	public MatchFullDto findMatch(int id) {
		return mapper.map(matchDAO.findById(id).orElseThrow(() -> new MatchNotFoundException(id)), MatchFullDto.class);
	}

	@Override
	public MatchFullDto updateMatch(int id, MatchNoIdDto m, int idOperator) throws ParseException {
		MatchFullDto match = findMatch(id);
		match = mapper.map(m, MatchFullDto.class);
		match.setId(id);
		match.setOperator(new OperatorOnlyIdDto(idOperator));
		return mapper.map(matchDAO.save(mapper.map(match, Match.class)), MatchFullDto.class);
	}

	@Override
	public MatchFullDto deleteMatch(int id) {
		MatchFullDto match = findMatch(id);
		matchDAO.deleteById(id);
		return match;
	}

	@Override
	public List<MatchFullDto> findBettableMatches() {
		List<Match> matches = matchDAO.findByOutcome(MatchOutcome.SCHEDULED.value());
		if (matches.isEmpty()) {
			throw new MatchNotFoundException("No bettable matches found");
		}
		List<MatchFullDto> retrieved = new ArrayList<MatchFullDto>();
		for (Match m : matches) {
			retrieved.add(mapper.map(m, MatchFullDto.class));
		}
		return retrieved;
	}

	@Override
	public List<MatchNoOpDto> findByOperator(int id) {
		operatorDAO.findById(id).orElseThrow(() -> new OperatorNotFoundException(id));
		List<Match> matches = matchDAO.findByOperator_Id(id);
		if (matches.isEmpty()) {
			throw new MatchNotFoundException("Operator " + id + " has no matches");
		}
		List<MatchNoOpDto> result = new ArrayList<MatchNoOpDto>();
		for (Match m : matches) {
			result.add(mapper.map(m, MatchNoOpDto.class));
		}
		return result;
	}

	@Override
	@Transactional
	public List<MatchFullDto> generateOutcome() {
		List<Match> retrieved = matchDAO.findByOutcome(MatchOutcome.SCHEDULED.value());
		List<MatchFullDto> result = new ArrayList<MatchFullDto>();
		for (Match m : retrieved) {
			m.setOutcome(new Random().nextInt(2) + 1);
		}
		for (Match m : retrieved) {
			result.add(mapper.map(m, MatchFullDto.class));
		}
		return result;
	}
}

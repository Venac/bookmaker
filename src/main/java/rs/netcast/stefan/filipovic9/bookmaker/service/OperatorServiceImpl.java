package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.netcast.stefan.filipovic9.bookmaker.dao.OperatorDAO;
import rs.netcast.stefan.filipovic9.bookmaker.domain.Bookmaker;
import rs.netcast.stefan.filipovic9.bookmaker.domain.Match;
import rs.netcast.stefan.filipovic9.bookmaker.domain.Operator;
import rs.netcast.stefan.filipovic9.bookmaker.dto.MatchNoOpDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.OperatorFullNoMatches;
import rs.netcast.stefan.filipovic9.bookmaker.dto.OperatorFullWithMatches;
import rs.netcast.stefan.filipovic9.bookmaker.dto.OperatorInitialRequestDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.OperatorNoPassMatchesDto;

@Service
public class OperatorServiceImpl implements OperatorService{
	@Autowired
	private OperatorDAO operatorDAO;
	@Autowired
	private MatchService matchService;
	@Autowired
	private BookmakerService bookmakerService;

	@Override
	public List<OperatorNoPassMatchesDto> findOperators() {
		List<Operator> operators = operatorDAO.findAll();
		List<OperatorNoPassMatchesDto> retrieved = new ArrayList<OperatorNoPassMatchesDto>();
		for (Operator o : operators) {
			retrieved.add(mapDomainToNoPassMatchesDto(o));
		}
		return retrieved;
	}
	
	
	@Override
	public OperatorNoPassMatchesDto saveOperator(OperatorInitialRequestDto operator, int idOperator) {
		Operator admin = operatorDAO.findById(idOperator).get();
		Operator o = mapInitialRequestToDomain(operator);
		Bookmaker b = new Bookmaker();
		b.setId(admin.getBookmaker().getId());
		o.setBookmaker(b);
		Operator saved = operatorDAO.save(o);
		return mapDomainToNoPassMatchesDto(saved);
	}
	
	@Override
	public OperatorFullWithMatches findOperator(int id) {
		Operator retrieved = operatorDAO.findById(id).get();
		retrieved.getMatches();
		return mapDomainToFullWithMatches(retrieved);
	}
	
	@Override
	public OperatorFullNoMatches updateOperator(int id, String password) {
		Operator o = operatorDAO.findById(id).get();
		o.setPassword(password);
		Operator saved = operatorDAO.save(o);
		return mapDomainToFullNoMatches(saved);
	}
	
	@Override
	public OperatorFullWithMatches deleteOperator(int id) {
		OperatorFullWithMatches operator = findOperator(id);
		operatorDAO.deleteById(id);
		return operator;
	}

	//helper method(s)

	@Override
	public OperatorNoPassMatchesDto mapDomainToNoPassMatchesDto(Operator o) {
		return new OperatorNoPassMatchesDto(o.getId(), o.getFirstName(), o.getLastName(), o.getEmail());
	}
	
	@Override
	public Operator mapInitialRequestToDomain(OperatorInitialRequestDto o) {
		Operator operator = new Operator();
		operator.setFirstName(o.getFirstName());
		operator.setLastName(o.getLastName());
		operator.setEmail(o.getEmail());
		operator.setPassword(o.getPassword());
		return operator;
	}
	
	@Override
	public OperatorFullWithMatches mapDomainToFullWithMatches(Operator o) {
		OperatorFullWithMatches result = new OperatorFullWithMatches();
		result.setId(o.getId());
		result.setFirstName(o.getFirstName());
		result.setLastName(o.getLastName());
		result.setEmail(o.getEmail());
		result.setBookmaker(bookmakerService.mapDomainToFullDto(o.getBookmaker()));
		List<MatchNoOpDto> matches = new ArrayList<MatchNoOpDto>();
		for (Match m : o.getMatches()) {
			matches.add(matchService.mapDomainToNoOpDto(m));
		}
		result.setMatches(matches);
		return result;
	}	
	
	@Override
	public Operator mapFullNoMatchesToDomain(OperatorFullNoMatches o) {
		Operator operator = new Operator();
		operator.setId(o.getId());
		operator.setFirstName(o.getFirstName());
		operator.setLastName(o.getLastName());
		operator.setEmail(o.getEmail());
		return operator;
	}
	
	@Override
	public OperatorFullNoMatches mapDomainToFullNoMatches(Operator o) {
		OperatorFullNoMatches operator = new OperatorFullNoMatches();
		operator.setId(o.getId());
		operator.setFirstName(o.getFirstName());
		operator.setLastName(o.getLastName());
		operator.setEmail(o.getEmail());
		return operator;
	}
	
}

package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.util.List;

import rs.netcast.stefan.filipovic9.bookmaker.domain.Operator;
import rs.netcast.stefan.filipovic9.bookmaker.dto.OperatorFullNoMatches;
import rs.netcast.stefan.filipovic9.bookmaker.dto.OperatorFullWithMatches;
import rs.netcast.stefan.filipovic9.bookmaker.dto.OperatorInitialRequestDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.OperatorNoPassMatchesDto;

public interface OperatorService {
	public List<OperatorNoPassMatchesDto> findOperators();
	public OperatorNoPassMatchesDto saveOperator(OperatorInitialRequestDto operator, int idOperator);
	public OperatorFullWithMatches findOperator(int id);
	public OperatorFullNoMatches updateOperator(int id, String password);
	public OperatorFullWithMatches deleteOperator(int id);
	//helper method(s)
	public OperatorNoPassMatchesDto mapDomainToNoPassMatchesDto(Operator o);
	public Operator mapInitialRequestToDomain(OperatorInitialRequestDto o);
	public OperatorFullWithMatches mapDomainToFullWithMatches(Operator o);
	public Operator mapFullNoMatchesToDomain(OperatorFullNoMatches o);
	public OperatorFullNoMatches mapDomainToFullNoMatches(Operator o);
}

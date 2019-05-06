package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.util.List;

import rs.netcast.stefan.filipovic9.bookmaker.dto.operator.OperatorFullWithMatches;
import rs.netcast.stefan.filipovic9.bookmaker.dto.operator.OperatorInitialRequestDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.operator.OperatorNoPassMatchesDto;

public interface OperatorService {
	public List<OperatorNoPassMatchesDto> findOperators();
	public OperatorNoPassMatchesDto saveOperator(OperatorInitialRequestDto operator, int idOperator);
	public OperatorFullWithMatches findOperator(int id);
	public String updateOperator(int id, String password);
	public OperatorFullWithMatches deleteOperator(int id);
}

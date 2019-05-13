package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.util.List;

import rs.netcast.stefan.filipovic9.bookmaker.dto.misc.PasswordDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.operator.OperatorFullWithMatches;
import rs.netcast.stefan.filipovic9.bookmaker.dto.operator.OperatorInitialRequestDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.operator.OperatorNoPassMatchesDto;

public interface OperatorService {
	public List<OperatorNoPassMatchesDto> findOperators();
	public OperatorNoPassMatchesDto saveOperator(OperatorInitialRequestDto operator, int idOperator);
	public OperatorFullWithMatches findOperator(int id);
	public PasswordDto updateOperator(int id, PasswordDto password);
	public OperatorFullWithMatches deleteOperator(int id);
}

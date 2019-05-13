package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.netcast.stefan.filipovic9.bookmaker.dao.OperatorDAO;
import rs.netcast.stefan.filipovic9.bookmaker.domain.Bookmaker;
import rs.netcast.stefan.filipovic9.bookmaker.domain.Operator;
import rs.netcast.stefan.filipovic9.bookmaker.dto.bookmaker.BookmakerOnlyIdDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.misc.PasswordDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.operator.OperatorFullWithMatches;
import rs.netcast.stefan.filipovic9.bookmaker.dto.operator.OperatorInitialRequestDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.operator.OperatorNoPassMatchesDto;
import rs.netcast.stefan.filipovic9.bookmaker.exception.OperatorNotFoundException;

@Service
public class OperatorServiceImpl implements OperatorService {
	@Autowired
	private OperatorDAO operatorDAO;
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<OperatorNoPassMatchesDto> findOperators() {
		List<Operator> operators = operatorDAO.findAll();
		List<OperatorNoPassMatchesDto> retrieved = new ArrayList<OperatorNoPassMatchesDto>();
		for (Operator o : operators) {
			retrieved.add(mapper.map(o, OperatorNoPassMatchesDto.class));
		}
		return retrieved;
	}

	@Override
	public OperatorNoPassMatchesDto saveOperator(OperatorInitialRequestDto operator, int idOperator) {
		Operator admin = operatorDAO.findById(idOperator).orElseThrow(() -> new OperatorNotFoundException(idOperator));
		BookmakerOnlyIdDto b = new BookmakerOnlyIdDto(admin.getBookmaker().getId());
		Operator toBeSaved = mapper.map(operator, Operator.class);
		toBeSaved.setBookmaker(mapper.map(b, Bookmaker.class));
		return mapper.map(operatorDAO.save(toBeSaved), OperatorNoPassMatchesDto.class);
	}

	@Override
	public OperatorFullWithMatches findOperator(int id) {
		return mapper.map(operatorDAO.findById(id).orElseThrow(() -> new OperatorNotFoundException(id)),
				OperatorFullWithMatches.class);
	}

	@Override
	public PasswordDto updateOperator(int id, PasswordDto password) {
		Operator operator = operatorDAO.findById(id).orElseThrow(() -> new OperatorNotFoundException(id));
		operator.setPassword(password.getPassword());
		operatorDAO.save(operator);
		return new PasswordDto("succesfully changed");
	}

	@Override
	public OperatorFullWithMatches deleteOperator(int id) {
		OperatorFullWithMatches operator = findOperator(id);
		operatorDAO.deleteById(id);
		return operator;
	}
}

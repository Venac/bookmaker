package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.netcast.stefan.filipovic9.bookmaker.dao.OperatorDAO;
import rs.netcast.stefan.filipovic9.bookmaker.domain.Operator;
import rs.netcast.stefan.filipovic9.bookmaker.dto.bookmaker.BookmakerOnlyIdDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.operator.OperatorFullWithMatches;
import rs.netcast.stefan.filipovic9.bookmaker.dto.operator.OperatorInitialRequestDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.operator.OperatorNoPassMatchesDto;

@Service
public class OperatorServiceImpl implements OperatorService{
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
		Operator admin = operatorDAO.findById(idOperator).get();
		BookmakerOnlyIdDto b = new BookmakerOnlyIdDto(admin.getBookmaker().getId());
		operator.setBookmaker(b);
		return mapper.map(operatorDAO.save(mapper.map(operator, Operator.class)), OperatorNoPassMatchesDto.class);
	}
	
	@Override
	public OperatorFullWithMatches findOperator(int id) {
		try {
			return mapper.map(operatorDAO.findById(id).get(), OperatorFullWithMatches.class);
		} catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public String updateOperator(int id, String password) {
		Operator o = operatorDAO.findById(id).get();
		o.setPassword(password);
		operatorDAO.save(o);
		return "Password changed successfully";
	}
	
	@Override
	public OperatorFullWithMatches deleteOperator(int id) {
		try {
			OperatorFullWithMatches operator = findOperator(id);
			operatorDAO.deleteById(id);
			return operator;
		} catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		}
	}
}

package rs.netcast.stefan.filipovic9.bookmaker.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.netcast.stefan.filipovic9.bookmaker.dto.misc.PasswordDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.operator.OperatorFullWithMatches;
import rs.netcast.stefan.filipovic9.bookmaker.dto.operator.OperatorInitialRequestDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.operator.OperatorNoPassMatchesDto;
import rs.netcast.stefan.filipovic9.bookmaker.service.OperatorService;

@RestController
@RequestMapping("/operators")
public class OperatorController {
	@Autowired
	private OperatorService operatorService;

	@GetMapping("/findAll")
	public List<OperatorNoPassMatchesDto> findOperators() {
		return operatorService.findOperators();
	}

	@PostMapping("/save")
	public OperatorNoPassMatchesDto saveOperator(@Valid @RequestBody OperatorInitialRequestDto operator,
			HttpServletRequest request) {
		int idOperator = (int) request.getAttribute("id");
		return operatorService.saveOperator(operator, idOperator);
	}

	@GetMapping("/find/{id}")
	public OperatorFullWithMatches findOperator(@PathVariable int id) {
		return operatorService.findOperator(id);
	}

	@PutMapping("/update/{id}")
	public PasswordDto updateOperator(@PathVariable int id, @Valid @RequestBody PasswordDto password) {
		return operatorService.updateOperator(id, password);
	}

	@DeleteMapping("/delete/{id}")
	public OperatorFullWithMatches deleteOperator(@PathVariable int id) {
		return operatorService.deleteOperator(id);
	}
}

package rs.netcast.stefan.filipovic9.bookmaker.controller;

import java.text.ParseException;
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

import rs.netcast.stefan.filipovic9.bookmaker.dto.match.MatchFullDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.match.MatchInitialRequestDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.match.MatchInitialResponseDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.match.MatchNoIdDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.match.MatchNoOpDto;
import rs.netcast.stefan.filipovic9.bookmaker.service.MatchService;

@RestController
@RequestMapping("/matches")
public class MatchController {
	@Autowired
	private MatchService matchService;
	
	@GetMapping("/findAll")
	public List<MatchFullDto> findMatches() {
		return matchService.findMatches();
	}
	
	@PostMapping("/save")
	public MatchInitialResponseDto saveMatch(@Valid @RequestBody MatchInitialRequestDto match, HttpServletRequest request) throws ParseException {
		int idOperator = (int)request.getAttribute("id");
		return matchService.saveMatch(match, idOperator);
	}
	
	@GetMapping("find/{id}")
	public MatchFullDto findMatchById(@PathVariable int id) {
		return matchService.findMatch(id);
	}
	
	@PutMapping("update/{id}")
	public MatchFullDto updateMatch(@PathVariable int id, @Valid @RequestBody MatchNoIdDto match, HttpServletRequest request) throws ParseException {
		int idOperator = (int)request.getAttribute("id");
		return matchService.updateMatch(id, match, idOperator);
	}
	
	@DeleteMapping("delete/{id}")
	public MatchFullDto deleteMatch(@PathVariable int id) {
		return matchService.deleteMatch(id);
	}
	
	@GetMapping("/findByOperator/{id}")
	public List<MatchNoOpDto> findByOperator(@PathVariable int id) {
		return matchService.findByOperator(id);
	}
	
	@GetMapping("/findBettable")
	public List<MatchFullDto> findBettableMatches() {
		return matchService.findBettableMatches();
	}
	
}

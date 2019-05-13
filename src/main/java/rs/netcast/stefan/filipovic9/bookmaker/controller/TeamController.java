package rs.netcast.stefan.filipovic9.bookmaker.controller;

import java.util.List;

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

import rs.netcast.stefan.filipovic9.bookmaker.dto.team.TeamNoIdDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.team.TeamNoMatchesDto;
import rs.netcast.stefan.filipovic9.bookmaker.service.TeamService;

@RestController
@RequestMapping("/teams")
public class TeamController {
	@Autowired
	private TeamService teamService;
	
	@GetMapping("/findAll")
	public List<TeamNoMatchesDto> findTeamsNoMatches() {
		return teamService.findTeamsNoMatches();
	}
	
	@PostMapping("/save")
	public TeamNoMatchesDto saveTeam(@Valid @RequestBody TeamNoIdDto team) {
		return teamService.saveTeam(team);
	}
	
	@GetMapping("/find/{id}")
	public TeamNoMatchesDto findTeamById(@PathVariable int id) {
		return teamService.findTeam(id);
	}
	
	@PutMapping("/update/{id}")
	public TeamNoMatchesDto updateTeam(@PathVariable int id, @Valid @RequestBody TeamNoIdDto team) {
		return teamService.updateTeam(id, team);
	}
	
	@DeleteMapping("/delete/{id}")
	public TeamNoMatchesDto deleteTeam(@PathVariable int id) {
		return teamService.deleteTeam(id);
	}
}

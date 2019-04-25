package rs.netcast.stefan.filipovic9.bookmaker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rs.netcast.stefan.filipovic9.bookmaker.dto.TeamNoIdDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.TeamNoMatchesDto;
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
	public TeamNoMatchesDto saveTeam(@RequestBody TeamNoIdDto teamNoIdDto) {
		return teamService.saveTeam(teamNoIdDto);
	}
	
	@GetMapping("/find/{id}")
	public TeamNoMatchesDto findTeamById(@PathVariable int id) {
		return teamService.findTeamById(id);
	}
	
	@PutMapping("/update/{id}")
	public TeamNoMatchesDto updateTeam(@PathVariable int id, @RequestBody TeamNoMatchesDto team) {
		return teamService.updateTeam(id, team);
	}
	
	@DeleteMapping("/delete/{id}")
	public TeamNoMatchesDto deleteTeam(@PathVariable int id) {
		return teamService.deleteTeam(id);
	}
}

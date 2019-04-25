package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.netcast.stefan.filipovic9.bookmaker.dao.TeamDAO;
import rs.netcast.stefan.filipovic9.bookmaker.domain.Team;
import rs.netcast.stefan.filipovic9.bookmaker.dto.TeamNoIdDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.TeamNoMatchesDto;

@Service
public class TeamServiceImpl implements TeamService{
	@Autowired
	private TeamDAO teamDAO;
	
	@Override
	public List<TeamNoMatchesDto> findTeamsNoMatches() {
		List<Team> teams = teamDAO.findAll();
		List<TeamNoMatchesDto> response = new ArrayList<TeamNoMatchesDto>();
		for (Team team : teams) {
			response.add(mapDomainToTeamNoMatchesDto(team));
		}
		return response;
	}

	@Override
	public TeamNoMatchesDto saveTeam(TeamNoIdDto teamNoIdDto) {
		Team team = new Team(teamNoIdDto.getName());
		Team saved = teamDAO.save(team);
		return mapDomainToTeamNoMatchesDto(saved);
	}

	@Override
	public TeamNoMatchesDto findTeamById(int id) {
		Team team = teamDAO.findById(id).get();
		return mapDomainToTeamNoMatchesDto(team);
	}

	@Override
	public TeamNoMatchesDto updateTeam(int id, TeamNoMatchesDto team) {
		Team t = mapTeamNoMatchesDtoToDomain(team);
		t.setId(id);
		Team saved = teamDAO.save(t);
		return mapDomainToTeamNoMatchesDto(saved);
	}

	@Override
	public TeamNoMatchesDto deleteTeam(int id) {
		Team retrieved = teamDAO.findById(id).get();
		teamDAO.deleteById(id);
		return mapDomainToTeamNoMatchesDto(retrieved);
	}
	
	// helper method(s)
	
	@Override
	public TeamNoMatchesDto mapDomainToTeamNoMatchesDto(Team team) {
		return new TeamNoMatchesDto(team.getId(), team.getName());
	}
	
	@Override
	public Team mapTeamNoMatchesDtoToDomain(TeamNoMatchesDto team) {
		return new Team(team.getId(), team.getName());
	}
		
}

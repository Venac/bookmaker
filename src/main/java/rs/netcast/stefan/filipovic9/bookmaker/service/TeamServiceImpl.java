package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.netcast.stefan.filipovic9.bookmaker.dao.TeamDAO;
import rs.netcast.stefan.filipovic9.bookmaker.domain.Team;
import rs.netcast.stefan.filipovic9.bookmaker.dto.team.TeamNoIdDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.team.TeamNoMatchesDto;
import rs.netcast.stefan.filipovic9.bookmaker.exception.TeamNotFoundException;

@Service
public class TeamServiceImpl implements TeamService {
	@Autowired
	private TeamDAO teamDAO;
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<TeamNoMatchesDto> findTeamsNoMatches() {
		List<Team> teams = teamDAO.findAll();
		List<TeamNoMatchesDto> response = new ArrayList<TeamNoMatchesDto>();
		for (Team team : teams) {
			response.add(mapper.map(team, TeamNoMatchesDto.class));
		}
		return response;
	}

	@Override
	public TeamNoMatchesDto saveTeam(TeamNoIdDto teamNoIdDto) {
		return mapper.map(teamDAO.save(mapper.map(teamNoIdDto, Team.class)), TeamNoMatchesDto.class);
	}

	@Override
	public TeamNoMatchesDto findTeam(int id) {
		return mapper.map(teamDAO.findById(id).orElseThrow(() -> new TeamNotFoundException(id)),
				TeamNoMatchesDto.class);
	}

	@Override
	public TeamNoMatchesDto updateTeam(int id, TeamNoIdDto t) {
		Team team = teamDAO.findById(id).orElseThrow(() -> new TeamNotFoundException(id));
		team.setName(t.getName());
		return mapper.map(team, TeamNoMatchesDto.class);
	}

	@Override
	public TeamNoMatchesDto deleteTeam(int id) {
		TeamNoMatchesDto retrieved = findTeam(id);
		teamDAO.deleteById(id);
		return retrieved;
	}
}

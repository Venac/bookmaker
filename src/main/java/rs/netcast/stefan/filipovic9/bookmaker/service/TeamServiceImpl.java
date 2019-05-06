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
	public TeamNoMatchesDto findTeamById(int id) {
		try {
			return mapper.map(teamDAO.findById(id).get(), TeamNoMatchesDto.class);
		} catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public TeamNoMatchesDto updateTeam(int id, String name) {
		try {
			return mapper.map(teamDAO.save(mapper.map(new TeamNoMatchesDto(id, name), Team.class)), TeamNoMatchesDto.class);
		} catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public TeamNoMatchesDto deleteTeam(int id) {
		try {
			Team retrieved = teamDAO.findById(id).get();
			teamDAO.deleteById(id);
			return mapper.map(retrieved, TeamNoMatchesDto.class);
		} catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		}
	}
}

package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.util.List;

import rs.netcast.stefan.filipovic9.bookmaker.dto.team.TeamNoIdDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.team.TeamNoMatchesDto;

public interface TeamService {
	public List<TeamNoMatchesDto> findTeamsNoMatches();
	public TeamNoMatchesDto saveTeam(TeamNoIdDto teamNoIdDto);
	public TeamNoMatchesDto findTeamById(int id);
	public TeamNoMatchesDto updateTeam(int id, String name);
	public TeamNoMatchesDto deleteTeam(int id);
}

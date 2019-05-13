package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.util.List;

import rs.netcast.stefan.filipovic9.bookmaker.dto.team.TeamNoIdDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.team.TeamNoMatchesDto;

public interface TeamService {
	public List<TeamNoMatchesDto> findTeamsNoMatches();
	public TeamNoMatchesDto saveTeam(TeamNoIdDto team);
	public TeamNoMatchesDto findTeam(int id);
	public TeamNoMatchesDto updateTeam(int id, TeamNoIdDto team);
	public TeamNoMatchesDto deleteTeam(int id);
}

package rs.netcast.stefan.filipovic9.bookmaker.service;

import java.util.List;

import rs.netcast.stefan.filipovic9.bookmaker.domain.Team;
import rs.netcast.stefan.filipovic9.bookmaker.dto.TeamNoIdDto;
import rs.netcast.stefan.filipovic9.bookmaker.dto.TeamNoMatchesDto;

public interface TeamService {
	public List<TeamNoMatchesDto> findTeamsNoMatches();
	public TeamNoMatchesDto saveTeam(TeamNoIdDto teamNoIdDto);
	public TeamNoMatchesDto findTeamById(int id);
	public TeamNoMatchesDto updateTeam(int id, TeamNoMatchesDto team);
	public TeamNoMatchesDto deleteTeam(int id);
	// helper method(s)
	public TeamNoMatchesDto mapDomainToTeamNoMatchesDto(Team team);
	public Team mapTeamNoMatchesDtoToDomain(TeamNoMatchesDto team);
}

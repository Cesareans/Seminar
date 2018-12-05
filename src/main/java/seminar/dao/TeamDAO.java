package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.Clbum;
import seminar.entity.Team;
import seminar.mapper.TeamMapper;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Cesare
 */
@Component
public class TeamDAO {
    private final ClbumDao clbumDao;
    private final TeamMapper teamMapper;
    @Autowired
    public TeamDAO(ClbumDao clbumDao, TeamMapper teamMapper) {
        this.clbumDao = clbumDao;
        this.teamMapper = teamMapper;
    }

    public List<Team> getByClbumId(String clbumId) {
        return teamMapper.selectTeamByClbumId(clbumId);
    }

    /**
     * Team belongs to clbum. So here are necessary
     * TODO:May use redundant courseId here.
     * @param courseId
     * @return
     */
    public List<Team> getByCourseId(String courseId){
        List<Clbum> clbums = clbumDao.getByCourseId(courseId);
        List<Team> teams = new LinkedList<>();
        clbums.forEach(clbum -> {
            teams.addAll(getByClbumId(clbum.getId()));
        });
        return teams;
    }

    /**
     * @author lyf
     */
    public boolean create(Team team){
        List<Team> teams = teamMapper.selectTeamById(team.getId());
        if(teams.isEmpty()) {
            teamMapper.insertTeam(team);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * @author lyf
     */
    public void deleteById(String teamId){
        teamMapper.deleteTeamById(teamId);
    }

    /**
     * @author lyf
     */
    public void deleteByClbumId(String clbumId){
        teamMapper.deleteTeamByClbumId(clbumId);
    }

    /**
     * @author lyf
     */
    public boolean update(Team team){
        List<Team> teams = teamMapper.selectTeamById(team.getId());
        if(teams.isEmpty()) {
            return false;
        }
        else{
            teamMapper.updateTeam(team);
            return true;
        }
    }

}

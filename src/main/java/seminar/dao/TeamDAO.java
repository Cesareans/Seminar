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

    public List<Team> getTeamsByClbumId(String clbumId){return teamMapper.selectTeamByClbumId(clbumId);}

    /**
     * Team belongs to clbum. So here are necessary
     * TODO:May use redundant courseId here.
     * @param courseId
     * @return
     */
    public List<Team> getTeamsByCourseId(String courseId){
        List<Clbum> clbums = clbumDao.getClbumsByCourseId(courseId);
        List<Team> teams = new LinkedList<>();
        clbums.forEach(clbum -> {
            teams.addAll(getTeamsByClbumId(clbum.getId()));
        });
        return teams;
    }

}

package seminar.dao.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.application.ShareTeamApplication;
import seminar.entity.application.TeamValidApplication;
import seminar.mapper.application.TeamValidApplicationMapper;

import java.util.List;

/**
 * @author Cesare
 */
@Component
public class TeamValidApplicationDAO {
    private final TeamValidApplicationMapper teamValidApplicationMapper;

    @Autowired
    public TeamValidApplicationDAO(TeamValidApplicationMapper teamValidApplicationMapper) {
        this.teamValidApplicationMapper = teamValidApplicationMapper;
    }

    public boolean create(TeamValidApplication teamValidApplication){
        if(!teamValidApplicationMapper.selectTeamValidApplicationByTeamId(teamValidApplication.getTeamId()).isEmpty()){
            return false;
        }
        teamValidApplicationMapper.insertTeamValidApplication(teamValidApplication);
        return true;
    }

    public List<TeamValidApplication> getByTeacherId(String teacherId){
        return teamValidApplicationMapper.selectTeamValidApplicationByTeacherId(teacherId);
    }

    public void deleteById(String id){
        teamValidApplicationMapper.deleteTeamValidApplicationById(id);
    }
}

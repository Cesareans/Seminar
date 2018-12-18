package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.application.TeamValidApplication;
import seminar.mapper.application.TeamValidApplicationMapper;

import java.util.List;

/**
 * @author SWJ
 */
@Component
public class GroupValidityMsgDAO {
    private final TeamValidApplicationMapper teamValidApplicationMapper;

    @Autowired
    public GroupValidityMsgDAO(TeamValidApplicationMapper teamValidApplicationMapper) {
        this.teamValidApplicationMapper = teamValidApplicationMapper;
    }

    public void create(TeamValidApplication teamValidApplication) {
        teamValidApplicationMapper.insertGroupValidityMsg(teamValidApplication);
    }

    public boolean update(TeamValidApplication teamValidApplication) {
        if (!teamValidApplicationMapper.selectGroupValidityMsgById(teamValidApplication.getId()).isEmpty()) {
            teamValidApplicationMapper.updateGroupValidityMsg(teamValidApplication);
            return true;
        }
        return false;
    }

    public List<TeamValidApplication> getAll() {
        return teamValidApplicationMapper.selectAllGroupValidityMsg();
    }

    public List<TeamValidApplication> getById(String id) {
        return teamValidApplicationMapper.selectGroupValidityMsgById(id);
    }

    public List<TeamValidApplication> getByTeacherId(String teacherId) {
        return teamValidApplicationMapper.selectGroupValidityMsgByTeacherId(teacherId);
    }

    public List<TeamValidApplication> getByTeamId(String teamId) {
        return teamValidApplicationMapper.selectGroupValidityMsgByTeamId(teamId);
    }

    public void deleteById(String id) {
        teamValidApplicationMapper.deleteGroupValidityMsgById(id);
    }

    public void deleteByTeacherId(String teacherId) {
        teamValidApplicationMapper.deleteGroupValidityMsgByTeacherId(teacherId);
    }

    public void deleteByTeamId(String teamId) {
        teamValidApplicationMapper.deleteGroupValidityMsgByTeamId(teamId);
    }
}

package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.TeamShare;
import seminar.mapper.TeamShareMapper;

import javax.xml.ws.Action;

/**
 * @author SWJ
 */
@Component
public class TeamShareDAO {
    private TeamShareMapper teamShareMapper;
    @Autowired
    public TeamShareDAO(TeamShareMapper teamShareMapper){
        this.teamShareMapper=teamShareMapper;
    }

    public void add(TeamShare teamShare){
        teamShareMapper.insertTeamShare(teamShare);
    }
    public void update(TeamShare teamShare){
        teamShareMapper.updateTeamShare(teamShare);
    }
}

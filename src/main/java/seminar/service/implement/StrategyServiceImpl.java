package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.TeamDAO;
import seminar.dao.regulation.StrategyCompositionDAO;
import seminar.entity.SeminarScore;
import seminar.entity.Team;
import seminar.entity.regulation.StrategyComposition;
import seminar.service.StrategyService;

/**
 * @author Xinyu Shi
 */
@Service
public class StrategyServiceImpl implements StrategyService {

    private final StrategyCompositionDAO strategyCompositionDAO;
    private final TeamDAO teamDAO;

    @Autowired
    public StrategyServiceImpl(StrategyCompositionDAO strategyCompositionDAO, TeamDAO teamDAO)
    {
        this.strategyCompositionDAO = strategyCompositionDAO;
        this.teamDAO = teamDAO;
    }

    @Override
    public boolean validate(String teamId, String courseId)
    {
        Team team = teamDAO.getById(teamId).get(0);
        StrategyComposition strategies = strategyCompositionDAO.getStrategiesByCourseId(courseId);
        return strategies.validate(team);
    }
}

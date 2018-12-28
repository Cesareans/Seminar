package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.TeamDAO;
import seminar.dao.regulation.StrategyCompositionDAO;
import seminar.entity.Team;
import seminar.entity.regulation.Strategy;
import seminar.entity.regulation.StrategyComposition;
import seminar.service.StrategyService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Xinyu Shi
 */
@Service
public class StrategyServiceImpl implements StrategyService {
    private Map<String, StrategyComposition> compositionMap;
    private final StrategyCompositionDAO strategyCompositionDAO;
    private final TeamDAO teamDAO;

    @Autowired
    public StrategyServiceImpl(StrategyCompositionDAO strategyCompositionDAO, TeamDAO teamDAO)
    {
        this.strategyCompositionDAO = strategyCompositionDAO;
        this.teamDAO = teamDAO;
        compositionMap = new HashMap<>();
    }

    @Override
    public boolean validate(String teamId, String courseId)
    {
        StrategyComposition strategies = compositionMap.getOrDefault(courseId, strategyCompositionDAO.getStrategiesByCourseId(courseId));
        boolean validation = true;
        Team team = teamDAO.getById(teamId).get(0);
        for(Strategy strategy:strategies.getStrategies())
        {
            if(!strategy.validate(team)){
                validation = false;
                break;
            }
        }
        return validation;
    }
}

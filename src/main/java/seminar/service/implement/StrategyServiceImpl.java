package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.TeamDAO;
import seminar.dao.regulation.StrategyCompositionDAO;
import seminar.entity.SeminarScore;
import seminar.entity.Team;
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
        StrategyComposition strategyComposition = compositionMap.get(courseId);
        if(strategyComposition == null){
            strategyComposition = strategyCompositionDAO.getStrategiesByCourseId(courseId);
            compositionMap.put(courseId, strategyComposition);
        }
        Team team = teamDAO.getById(teamId).get(0);
        return strategyComposition.validate(team);
    }
}

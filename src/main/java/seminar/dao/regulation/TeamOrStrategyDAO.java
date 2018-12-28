package seminar.dao.regulation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.regulation.Strategy;
import seminar.entity.regulation.StrategyNameId;
import seminar.entity.regulation.TeamAndStrategy;
import seminar.logger.DebugLogger;
import seminar.mapper.TeamOrStrategyMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xinyu Shi
 */
@Component
public class TeamOrStrategyDAO {
    private final TeamOrStrategyMapper teamOrStrategyMapper;
    private final ConflictCourseStrategyDAO conflictCourseStrategyDAO;
    private final CourseMemberLimitStrategyDAO courseMemberLimitStrategyDAO;
    private final MemberLimitStrategyDAO memberLimitStrategyDAO;

    @Autowired
    public TeamOrStrategyDAO(TeamOrStrategyMapper teamOrStrategyMapper, CourseMemberLimitStrategyDAO courseMemberLimitStrategyDAO, ConflictCourseStrategyDAO conflictCourseStrategyDAO, MemberLimitStrategyDAO memberLimitStrategyDAO)
    {
        this.teamOrStrategyMapper = teamOrStrategyMapper;
        this.conflictCourseStrategyDAO = conflictCourseStrategyDAO;
        this.courseMemberLimitStrategyDAO = courseMemberLimitStrategyDAO;
        this.memberLimitStrategyDAO = memberLimitStrategyDAO;
    }

    private List<Strategy> getOrStrategyById(String id)
    {
        List<Strategy> strategies = new ArrayList<>();
        List<StrategyNameId> strategySet = teamOrStrategyMapper.selectStrategiesById(id);
        for (StrategyNameId s : strategySet)
        {
            switch(s.getStrategyName()){
                case("MemberLimitStrategy"):
                    strategies.add(memberLimitStrategyDAO.getById(s.getStrategyId()));
                    break;
                case("ConflictCourseStrategy"):
                    strategies.add(conflictCourseStrategyDAO.getById(s.getStrategyId()));
                    break;
                case("CourseMemberLimitStrategy"):
                    strategies.add(courseMemberLimitStrategyDAO.getById(s.getStrategyId()));
                    break;
                default:break;
            }
        }

        return strategies;
    }

    public TeamAndStrategy getById(String strategyId)
    {
        TeamAndStrategy teamOrStrategy = new TeamAndStrategy();
        teamOrStrategy.setId(strategyId);
        teamOrStrategy.setStrategies(getOrStrategyById(strategyId));
        return teamOrStrategy;
    }

    public String allocateId()
    {
        return teamOrStrategyMapper.allocateId();
    }

    public void createTeamOrStrategy(String id,String strategyName, String strategyId)
    {
        teamOrStrategyMapper.insertSingleTeamOrStrategy(id,strategyName,strategyId);
    }
}

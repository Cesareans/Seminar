package seminar.dao.regulation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.regulation.Strategy;
import seminar.entity.regulation.StrategyNameId;
import seminar.entity.regulation.TeamAndStrategy;
import seminar.mapper.TeamAndStrategyMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xinyu Shi
 */
@Component
public class TeamAndStrategyDAO {

    private final TeamAndStrategyMapper teamAndStrategyMapper;
    private final ConflictCourseStrategyDAO conflictCourseStrategyDAO;
    private final CourseMemberLimitStrategyDAO courseMemberLimitStrategyDAO;
    private final MemberLimitStrategyDAO memberLimitStrategyDAO;
    private final TeamOrStrategyDAO teamOrStrategyDAO;

    @Autowired
    public TeamAndStrategyDAO(TeamAndStrategyMapper teamAndStrategyMapper, CourseMemberLimitStrategyDAO courseMemberLimitStrategyDAO, ConflictCourseStrategyDAO conflictCourseStrategyDAO, MemberLimitStrategyDAO memberLimitStrategyDAO, TeamOrStrategyDAO teamOrStrategyDAO)
    {
        this.teamAndStrategyMapper = teamAndStrategyMapper;
        this.conflictCourseStrategyDAO = conflictCourseStrategyDAO;
        this.courseMemberLimitStrategyDAO = courseMemberLimitStrategyDAO;
        this.memberLimitStrategyDAO = memberLimitStrategyDAO;
        this.teamOrStrategyDAO = teamOrStrategyDAO;
    }

    private List<Strategy> getAndStrategyById(String id)
    {
        List<Strategy> strategies = new ArrayList<>();
        List<StrategyNameId> strategySet = teamAndStrategyMapper.selectStrategiesById(id);
        for (StrategyNameId s : strategySet)
        {
            switch(s.getStrategyName()){
                case("CourseMemberLimitStrategy"):
                    strategies.add(courseMemberLimitStrategyDAO.getById(s.getStrategyId()));
                    break;
                case("ConflictCourseStrategy"):
                    strategies.add(conflictCourseStrategyDAO.getById(s.getStrategyId()));
                    break;
                case("MemberLimitStrategy"):
                    strategies.add(memberLimitStrategyDAO.getById(s.getStrategyId()));
                    break;
                case("TeamOrStrategy"):
                    strategies.add(teamOrStrategyDAO.getById(s.getStrategyId()));
                    break;
                default:break;
            }
        }

        return strategies;
    }

    public TeamAndStrategy getById(String strategyId)
    {
        TeamAndStrategy teamAndStrategy = new TeamAndStrategy();
        teamAndStrategy.setId(strategyId);
        teamAndStrategy.setStrategies(getAndStrategyById(strategyId));
        return teamAndStrategy;
    }
}

package seminar.dao.regulation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.regulation.Strategy;
import seminar.entity.regulation.StrategyNameId;
import seminar.entity.regulation.TeamAndStrategy;
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
        List<StrategyNameId> strategySet = teamOrStrategyMapper.selectStratigiesById(id);
        for (StrategyNameId s : strategySet)
        {
            switch(s.getStrategy_name()){
                case("MemberLimitStrategy"):
                    strategies.add(memberLimitStrategyDAO.getById(s.getStrategy_id()));
                    break;
                case("ConflictCourseStrategy"):
                    strategies.add(conflictCourseStrategyDAO.getById(s.getStrategy_id()));
                    break;
                case("CourseMemberLimitStrategy"):
                    strategies.add(courseMemberLimitStrategyDAO.getById(s.getStrategy_id()));
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
}

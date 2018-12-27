package seminar.dao.regulation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.Team;
import seminar.entity.regulation.*;
import seminar.logger.DebugLogger;
import seminar.mapper.TeamFinalStrategyMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xinyu Shi
 */
@Component
public class StrategyCompositionDAO {

    private final TeamFinalStrategyMapper teamFinalStrategyMapper;
    private final TeamAndStrategyDAO teamAndStrategyDAO;
    private final TeamOrStrategyDAO teamOrStrategyDAO;
    private final ConflictCourseStrategyDAO conflictCourseStrategyDAO;
    private final CourseMemberLimitStrategyDAO courseMemberLimitStrategyDAO;
    private final MemberLimitStrategyDAO memberLimitStrategyDAO;

    private final String LOCATION = "seminar.entity.regulation.";

    @Autowired
    public StrategyCompositionDAO(TeamFinalStrategyMapper teamFinalStrategyMapper, TeamAndStrategyDAO teamAndStrategyDAO, TeamOrStrategyDAO teamOrStrategyDAO, CourseMemberLimitStrategyDAO courseMemberLimitStrategyDAO, ConflictCourseStrategyDAO conflictCourseStrategyDAO, MemberLimitStrategyDAO memberLimitStrategyDAO)
    {
        this.teamFinalStrategyMapper = teamFinalStrategyMapper;
        this.conflictCourseStrategyDAO = conflictCourseStrategyDAO;
        this.courseMemberLimitStrategyDAO = courseMemberLimitStrategyDAO;
        this.memberLimitStrategyDAO = memberLimitStrategyDAO;
        this.teamAndStrategyDAO = teamAndStrategyDAO;
        this.teamOrStrategyDAO = teamOrStrategyDAO;
    }

    public boolean validate(Team team, String courseId)
    {
        boolean validation = true;
        List<Strategy> strategies = getStrategiesByCourseId(courseId);
        for(Strategy strategy:strategies)
        {
            if(!strategy.validate(team)){
                validation = false;
                break;
            }
        }
        return validation;
    }

    public List<Strategy> getStrategiesByCourseId(String courseId)
    {
        List<Strategy> strategies = new ArrayList<>();
        List<StrategyNameId> strategySet = teamFinalStrategyMapper.selectStrategiesById(courseId);
        for (StrategyNameId s : strategySet)
        {
            try {
                DebugLogger.logJson(s.getStrategyName());
                Strategy strategy = (Strategy) Class.forName(LOCATION + s.getStrategyName()).newInstance();
                strategy = makeStrategyByDAO(strategy,s.getStrategyId());
                strategies.add(strategy);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return strategies;
    }

    private Strategy makeStrategyByDAO(Strategy strategy, String strategyId)
    {
        if(strategy instanceof ConflictCourseStrategy){
            return conflictCourseStrategyDAO.getById(strategyId);
        }
        else if(strategy instanceof CourseMemberLimitStrategy){
            return courseMemberLimitStrategyDAO.getById(strategyId);
        }
        else if(strategy instanceof MemberLimitStrategy){
            return memberLimitStrategyDAO.getById(strategyId);
        }
        else if(strategy instanceof TeamAndStrategy){
            return teamAndStrategyDAO.getById(strategyId);
        }
        else {
            return teamOrStrategyDAO.getById(strategyId);
        }
    }
}
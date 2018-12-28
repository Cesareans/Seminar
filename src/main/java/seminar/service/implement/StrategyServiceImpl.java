package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.TeamDAO;
import seminar.dao.regulation.*;
import seminar.entity.Team;
import seminar.entity.regulation.ConflictCourseStrategy;
import seminar.entity.regulation.CourseMemberLimitStrategy;
import seminar.entity.regulation.MemberLimitStrategy;
import seminar.entity.regulation.StrategyComposition;
import seminar.pojo.dto.CourseCreateDTO;
import seminar.service.StrategyService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xinyu Shi
 */
@Service
public class StrategyServiceImpl implements StrategyService {
    private Map<String, StrategyComposition> compositionMap;
    private final StrategyCompositionDAO strategyCompositionDAO;
    private final TeamDAO teamDAO;
    private final MemberLimitStrategyDAO memberLimitStrategyDAO;
    private final CourseMemberLimitStrategyDAO courseMemberLimitStrategyDAO;
    private final ConflictCourseStrategyDAO conflictCourseStrategyDAO;
    private final TeamAndStrategyDAO teamAndStrategyDAO;
    private final TeamOrStrategyDAO teamOrStrategyDAO;

    @Autowired
    public StrategyServiceImpl(StrategyCompositionDAO strategyCompositionDAO, TeamDAO teamDAO, MemberLimitStrategyDAO memberLimitStrategyDAO,CourseMemberLimitStrategyDAO courseMemberLimitStrategyDAO,ConflictCourseStrategyDAO conflictCourseStrategyDAO, TeamOrStrategyDAO teamOrStrategyDAO, TeamAndStrategyDAO teamAndStrategyDAO)
    {
        this.strategyCompositionDAO = strategyCompositionDAO;
        this.teamDAO = teamDAO;
        compositionMap = new HashMap<>();
        this.memberLimitStrategyDAO = memberLimitStrategyDAO;
        this.conflictCourseStrategyDAO = conflictCourseStrategyDAO;
        this.courseMemberLimitStrategyDAO = courseMemberLimitStrategyDAO;
        this.teamAndStrategyDAO = teamAndStrategyDAO;
        this.teamOrStrategyDAO = teamOrStrategyDAO;
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

    @Override
    public void createStrategy(CourseCreateDTO courseCreateDTO, String mainCourseId)
    {
        String teamAndId = teamAndStrategyDAO.allocateId();
        String teamOrId = teamOrStrategyDAO.allocateId();
        MemberLimitStrategy memberLimitStrategy = courseCreateDTO.getMemberLimitStrategy();
        List<CourseMemberLimitStrategy> courseMemberLimitStrategies = courseCreateDTO.getCourseMemberLimitStrategies();
        List<ConflictCourseStrategy> conflictCourseStrategies = courseCreateDTO.getConflictCourseStrategies();
        memberLimitStrategyDAO.createMemberLimitStrategy(memberLimitStrategy);
        teamAndStrategyDAO.createTeamAndStrategy(teamAndId,"MemberLimitStrategy",memberLimitStrategy.getId());
        for(CourseMemberLimitStrategy courseMemberLimitStrategy:courseMemberLimitStrategies)
        {
            courseMemberLimitStrategyDAO.createCourseMemberLimitStrategy(courseMemberLimitStrategy);
            teamOrStrategyDAO.createTeamOrStrategy(teamOrId,"CourseMemberLimitStrategy",courseMemberLimitStrategy.getId());
        }
        teamAndStrategyDAO.createTeamAndStrategy(teamAndId,"TeamOrStrategy",teamOrId);
        for(ConflictCourseStrategy conflictCourseStrategy:conflictCourseStrategies)
        {
            conflictCourseStrategyDAO.createConflictCourseStrategy(conflictCourseStrategy,mainCourseId);
            strategyCompositionDAO.createTeamStrategy(mainCourseId,strategyCompositionDAO.allocateSerial(mainCourseId),"ConflictCourseStrategy",mainCourseId);
        }
        strategyCompositionDAO.createTeamStrategy(mainCourseId,strategyCompositionDAO.allocateSerial(mainCourseId),"TeamAndStrategy",teamAndId);
    }
}

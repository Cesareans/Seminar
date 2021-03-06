package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.CourseDAO;
import seminar.dao.TeamDAO;
import seminar.dao.regulation.*;
import seminar.entity.Team;
import seminar.entity.regulation.ConflictCourseStrategy;
import seminar.entity.regulation.CourseMemberLimitStrategy;
import seminar.entity.regulation.MemberLimitStrategy;
import seminar.entity.regulation.StrategyComposition;
import seminar.logger.DebugLogger;
import seminar.pojo.dto.CourseCreateDTO;
import seminar.pojo.enumration.TeamStatus;
import seminar.service.StrategyService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Xinyu Shi
 */
@Service
public class StrategyServiceImpl implements StrategyService {
    private final StrategyCompositionDAO strategyCompositionDAO;
    private final CourseDAO courseDAO;
    private final TeamDAO teamDAO;
    private final MemberLimitStrategyDAO memberLimitStrategyDAO;
    private final CourseMemberLimitStrategyDAO courseMemberLimitStrategyDAO;
    private final ConflictCourseStrategyDAO conflictCourseStrategyDAO;
    private final TeamAndStrategyDAO teamAndStrategyDAO;
    private final TeamOrStrategyDAO teamOrStrategyDAO;
    private Map<String, StrategyComposition> compositionMap;


    @Autowired
    public StrategyServiceImpl(StrategyCompositionDAO strategyCompositionDAO, CourseDAO courseDAO, TeamDAO teamDAO, MemberLimitStrategyDAO memberLimitStrategyDAO, CourseMemberLimitStrategyDAO courseMemberLimitStrategyDAO, ConflictCourseStrategyDAO conflictCourseStrategyDAO, TeamOrStrategyDAO teamOrStrategyDAO, TeamAndStrategyDAO teamAndStrategyDAO) {
        this.strategyCompositionDAO = strategyCompositionDAO;
        this.courseDAO = courseDAO;
        this.teamDAO = teamDAO;
        compositionMap = new HashMap<>();
        this.memberLimitStrategyDAO = memberLimitStrategyDAO;
        this.conflictCourseStrategyDAO = conflictCourseStrategyDAO;
        this.courseMemberLimitStrategyDAO = courseMemberLimitStrategyDAO;
        this.teamAndStrategyDAO = teamAndStrategyDAO;
        this.teamOrStrategyDAO = teamOrStrategyDAO;
    }

    @Override
    public void handleVariation(Team team) {
        if (validate(team.getId(), team.getCourseId())) {
            team.setStatus(TeamStatus.Valid.getStatus());
        } else {
            team.setStatus(TeamStatus.Invalid.getStatus());
        }
    }

    @Override
    public boolean validate(String teamId, String courseId) {
        Date teamEndDate = courseDAO.getByCourseId(courseId).get(0).getTeamEndDate();
        if (new Date().compareTo(teamEndDate) > 0) {
            return false;
        }
        StrategyComposition strategyComposition = compositionMap.get(courseId);
        if (strategyComposition == null) {
            strategyComposition = strategyCompositionDAO.getStrategiesByCourseId(courseId);
            compositionMap.put(courseId, strategyComposition);
        }
        Team team = teamDAO.getById(teamId).get(0);
        return strategyComposition.validate(team);
    }

    @Override
    public void createStrategy(CourseCreateDTO courseCreateDTO, String courseId) {
        String teamAndId = teamAndStrategyDAO.allocateId();
        String teamOrId = teamOrStrategyDAO.allocateId();
        MemberLimitStrategy memberLimitStrategy = courseCreateDTO.getMemberLimitStrategy();
        List<CourseMemberLimitStrategy> courseMemberLimitStrategies = courseCreateDTO.getCourseMemberLimitStrategies();
        List<ConflictCourseStrategy> conflictCourseStrategies = courseCreateDTO.getConflictCourseStrategies();
        DebugLogger.logJson(memberLimitStrategy);
        memberLimitStrategyDAO.createMemberLimitStrategy(memberLimitStrategy);
        teamAndStrategyDAO.createTeamAndStrategy(teamAndId, "MemberLimitStrategy", memberLimitStrategy.getId());
        for (CourseMemberLimitStrategy courseMemberLimitStrategy : courseMemberLimitStrategies) {
            courseMemberLimitStrategyDAO.createCourseMemberLimitStrategy(courseMemberLimitStrategy);
            teamOrStrategyDAO.createTeamOrStrategy(teamOrId, "CourseMemberLimitStrategy", courseMemberLimitStrategy.getId());
        }
        teamAndStrategyDAO.createTeamAndStrategy(teamAndId, "TeamOrStrategy", teamOrId);
        for (ConflictCourseStrategy conflictCourseStrategy : conflictCourseStrategies) {
            String conflictId = conflictCourseStrategyDAO.allocateId();
            DebugLogger.logJson(conflictId);
            conflictCourseStrategyDAO.createConflictCourseStrategy(conflictCourseStrategy, conflictId);
            strategyCompositionDAO.createTeamStrategy(courseId, strategyCompositionDAO.allocateSerial(courseId), "ConflictCourseStrategy", conflictId);
        }
        strategyCompositionDAO.createTeamStrategy(courseId, strategyCompositionDAO.allocateSerial(courseId), "TeamAndStrategy", teamAndId);
    }
}

package seminar.dao.regulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.regulation.ConflictCourseStrategy;
import seminar.mapper.ConflictCourseStrategyMapper;


/**
 * @author Xinyu Shi
 */
@Component
public class ConflictCourseStrategyDAO {

    private final ConflictCourseStrategyMapper conflictCourseStrategyMapper;

    @Autowired
    public ConflictCourseStrategyDAO(ConflictCourseStrategyMapper conflictCourseStrategyMapper) {
        this.conflictCourseStrategyMapper = conflictCourseStrategyMapper;
    }

    public ConflictCourseStrategy getById(String strategyId) {
        ConflictCourseStrategy conflictCourseStrategy = new ConflictCourseStrategy();
        conflictCourseStrategy.setConflictCourses(conflictCourseStrategyMapper.selectConflictCoursesById(strategyId));
        return conflictCourseStrategy;
    }

    public void createConflictCourseStrategy(ConflictCourseStrategy conflictCourseStrategy, String id)
    {
        for(String courseId:conflictCourseStrategy.getConflictCourses())
        {
            conflictCourseStrategyMapper.insertSingleCourseMemberLimitStrategy(id,courseId);
        }
    }

    public String allocateId()
    {
        return conflictCourseStrategyMapper.allocateId();
    }
}

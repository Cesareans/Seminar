package seminar.service;

import seminar.entity.Student;
import seminar.entity.Teacher;
import seminar.pojo.dto.StudentFilter;
import seminar.pojo.dto.TeacherFilter;

import java.util.List;

/**
 * @author Xinyu Shi
 */
public interface StrategyService {
   /**
    * Validate a team via course's strategy
    * @param teamId the team refer gist
    * @param courseId the course refer gsit
    * @return whether valid
    */
   boolean validate(String teamId, String courseId);


}

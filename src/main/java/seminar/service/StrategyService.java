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

   boolean validate(String teamId, String courseId);


}

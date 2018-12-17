package seminar.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import seminar.entity.Course;
import seminar.logger.DebugLogger;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseMapperTest {
    @Autowired
    private CourseMapper courseMapper;

    @Test
    public void selectCourseById(){
        DebugLogger.logJson(courseMapper.selectCourseById(null));
    }
    @Test
    public void selectCourseByTeacherNumTest(){
        List<Course> courses = courseMapper.selectCourseByTeacherId("1234");
        DebugLogger.logJson(courses);
        DebugLogger.logJson(courses.get(0).getTeamEndDate().toString());
    }

}

package seminar.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import seminar.logger.DebugLogger;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseDAOTest {
    @Autowired
    CourseDAO courseDAO;
    @Test
    public void getOtherCoursesByCourseId() {
        DebugLogger.logJson(courseDAO.getOtherCoursesByCourseId("112"));
        DebugLogger.logJson(courseDAO.getOtherCoursesByCourseId("113"));
        DebugLogger.logJson(courseDAO.getOtherCoursesByCourseId("114"));

    }
}
package seminar.service.implement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import seminar.dao.TeamDAO;
import seminar.logger.DebugLogger;
import seminar.service.StudentService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceImplTest {

    @Autowired
    StudentService studentService;
    TeamDAO teamDAO;

    @Test
    public void createTeam()
    {
        DebugLogger.logJson(studentService.createTeam("1239","112","145","testTeam"));

    }

    @Test
    public void getAllTeamsByCourseId()
    {
        DebugLogger.logJson(studentService.getAllTeamInformation("112"));
    }

    @Test
    public void getAllUnTeamedStudents()
    {
        DebugLogger.logJson(studentService.getAllUnTeamedStudentsByCourseId("112"));
    }

    @Test
    public void exitTeam()
    {
        studentService.exitTeam("1239","128");
        DebugLogger.logJson(teamDAO.getById("128"));
    }

}
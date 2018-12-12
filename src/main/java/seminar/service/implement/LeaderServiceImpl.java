package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.CourseDAO;
import seminar.dao.StudentDAO;
import seminar.dao.TeamDAO;
import seminar.dao.TeamStudentDAO;
import seminar.entity.Course;
import seminar.entity.Team;
import seminar.entity.relation.TeamStudent;
import seminar.service.LeaderService;

import java.util.Date;
import java.util.List;

@Service
public class LeaderServiceImpl implements LeaderService {

    private final TeamStudentDAO teamStudentDAO;
    private StudentDAO studentDAO;
    private CourseDAO courseDAO;
    private TeamDAO teamDAO;

    @Autowired
    public LeaderServiceImpl(TeamStudentDAO teamStudentDAO, StudentDAO studentDAO, CourseDAO courseDAO, TeamDAO teamDAO)
    {
        this.teamStudentDAO = teamStudentDAO;
        this.studentDAO = studentDAO;
        this.courseDAO = courseDAO;
        this.teamDAO = teamDAO;
    }

    @Override
    public boolean addGroupMember(String courseId, String teamId, String studentSn)
    {
        List<TeamStudent> teamAndStudent = teamStudentDAO.getByStudentId(studentSn);
        if(!teamAndStudent.isEmpty())
            return false;
        else
        {
            TeamStudent teamStudent = new TeamStudent();
            teamStudent.setStudentId(studentSn);
            teamStudent.setTeamId(teamId);
            teamStudentDAO.create(teamStudent);
            Date today = new Date();

            Course course = courseDAO.getByCourseId(courseId).get(0);
            Date teamEndDate = course.getTeamEndDate();
            if(today.getTime() > teamEndDate.getTime())
            {
                Team team = teamDAO.getById(teamId).get(0);
                team.setValid(false);
            }

            return true;
        }

    }

    /**
     * TODO: unfinish
     * @param teamId
     */
    @Override
    public void submitReviewRequest(String teamId)
    {

    }

    @Override
    public void deleteGroupMember(String courseId, String teamId, String studentId)
    {
        teamStudentDAO.deleteByStudentId(studentId);
        Course course = courseDAO.getByCourseId(courseId).get(0);
        Date teamEndDate = course.getTeamEndDate();
        Date today = new Date();
        if(today.getTime() > teamEndDate.getTime())
        {
            Team team = teamDAO.getById(teamId).get(0);
            team.setValid(false);
        }
    }
}

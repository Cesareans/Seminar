package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.CourseDAO;
import seminar.dao.KlassStudentDAO;
import seminar.dao.StudentDAO;
import seminar.dao.TeamDAO;
import seminar.entity.Team;
import seminar.entity.relation.KlassStudent;
import seminar.service.LeaderService;

import java.util.Date;

/**
 * @author Xinyu Shi
 */
@Service
public class LeaderServiceImpl implements LeaderService {

    private final CourseDAO courseDAO;
    private final TeamDAO teamDAO;
    private final KlassStudentDAO klassStudentDAO;
    private final StudentDAO studentDAO;
    private final String NOT_HAVE_TEAM = "0";
    private final int TEAM_IS_INVALID = 0;
    private final int TEAM_IS_CHECKING = 2;


    @Autowired
    public LeaderServiceImpl(CourseDAO courseDAO, TeamDAO teamDAO, KlassStudentDAO klassStudentDAO, StudentDAO studentDAO) {
        this.courseDAO = courseDAO;
        this.teamDAO = teamDAO;
        this.klassStudentDAO = klassStudentDAO;
        this.studentDAO = studentDAO;
    }
    @Override
    public boolean addGroupMember(String studentId, String courseId, String teamId)
    {
        Date today = new Date();
        Date teamEndDate = courseDAO.getByCourseId(courseId).get(0).getTeamEndDate();
        Team team = teamDAO.getById(teamId).get(0);
        if(team.getStatus()==TEAM_IS_CHECKING) {
            return false;
        }
        if(studentDAO.studenHasAlreadyTeamed(studentId,courseId)) {
            return false;
        }
        if(today.getTime() > teamEndDate.getTime()) {
            team.setStatus(TEAM_IS_INVALID);
        }

        studentDAO.updateTeamInfoInKlassStudent(studentId,courseId,teamId);
        team = teamDAO.getById(teamId).get(0);
        teamDAO.update(team);

        /**
         * TODO: judge whether the team id valid or not.
         */
        return true;
    }

    @Override
    public boolean deleteGroupMember(String studentId, String courseId, String teamId)
    {
        Date today = new Date();
        Date teamEndDate = courseDAO.getByCourseId(courseId).get(0).getTeamEndDate();
        Team team = teamDAO.getById(teamId).get(0);
        if(team.getStatus()==TEAM_IS_CHECKING) {
            return false;
        }

        if(today.getTime() > teamEndDate.getTime()) {
            team.setStatus(TEAM_IS_INVALID);
        }

        studentDAO.updateTeamInfoInKlassStudent(studentId,courseId,NOT_HAVE_TEAM);
        team = teamDAO.getById(teamId).get(0);
        teamDAO.update(team);

        /**
         * TODO: judge whether the team id valid or not.
         */
        return true;
    }

}

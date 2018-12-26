package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.CourseDAO;
import seminar.dao.StudentDAO;
import seminar.dao.TeamDAO;
import seminar.entity.Student;
import seminar.entity.Team;
import seminar.service.LeaderService;

import java.util.Date;
import java.util.List;

/**
 * @author Xinyu Shi
 */
@Service
public class LeaderServiceImpl implements LeaderService {

    private final CourseDAO courseDAO;
    private final TeamDAO teamDAO;
    private final StudentDAO studentDAO;
    private final int TEAM_IS_INVALID = 0;
    private final int TEAM_IS_VALID = 1;
    private final int TEAM_IS_CHECKING = 2;


    @Autowired
    public LeaderServiceImpl(CourseDAO courseDAO, TeamDAO teamDAO, StudentDAO studentDAO) {
        this.courseDAO = courseDAO;
        this.teamDAO = teamDAO;
        this.studentDAO = studentDAO;
    }
    @Override
    public boolean addGroupMember(String studentId, String teamId)
    {
        Team team = teamDAO.getById(teamId).get(0);
        Date teamEndDate = courseDAO.getByCourseId(team.getCourseId()).get(0).getTeamEndDate();
        if(team.getStatus()==TEAM_IS_CHECKING) {
            return false;
        }
        if(studentDAO.studentHasAlreadyTeamed(studentId,team.getCourseId())) {
            return false;
        }
        if(new Date().compareTo(teamEndDate) > 0) {
            team.setStatus(TEAM_IS_INVALID);
        }
        studentDAO.insertStudentIntoTeamStudent(studentId,teamId);
        teamDAO.update(team);

        /**
         * TODO: judge whether the team id valid or not.
         */

        return true;
    }

    @Override
    public boolean deleteGroupMember(String studentId, String teamId)
    {
        Team team = teamDAO.getById(teamId).get(0);
        Date teamEndDate = courseDAO.getByCourseId(team.getCourseId()).get(0).getTeamEndDate();
        if(team.getStatus()==TEAM_IS_CHECKING) {
            return false;
        }
        if(new Date().compareTo(teamEndDate) > 0) {
            team.setStatus(TEAM_IS_INVALID);
        }
        studentDAO.deleteStudentFromTeamStudent(studentId);
        teamDAO.update(team);

        /**
         * TODO: judge whether the team id valid or not.
         */
        return true;
    }

    /**
     * create team
     * @author Xinyu Shi
     * @param team the new team
     * @return whether the operation is successful
     */
    @Override
    public boolean createTeam(Team team)
    {
        Date teamEndDate = courseDAO.getByCourseId(team.getCourseId()).get(0).getTeamEndDate();
        if(new Date().compareTo(teamEndDate) > 0) {
            return false;
        }
        team.setStatus(TEAM_IS_VALID);
        teamDAO.create(team);
        return true;
    }

    /**
     * TODO
     * @author Xinyu Shi
     * @param teamId
     */
    @Override
    public void dissolveTeam(String teamId)
    {
        List<Student> students = teamDAO.getStudentsByTeamId(teamId);
        for(Student student : students)
        {
            studentDAO.deleteStudentFromTeamStudent(student.getId());
        }
        //delete this team.
        teamDAO.deleteById(teamId);
    }

}

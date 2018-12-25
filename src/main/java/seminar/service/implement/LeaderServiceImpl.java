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
    private final String NOT_HAVE_TEAM = "0";
    private final int TEAM_IS_INVALID = 0;
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
        if(studentDAO.studenHasAlreadyTeamed(studentId,team.getCourseId())) {
            return false;
        }
        if(!compareTime(teamEndDate)) {
            team.setStatus(TEAM_IS_INVALID);
        }

        studentDAO.updateTeamInfoInKlassStudent(studentId,team.getCourseId(),teamId);
        team = teamDAO.getById(teamId).get(0);
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
        if(!compareTime(teamEndDate)) {
            team.setStatus(TEAM_IS_INVALID);
        }
        studentDAO.updateTeamInfoInKlassStudent(studentId,team.getCourseId(),NOT_HAVE_TEAM);
        team = teamDAO.getById(teamId).get(0);
        teamDAO.update(team);

        /**
         * TODO: judge whether the team id valid or not.
         */
        return true;
    }

    /**
     * TODO
     * @author Xinyu Shi
     * @param studentId
     * @param courseId
     * @param klassId
     * @param teamName
     * @return
     */
    @Override
    public boolean createTeam(String studentId, String courseId, String klassId, String teamName)
    {
        Date teamEndDate = courseDAO.getByCourseId(courseId).get(0).getTeamEndDate();
        if(!compareTime(teamEndDate)) {
            return false;
        }

        Team team = new Team();
        Student leader = studentDAO.getById(studentId).get(0);
        team.setCourseId(courseId);
        team.setKlassId(klassId);
        team.setLeader(leader);
        team.setLeaderId(studentId);
        team.setTeamName(teamName);
        team.setStatus(1);
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
        Team team = teamDAO.getById(teamId).get(0);
        List<Student> students = team.getStudents();
        for(Student student : students)
        {
            studentDAO.exitTeam(student.getId(),teamId);
        }
        //delete this team.
        teamDAO.deleteById(teamId);
    }

    /**
     * compare the current time to the specific time,
     * if the current time is earlier than the specific time, return true
     * otherwise, return false
     * @author Xinyu Shi
     * @param date
     * @return
     */
    private boolean compareTime(Date date)
    {
        Date today = new Date();
        if(today.getTime() < date.getTime()) {
            return true;
        }
        else{
            return false;
        }
    }

}

package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.CourseDAO;
import seminar.dao.KlassStudentDAO;
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

    @Autowired
    public LeaderServiceImpl(CourseDAO courseDAO, TeamDAO teamDAO, KlassStudentDAO klassStudentDAO) {
        this.courseDAO = courseDAO;
        this.teamDAO = teamDAO;
        this.klassStudentDAO = klassStudentDAO;
    }
    @Override
    public boolean addGroupMember(String studentId, String courseId, String teamId)
    {
        Date today = new Date();
        Date teamEndDate = courseDAO.getByCourseId(courseId).get(0).getTeamEndDate();
        Team team = teamDAO.getById(teamId).get(0);
        KlassStudent klassStudent = klassStudentDAO.getByStudentIdAndCourseId(studentId,courseId).get(0);
        if(team.getStatus()==2)
            return false;
        if(!klassStudent.getTeamId().equals("0"))
            return false;

        if(today.getTime() > teamEndDate.getTime()) {
            team.setStatus(0);
        }

        klassStudent.setTeamId(teamId);
        klassStudentDAO.update(klassStudent);
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
        KlassStudent klassStudent = klassStudentDAO.getByStudentIdAndCourseId(studentId,courseId).get(0);
        if(team.getStatus()==2)
            return false;

        if(today.getTime() > teamEndDate.getTime()) {
            team.setStatus(0);
        }

        klassStudent.setTeamId("0");
        klassStudentDAO.update(klassStudent);
        team = teamDAO.getById(teamId).get(0);
        teamDAO.update(team);

        /**
         * TODO: judge whether the team id valid or not.
         */
        return true;
    }

}

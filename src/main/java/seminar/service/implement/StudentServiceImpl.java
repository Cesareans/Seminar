package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.StudentDAO;
import seminar.dao.TeamDAO;
import seminar.dao.TeamStudentDAO;
import seminar.entity.Student;
import seminar.entity.Team;
import seminar.entity.TeamStudent;
import seminar.service.StudentService;

import java.util.List;

/**
 * @author Cesare
 */
@Service
public class StudentServiceImpl implements StudentService {
    private StudentDAO studentDAO;
    private final TeamStudentDAO teamStudentDAO;
    private final TeamDAO teamDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO, TeamStudentDAO teamStudentDAO, TeamDAO teamDAO) {
        this.studentDAO = studentDAO;
        this.teamStudentDAO = teamStudentDAO;
        this.teamDAO = teamDAO;
    }

    /**
     * @author SWJ
     */
    @Override
    public boolean createTeam(Team team){
        List<TeamStudent> teamStudents = teamStudentDAO.getAll();
        for(TeamStudent t:teamStudents){
            if(team.getLeaderId().equals(t.getStudentId())) {
                return false;
            }
        }
        teamDAO.create(team);
        TeamStudent teamStudent = new TeamStudent();
        teamStudent.setIdentity(1);
        teamStudent.setTeamId(team.getId());
        teamStudent.setStudentId(team.getLeaderId());
        teamStudentDAO.create(teamStudent);
        return true;
    }

    /**
     * @author SWJ
     */
    @Override
    public void leaveTeam(String studentId){
        List<TeamStudent> teamStudents = teamStudentDAO.getAll();
        for(TeamStudent t:teamStudents){
            if(t.getStudentId().equals(studentId)){
                if(t.getIdentity()==1){
                    teamDAO.deleteById(t.getTeamId());
                    teamStudentDAO.deleteByTeamId(t.getTeamId());
                }
                else{
                    teamStudentDAO.deleteByStudentId(t.getStudentId());
                }
                break;
            }
        }
    }
}

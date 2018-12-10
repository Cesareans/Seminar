package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.StudentDAO;
import seminar.dao.TeamDAO;
import seminar.dao.TeamStudentDAO;
import seminar.entity.Student;
import seminar.entity.Team;
import seminar.entity.relation.TeamStudent;
import seminar.service.StudentService;

import java.util.List;

/**
 * @author Cesare
 */
@Service
public class StudentServiceImpl implements StudentService {
    private final TeamStudentDAO teamStudentDAO;
    private final TeamDAO teamDAO;
    private StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO, TeamStudentDAO teamStudentDAO, TeamDAO teamDAO) {
        this.studentDAO = studentDAO;
        this.teamStudentDAO = teamStudentDAO;
        this.teamDAO = teamDAO;
    }

    @Override
    public boolean modifyPasswordViaSn(String sn, String password) {
        List<Student> students = studentDAO.getBySN(sn);
        if (students.size() == 0) {
            return false;
        } else {
            Student targetStudent = students.get(0);
            targetStudent.setPassword(password);
            studentDAO.update(targetStudent);
            return true;
        }
    }

    /**
     * @author SWJ
     */
    @Override
    public boolean createTeam(Team team) {
        List<TeamStudent> teamStudents = teamStudentDAO.getAll();
        for (TeamStudent t : teamStudents) {
            if (team.getLeaderId().equals(t.getStudentId())) {
                return false;
            }
        }
        teamDAO.create(team);
        TeamStudent teamStudent = new TeamStudent();
        teamStudent.setTeamId(team.getId());
        teamStudent.setStudentId(team.getLeaderId());
        teamStudentDAO.create(teamStudent);
        return true;
    }

    /**
     * @author SWJ
     */
    @Override
    public void leaveTeam(String studentId) {
        //数据库改了，之后重新写一下，identity去掉了
        throw new UnsupportedOperationException();
    }
}

package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.StudentDAO;
import seminar.dao.TeamDAO;
import seminar.dao.TeamStudentDAO;
import seminar.entity.Student;
import seminar.entity.Teacher;
import seminar.entity.Team;
import seminar.entity.relation.TeamStudent;
import seminar.service.StudentService;

import java.util.LinkedList;
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

    /**
     * @author lyf
     */
    @Override
    public boolean activate(String studentId, String password, String email){
        List<Student> students = studentDAO.getById(studentId);
        if (students.size() == 0) {
            return false;
        }
        Student student = students.get(0);
        student.setPassword(password);
        student.setEmail(email);
        student.setActivated(true);
        return studentDAO.update(student);
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
     * @author lyf
     */
    @Override
    public boolean modifyEmailViaSn() {
        return true;
    }

    /**
     * @author SWJ
     */
    @Override
    public boolean createTeam(Team team, String courseId) {
        List<Team> teams = teamDAO.getByCourseId(courseId);
        List<TeamStudent> teamStudents = new LinkedList<>();
        for(Team t:teams){
            teamStudents.addAll(teamStudentDAO.getByTeamId(t.getId()));
            if(team.getLeaderId().equals(t.getLeaderId())){
                return false;
            }
        }
        for (TeamStudent ts : teamStudents) {
            if (team.getLeaderId().equals(ts.getStudentId())) {
                return false;
            }
        }
        teamDAO.create(team);
        return true;
    }

    /**
     * @author SWJ
     */
    @Override
    public void leaveTeam(String studentId, String courseId) {
        List<Team> teams = teamDAO.getByCourseId(courseId);
        List<TeamStudent> teamStudents = new LinkedList<>();
        for(Team t:teams){
            teamStudents.addAll(teamStudentDAO.getByTeamId(t.getId()));
        }
        for(Team t:teams){
            if(t.getLeaderId().equals(studentId)){
                teamStudentDAO.deleteByTeamId(t.getId());
                teamDAO.deleteById(t.getId());
                return;
            }
        }
        teamStudentDAO.deleteByStudentId(studentId);
    }
}

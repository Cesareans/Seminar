package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.CourseDAO;
import seminar.dao.KlassStudentDAO;
import seminar.dao.StudentDAO;
import seminar.dao.TeamDAO;
import seminar.entity.Student;
import seminar.entity.Team;
import seminar.entity.relation.KlassStudent;
import seminar.service.StudentService;

import java.util.Date;
import java.util.List;

/**
 * @author Cesare
 */
@Service
public class StudentServiceImpl implements StudentService {
    private StudentDAO studentDAO;
    private CourseDAO courseDAO;
    private TeamDAO teamDAO;
    private KlassStudentDAO klassStudentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO, CourseDAO courseDAO, TeamDAO teamDAO, KlassStudentDAO klassStudentDAO) {
        this.studentDAO = studentDAO;
        this.courseDAO = courseDAO;
        this.teamDAO = teamDAO;
        this.klassStudentDAO = klassStudentDAO;
    }

    /**
     * @author Cesare
     */
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
     * @author Xinyu Shi
     */
    @Override
    public boolean createTeam(String studentId, String courseId, String klassId, String teamName)
    {
        Date today = new Date();
        Date teamEndDate = courseDAO.getByCourseId(courseId).get(0).getTeamEndDate();
        if(today.getTime() > teamEndDate.getTime())
            return false;

        Team team = new Team();
        team.setCourseId(courseId);
        team.setKlassId(klassId);
        Student leader = studentDAO.getById(studentId).get(0);
        team.setLeader(leader);
        team.setLeaderId(studentId);
        team.setTeamName(teamName);
        team.setStatus(1);
        teamDAO.create(team);
        Team teamCreated = teamDAO.getById(team.getId()).get(0);
        KlassStudent klassStudent = new KlassStudent();
        klassStudent.setKlassId(klassId);
        klassStudent.setCourseId(courseId);
        klassStudent.setTeamId(teamCreated.getSerial());
        klassStudent.setStudentId(studentId);
        klassStudentDAO.update(klassStudent);

        return true;
    }

    @Override
    public List<Team> getAllTeamInformation(String courseId)
    {
        return teamDAO.getCourseTeamsByCourseId(courseId);
    }

    @Override
    public List<Student> getAllUnteamedStudentsByCourseId(String courseId)
    {
        return studentDAO.studentsUnTeamed(courseId);
    }

    @Override
    public void exitTeam(String studentId, String teamId)
    {
        Team team = teamDAO.getById(teamId).get(0);
        if((team.getLeaderId()).equals(studentId))
        {
            List<Student> students = team.getStudents();
            for(Student student : students)
            {
                KlassStudent klassStudent = klassStudentDAO.getByStudentId(student.getId()).get(0);
                klassStudent.setTeamId("0");
                klassStudentDAO.update(klassStudent);
            }
            teamDAO.deleteById(teamId);
        }
        else
        {
            KlassStudent klassStudent = klassStudentDAO.getByStudentId(studentId).get(0);
            klassStudent.setTeamId("0");
            klassStudentDAO.update(klassStudent);
            team = teamDAO.getById(teamId).get(0);
            teamDAO.update(team);
        }
    }
}

package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import seminar.dao.*;
import seminar.entity.*;
import seminar.entity.relation.KlassStudent;
import seminar.logger.DebugLogger;
import seminar.service.StudentService;

import java.util.Date;
import java.util.List;

/**
 * @author Xinyu Shi
 */
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentDAO studentDAO;
    private final CourseDAO courseDAO;
    private final KlassDao klassDao;
    private final TeamDAO teamDAO;
    private final KlassSeminarDAO klassSeminarDAO;
    private final AttendanceDAO attendanceDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO, CourseDAO courseDAO, KlassDao klassDao, TeamDAO teamDAO, KlassSeminarDAO klassSeminarDAO, AttendanceDAO attendanceDAO) {
        this.studentDAO = studentDAO;
        this.courseDAO = courseDAO;
        this.klassDao = klassDao;
        this.teamDAO = teamDAO;
        this.klassSeminarDAO = klassSeminarDAO;
        this.attendanceDAO = attendanceDAO;
    }

    @Override
    public boolean activate(String studentId, String password, String email) {
        Student student = studentDAO.getById(studentId).get(0);
        student.setPassword(password);
        student.setEmail(email);
        student.setActivated(true);
        studentDAO.update(student);
        return true;
    }

    @Override
    public boolean modifyEmail(String studentId, String email) {
        List<Student> students = studentDAO.getById(studentId);
        if(students.isEmpty()){
            return false;
        }
        Student student = students.get(0);
        student.setEmail(email);
        studentDAO.update(student);
        return true;
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
     * @author Cesare
     */
    @Override
    public boolean modifyPasswordViaId(String studentId, String password) {
        List<Student> students = studentDAO.getById(studentId);
        if (students.isEmpty()) {
            return false;
        }
        Student student = students.get(0);
        student.setPassword(password);
        studentDAO.update(student);
        return true;
    }

    @Override
    public List<Course> getCoursesByStudentId(String studentId) {
        return courseDAO.getByStudentId(studentId);
    }

    @Override
    public List<Klass> getKlassesByStudentId(String studentId) {
        return klassDao.getByStudentId(studentId);
    }

    @Override
    public boolean seminarEnroll(String ksId, String teamId, int sn) {
        List<Attendance> enrollList = klassSeminarDAO.getEnrollList(ksId);
        DebugLogger.log(teamId);
        DebugLogger.log(sn);
        for (Attendance attendance : enrollList) {
            if(attendance == null){
                continue;
            }
            if(attendance.getTeam().getId().equals(teamId) || attendance.getSn() == sn){
                return false;
            }
        }
        Attendance attendance = new Attendance();
        attendance.setKlassSeminarId(ksId);
        attendance.setPresenting(false);
        attendance.setSn(sn);
        attendance.setTeamId(teamId);
        attendanceDAO.create(attendance);
        return true;
    }

    @Override
    public void uploadPreFile(String attendanceId, String preFileName) {
        Attendance attendance = attendanceDAO.getById(attendanceId).get(0);
        attendance.setPreFile(preFileName);
        attendanceDAO.update(attendance);
    }

    /**
     * @author Xinyu Shi
     */


    @Override
    public List<Team> getAllTeamInformation(String courseId)
    {
        return teamDAO.getCourseTeamsByCourseId(courseId);
    }

    @Override
    public List<Student> getAllUnTeamedStudentsByCourseId(String courseId)
    {
        return studentDAO.studentsUnTeamed(courseId);
    }

    @Override
    public void exitTeam(String studentId, String teamId)
    {
        studentDAO.deleteStudentFromTeamStudent(studentId);
        /**
         * TODO: judge whether the team id valid or not.
         */
    }
}

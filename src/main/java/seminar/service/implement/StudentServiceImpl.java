package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.*;
import seminar.entity.Attendance;
import seminar.entity.Student;
import seminar.entity.Team;
import seminar.pojo.enumration.TeamStatus;
import seminar.service.StrategyService;
import seminar.service.StudentService;

import java.util.Date;
import java.util.List;

/**
 * @author Xinyu Shi
 */
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentDAO studentDAO;
    private final TeamDAO teamDAO;
    private final CourseDAO courseDAO;
    private final KlassSeminarDAO klassSeminarDAO;
    private final AttendanceDAO attendanceDAO;
    private final StrategyService strategyService;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO, TeamDAO teamDAO, CourseDAO courseDAO, KlassSeminarDAO klassSeminarDAO, AttendanceDAO attendanceDAO, StrategyService strategyService) {
        this.studentDAO = studentDAO;
        this.teamDAO = teamDAO;
        this.courseDAO = courseDAO;
        this.klassSeminarDAO = klassSeminarDAO;
        this.attendanceDAO = attendanceDAO;
        this.strategyService = strategyService;
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
        if (students.isEmpty()) {
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

    /**
     * @author Cesare
     */
    @Override
    public boolean enrollSeminar(String ksId, String teamId, int sn) {
        List<Attendance> enrollList = attendanceDAO.getEnrollList(ksId);
        for (Attendance attendance : enrollList) {
            if (attendance == null) {
                continue;
            }
            if (attendance.getTeam().getId().equals(teamId) || attendance.getSn() == sn) {
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
    public void cancelEnroll(String attendanceId) {
        attendanceDAO.deleteById(attendanceId);
    }

    /**
     * @author Cesare
     */
    @Override
    public void uploadPreFile(String attendanceId, String preFileName) {
        Attendance attendance = attendanceDAO.getById(attendanceId).get(0);
        attendance.setPreFile(preFileName);
        attendanceDAO.update(attendance);
    }

    /**
     * @author Cesare
     */
    @Override
    public void uploadReportFile(String attendanceId, String reportFileName) {
        Attendance attendance = attendanceDAO.getById(attendanceId).get(0);
        attendance.setReportFile(reportFileName);
        attendanceDAO.update(attendance);
    }

    /**
     * @author Xinyu Shi
     */
    @Override
    public boolean createTeam(Team team) {
        Date teamEndDate = courseDAO.getByCourseId(team.getCourseId()).get(0).getTeamEndDate();
        if (new Date().compareTo(teamEndDate) > 0) {
            return false;
        }
        team.setStatus(TeamStatus.Valid.getStatus());
        teamDAO.create(team);
        team = teamDAO.getById(team.getId()).get(0);
        strategyService.handleVariation(team);
        teamDAO.update(team);
        return true;
    }

    @Override
    public boolean updateTeam(Team team) {
        return teamDAO.update(team);
    }

    /**
     * @author Xinyu Shi
     */
    @Override
    public boolean addTeamMember(String studentId, String teamId) {
        Team team = teamDAO.getById(teamId).get(0);
        if (team.getStatus() == TeamStatus.Checking.getStatus()) {
            return false;
        }
        if (studentDAO.studentHasAlreadyTeamed(studentId, team.getCourseId())) {
            return false;
        }
        studentDAO.insertStudentIntoTeamStudent(studentId, teamId);
        strategyService.handleVariation(team);
        teamDAO.update(team);
        return true;
    }

    /**
     * @author Xinyu Shi
     */
    @Override
    public boolean deleteTeamMember(String studentId, String teamId) {
        Team team = teamDAO.getById(teamId).get(0);
        if (team.getStatus() == TeamStatus.Checking.getStatus()) {
            return false;
        }
        studentDAO.deleteStudentFromTeamStudent(teamId, studentId);
        strategyService.handleVariation(team);
        teamDAO.update(team);
        return true;
    }

    /**
     * @author Xinyu Shi
     */
    @Override
    public void dissolveTeam(String teamId) {
        List<Student> students = teamDAO.getStudentsByTeamId(teamId);
        for (Student student : students) {
            studentDAO.deleteStudentFromTeamStudent(teamId, student.getId());
        }
        teamDAO.deleteById(teamId);
    }
}


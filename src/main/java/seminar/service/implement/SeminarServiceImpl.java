package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.*;
import seminar.entity.*;
import seminar.service.SeminarService;

import java.util.List;

/**
 * @author Cesare
 */
@Service
public class SeminarServiceImpl implements SeminarService {
    private final CourseDAO courseDAO;
    private final ClbumDao clbumDao;
    private final TeamDAO teamDAO;
    private final RoundDAO roundDAO;
    private final SeminarDAO seminarDAO;
    private final ClbumSeminarDAO clbumSeminarDAO;
    private final AttendanceDAO attendanceDAO;
    private final TeamStudentDAO teamStudentDAO;
    private final StudentDAO studentDAO;

    @Autowired
    public SeminarServiceImpl(CourseDAO courseDAO, ClbumDao clbumDao, TeamDAO teamDAO, RoundDAO roundDAO, SeminarDAO seminarDAO, ClbumSeminarDAO clbumSeminarDAO, AttendanceDAO attendanceDAO, TeamStudentDAO teamStudentDAO, StudentDAO studentDAO) {
        this.courseDAO = courseDAO;
        this.clbumDao = clbumDao;
        this.teamDAO = teamDAO;
        this.roundDAO = roundDAO;
        this.seminarDAO = seminarDAO;
        this.clbumSeminarDAO = clbumSeminarDAO;
        this.attendanceDAO = attendanceDAO;
        this.teamStudentDAO = teamStudentDAO;
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Clbum> getClbumByCourseId(String courseId) {
        return clbumDao.getByCourseId(courseId);
    }

    @Override
    public List<Team> getTeamsByCourseId(String courseId) {
        return teamDAO.getByCourseId(courseId);
    }

    @Override
    public List<Round> getRoundsByCourseId(String courseId) {
        return roundDAO.getByCourseId(courseId);
    }

    @Override
    public List<Seminar> getSeminarsByRoundId(String roundId) {
        return seminarDAO.getByRoundId(roundId);
    }

    @Override
    public List<ClbumSeminar> getClbumSeminarByClbumIdAndSeminarId(String clbumId, String seminarId){
        return clbumSeminarDAO.getByClbumIdAndSeminarId(clbumId,seminarId);
    }

    @Override
    public List<ClbumSeminar> getClbumSeminarByClbumSeminarId(String clbumSeminarId) {
        return clbumSeminarDAO.getClbumSeminarByClbumSeminarId(clbumSeminarId);
    }

    @Override
    public List<Seminar> getSeminarBySeminarId(String seminarId) {
        return seminarDAO.getBySeminarId(seminarId);
    }

    @Override
    public List<Attendance> getAttendancesByClbumSeminarId(String clbumSeminarId) {
        return attendanceDAO.getAttendanceByClbumSeminarId(clbumSeminarId);
    }

    @Override
    public List<Course> getCourseByCourseId(String courseId) {
        return courseDAO.getByCourseId(courseId);
    }

    /**
     * @author SWJ
     */
    @Override
    public List<Student> getStudentWithoutTeam(String courseId){
        return studentDAO.getStudentWithoutTeamByCourseId(courseId);
    }
}

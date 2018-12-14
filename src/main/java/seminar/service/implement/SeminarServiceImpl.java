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
    private final KlassDao klassDao;
    private final TeamDAO teamDAO;
    private final RoundDAO roundDAO;
    private final SeminarDAO seminarDAO;
    private final KlassSeminarDAO klassSeminarDAO;
    private final AttendanceDAO attendanceDAO;
    private final StudentDAO studentDAO;

    @Autowired
    public SeminarServiceImpl(CourseDAO courseDAO, KlassDao klassDao, TeamDAO teamDAO, RoundDAO roundDAO, SeminarDAO seminarDAO, KlassSeminarDAO klassSeminarDAO, AttendanceDAO attendanceDAO, StudentDAO studentDAO) {
        this.courseDAO = courseDAO;
        this.klassDao = klassDao;
        this.teamDAO = teamDAO;
        this.roundDAO = roundDAO;
        this.seminarDAO = seminarDAO;
        this.klassSeminarDAO = klassSeminarDAO;
        this.attendanceDAO = attendanceDAO;
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Klass> getKlassByCourseId(String courseId) {
        return klassDao.getByCourseId(courseId);
    }

    @Override
    public List<Team> getTeamsByCourseId(String courseId) {
        return teamDAO.getCourseTeamsByCourseId(courseId);
    }

    @Override
    public List<Round> getRoundsByCourseId(String courseId) {
        return roundDAO.getByCourseId(courseId);
    }

    @Override
    public List<Attendance> getEnrollListByKsId(String ksId) {
        return klassSeminarDAO.getEnrollList(ksId);
    }

    @Override
    public List<Seminar> getSeminarsByRoundId(String roundId) {
        return seminarDAO.getByRoundId(roundId);
    }

    @Override
    public List<KlassSeminar> getKlassSeminarByKlassIdAndSeminarId(String klassId, String seminarId) {
        return klassSeminarDAO.getByKlassIdAndSeminarId(klassId, seminarId);
    }

    @Override
    public List<KlassSeminar> getKlassSeminarByKlassSeminarId(String klassSeminarId) {
        return klassSeminarDAO.getByKlassSeminarId(klassSeminarId);
    }

    @Override
    public List<Seminar> getSeminarBySeminarId(String seminarId) {
        return seminarDAO.getBySeminarId(seminarId);
    }

    @Override
    public List<Attendance> getAttendancesByKlassSeminarId(String klassSeminarId) {
        return attendanceDAO.getAttendanceByKlassSeminarId(klassSeminarId);
    }

    @Override
    public List<Course> getCourseByCourseId(String courseId) {
        return courseDAO.getByCourseId(courseId);
    }
}

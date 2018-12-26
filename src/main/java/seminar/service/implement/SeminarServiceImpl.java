package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.*;
import seminar.entity.*;
import seminar.entity.relation.KlassRound;
import seminar.service.SeminarService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private final KlassRoundDAO klassRoundDAO;

    @Autowired
    public SeminarServiceImpl(CourseDAO courseDAO, KlassDao klassDao, TeamDAO teamDAO, RoundDAO roundDAO, SeminarDAO seminarDAO, KlassSeminarDAO klassSeminarDAO, AttendanceDAO attendanceDAO, StudentDAO studentDAO, KlassRoundDAO klassRoundDAO) {
        this.courseDAO = courseDAO;
        this.klassDao = klassDao;
        this.teamDAO = teamDAO;
        this.roundDAO = roundDAO;
        this.seminarDAO = seminarDAO;
        this.klassSeminarDAO = klassSeminarDAO;
        this.attendanceDAO = attendanceDAO;
        this.studentDAO = studentDAO;
        this.klassRoundDAO = klassRoundDAO;
    }

    @Override
    public List<Course> getCourseByCourseId(String courseId) {
        return courseDAO.getByCourseId(courseId);
    }


    @Override
    public List<Course> getCoursesByTeacherId(String teacherId) {
        return courseDAO.getByTeacherId(teacherId);
    }

    @Override
    public List<Course> getOtherCoursesByCourseId(String courseId) {
        return courseDAO.getCanShareCoursesByCourseId(courseId);
    }

    @Override
    public Map<String, List<Course>> getMainCoursesByCourseId(String courseId) {
        Course course = courseDAO.getByCourseId(courseId).get(0);
        Map<String, List<Course>> mainCourses = new HashMap<>(2);
        mainCourses.put("team", courseDAO.getByCourseId(course.getTeamMainCourseId()));
        mainCourses.put("seminar", courseDAO.getByCourseId(course.getSeminarMainCourseId()));
        return mainCourses;
    }

    @Override
    public Map<String, List<Course>> getSubCoursesByCourseId(String courseId) {
        Map<String, List<Course>> mainCourses = new HashMap<>(2);
        mainCourses.put("team", courseDAO.getSubCourseOfTeamShare(courseId));
        mainCourses.put("seminar", courseDAO.getSubCourseOfSeminarShare(courseId));
        return mainCourses;
    }

    @Override
    public List<Team> getTeamsByCourseId(String courseId) {
        return teamDAO.getOwnStudentsTeamByCourseId(courseId);
    }

    @Override
    public Team getTeamByCourseIdAndStudentId(String courseId, String studentId) {
        return teamDAO.getByCourseIdAndStudentId(courseId, studentId);
    }

    @Override
    public Team getTeamByTeamId(String teamId) {
        return teamDAO.getById(teamId).get(0);
    }

    @Override
    public Team getTeamByCourseIdAndTeamId(String courseId, String teamId) {
        return teamDAO.getOwnStudentTeamByCourseIdAndTeamId(courseId, teamId);
    }

    @Override
    public List<Student> getNotTeamedStudentsByCourseId(String courseId) {
        return studentDAO.getNotTeamedStudentsByCourseId(courseId);
    }

    @Override
    public List<Round> getRoundsByCourseId(String courseId) {
        Course course = courseDAO.getByCourseId(courseId).get(0);
        if (course.getSeminarMainCourseId() == null) {
            return roundDAO.getByCourseId(courseId);
        } else {
            return roundDAO.getByCourseId(course.getSeminarMainCourseId());
        }
    }

    @Override
    public List<Round> getRoundByRoundId(String roundId) {
        return roundDAO.getByRoundId(roundId);
    }

    @Override
    public int getMaxSeminarSerialByCourseId(String courseId) {
        return seminarDAO.getMaxSeminarSerial(courseId);
    }

    @Override
    public List<Attendance> getAttendanceById(String id) {
        return attendanceDAO.getById(id);
    }

    @Override
    public List<Attendance> getAttendanceByTeamIdAndKlassSeminarId(String teamId, String ksId) {
        return attendanceDAO.getByTeamIdAndKlassSeminarId(teamId, ksId);
    }

    @Override
    public List<Attendance> getAttendanceByKsId(String ksId) {
        return attendanceDAO.getByKlassSeminarId(ksId);
    }

    @Override
    public List<Klass> getKlassByCourseId(String courseId) {
        return klassDao.getByCourseId(courseId);
    }

    @Override
    public List<Klass> getKlassesByStudentId(String studentId) {
        return klassDao.getByStudentId(studentId);
    }

    @Override
    public List<Klass> getKlassById(String klassId) {
        return klassDao.getById(klassId);
    }

    @Override
    public List<Attendance> getEnrollListByKsId(String ksId) {
        return klassSeminarDAO.getEnrollList(ksId);
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
    public List<KlassRound> getKlassRoundsByKlassIdAndRoundId(String klassId, String roundId) {
        List<KlassRound> klassRounds = klassRoundDAO.getByKlassIdAndRoundId(klassId,roundId);
        if(klassRounds.size() == 0){
            KlassRound klassRound = new KlassRound();
            klassRound.setEnrollLimit(1);
            klassRound.setKlassId(klassId);
            klassRound.setRoundId(roundId);
            klassRoundDAO.insert(klassRound);
            klassRounds.add(klassRound);
        }
        return klassRounds;
    }
}

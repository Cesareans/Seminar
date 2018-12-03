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
    private final ClbumDao clbumDao;
    private final TeamDAO teamDAO;
    private final RoundDAO roundDAO;
    private final SeminarDAO seminarDAO;
    private final ClbumSeminarDAO clbumSeminarDAO;
    private final AttendanceDAO attendanceDAO;

    @Autowired
    public SeminarServiceImpl(ClbumDao clbumDao, TeamDAO teamDAO, RoundDAO roundDAO, SeminarDAO seminarDAO, ClbumSeminarDAO clbumSeminarDAO, AttendanceDAO attendanceDAO) {
        this.clbumDao = clbumDao;
        this.teamDAO = teamDAO;
        this.roundDAO = roundDAO;
        this.seminarDAO = seminarDAO;
        this.clbumSeminarDAO = clbumSeminarDAO;
        this.attendanceDAO = attendanceDAO;
    }

    @Override
    public List<Clbum> getClbumByCourseId(String courseId) {
        return clbumDao.getClbumsByCourseId(courseId);
    }

    @Override
    public List<Team> getTeamsByCourseId(String courseId) {
        return teamDAO.getTeamsByCourseId(courseId);
    }

    @Override
    public List<Round> getRoundsByCourseId(String courseId) {
        return roundDAO.getRoundsByCourseId(courseId);
    }

    @Override
    public List<Seminar> getSeminarsByRoundId(String roundId) {
        return seminarDAO.getSeminarsByRoundId(roundId);
    }

    @Override
    public List<ClbumSeminar> getClbumSeminarByClbumIdAndSeminarId(String clbumId, String seminarId){
        return clbumSeminarDAO.getClbumSeminarByClbumIdAndSeminarId(clbumId,seminarId);
    }

    @Override
    public List<Attendance> getAttendancesByClbumSeminarId(String clbumSeminarId) {
        return attendanceDAO.getAttendanceByClbumSeminarId(clbumSeminarId);
    }



}

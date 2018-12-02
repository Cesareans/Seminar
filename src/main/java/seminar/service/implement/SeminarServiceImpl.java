package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.ClbumDao;
import seminar.dao.RoundDAO;
import seminar.dao.SeminarDAO;
import seminar.dao.TeamDAO;
import seminar.entity.Clbum;
import seminar.entity.Round;
import seminar.entity.Seminar;
import seminar.entity.Team;
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

    @Autowired
    public SeminarServiceImpl(ClbumDao clbumDao, TeamDAO teamDAO, RoundDAO roundDAO, SeminarDAO seminarDAO) {
        this.clbumDao = clbumDao;
        this.teamDAO = teamDAO;
        this.roundDAO = roundDAO;
        this.seminarDAO = seminarDAO;
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
}

package seminar.service;

import seminar.entity.Clbum;
import seminar.entity.Round;
import seminar.entity.Seminar;
import seminar.entity.Team;

import java.util.List;

public interface SeminarService {

    /**
     * Get a course's clbums via courseId
     *
     * @param courseId refer gist
     * @return list of course's clbums
     */
    public List<Clbum> getClbumByCourseId(String courseId);

    /**
     * TODO:Write Javadoc
     *
     * @param courseId
     * @return
     */
    public List<Team> getTeamsByCourseId(String courseId);

    public List<Round> getRoundsByCourseId(String courseId);

    public List<Seminar> getSeminarsByRoundId(String roundId);

}

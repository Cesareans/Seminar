package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.*;
import seminar.entity.*;
import seminar.mapper.MaxMinRegulationMapper;
import seminar.service.TeacherService;

import java.util.List;

/**
 * @author Cesare
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    private final SeminarDAO seminarDAO;
    private final ClbumDao clbumDAO;
    private final MaxMinRegulationDAO maxMinRegulationDAO;
    private TeacherDAO teacherDAO;
    private final CourseDAO courseDAO;
    private final TeamShareMsgDAO teamShareMsgDAO;
    private final TeamShareDAO teamShareDAO;
    private final GroupValidityMsgDAO groupValidityMsgDAO;
    private final TeamDAO teamDAO;

    @Autowired
    public TeacherServiceImpl(TeacherDAO teacherDAO, CourseDAO courseDAO, ClbumDao clbumDAO, SeminarDAO seminarDAO, MaxMinRegulationDAO maxMinRegulationDAO, TeamShareMsgDAO teamShareMsgDAO, TeamShareDAO teamShareDAO, GroupValidityMsgDAO groupValidityMsgDAO, TeamDAO teamDAO) {
        this.teacherDAO = teacherDAO;
        this.courseDAO = courseDAO;
        this.seminarDAO = seminarDAO;
        this.clbumDAO = clbumDAO;
        this.maxMinRegulationDAO = maxMinRegulationDAO;
        this.teamShareMsgDAO = teamShareMsgDAO;
        this.teamShareDAO = teamShareDAO;
        this.groupValidityMsgDAO = groupValidityMsgDAO;
        this.teamDAO = teamDAO;
    }

    @Override
    public List<Teacher> getTeacherByTN(String teacherNum) {
        return teacherDAO.getByTN(teacherNum);
    }

    @Override
    public List<Course> getCoursesByTeacherId(String teacherId) {
        return courseDAO.getByTeacherId(teacherId);
    }


    /**
     * @author lyf
     */
    @Override
    public boolean createCourse(Course course, MaxMinRegulation maxMinRegulation) {
        return courseDAO.create(course, maxMinRegulation);
    }

    /**
     * @author lyf
     */
    @Override
    public void deleteCourseById(String courseId) {
        courseDAO.deleteByCourseId(courseId);
    }

    /**
     * @author lyf
     */
    @Override
    public boolean updateCourse(Course course, MaxMinRegulation maxMinRegulation) {
        return courseDAO.update(course, maxMinRegulation);
    }

    /**
     * @author lyf
     */
    @Override
    public boolean createClbum(Clbum clbum) {
        return clbumDAO.create(clbum);
    }

    /**
     * @author lyf
     */
    @Override
    public boolean updateClbum(Clbum clbum) {
        return clbumDAO.update(clbum);
    }

    /**
     * @author lyf
     */
    @Override
    public void deleteClbumById(String clbumId) {
        clbumDAO.deleteById(clbumId);
    }

    /**
     * @author lyf
     */
    @Override
    public boolean createSeminar(Seminar seminar) {
        return seminarDAO.create(seminar);
    }

    /**
     * @author lyf
     */
    @Override
    public boolean updateSeminar(Seminar seminar) {
        return seminarDAO.update(seminar);
    }

    /**
     * @author lyf
     */
    @Override
    public void deleteSeminarByRoundId(String roundId) {
        seminarDAO.deleteByRoundId(roundId);
    }

    /**
     * @author SWJ
     */
    @Override
    public boolean createTeamShareMsg(TeamShareMsg teamShareMsg){
        return teamShareMsgDAO.create(teamShareMsg);
    }

    /**
     * @author SWJ
     */
    @Override
    public boolean createTeamShare(TeamShare teamShare){
        return teamShareDAO.create(teamShare);
    }

    /**
     * @author SWJ
     */
    @Override
    public void deleteTeamShare(String id){
        teamShareDAO.deleteById(id);
    }

    /**
     * @author SWJ
     */
    @Override
    public List<GroupValidityMsg> getGroupValidityMsgByTeacherId(String teacherId){
        return groupValidityMsgDAO.getByTeacherId(teacherId);
    }

    /**
     * @author SWJ
     */
    @Override
    public boolean updateTeam(Team team){
        return teamDAO.update(team);
    }
}

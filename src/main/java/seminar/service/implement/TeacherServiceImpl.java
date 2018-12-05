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

    @Autowired
    public TeacherServiceImpl(TeacherDAO teacherDAO, CourseDAO courseDAO, ClbumDao clbumDAO, SeminarDAO seminarDAO, MaxMinRegulationDAO maxMinRegulationDAO) {
        this.teacherDAO = teacherDAO;
        this.courseDAO = courseDAO;
        this.seminarDAO = seminarDAO;
        this.clbumDAO = clbumDAO;
        this.maxMinRegulationDAO = maxMinRegulationDAO;
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

}

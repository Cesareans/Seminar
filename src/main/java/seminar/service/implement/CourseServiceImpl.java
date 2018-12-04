package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import seminar.dao.ClbumDao;
import seminar.dao.CourseDAO;
import seminar.dao.SeminarDAO;
import seminar.dao.MaxMinRegulationDAO;
import seminar.entity.Clbum;
import seminar.entity.Course;
import seminar.entity.MaxMinRegulation;
import seminar.entity.Seminar;
import seminar.service.CourseService;
import seminar.entity.MaxMinRegulation;

public class CourseServiceImpl implements CourseService {

    private final CourseDAO courseDAO;
    private final ClbumDao clbumDAO;
    private final SeminarDAO seminarDAO;
    private final MaxMinRegulationDAO maxminregualtionDAO;

    @Autowired
    public CourseServiceImpl(CourseDAO courseDAO, ClbumDao clbumDAO, SeminarDAO seminarDAO, MaxMinRegulationDAO maxminregulationDAO){
        this.courseDAO = courseDAO;
        this.clbumDAO = clbumDAO;
        this.seminarDAO = seminarDAO;
        this.maxminregualtionDAO = maxminregulationDAO;
    }
    /**
     * @author lyf
     */
    @Override
    public void createCourse(Course course, MaxMinRegulation maxminregulation) {
        courseDAO.createCourse(course);
        maxminregulationDAO.insertMaxMinRegulation(maxminregulation);
    }

    /**
     * @author lyf
     */
    @Override
    public void deleteCourseById(String courseId){
        courseDAO.deleteCourseById(courseId);
    }

    /**
     * @author lyf
     */
    @Override
    public void updateCourse(Course course){
        courseDAO.updateCourseById(course);
    }

    /**
     * @author lyf
     */
    @Override
    public void createClbum(Clbum clbum){
        clbumDAO.createClbum(clbum);
    }

    /**
     * @author lyf
     */
    @Override
    public void updateClbum(Clbum clbum){
        clbumDAO.updateClbum(clbum);
    }

    /**
     * @author lyf
     */
    @Override
    public void deleteClbumById(String clbumId){
        clbumDAO.deleteClbumById(clbumId);
    }


    /**
     * @author lyf
     */
    @Override
    public void createSeminar(Seminar seminar){
        seminarDAO.createSeminar(seminar);
    }

    /**
     * @author lyf
     */
    @Override
    public void updateSeminar(Seminar seminar){
        seminarDAO.updateSeminar(seminar);
    }

    /**
     * @author lyf
     */
    @Override
    public void deleteSeminarByCourseId(String courseId){
        seminarDAO.deleteSeminarByCourseId(courseId);
    }

}

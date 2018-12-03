package seminar.service;

import seminar.entity.Clbum;
import seminar.entity.Course;
import seminar.entity.Seminar;

public interface CourseService {

    /**
     * @author lyf
     */
    public void createCourse(Course course);

    /**
     * @author lyf
     */
    public void deleteCourseById(String courseId);

    /**
     * @author lyf
     */
    public void updateCourse(Course course);

    /**
     * @author lyf
     */
    public void createClbum(Clbum clbum);

    /**
     * @author lyf
     */
    public void updateClbum(Clbum clbum);

    /**
     * @author lyf
     */
    public void deleteClbumById(String clbumId);

    /**
     * @author lyf
     */
    public void createSeminar(Seminar seminar);

    /**
     * @author lyf
     */
    public void updateSeminar(Seminar seminar);

    /**
     * @author lyf
     */
    public void deleteSeminarByCourseId(String courseId);

}

package seminar.service;

import seminar.entity.*;

import java.util.List;

/**
 * @author Cesare
 */
public interface TeacherService {
    /**
     * Get the teacher entity via teacherNum
     *
     * @param teacherNum refer gist
     * @return teacher entity
     */
    public List<Teacher> getTeacherByTN(String teacherNum);

    /**
     * TODO:May not be useful. Can be deleted afterwards
     * Get a teacher's courses via teacherId
     *
     * @param teacherId refer gist
     * @return list of teacher's courses
     */
    public List<Course> getCoursesByTeacherId(String teacherId);

    /**
     * @author lyf
     */
    public boolean createCourse(Course course, MaxMinRegulation maxminregulation);

    /**
     * @author lyf
     */
    public boolean deleteCourseById(String courseId);

    /**
     * @author lyf
     */
    public boolean updateCourse(Course course);

    /**
     * @author lyf
     */
    public boolean createClbum(Clbum clbum);

    /**
     * @author lyf
     */
    public boolean updateClbum(Clbum clbum);

    /**
     * @author lyf
     */
    public boolean deleteClbumById(String clbumId);

    /**
     * @author lyf
     */
    public boolean createSeminar(Seminar seminar);

    /**
     * @author lyf
     */
    public boolean updateSeminar(Seminar seminar);

    /**
     * @author lyf
     */
    public boolean deleteSeminarByRoundId(String courseId);

}

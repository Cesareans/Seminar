package seminar.service;

import seminar.entity.Clbum;
import seminar.entity.Course;
import seminar.entity.Teacher;

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

}

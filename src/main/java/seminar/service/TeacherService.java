package seminar.service;

import seminar.entity.Teacher;

import java.util.List;

/**
 * @author Cesare
 */
public interface TeacherService {
    /**
     * TODO:Write Javadoc
     *
     * @param teacherNum
     * @return
     */
    public List<Teacher> getTeacherByTN(String teacherNum);
}

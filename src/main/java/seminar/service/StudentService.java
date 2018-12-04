package seminar.service;

import seminar.entity.Student;

import java.util.List;

/**
 * @author Cesare
 */
public interface StudentService {
    /**
     * TODO:Write Javadoc
     *
     * @param studentNum
     * @return
     */
    public List<Student> getStudentBySN(String studentNum);

}

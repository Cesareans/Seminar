package seminar.service;

import seminar.entity.Student;
import seminar.entity.Teacher;
import seminar.entity.vo.StudentFilter;
import seminar.entity.vo.TeacherFilter;

import java.util.List;

/**
 * @author Cesare
 */
public interface AccountManageService {
    /**
     * TODO:Write Javadoc
     *
     * @param filter
     * @return
     */
    List<Student> getStudentsByFilter(StudentFilter filter);

    /**
     * TODO:Write Javadoc
     *
     * @param sn student'num
     * @return void
     */
    List<Student> getStudentBySN(String sn);

    List<Student> getStudentById(String id);

    boolean addStudent(Student student);

    boolean updateStudent(Student student);

    boolean deleteStudentBySN(String sn);

    boolean studentModifyPassword(String sn, String password);

    boolean studentResetPassword(String sn);

    List<Teacher> getTeachersByFilter(TeacherFilter filter);
    /**
     * Get the teacher entity via teacherNum
     *
     * @param tn refer gist
     * @return teacher entity
     */
    List<Teacher> getTeacherByTN(String tn);

    List<Teacher> getTeacherById(String id);

    boolean addTeacher(Teacher teacher);

    boolean updateTeacher(Teacher teacher);

    boolean deleteTeacherByTN(String tn);

    boolean teacherModifyPassword(String tn, String password);

    boolean teacherResetPassword(String tn);
}

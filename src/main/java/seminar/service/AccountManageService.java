package seminar.service;

import seminar.entity.Student;
import seminar.entity.Teacher;
import seminar.entity.view.StudentFilter;
import seminar.entity.view.TeacherFilter;

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
    public List<Student> getStudentsByFilter(StudentFilter filter);

    public boolean addStudent(Student student);

    public boolean updateStudent(Student student);

    public boolean deleteStudentByStuNum(String stuNum);

    public boolean studentResetPassword(String stuNum);

    public List<Teacher> getTeachersByFilter(TeacherFilter filter);

    public boolean addTeacher(Teacher teacher);

    public boolean updateTeacher(Teacher teacher);

    public boolean deleteByTeacherNum(String teacherNum);

    public boolean teacherResetPassword(String teacherNum);
}

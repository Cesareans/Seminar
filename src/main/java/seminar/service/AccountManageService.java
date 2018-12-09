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
     * Get students via given filter
     *
     * @author cesare
     * @param filter the refer filter
     * @return a list that contains the students under filter
     */
    List<Student> getStudentsByFilter(StudentFilter filter);

    /**
     * Get student via student num
     *
     * @author cesare
     * @param sn student num
     * @return a list that contains the student with the student num
     */
    List<Student> getStudentBySN(String sn);

    /**
     * Get student via student account id
     *
     * @author cesare
     * @param id student account id
     * @return a list contains the student with the student account id
     */
    List<Student> getStudentById(String id);

    /**
     * Add a student into database.
     * The student's default password is configured in seminar.config.SeminarConfig
     * The student's default activation is set as false
     *
     * @author cesare
     * @param student the entity that will be added into database
     * @return whether the operation is success
     */
    boolean addStudent(Student student);

    /**
     * Update student in database.
     * This method will not change the student's password and activation.
     *
     * @author cesare
     * @param student the entity that will be updated in database
     * @return whether the operation is success
     */
    boolean updateStudent(Student student);

    /**
     * Delete student in database.
     *
     * @author cesare
     * @param sn delete refer gist
     * @return whether the operation is success
     */
    boolean deleteStudentBySN(String sn);

    /**
     * Modify a student's password when he/she forget his/her password
     *
     * @author cesare
     * @param sn the student num
     * @param password the new password
     * @return  whether the operation is success
     */
    boolean studentModifyPassword(String sn, String password);

    /**
     * Reset a student password to default password.
     * The student's default password is configured in seminar.config.SeminarConfig
     *
     * @author cesare
     * @param sn the student num
     * @return whether the operation is success
     */
    boolean studentResetPassword(String sn);

    /**
     * Get teachers via given filter
     *
     * @author cesare
     * @param filter the refer filter
     * @return a list that contains the teachers under filter
     */
    List<Teacher> getTeachersByFilter(TeacherFilter filter);

    /**
     * Get teacher via teacher num
     *
     * @author cesare
     * @param tn refer gist
     * @return a list that contains the teacher with the teacher num
     */
    List<Teacher> getTeacherByTN(String tn);

    /**
     * Get teacher via teacher account id
     *
     * @author cesare
     * @param id teacher account id
     * @return a list that contains the teacher with the teacher account id
     */
    List<Teacher> getTeacherById(String id);

    /**
     * Add a teacher into database.
     * The teacher's default password is configured in seminar.config.SeminarConfig
     * The teacher's default activation is set as false
     *
     * @author cesare
     * @param teacher the entity that will be added into database
     * @return whether the operation is success
     */
    boolean addTeacher(Teacher teacher);

    /**
     * Update teacher in database.
     * This method will not change the teacher's password and activation.
     *
     * @author cesare
     * @param teacher the entity that will be updated in database
     * @return whether the operation is success
     */
    boolean updateTeacher(Teacher teacher);

    /**
     * Delete teacher in database.
     *
     * @author cesare
     * @param tn delete refer gist
     * @return whether the operation is success
     */
    boolean deleteTeacherByTN(String tn);

    /**
     * Modify a teacher's password when he/she forget his/her password
     *
     * @author cesare
     * @param tn the teacher num
     * @param password the new password
     * @return whether the operation is success
     */
    boolean teacherModifyPassword(String tn, String password);

    /**
     * Reset a teacher password to default password.
     * The teacher's default password is configured in seminar.config.SeminarConfig
     *
     * @author cesare
     * @param tn the student num
     * @return whether the operation is success
     */
    boolean teacherResetPassword(String tn);
}

package seminar.service;

import seminar.entity.Student;
import seminar.entity.Teacher;
import seminar.pojo.dto.StudentFilter;
import seminar.pojo.dto.TeacherFilter;

import java.util.List;

/**
 * @author Cesare
 */
public interface AccountManageService {
    /**
     * Get students via given filter
     *
     * @param filter the refer filter
     * @return a list that contains the students under filter
     * @author cesare
     */
    List<Student> getStudentsByFilter(StudentFilter filter);

    /**
     * Get student via student num
     *
     * @param sn student num
     * @return a list that contains the student with the student num
     * @author cesare
     */
    List<Student> getStudentBySN(String sn);

    /**
     * Get student via student account id
     *
     * @param id student account id
     * @return a list contains the student with the student account id
     * @author cesare
     */
    List<Student> getStudentById(String id);

    /**
     * Add a student into database.
     * The student's default password is configured in seminar.config.SeminarConfig
     * The student's default activation is set as false
     *
     * @param student the entity that will be added into database
     * @return whether the operation is success
     * @author cesare
     */
    boolean addStudent(Student student);

    /**
     * Update student in database.
     * This method will not change the student's password and activation.
     *
     * @param student the entity that will be updated in database
     * @return whether the operation is success
     * @author cesare
     */
    boolean updateStudent(Student student);

    /**
     * Delete student in database.
     *
     * @param sn delete refer gist
     * @return whether the operation is success
     * @author cesare
     */
    boolean deleteStudentBySN(String sn);


    /**
     * Reset a student password to default password.
     * The student's default password is configured in seminar.config.SeminarConfig
     *
     * @param sn the student num
     * @return whether the operation is success
     * @author cesare
     */
    boolean studentResetPassword(String sn);

    /**
     * Get teachers via given filter
     *
     * @param filter the refer filter
     * @return a list that contains the teachers under filter
     * @author cesare
     */
    List<Teacher> getTeachersByFilter(TeacherFilter filter);

    /**
     * Get teacher via teacher num
     *
     * @param tn refer gist
     * @return a list that contains the teacher with the teacher num
     * @author cesare
     */
    List<Teacher> getTeacherByTN(String tn);

    /**
     * Get teacher via teacher account id
     *
     * @param id teacher account id
     * @return a list that contains the teacher with the teacher account id
     * @author cesare
     */
    List<Teacher> getTeacherById(String id);

    /**
     * Add a teacher into database.
     * The teacher's default password is configured in seminar.config.SeminarConfig
     * The teacher's default activation is set as false
     *
     * @param teacher the entity that will be added into database
     * @return whether the operation is success
     * @author cesare
     */
    boolean addTeacher(Teacher teacher);

    /**
     * Update teacher in database.
     * This method will not change the teacher's password and activation.
     *
     * @param teacher the entity that will be updated in database
     * @return whether the operation is success
     * @author cesare
     */
    boolean updateTeacher(Teacher teacher);

    /**
     * Delete teacher in database.
     *
     * @param tn delete refer gist
     * @return whether the operation is success
     * @author cesare
     */
    boolean deleteTeacherByTN(String tn);


    /**
     * Reset a teacher password to default password.
     * The teacher's default password is configured in seminar.config.SeminarConfig
     *
     * @param tn the student num
     * @return whether the operation is success
     * @author cesare
     */
    boolean teacherResetPassword(String tn);
}

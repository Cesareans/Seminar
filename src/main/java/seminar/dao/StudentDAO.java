package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.config.SeminarConfig;
import seminar.entity.Student;
import seminar.mapper.StudentMapper;
import seminar.mapper.relation.KlassStudentMapper;
import seminar.pojo.dto.StudentFilter;

import java.util.List;

/**
 * @author Cesare
 */
@Component
public class StudentDAO {
    private StudentMapper studentMapper;
    private KlassStudentMapper klassStudentMapper;

    @Autowired
    public StudentDAO(StudentMapper studentMapper, KlassStudentMapper klassStudentMapper) {
        this.studentMapper = studentMapper;
        this.klassStudentMapper = klassStudentMapper;
    }

    /**
     * Need previously check if the student is new.
     * Only need two attr here:studentNum and studentName
     */
    public void insertNewStudent(Student student) {
        student.setPassword(SeminarConfig.DEFAULT_PASSWORD);
        student.setActivated(false);
        studentMapper.insertStudent(student);
    }

    public boolean existStudent(Student student) {
        return !studentMapper.selectStudentByStudentNum(student.getStudentNum()).isEmpty();
    }

    public boolean create(Student student) {
        List<Student> students = studentMapper.selectStudentByStudentNum(student.getStudentNum());
        if (students.isEmpty()) {
            studentMapper.insertStudent(student);
            return true;
        } else {
            return false;
        }
    }

    public boolean update(Student student) {
        List<Student> students = studentMapper.selectStudentById(student.getId());
        if (students.isEmpty()) {
            return false;
        } else {
            studentMapper.updateStudent(student);
            return true;
        }
    }

    public List<Student> getAll() {
        return studentMapper.selectAllStudent();
    }

    public List<Student> getById(String id) {
        return studentMapper.selectStudentById(id);
    }

    public List<Student> getBySN(String sn) {
        return studentMapper.selectStudentByStudentNum(sn);
    }

    public List<Student> getByFilter(StudentFilter filter) {
        List<Student> students;
        if (filter.getStudentNum().length() != 0) {
            students = studentMapper.selectStudentByStudentNum(filter.getStudentNum());
        } else if (filter.getName().length() != 0) {
            students = studentMapper.selectStudentByStudentName(filter.getName());
        } else {
            students = studentMapper.selectAllStudent();
        }
        return students;
    }

    public void deleteBySN(String sn) {
        studentMapper.deleteStudentByStudentNum(sn);
    }

    /**
     * Judge a student is teamed or not. If the student has already in a team, return true, otherwise return false
     */
    public boolean studentHasAlreadyTeamed(String studentId, String courseId)
    {
        return klassStudentMapper.hasTeamed(courseId, studentId);
    }

    /**
     * Get all not teamed students
     */
    public List<Student> studentsUnTeamed(String courseId)
    {
        return klassStudentMapper.selectNotTeamedStudentsByCourseId(courseId);
    }

    /**
     * @author Xinyu Shi
     */
    public void insertStudentIntoTeamStudent(String studentId, String teamId)
    {
        klassStudentMapper.insertStudentIntoTeam(teamId,studentId);
    }

    /**
     * @author Xinyu Shi
     */
    public void deleteStudentFromTeamStudent(String studentId)
    {
        klassStudentMapper.deleteStudentFromTeam(studentId);
    }



}

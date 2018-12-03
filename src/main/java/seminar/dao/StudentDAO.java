package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.Student;
import seminar.entity.vo.StudentFilter;
import seminar.mapper.StudentMapper;

import java.util.List;

/**
 * @author Cesare
 */
@Component
public class StudentDAO {
    private StudentMapper studentMapper;

    @Autowired
    public StudentDAO(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public void add(Student student) {
        studentMapper.insertStudent(student);
    }

    public void update(Student student) {
        studentMapper.updateStudent(student);
    }

    public List<Student> getAll() {
        return studentMapper.selectAllStudent();
    }

    public List<Student> getBySN(String studentNum) {
        return studentMapper.selectStudentByStudentNum(studentNum);
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

    public void deleteBySN(String studentNum) {
        studentMapper.deleteStudentByStudentNum(studentNum);
    }

}

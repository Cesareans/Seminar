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

    public boolean create(Student student) {
        List<Student> students = studentMapper.selectStudentByStudentNum(student.getStudentNum());
        if(students.isEmpty()){
            studentMapper.insertStudent(student);
            return true;
        }
        else return false;
    }

    public boolean update(Student student) {
        List<Student> students = studentMapper.selectStudentById(student.getId());
        if(students.isEmpty()) return false;
        else {
            studentMapper.updateStudent(student);
            return true;
        }
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

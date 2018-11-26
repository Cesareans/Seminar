package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.Student;
import seminar.entity.view.StudentFilter;
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

    public void add(Student student){
        studentMapper.insertStudent(student);
    }

    public void update(Student student){
        studentMapper.updateStudent(student);
    }

    public List<Student> getAll() {
        return studentMapper.selectAllStudent();
    }

    public List<Student> getBySN(String id){
        return studentMapper.selectStudentByStuNum(id);
    }

    public List<Student> getByFilter(StudentFilter filter){
        List<Student> students;
        if(filter.getStuNum().length() != 0){
            students = studentMapper.selectStudentByStuNum(filter.getStuNum());
        }else if(filter.getName().length() != 0){
            students = studentMapper.selectStudentByName(filter.getName());
        }else {
            students = studentMapper.selectAllStudent();
        }
        return students;
    }

    public void deleteBySN(String id){
        studentMapper.deleteStudentByStuNum(id);
    }

}

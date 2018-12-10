package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.Teacher;
import seminar.mapper.TeacherMapper;
import seminar.pojo.vo.TeacherFilter;

import java.util.List;

/**
 * @author Cesare
 */
@Component
public class TeacherDAO {
    private TeacherMapper teacherMapper;

    @Autowired
    public TeacherDAO(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    public void create(Teacher teacher) {
        teacherMapper.insertTeacher(teacher);
    }

    public void update(Teacher teacher) {
        teacherMapper.updateTeacher(teacher);
    }

    public List<Teacher> getAll() {
        return teacherMapper.selectAllTeacher();
    }

    public List<Teacher> getById(String id) {
        return teacherMapper.selectTeacherById(id);
    }

    public List<Teacher> getByTN(String tn) {
        return teacherMapper.selectTeacherByTeacherNum(tn);
    }

    public List<Teacher> getByFilter(TeacherFilter filter) {
        List<Teacher> teachers;
        if (filter.getTeacherNum().length() != 0) {
            teachers = teacherMapper.selectTeacherByTeacherNum(filter.getTeacherNum());
        } else if (filter.getName().length() != 0) {
            teachers = teacherMapper.selectTeacherByTeacherName(filter.getName());
        } else {
            teachers = teacherMapper.selectAllTeacher();
        }
        return teachers;
    }

    public void deleteByTN(String tn) {
        teacherMapper.deleteTeacherByTeacherNum(tn);
    }

}

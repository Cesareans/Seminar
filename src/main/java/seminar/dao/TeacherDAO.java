package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.Teacher;
import seminar.mapper.TeacherMapper;
import seminar.pojo.dto.TeacherFilter;

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

    /**
     * modified by lyf
     *
     * @param teacher
     * @return boolean
     */
    public boolean create(Teacher teacher) {
        List<Teacher> teachers = teacherMapper.selectTeacherByTeacherNum(teacher.getTeacherNum());
        for (Teacher t : teachers) {
            if (t.getTeacherNum().equals(teacher.getTeacherNum())) {
                return false;
            }
        }
        teacherMapper.insertTeacher(teacher);
        return true;
    }

    /**
     * modified by lyf
     *
     * @param teacher
     * @return boolean
     */
    public boolean update(Teacher teacher) {
        List<Teacher> teachers = teacherMapper.selectTeacherByTeacherNum(teacher.getTeacherNum());
        for (Teacher t : teachers) {
            if (t.getTeacherNum().equals(teacher.getTeacherNum())) {
                teacherMapper.updateTeacher(teacher);
                return false;
            }
        }
        return false;
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

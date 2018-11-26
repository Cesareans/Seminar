package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.Teacher;
import seminar.entity.view.TeacherFilter;
import seminar.mapper.TeacherMapper;

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

    public void add(Teacher teacher) {
        teacherMapper.insertTeacher(teacher);
    }

    public void update(Teacher teacher) {
        teacherMapper.updateTeacher(teacher);
    }

    public List<Teacher> getAll() {
        return teacherMapper.selectAllTeacher();
    }

    public List<Teacher> getByBN(String badgeNum) {
        return teacherMapper.selectTeacherByBadgeNum(badgeNum);
    }

    public List<Teacher> getByFilter(TeacherFilter filter) {
        List<Teacher> teachers;
        if(filter.getBadgeNum().length() != 0){
            teachers = teacherMapper.selectTeacherByBadgeNum(filter.getBadgeNum());
        }else if(filter.getName().length() != 0){
            teachers = teacherMapper.selectTeacherByName(filter.getName());
        }else {
            teachers = teacherMapper.selectAllTeacher();
        }
        return teachers;
    }

    public void deleteByBN(String badgeNum) {
        teacherMapper.deleteTeacherByBadgeNum(badgeNum);
    }

}

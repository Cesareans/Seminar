package seminar.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.entity.Teacher;
import seminar.mapper.TeacherMapper;
import util.log.DebugLogger;

import java.util.List;

/**
 * @author Cesare
 */
@Service
public class TeacherService {
    private TeacherMapper teacherMapper;

    @Autowired
    public TeacherService(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    public void add(Teacher teacher){
        teacherMapper.insertTeacher(teacher);
    }

    public void update(Teacher teacher){
        teacherMapper.updateTeacher(teacher);
    }

    public List<Teacher> getAll() {
        return teacherMapper.selectAllTeacher();
    }

    public List<Teacher> getByBN(String id){
        return teacherMapper.selectTeacherById(id);
    }

    public void deleteByBN(String id){
        teacherMapper.deleteTeacherById(id);
    }
}

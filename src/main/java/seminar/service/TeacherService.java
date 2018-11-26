package seminar.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.TeacherDAO;
import seminar.entity.Admin;
import seminar.entity.Teacher;
import seminar.entity.view.TeacherFilter;
import seminar.mapper.TeacherMapper;
import util.log.DebugLogger;

import java.util.List;

/**
 * @author Cesare
 */
@Service
public class TeacherService {
    private TeacherDAO teacherDAO;

    @Autowired
    public TeacherService(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    public List<Teacher> getByFilter(TeacherFilter filter){
        return teacherDAO.getByFilter(filter);
    }


    public boolean add(Teacher teacher){
        if(teacherDAO.getByBN(teacher.getBadgeNum()).size() == 0){
            teacherDAO.add(teacher);
            return true;
        }else {
            return false;
        }
    }

    public boolean update(Teacher teacher){
        List<Teacher> teachers = teacherDAO.getByBN(teacher.getBadgeNum());
        if(teachers.size() == 0){
            return false;
        }else {
            Teacher targetTeacher = teachers.get(0);
            teacher.setPassword(targetTeacher.getPassword());
            teacher.setActivated(targetTeacher.isActivated());
            teacherDAO.update(teacher);
            return true;
        }
    }

    public boolean deleteByBadgeNum(String badgeNum){
        if(teacherDAO.getByBN(badgeNum).size() == 0){
            return false;
        }else {
            teacherDAO.deleteByBN(badgeNum);
            return true;
        }
    }

    public boolean resetPassword(String badgeNum){
        List<Teacher> teachers = teacherDAO.getByBN(badgeNum);
        if (teachers.size() == 0){
            return false;
        }
        Teacher teacher = teachers.get(0);
        teacher.setPassword(Admin.DEFAULT_PASSWORD);
        return update(teacher);
    }
}

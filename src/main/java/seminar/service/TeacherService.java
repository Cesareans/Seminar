package seminar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.TeacherDAO;
import seminar.entity.Admin;
import seminar.entity.Teacher;
import seminar.entity.view.TeacherFilter;

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

    public List<Teacher> getByTN(String teacherNum){
        return teacherDAO.getByTN(teacherNum);
    }


    public boolean add(Teacher teacher){
        if(teacherDAO.getByTN(teacher.getTeacherNum()).size() == 0){
            teacherDAO.add(teacher);
            return true;
        }else {
            return false;
        }
    }

    public boolean update(Teacher teacher){
        List<Teacher> teachers = teacherDAO.getByTN(teacher.getTeacherNum());
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

    public boolean deleteByTeacherNum(String teacherNum){
        if(teacherDAO.getByTN(teacherNum).size() == 0){
            return false;
        }else {
            teacherDAO.deleteByTN(teacherNum);
            return true;
        }
    }

    public boolean resetPassword(String teacherNum){
        List<Teacher> teachers = teacherDAO.getByTN(teacherNum);
        if (teachers.size() == 0){
            return false;
        }
        Teacher teacher = teachers.get(0);
        teacher.setPassword(Admin.DEFAULT_PASSWORD);
        return update(teacher);
    }
}

package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.*;
import seminar.entity.*;
import seminar.entity.message.GroupValidityMsg;
import seminar.entity.message.SeminarShareMsg;
import seminar.entity.message.TeamShareMsg;
import seminar.entity.regulation.MaxMinRegulation;
import seminar.service.TeacherService;

import java.util.List;

/**
 * @author Cesare
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    private final SeminarDAO seminarDAO;
    private final KlassDao klassDAO;
    private final MaxMinRegulationDAO maxMinRegulationDAO;
    private final CourseDAO courseDAO;
    private final TeamShareMsgDAO teamShareMsgDAO;
    private final GroupValidityMsgDAO groupValidityMsgDAO;
    private final TeamDAO teamDAO;
    private final SeminarShareMsgDAO seminarShareMsgDAO;
    private final AttendanceDAO attendanceDAO;
    private TeacherDAO teacherDAO;
    private final RoundDAO roundDAO;

    @Autowired
    public TeacherServiceImpl(TeacherDAO teacherDAO, CourseDAO courseDAO, KlassDao klassDAO, SeminarDAO seminarDAO, MaxMinRegulationDAO maxMinRegulationDAO, TeamShareMsgDAO teamShareMsgDAO, TeamShareDAO teamShareDAO, GroupValidityMsgDAO groupValidityMsgDAO, TeamDAO teamDAO, SeminarShareMsgDAO seminarShareMsgDAO, SeminarShareDAO seminarShareDAO, AttendanceDAO attendanceDAO, RoundDAO roundDAO) {
        this.teacherDAO = teacherDAO;
        this.courseDAO = courseDAO;
        this.seminarDAO = seminarDAO;
        this.klassDAO = klassDAO;
        this.maxMinRegulationDAO = maxMinRegulationDAO;
        this.teamShareMsgDAO = teamShareMsgDAO;
        this.groupValidityMsgDAO = groupValidityMsgDAO;
        this.teamDAO = teamDAO;
        this.seminarShareMsgDAO = seminarShareMsgDAO;
        this.attendanceDAO = attendanceDAO;
        this.roundDAO = roundDAO;
    }

    @Override
    public boolean activate(String teacherId, String password, String email) {
        List<Teacher> teachers = teacherDAO.getById(teacherId);
        if (teachers.size() == 0) {
            return false;
        }
        Teacher teacher = teachers.get(0);
        teacher.setPassword(password);
        teacher.setEmail(email);
        teacher.setActivated(true);
        teacherDAO.update(teacher);
        return true;
    }

    @Override
    public boolean modifyEmail(String teacherId, String email) {
        List<Teacher> teachers = teacherDAO.getById(teacherId);
        if (teachers.size() == 0) {
            return false;
        }
        Teacher teacher = teachers.get(0);
        teacher.setEmail(email);
        teacherDAO.update(teacher);
        return true;
    }


    @Override
    public boolean modifyPasswordViaTn(String tn, String password) {
        List<Teacher> teachers = teacherDAO.getByTN(tn);
        if (teachers.size() == 0) {
            return false;
        } else {
            Teacher targetTeacher = teachers.get(0);
            targetTeacher.setPassword(password);
            teacherDAO.update(targetTeacher);
            return true;
        }
    }

    @Override
    public boolean modifyPasswordViaId(String teacherId, String password) {
        List<Teacher> teachers = teacherDAO.getById(teacherId);
        if (teachers.size() == 0) {
            return false;
        }
        Teacher teacher = teachers.get(0);
        teacher.setPassword(password);
        teacherDAO.update(teacher);
        return true;
    }

    @Override
    public List<Course> getCoursesByTeacherId(String teacherId) {
        return courseDAO.getByTeacherId(teacherId);
    }


    /**
     * @author lyf
     */
    @Override
    public boolean createCourse(Course course) {
        return courseDAO.create(course);
    }

    /**
     * @author lyf
     */
    @Override
    public void deleteCourseById(String courseId) {
        courseDAO.deleteByCourseId(courseId);
    }

    /**
     * @author lyf
     */
    @Override
    public boolean updateCourse(Course course, MaxMinRegulation maxMinRegulation) {
        return courseDAO.update(course, maxMinRegulation);
    }

    /**
     * @author lyf
     */
    @Override
    public boolean createKlass(Klass klass) {
        return klassDAO.create(klass);
    }

    /**
     * @author lyf
     */
    @Override
    public boolean updateKlass(Klass klass) {
        return klassDAO.update(klass);
    }

    /**
     * @author lyf
     */
    @Override
    public void deleteKlassById(String klassId) {
        klassDAO.deleteById(klassId);
    }

    @Override
    public void addRound(String courseId) {
        roundDAO.addRound(courseId);
    }

    /**
     * @author lyf
     */
    @Override
    public boolean createSeminar(Seminar seminar) {
        return seminarDAO.create(seminar);
    }

    /**
     * @author lyf
     */
    @Override
    public boolean updateSeminar(Seminar seminar) {
        return seminarDAO.update(seminar);
    }

    /**
     * @author lyf
     */
    @Override
    public void deleteSeminarByRoundId(String roundId) {
        seminarDAO.deleteByRoundId(roundId);
    }

    /**
     * @author SWJ
     */
    @Override
    public boolean createTeamShareMsg(TeamShareMsg teamShareMsg) {
        return teamShareMsgDAO.create(teamShareMsg);
    }

    /**
     * @author SWJ
     */
    @Override
    public List<GroupValidityMsg> getGroupValidityMsgByTeacherId(String teacherId) {
        return groupValidityMsgDAO.getByTeacherId(teacherId);
    }

    /**
     * @author SWJ
     */
    @Override
    public boolean updateTeam(String teamId) {
        Team team = teamDAO.getById(teamId).get(0);
        team.setValid(true);
        return teamDAO.update(team);
    }

    /**
     * @author SWJ
     */
    @Override
    public boolean createSeminarShareMsg(SeminarShareMsg seminarShareMsg) {
        return seminarShareMsgDAO.create(seminarShareMsg);
    }

    /**
     * @author SWJ
     */
    @Override
    public boolean updateReportScore(int reportScore, String klassSeminarId) {
        List<Attendance> attendances = attendanceDAO.getByKlassSeminarId(klassSeminarId);
        for (Attendance a : attendances) {
            a.setReportScore(reportScore);
            boolean flag = attendanceDAO.update(a);
            if (!flag) {
                return false;
            }
        }
        return true;
    }
}

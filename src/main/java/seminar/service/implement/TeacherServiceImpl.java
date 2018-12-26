package seminar.service.implement;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.*;
import seminar.dao.application.ShareSeminarApplicationDAO;
import seminar.dao.application.ShareTeamApplicationDAO;
import seminar.entity.*;
import seminar.entity.application.ShareSeminarApplication;
import seminar.entity.application.ShareTeamApplication;
import seminar.entity.application.TeamValidApplication;
import seminar.entity.relation.KlassRound;
import seminar.entity.relation.KlassStudent;
import seminar.service.TeacherService;

import java.util.List;

/**
 * @author Cesare
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    private final SeminarDAO seminarDAO;
    private final KlassDao klassDAO;
    private final CourseDAO courseDAO;
    private final TeamDAO teamDAO;
    private final AttendanceDAO attendanceDAO;
    private final RoundDAO roundDAO;
    private final TeacherDAO teacherDAO;
    private final StudentDAO studentDAO;
    private final KlassRoundDAO klassRoundDAO;

    @Autowired
    public TeacherServiceImpl(TeacherDAO teacherDAO, CourseDAO courseDAO, KlassDao klassDAO, SeminarDAO seminarDAO, MaxMinRegulationDAO maxMinRegulationDAO, ShareTeamApplicationDAO shareTeamApplicationDAO, TeamDAO teamDAO, ShareSeminarApplicationDAO shareSeminarApplicationDAO, AttendanceDAO attendanceDAO, RoundDAO roundDAO, StudentDAO studentDAO, KlassRoundDAO klassRoundDAO) {
        this.teacherDAO = teacherDAO;
        this.courseDAO = courseDAO;
        this.seminarDAO = seminarDAO;
        this.klassDAO = klassDAO;
        this.teamDAO = teamDAO;
        this.attendanceDAO = attendanceDAO;
        this.roundDAO = roundDAO;
        this.studentDAO = studentDAO;
        this.klassRoundDAO = klassRoundDAO;
    }

    @Override
    public boolean activate(String teacherId, String password) {
        Teacher teacher = teacherDAO.getById(teacherId).get(0);
        teacher.setPassword(password);
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
    public boolean updateCourse(Course course) {
        return courseDAO.update(course);
    }

    /**
     * @author lyf
     */
    @Override
    public boolean createKlass(Klass klass) {
        return klassDAO.create(klass);
    }

    /**
     * @author Cesare
     */
    @Override
    public void insertKlassStudent(Klass klass, Workbook workbook) {
        Student student = new Student();
        klassDAO.deleteStudents(klass.getId());
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            Sheet sheet = workbook.getSheetAt(i);
            for (int j = 1; j < sheet.getPhysicalNumberOfRows(); j++) {
                Row row = sheet.getRow(j);
                if (row.getCell(0).getStringCellValue().length() == 0) {
                    continue;
                }
                student.setStudentNum(row.getCell(0).getStringCellValue().replace((char)160, (char)32).trim());
                student.setStudentName(row.getCell(1).getStringCellValue().replace((char)160, (char)32).trim());
                if (!studentDAO.existStudent(student)) {
                    studentDAO.insertNewStudent(student);
                }
                student = studentDAO.getBySN(student.getStudentNum()).get(0);
                klassDAO.insertStudent(new KlassStudent(klass.getCourseId(), klass.getId(), student.getId()));
            }
        }
    }

    /**
     * @author lyf
     */
    @Override
    public void deleteKlassById(String klassId) {
        klassDAO.deleteById(klassId);
    }

    /**
     * @author lyf
     */
    @Override
    public void addRound(Round round) {
        roundDAO.addRound(round);
    }

    /**
     * @author lyf
     */
    @Override
    public void createSeminar(Seminar seminar) {
        seminarDAO.create(seminar);
    }

    /**
     * @author lyf
     */
    @Override
    public boolean updateSeminar(Seminar seminar) {
        return seminarDAO.update(seminar);
    }

    @Override
    public boolean updateRoundScoreType(Round typeRound) {
        Round round = roundDAO.getByRoundId(typeRound.getId()).get(0);
        round.setPreScoreType(typeRound.getPreScoreType());
        round.setQuesScoreType(typeRound.getQuesScoreType());
        round.setReportScoreType(typeRound.getReportScoreType());
        return roundDAO.update(round);
    }

    @Override
    public boolean updateKlassRound(KlassRound klassRound) {
        return klassRoundDAO.update(klassRound);
    }

    /**
     * @author lyf
     */
    @Override
    public void deleteSeminarById(String seminarId) {
        seminarDAO.deleteById(seminarId);
    }


    /**
     * @author SWJ
     */
    @Override
    public boolean updateReportScore(int reportScore, String klassSeminarId) {
        List<Attendance> attendances = attendanceDAO.getByKlassSeminarId(klassSeminarId);
        for (Attendance a : attendances) {
            boolean flag = attendanceDAO.update(a);
            if (!flag) {
                return false;
            }
        }
        return true;
    }
}

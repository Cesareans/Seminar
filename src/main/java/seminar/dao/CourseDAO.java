package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.*;
import seminar.entity.relation.KlassRound;
import seminar.entity.relation.KlassStudent;
import seminar.mapper.*;
import seminar.mapper.relation.KlassRoundMapper;
import seminar.mapper.relation.KlassStudentMapper;

import java.util.List;

/**
 * @author Cesare
 */
@Component
public class CourseDAO {
    private final CourseMapper courseMapper;
    private final KlassMapper klassMapper;
    private final RoundMapper roundMapper;
    private final KlassRoundMapper klassRoundMapper;
    private final TeamMapper teamMapper;
    private final KlassStudentMapper klassStudentMapper;
    private final TeacherMapper teacherMapper;

    @Autowired
    public CourseDAO(CourseMapper courseMapper, KlassMapper klassMapper, TeacherMapper teacherMapper, KlassStudentMapper klassStudentMapper, RoundMapper roundMapper, KlassRoundMapper klassRoundMapper, TeamMapper teamMapper) {
        this.courseMapper = courseMapper;
        this.klassMapper = klassMapper;
        this.teacherMapper = teacherMapper;
        this.klassStudentMapper = klassStudentMapper;
        this.roundMapper = roundMapper;
        this.klassRoundMapper = klassRoundMapper;
        this.teamMapper = teamMapper;
    }
    /**
     * @author Cesare
     */
    public void setTeacher(Course course){
        course.setTeacher(teacherMapper.selectTeacherById(course.getTeacherId()).get(0));
    }

    /**
     * @author cesare
     */
    public List<Course> getByCourseId(String courseId) {
        return courseMapper.selectCourseById(courseId);
    }

    /**
     * @author cesare
     */
    public List<Course> getByTeacherId(String teacherId) {
        return courseMapper.selectCourseByTeacherId(teacherId);
    }

    /**
     * @author cesare
     */
    public List<Course> getByStudentId(String studentId){
        return klassStudentMapper.selectCourseByStudentId(studentId);
    }

    /**
     * @author lyf
     */
    public boolean create(Course course) {
        List<Course> courses = courseMapper.selectCourseByTeacherId(course.getTeacherId());
        for (Course c : courses) {
            if (c.getCourseName().equals(course.getCourseName())) {
                return false;
            }
        }
        courseMapper.insertCourse(course);
        return true;
    }

    /**
     * @author lyf
     */
    public void deleteByCourseId(String courseId) {
        courseMapper.deleteCourseById(courseId);
    }

    /**
     * @author lyf
     */
    public boolean update(Course course) {
        if (!courseMapper.selectCourseById(course.getId()).isEmpty()) {
            courseMapper.updateCourse(course);
            return true;
        } else {
            return false;
        }
    }

    /**
     * @author cesare
     */
    public List<Course> getSubCourseOfSeminarShare(String seminarMainCourseId){
        return courseMapper.selectCourseBySeminarMainCourseId(seminarMainCourseId);
    }

    /**
     * Copy klass round
     * @author cesare
     */
    public boolean buildSeminarShare(String mainCourseId, String subCourseId){
        Course subCourse = getByCourseId(subCourseId).get(0);
        if (subCourse.getSeminarMainCourseId() != null) {
            return false;
        }
        subCourse.setSeminarMainCourseId(mainCourseId);
        update(subCourse);

        List<Round> rounds = roundMapper.selectRoundByCourseId(mainCourseId);
        List<Klass> klasses = klassMapper.selectKlassByCourseId(subCourseId);

        KlassRound klassRound = new KlassRound();
        klassRound.setEnrollLimit(1);
        rounds.forEach(round -> {
            klasses.forEach(klass -> {
                klassRound.setRoundId(round.getId());
                klassRound.setKlassId(klass.getId());
                klassRoundMapper.insertKlassRound(klassRound);
            });
        });
        return true;
    }
    /**
     * @author cesare
     */
    public List<Course> getSubCourseOfTeamShare(String teamMainCourseId){
        return courseMapper.selectCourseByTeamMainCourseId(teamMainCourseId);
    }

    /**
     * @author cesare
     */
    public boolean buildTeamShare(String mainCourseId, String subCourseId){
        Course subCourse = getByCourseId(subCourseId).get(0);
        if (subCourse.getTeamMainCourseId() != null) {
            return false;
        }
        subCourse.setTeamMainCourseId(mainCourseId);
        update(subCourse);



        List<Team> teams = teamMapper.selectTeamByMainCourseId(mainCourseId);
        List<Klass> klasses = klassMapper.selectKlassByCourseId(subCourseId);
        teams.forEach(team -> {
            List<Student> students= klassStudentMapper.selectStudentsFromTeam(team.getId());

        });

        return true;
    }

    /**
     * @author cesare
     */
    public List<Course> getOtherCoursesByCourseId(String courseId){
        Course course = courseMapper.selectCourseById(courseId).get(0);
        List<Course> otherCourses = courseMapper.selectOtherCoursesById(course.getId(), course.getTeamMainCourseId(), course.getSeminarMainCourseId());
        otherCourses.forEach(this::setTeacher);
        return otherCourses;
    }
}

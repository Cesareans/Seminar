package seminar.dao.regulation;

import org.springframework.beans.factory.annotation.Autowired;
import seminar.entity.Student;
import seminar.entity.Team;
import seminar.entity.regulation.ConflictCourseStrategy;
import seminar.mapper.ConflictCourseStrategyMapper;
import seminar.mapper.StudentMapper;
import seminar.mapper.relation.KlassStudentMapper;

import java.util.ArrayList;
import java.util.List;

public class ConflictCourseStrategyDAO implements RegulationDAO {

    private final StudentMapper studentMapper;
    private final KlassStudentMapper klassStudentMapper;
    private final ConflictCourseStrategyMapper conflictCourseStrategyMapper;
    @Autowired
    private ConflictCourseStrategy conflictCourseStrategy;
    private String regulationId;

    @Autowired
    public ConflictCourseStrategyDAO(StudentMapper studentMapper, KlassStudentMapper klassStudentMapper, ConflictCourseStrategyMapper conflictCourseStrategyMapper)
    {
        this.studentMapper = studentMapper;
        this.klassStudentMapper = klassStudentMapper;
        this.conflictCourseStrategyMapper = conflictCourseStrategyMapper;
    }

    @Override
    public void setRegulation(String regulationId)
    {
        this.regulationId = regulationId;
    }

    @Override
    public boolean validate(Team team)
    {
        conflictCourseStrategy.setConflictCourses(conflictCourseStrategyMapper.selectConflictCoursesById(regulationId));
        List<Student> conflictStudents = new ArrayList<>();
        for(Student student:team.getStudents())
        {

        }
        List<String> courseIdOfStudents = new ArrayList<>();


        return true;
    }

    @Override
    public String getErrorMsg()
    {
        return "";
    }
}

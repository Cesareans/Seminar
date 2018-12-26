package seminar.dao.regulation;

import org.springframework.beans.factory.annotation.Autowired;
import seminar.entity.Student;
import seminar.entity.Team;
import seminar.entity.regulation.CourseMemberLimitStrategy;
import seminar.mapper.CourseMapper;
import seminar.mapper.CourseMemberLimitStrategyMapper;
import seminar.mapper.relation.KlassStudentMapper;

import java.util.List;

public class CourseMemberLimitStrategyDAO implements RegulationDAO {

    private CourseMemberLimitStrategy courseMemberLimitStrategy;
    private final CourseMapper courseMapper;
    private final KlassStudentMapper klassStudentMapper;
    private final CourseMemberLimitStrategyMapper courseMemberLimitStrategyMapper;
    private String regulationId;

    @Autowired
    public CourseMemberLimitStrategyDAO(CourseMapper courseMapper, KlassStudentMapper klassStudentMapper, CourseMemberLimitStrategyMapper courseMemberLimitStrategyMapper)
    {
        this.courseMapper = courseMapper;
        this.klassStudentMapper = klassStudentMapper;
        this.courseMemberLimitStrategyMapper = courseMemberLimitStrategyMapper;
    }

    @Override
    public void setRegulation(String regulationId)
    {
        this.regulationId = regulationId;
    }
    @Override
    public  boolean validate(Team team)
    {
        courseMemberLimitStrategy = courseMemberLimitStrategyMapper.selectCourseMemberLimitStrategyById(regulationId).get(0);
        List<Student> studentsInSpecificCourse = klassStudentMapper.selectStudentsFromTeamByCourseIdAndTeamId(courseMemberLimitStrategy.getCourseId(),team.getId());
        int studentsNum = studentsInSpecificCourse.size();
        if(studentsNum>=courseMemberLimitStrategy.getMin() && studentsNum<=courseMemberLimitStrategy.getMax()){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String getErrorMsg()
    {
        String courseName = courseMapper.selectCourseById(courseMemberLimitStrategy.getCourseId()).get(0).getCourseName();
        return "小组中选修课程"+courseName + "的人数应在" + courseMemberLimitStrategy.getMin() + "与" + courseMemberLimitStrategy.getMax()+"之间";
    }
}

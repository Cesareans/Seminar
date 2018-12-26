package seminar.entity.regulation;

import cesare.mybatis.annotations.Gist;
import cesare.mybatis.annotations.ID;
import cesare.mybatis.annotations.Link;
import cesare.mybatis.annotations.TargetPackage;
import seminar.entity.Course;
import seminar.entity.Student;
import seminar.entity.Team;

import java.util.List;

/**
 * @author Xinyu Shi
 */
@TargetPackage(value = "seminar.mapper")
public class CourseMemberLimitStrategy implements Strategy {

    @ID(isIncrement = true)
    private String id;
    private int min;
    private int max;
    @Gist
    private String courseId;

    @Link(gist = "courseId", select = "seminar.mapper.CourseMapper.selectCourseById")
    private List<Course> courses;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public List<Course> getCourses()
    {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public boolean validate(Team team)
    {
        int memberInSpecificCourse = 0;
        for(Student student:team.getStudents())
        {
            if(student.getCourses().contains(courseId)){
                memberInSpecificCourse++;
            }
        }
        if(memberInSpecificCourse >= min && memberInSpecificCourse <= max){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String getErrorMsg()
    {
        return "选修" + courses.get(0).getCourseName() + "课程的小组成员数应在" + min + "到" + max + "之间";
    }

}
package seminar.entity.regulation;

import seminar.entity.Course;
import seminar.entity.Student;
import seminar.entity.Team;
import seminar.logger.DebugLogger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xinyu Shi
 */
public class CourseMemberLimitStrategy implements Strategy {
    private String id;
    private int min;
    private int max;
    private String courseId;

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


    @Override
    public boolean validate(Team team) {
        int memberInSpecificCourse = 0;
        for (Student student : team.getStudents()) {
            List<String> courseIds = new ArrayList<>();
            for (Course course : student.getCourses()) {
                courseIds.add(course.getId());
            }
            if (courseIds.contains(courseId)) {
                memberInSpecificCourse++;
            }
        }
        DebugLogger.log(memberInSpecificCourse);
        return memberInSpecificCourse >= min && memberInSpecificCourse <= max;
    }

    @Override
    public String getErrorMsg() {
        return "选修某课程的小组成员数应在" + min + "到" + max + "之间";
    }

}
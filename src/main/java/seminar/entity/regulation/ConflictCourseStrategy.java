package seminar.entity.regulation;

import cesare.mybatis.annotations.ID;
import cesare.mybatis.annotations.TargetPackage;
import seminar.entity.Course;
import seminar.entity.Student;
import seminar.entity.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xinyu Shi
 */
@TargetPackage(value = "seminar.mapper")
public class ConflictCourseStrategy implements Strategy {

    private final int CONFLICT_BOUNDARY = 1;

    @ID(isIncrement = true)
    private String id;

    private List<String> conflictCourses;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getConflictCourses() {
        return conflictCourses;
    }

    public void setConflictCourses(List<String> conflictCourses) {
        this.conflictCourses = conflictCourses;
    }

    @Override
    public boolean validate(Team team) {
        int conflict = 0;
        for (String courseId : conflictCourses) {
            for (Student student : team.getStudents()) {
                List<String> coursesOfStudent = new ArrayList<>();
                for (Course course : student.getCourses()) {
                    coursesOfStudent.add(course.getId());
                }
                if (coursesOfStudent.contains(courseId)) {
                    conflict++;
                    break;
                }
            }
        }
        if (conflict > CONFLICT_BOUNDARY) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String getErrorMsg() {
        return "小组成员选修的课程存在冲突";
    }
}

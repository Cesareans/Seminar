package seminar.entity.regulation;

import seminar.entity.Course;
import seminar.entity.Student;
import seminar.entity.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xinyu Shi
 */
public class ConflictCourseStrategy implements Strategy {
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
        final int conflictBoundary = 1;
        return conflict <= conflictBoundary;
    }

    @Override
    public String getErrorMsg() {
        return "小组成员选修的课程存在冲突";
    }
}

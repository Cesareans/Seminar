package seminar.entity.relation;

/**
 * @author Cesare
 */

public class KlassStudent {
    private String courseId;
    private String klassId;
    private String teamId;
    private String studentId;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getKlassId() {
        return klassId;
    }

    public void setKlassId(String klassId) {
        this.klassId = klassId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getStudentId() {
        return studentId;

    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}

package seminar.entity.regulation;

import cesare.mybatis.annotations.Gist;
import cesare.mybatis.annotations.ID;
import cesare.mybatis.annotations.TargetPackage;
import seminar.entity.Team;

/**
 * @author Xinyu Shi
 */
@TargetPackage(value = "seminar.mapper")
public class CourseMemberLimitRegulation implements Regulation{

    @ID(isIncrement = true)
    private String id;
    private int min;
    private int max;
    @Gist
    private String courseId;

    @Override
    public boolean validate(Team team) {
        return true;
    }

    @Override
    public String getErrorMsg() {
        return "该课程人数应在" + min + "-" + max + "之间";
    }

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

}

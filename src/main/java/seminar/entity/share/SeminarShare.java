package seminar.entity.share;

import cesare.mybatis.annotations.Gist;
import cesare.mybatis.annotations.ID;
import cesare.mybatis.annotations.TargetPackage;

/**
 * @author SWJ
 */
@TargetPackage(value = "seminar.mapper")
public class SeminarShare {
    @ID(isIncrement = true)
    private String id;
    @Gist
    private String principalCourseId;
    @Gist
    private String subordinateCourseId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrincipalCourseId() {
        return principalCourseId;
    }

    public void setPrincipalCourseId(String principalCourseId) {
        this.principalCourseId = principalCourseId;
    }

    public String getSubordinateCourseId() {
        return subordinateCourseId;
    }

    public void setSubordinateCourseId(String subordinateCourseId) {
        this.subordinateCourseId = subordinateCourseId;
    }


}

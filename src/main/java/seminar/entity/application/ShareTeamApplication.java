package seminar.entity.application;

import cesare.mybatis.annotations.Gist;
import cesare.mybatis.annotations.ID;
import cesare.mybatis.annotations.SqlMap;
import cesare.mybatis.annotations.TargetPackage;

/**
 * @author SWJ
 */
@TargetPackage(value = "seminar.mapper.application")
public class ShareTeamApplication {
    @ID(isIncrement = true)
    private String id;
    @Gist
    @SqlMap("sub_course_teacher_id")
    private String teacherId;
    @Gist
    private String mainCourseId;
    @Gist
    private String subCourseId;
    private int status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getMainCourseId() {
        return mainCourseId;
    }

    public void setMainCourseId(String mainCourseId) {
        this.mainCourseId = mainCourseId;
    }

    public String getSubCourseId() {
        return subCourseId;
    }

    public void setSubCourseId(String subCourseId) {
        this.subCourseId = subCourseId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

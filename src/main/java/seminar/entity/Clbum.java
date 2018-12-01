package seminar.entity;

import cesare.mybatis.annotations.Gist;
import cesare.mybatis.annotations.ID;
import cesare.mybatis.annotations.TargetPackage;

/**
 * @author Cesare
 */
@TargetPackage(target = "seminar.mapper")
public class Clbum {
    @ID(isIncrement = true)
    private String id;
    private String clbumName;
    private String time;
    private String location;

    @Gist
    private
    String courseId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClbumName() {
        return clbumName;
    }

    public void setClbumName(String clbumName) {
        this.clbumName = clbumName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}

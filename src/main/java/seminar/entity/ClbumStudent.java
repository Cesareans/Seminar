package seminar.entity;

import cesare.mybatis.annotations.Gist;
import cesare.mybatis.annotations.ID;
import cesare.mybatis.annotations.TargetPackage;

/**
 * @author Cesare
 */
@TargetPackage(value = "seminar.mapper")
public class ClbumStudent {
    @ID(isIncrement = true)
    private String id;
    @Gist
    private String clbumId;
    @Gist
    private String studentId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClbumId() {
        return clbumId;
    }

    public void setClbumId(String clbumId) {
        this.clbumId = clbumId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}

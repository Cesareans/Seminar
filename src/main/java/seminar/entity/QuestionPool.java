package seminar.entity;

import cesare.mybatis.annotations.Gist;
import cesare.mybatis.annotations.ID;
import cesare.mybatis.annotations.TargetPackage;

/**
 * @author Cesare
 */
@TargetPackage(target = "seminar.mapper")
public class QuestionPool {
    @ID(isIncrement = true)
    private String id;
    @Gist
    private String clbumSeminarId;
    @Gist
    private String teamId;
    @Gist
    private String studentId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClbumSeminarId() {
        return clbumSeminarId;
    }

    public void setClbumSeminarId(String clbumSeminarId) {
        this.clbumSeminarId = clbumSeminarId;
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

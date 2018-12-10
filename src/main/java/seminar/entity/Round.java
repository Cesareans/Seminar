package seminar.entity;

import cesare.mybatis.annotations.Gist;
import cesare.mybatis.annotations.ID;
import cesare.mybatis.annotations.Link;
import cesare.mybatis.annotations.TargetPackage;

import java.util.List;

/**
 * When the round is generated, the seminars belonging to the round will also be generated via a eager type
 *
 * @author Cesare
 */
@TargetPackage(value = "seminar.mapper")
public class Round {
    @ID(isIncrement = true)
    private String id;
    private String roundNum;
    @Gist
    private String courseId;

    @Link(gist = "id", select = "seminar.mapper.SeminarMapper.selectSeminarByRoundId", lazy = false)
    private List<Seminar> seminars;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoundNum() {
        return roundNum;
    }

    public void setRoundNum(String roundNum) {
        this.roundNum = roundNum;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public List<Seminar> getSeminars() {
        return seminars;
    }

    public void setSeminars(List<Seminar> seminars) {
        this.seminars = seminars;
    }
}

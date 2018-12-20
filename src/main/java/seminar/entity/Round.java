package seminar.entity;

import cesare.mybatis.annotations.*;

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
    @SqlMap("round_serial")
    private String roundNum;
    private int presentationScoreMethod;
    private int reportScoreMethod;
    private int questionScoreMethod;
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

    public int getPresentationScoreMethod() {
        return presentationScoreMethod;
    }

    public void setPresentationScoreMethod(int presentationScoreMethod) {
        this.presentationScoreMethod = presentationScoreMethod;
    }

    public int getReportScoreMethod() {
        return reportScoreMethod;
    }

    public void setReportScoreMethod(int reportScoreMethod) {
        this.reportScoreMethod = reportScoreMethod;
    }

    public int getQuestionScoreMethod() {
        return questionScoreMethod;
    }

    public void setQuestionScoreMethod(int questionScoreMethod) {
        this.questionScoreMethod = questionScoreMethod;
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

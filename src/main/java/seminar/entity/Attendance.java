package seminar.entity;

import cesare.mybatis.annotations.Gist;
import cesare.mybatis.annotations.ID;
import cesare.mybatis.annotations.TargetPackage;

/**
 * @author Cesare
 */
@TargetPackage(value = "seminar.mapper")
public class Attendance {
    @ID(isIncrement = true)
    private String id;
    private String preFile;
    private boolean presenting;
    private String reportFile;
    private int preScore;
    private int reportScore;
    @Gist
    private String teamId;
    @Gist
    private String clbumSeminarId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPreFile() {
        return preFile;
    }

    public void setPreFile(String preFile) {
        this.preFile = preFile;
    }

    public boolean isPresenting() {
        return presenting;
    }

    public void setPresenting(boolean presenting) {
        this.presenting = presenting;
    }

    public String getReportFile() {
        return reportFile;
    }

    public void setReportFile(String reportFile) {
        this.reportFile = reportFile;
    }

    public int getPreScore() {
        return preScore;
    }

    public void setPreScore(int preScore) {
        this.preScore = preScore;
    }

    public int getReportScore() {
        return reportScore;
    }

    public void setReportScore(int reportScore) {
        this.reportScore = reportScore;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getClbumSeminarId() {
        return clbumSeminarId;
    }

    public void setClbumSeminarId(String clbumSeminarId) {
        this.clbumSeminarId = clbumSeminarId;
    }
}

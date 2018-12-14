package seminar.entity;

import cesare.mybatis.annotations.Gist;
import cesare.mybatis.annotations.ID;
import cesare.mybatis.annotations.Link;
import cesare.mybatis.annotations.TargetPackage;

/**
 * @author Cesare
 */
@TargetPackage(value = "seminar.mapper")
public class Attendance {
    @ID(isIncrement = true)
    private String id;
    private int sn;
    private String preFile;
    private boolean presenting;
    private String reportFile;
    private int preScore;
    private int reportScore;
    @Gist
    private String teamId;
    @Gist
    private String klassSeminarId;

    @Link(gist = "teamId", select = "seminar.mapper.TeamMapper.selectTeamById", lazy = false)
    private Team team;

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Attendance)) {
            return false;
        }
        return id.equals(((Attendance) obj).id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
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

    public String getKlassSeminarId() {
        return klassSeminarId;
    }

    public void setKlassSeminarId(String klassSeminarId) {
        this.klassSeminarId = klassSeminarId;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}

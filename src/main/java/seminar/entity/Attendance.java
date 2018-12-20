package seminar.entity;

import cesare.mybatis.annotations.*;

/**
 * @author Cesare
 */
@TargetPackage(value = "seminar.mapper")
public class Attendance {
    @ID(isIncrement = true)
    private String id;
    @SqlMap("team_order")
    private int sn;
    @SqlMap("is_present")
    private boolean presenting;
    @SqlMap("ppt_name")
    private String preFile;
    @SqlMap("report_name")
    private String reportFile;

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
        if (!(obj instanceof Attendance)) {
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

package seminar.entity.application;

import cesare.mybatis.annotations.*;
import seminar.entity.Team;

/**
 * @author SWJ
 */
@TargetPackage(value = "seminar.mapper.application")
public class TeamValidApplication {
    @ID(isIncrement = true)
    private String id;
    @SqlMap("reason")
    private String content;
    @Gist
    private String teacherId;
    @Gist
    private String teamId;

    @Link(gist = "teamId", select = "seminar.mapper.TeamMapper.selectTeamById")
    private Team team;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }


    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}

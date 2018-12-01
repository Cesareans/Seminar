package seminar.entity;

import cesare.mybatis.annotations.Gist;
import cesare.mybatis.annotations.ID;
import cesare.mybatis.annotations.TargetPackage;

/**
 * @author Cesare
 */
@TargetPackage(target = "seminar.mapper")
public class Team {
    @ID(isIncrement = true)
    private String id;
    private String serial;
    private String teamName;
    private boolean valid;
    @Gist
    private String clbumId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getClbumId() {
        return clbumId;
    }

    public void setClbumId(String clbumId) {
        this.clbumId = clbumId;
    }
}

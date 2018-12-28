package seminar.pojo.websocket.response;

import seminar.pojo.websocket.monitor.SeminarMonitor;
import seminar.pojo.websocket.monitor.state.SeminarState;

/**
 * @author Cesare
 */
public class SwitchTeamResponse implements Response {
    private int attendanceIndex;
    private String teamId;
    private SeminarState state;
    @Override
    public Response execute(SeminarMonitor monitor) {
        attendanceIndex = monitor.getOnPreAttendanceIndex();
        teamId = monitor.getOnPreAttendance().getTeamId();
        state = monitor.getState();
        return this;
    }

    public int getAttendanceIndex() {
        return attendanceIndex;
    }

    public void setAttendanceIndex(int attendanceIndex) {
        this.attendanceIndex = attendanceIndex;
    }

    public SeminarState getState() {
        return state;
    }

    public void setState(SeminarState state) {
        this.state = state;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }
}

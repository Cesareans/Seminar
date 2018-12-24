package seminar.pojo.websocket.request;

import seminar.pojo.websocket.annotation.BindResponse;
import seminar.pojo.websocket.monitor.SeminarMonitor;
import seminar.pojo.websocket.response.SwitchTeamResponse;

/**
 * @author Cesare
 */
@BindResponse(response = SwitchTeamResponse.class)
public class SwitchTeamRequest implements Request {
    @Override
    public void execute(SeminarMonitor monitor) {
        monitor.switchTeam();
    }
}

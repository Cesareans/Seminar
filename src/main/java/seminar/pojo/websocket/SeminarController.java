package seminar.pojo.websocket;

import seminar.entity.Attendance;
import seminar.entity.Question;
import seminar.entity.Teacher;
import seminar.entity.Team;

import java.util.List;
import java.util.Map;

/**
 * @author Cesare
 */
public class SeminarController {
    String klassSeminarId;
    Teacher teacher;
    List<Attendance> attendances;
    List<Team> teams;
    Map<Question, Team> questionTeamMap;

}

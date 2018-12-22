package seminar.pojo.websocket.request;

import seminar.entity.Student;
import seminar.entity.Team;
import seminar.pojo.websocket.annotation.BindResponse;
import seminar.pojo.websocket.monitor.SeminarMonitor;
import seminar.pojo.websocket.response.RaiseQuestionResponse;

/**
 * @author Cesare
 */
@BindResponse(response = RaiseQuestionResponse.class)
public class RaiseQuestionRequest implements Request {
    private String attendanceId;
    private String studentId;
    @Override
    public void execute(SeminarMonitor monitor) {
        if(!monitor.getOnPreAttendance().getId().equals(attendanceId)){
            throw new RuntimeException();
        }
        Team team = monitor.getStudentNumTeamMap().get(studentId);
        for (Student student : team.getStudents()) {
            if(student.getId().equals(studentId)){
                monitor.getQuestionPool().putRequest(monitor.getOnPreAttendance(), student,team);
            }
        }
    }

    public String getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(String attendanceId) {
        this.attendanceId = attendanceId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}

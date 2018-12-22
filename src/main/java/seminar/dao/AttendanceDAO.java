package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.Attendance;
import seminar.mapper.AttendanceMapper;

import java.util.List;

/**
 * @author Cesare
 */
@Component
public class AttendanceDAO {
    private final AttendanceMapper attendanceMapper;

    @Autowired
    public AttendanceDAO(AttendanceMapper attendanceMapper) {
        this.attendanceMapper = attendanceMapper;
    }

    public List<Attendance> getAttendanceByKlassSeminarId(String klassSeminarId) {
        return attendanceMapper.selectAttendanceByKlassSeminarId(klassSeminarId);
    }

    /**
     * @author Xinyu Shi
     */
    public List<Attendance> getAll() {
        return attendanceMapper.selectAllAttendance();
    }

    /**
     * @author Xinyu Shi
     */
    public List<Attendance> getByKlassSeminarId(String klassSeminarId) {
        return attendanceMapper.selectAttendanceByKlassSeminarId(klassSeminarId);
    }

    /**
     * @author Xinyu Shi
     */
    public List<Attendance> getById(String id) {
        return attendanceMapper.selectAttendanceById(id);
    }

    /**
     * @author Xinyu Shi
     */
    public List<Attendance> getByTeamId(String teamId) {
        return attendanceMapper.selectAttendanceByTeamId(teamId);
    }

    /**
     * @author Xinyu Shi
     */
    public void deleteByKlassSeminarId(String klassSeminarId) {
        attendanceMapper.deleteAttendanceByKlassSeminarId(klassSeminarId);
    }

    /**
     * @author Xinyu Shi
     */
    public void deleteById(String id) {
        attendanceMapper.deleteAttendanceById(id);
    }

    /**
     * @author Xinyu Shi
     */
    public void deleteByTeamId(String teamId) {
        attendanceMapper.deleteAttendanceByTeamId(teamId);
    }

    /**
     * @author Xinyu Shi
     */
    public void create(Attendance attendance) {
        attendanceMapper.insertAttendance(attendance);
    }

    /**
     * @author Xinyu Shi
     * <p>
     * change by SWJ
     */
    public boolean update(Attendance attendance) {
        if (!attendanceMapper.selectAttendanceById(attendance.getId()).isEmpty()) {
            attendanceMapper.updateAttendance(attendance);
            return true;
        }
        return false;
    }

    /**
     * @author Xinyu Shi
     *
     *
     */
    public List<Attendance> getByTeamIdAndKlassSeminarId(String teamId, String klassSeminarId)
    {
        return attendanceMapper.selectAttendanceByTeamIdAndKlassSeminarId(teamId,klassSeminarId);
    }


}

package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.Attendance;
import seminar.entity.KlassSeminar;
import seminar.mapper.AttendanceMapper;
import seminar.mapper.KlassSeminarMapper;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author Cesare
 */
@Component
public class AttendanceDAO {
    private final AttendanceMapper attendanceMapper;
    private final KlassSeminarMapper klassSeminarMapper;

    @Autowired
    public AttendanceDAO(AttendanceMapper attendanceMapper, KlassSeminarMapper klassSeminarMapper) {
        this.attendanceMapper = attendanceMapper;
        this.klassSeminarMapper = klassSeminarMapper;
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
     * @author Cesare
     */
    public List<Attendance> getEnrollList(String ksId) {
        KlassSeminar klassSeminar = klassSeminarMapper.selectKlassSeminarById(ksId).get(0);
        List<Attendance> enrollList = new LinkedList<>();
        IntStream.range(1, klassSeminar.getSeminar().getMaxTeam() + 1).forEach(i -> {
            boolean isEnrolled = false;
            for (Attendance attendance : klassSeminar.getAttendances()) {
                if (attendance.getSn() == i) {
                    isEnrolled = true;
                    enrollList.add(attendance);
                    break;
                }
            }
            if (!isEnrolled) {
                enrollList.add(null);
            }
        });
        return enrollList;
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
     */
    public List<Attendance> getByTeamIdAndKlassSeminarId(String teamId, String klassSeminarId) {
        return attendanceMapper.selectAttendanceByTeamIdAndKlassSeminarId(teamId, klassSeminarId);
    }


}

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

    public List<Attendance> getAttendanceByClbumSeminarId(String clbumSeminarId){
        return attendanceMapper.selectAttendanceByClbumSeminarId(clbumSeminarId);
    }

    /**
     * @author Xinyu Shi
     */
    public List<Attendance> getAll()
    {
        return attendanceMapper.selectAllAttendance();
    }

    /**
     * @author Xinyu Shi
     */
    public List<Attendance> getByClbumSeminarId(String clbumSeminarId)
    {
        return attendanceMapper.selectAttendanceByClbumSeminarId(clbumSeminarId);
    }

    /**
     * @author Xinyu Shi
     */
    public List<Attendance> getById(String id)
    {
        return attendanceMapper.selectAttendanceById(id);
    }

    /**
     * @author Xinyu Shi
     */
    public List<Attendance> getByTeamId(String teamId)
    {
        return attendanceMapper.selectAttendanceByTeamId(teamId);
    }

    /**
     * @author Xinyu Shi
     */
    public void deleteByClbumSeminarId(String clbumSeminarId)
    {
        attendanceMapper.deleteAttendanceByClbumSeminarId(clbumSeminarId);
    }

    /**
     * @author Xinyu Shi
     */
    public void deleteById(String id)
    {
        attendanceMapper.deleteAttendanceById(id);
    }

    /**
     * @author Xinyu Shi
     */
    public void deleteByTeamId(String teamId)
    {
        attendanceMapper.deleteAttendanceByTeamId(teamId);
    }

    /**
     * @author Xinyu Shi
     */
    public void create(Attendance attendance)
    {
        attendanceMapper.insertAttendance(attendance);
    }

    /**
     * @author Xinyu Shi
     */
    public void update(Attendance attendance)
    {
        attendanceMapper.updateAttendance(attendance);
    }


}

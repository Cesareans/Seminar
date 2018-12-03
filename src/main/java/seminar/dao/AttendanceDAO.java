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
}

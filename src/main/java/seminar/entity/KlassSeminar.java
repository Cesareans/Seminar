package seminar.entity;

import cesare.mybatis.annotations.Gist;
import cesare.mybatis.annotations.ID;
import cesare.mybatis.annotations.Link;
import cesare.mybatis.annotations.TargetPackage;

import java.util.List;

/**
 * @author Cesare
 */
@TargetPackage(value = "seminar.mapper")
public class KlassSeminar {
    @ID(isIncrement = true)
    private String id;
    private int state;
    @Gist(unions = {"seminarId"})
    private String klassId;
    @Gist
    private String seminarId;

    @Link(gist = "id", select = "seminar.mapper.AttendanceMapper.selectAttendanceByKlassSeminarId")
    private List<Attendance> attendances;

    @Link(gist = "seminarId", select = "seminar.mapper.SeminarMapper.selectSeminarById")
    private Seminar seminar;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getKlassId() {
        return klassId;
    }

    public void setKlassId(String klassId) {
        this.klassId = klassId;
    }

    public String getSeminarId() {
        return seminarId;
    }

    public void setSeminarId(String seminarId) {
        this.seminarId = seminarId;
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }

    public Seminar getSeminar() {
        return seminar;
    }

    public void setSeminar(Seminar seminar) {
        this.seminar = seminar;
    }
}

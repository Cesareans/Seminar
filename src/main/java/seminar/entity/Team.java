package seminar.entity;

import cesare.mybatis.annotations.*;

import java.util.List;

/**
 * @author Cesare
 */
@TargetPackage(value = "seminar.mapper")
public class Team {
    @Block
    private static String[] teamStatus = new String[]{"不合法", "合法", "审核中"};

    @ID(isIncrement = true)
    private String id;
    @SqlMap("team_serial")
    private String serial;
    private String teamName;
    private int status;
    @Gist
    private String courseId;
    @Gist
    private String klassId;
    private String leaderId;

    @Link(gist = "leaderId", select = "seminar.mapper.StudentMapper.selectStudentById")
    private Student leader;
    @Link(gist = "id", select = "seminar.mapper.relation.KlassStudentMapper.selectStudentsByTeamId")
    private List<Student> students;
    @Link(gist = "klassId", select = "seminar.mapper.KlassMapper.selectKlassById")
    private Klass klass;

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

    public String getTeamStatus() {
        return teamStatus[status];
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getKlassId() {
        return klassId;
    }

    public void setKlassId(String klassId) {
        this.klassId = klassId;
    }

    public String getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId;
    }

    public Student getLeader() {
        return leader;
    }

    public void setLeader(Student leader) {
        this.leader = leader;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }
}
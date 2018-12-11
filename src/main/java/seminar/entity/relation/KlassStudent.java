package seminar.entity.relation;

import cesare.mybatis.annotations.Gist;
import cesare.mybatis.annotations.ID;
import cesare.mybatis.annotations.TargetPackage;

/**
 * @author Cesare
 */
@TargetPackage(value = "seminar.mapper")
public class KlassStudent {
    @ID(isIncrement = true)
    private String id;
    @Gist
    private String klassId;
    @Gist
    private String studentId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKlassId() {
        return klassId;
    }

    public void setKlassId(String klassId) {
        this.klassId = klassId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}

package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;
import seminar.entity.Klass;
import seminar.entity.relation.KlassStudent;
import seminar.mapper.KlassMapper;
import seminar.mapper.relation.KlassStudentMapper;

import java.util.List;

/**
 * @author Cesare
 */
@Component
public class KlassDao {
    private final KlassMapper klassMapper;
    private final KlassStudentMapper klassStudentMapper;

    @Autowired
    public KlassDao(KlassMapper klassMapper, KlassStudentMapper klassStudentMapper) {
        this.klassMapper = klassMapper;
        this.klassStudentMapper = klassStudentMapper;
    }

    public List<Klass> getByCourseId(String courseId) {
        return klassMapper.selectKlassByCourseId(courseId);
    }

    /**
     * @author lyf
     */
    public boolean create(Klass klass) {
        List<Klass> klasses = klassMapper.selectKlassByCourseId(klass.getCourseId());
        for (Klass c : klasses) {
            if (c.getKlassName().equals(klass.getKlassName())) {
                return false;
            }
        }

        klassMapper.insertKlass(klass);
        return true;
    }

    /**
     * @author lyf
     */
    public boolean update(Klass klass) {
        List<Klass> klasses = klassMapper.selectKlassByCourseId(klass.getCourseId());
        if (klasses.isEmpty()) {
            return false;
        } else {
            for (Klass c : klasses) {
                if (c.getKlassName().equals(klass.getKlassName())) {
                    klassMapper.updateKlass(klass);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @author cesare
     */
    public List<Klass> getById(String id) {
        return klassMapper.selectKlassById(id);
    }

    /**
     * @author cesare
     */
    public List<Klass> getByStudentId(String studentId) {
        return klassStudentMapper.selectKlassByStudentId(studentId);
    }

    /**
     * @author lyf
     */
    public void deleteById(String klassId) {
        //先删除班级成员
        klassStudentMapper.deleteKlassStudents(klassId);
        //再删除班级对象
        klassMapper.deleteKlassById(klassId);
    }

    public void deleteByCourseId(String courseId) {
        List<Klass> klasses = klassMapper.selectKlassByCourseId(courseId);
        klasses.forEach(klass -> {
            deleteById(klass.getId());
        });
    }

    /**
     * TODO: Here we just delete all students previously in the klass, ignoring the team. May lead bugs afterwards.
     *
     * @author cesare
     */
    public void deleteStudents(String klassId) {
        klassStudentMapper.deleteKlassStudents(klassId);
    }

    /**
     * @author cesare
     */
    public void insertStudent(KlassStudent klassStudent) {
        klassStudentMapper.insertStudentIntoKlass(klassStudent);
    }

}

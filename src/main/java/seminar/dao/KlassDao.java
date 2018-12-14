package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.Course;
import seminar.entity.Klass;
import seminar.mapper.CourseMapper;
import seminar.mapper.KlassMapper;

import java.util.List;

/**
 * @author Cesare
 */
@Component
public class KlassDao {
    private final KlassMapper klassMapper;
    private final CourseMapper courseMapper;

    @Autowired
    public KlassDao(KlassMapper klassMapper, CourseMapper courseMapper) {
        this.klassMapper = klassMapper;
        this.courseMapper = courseMapper;
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
     * @author lyf
     */
    public boolean deleteById(String klassId) {
        List<Klass> klasses = klassMapper.selectKlassById(klassId);
        if (klasses.isEmpty()) {
            return false;
        } else {
            klassMapper.deleteKlassById(klassId);
            return true;
        }
    }

    /**
     * @author lyf
     */
    public boolean deleteByCourseId(String courseId) {
        List<Course> courses = courseMapper.selectCourseById(courseId);
        if (courses.isEmpty()) {
            return false;
        } else {
            klassMapper.deleteKlassByCourseId(courseId);
            return true;
        }
    }

}

package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.Clbum;
import seminar.mapper.ClbumMapper;
import seminar.entity.Course;
import seminar.mapper.CourseMapper;

import java.util.List;

/**
 * @author Cesare
 */
@Component
public class ClbumDao {
    private final ClbumMapper clbumMapper;
    private final CourseMapper courseMapper;

    @Autowired
    public ClbumDao(ClbumMapper clbumMapper, CourseMapper courseMapper) {
        this.clbumMapper = clbumMapper;
        this.courseMapper = courseMapper;
    }

    public List<Clbum> getByCourseId(String courseId){
        return clbumMapper.selectClbumByCourseId(courseId);
    }

    /**
     * @author lyf
     */
    public boolean create(Clbum clbum){
        List<Clbum> clbums = clbumMapper.selectClbumByCourseId(clbum.getCourseId());
        for(Clbum c:clbums){
            if(c.getClbumName().equals(clbum.getClbumName()))
                return false;
        }

        clbumMapper.insertClbum(clbum);
        return true;
    }

    /**
     * @author lyf
     */
    public boolean update(Clbum clbum){
        List<Clbum> clbums = clbumMapper.selectClbumByCourseId(clbum.getCourseId());
        for(Clbum c:clbums){
            if(c.getClbumName().equals(clbum.getClbumName()))
                return false;
        }
        clbumMapper.updateClbum(clbum);
        return true;
    }

    /**
     * @author lyf
     */
    public boolean deleteById(String clbumId){
        List<Clbum> clbums = clbumMapper.selectClbumById(clbumId);
        if(clbums.isEmpty())
            return false;
        else {
            clbumMapper.deleteClbumById(clbumId);
            return true;
        }
    }

    /**
     * @author lyf
     */
    public boolean deleteByCourseId(String courseId){
        List<Course> courses = courseMapper.selectCourseById(courseId);
        if(courses.isEmpty())
            return false;
        else{
            clbumMapper.deleteClbumByCourseId(courseId);
            return true;
        }
    }

}

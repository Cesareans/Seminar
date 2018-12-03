package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.Clbum;
import seminar.mapper.ClbumMapper;

import java.util.List;

/**
 * @author Cesare
 */
@Component
public class ClbumDao {
    private final ClbumMapper clbumMapper;

    @Autowired
    public ClbumDao(ClbumMapper clbumMapper) {
        this.clbumMapper = clbumMapper;
    }

    public List<Clbum> getClbumsByCourseId(String courseId){
        return clbumMapper.selectClbumByCourseId(courseId);
    }

    /**
     * @author lyf
     */
    public void createClbum(Clbum clbum){
        clbumMapper.insertClbum(clbum);
    }

    /**
     * @author lyf
     */
    public void updateClbum(Clbum clbum){
        clbumMapper.updateClbum(clbum);
    }

    /**
     * @author lyf
     */
    public void deleteClbumById(String clbumId){
        clbumMapper.deleteClbumById(clbumId);
    }

    /**
     * @author lyf
     */
    public void deleteClbumByCourseId(String courseId){
        clbumMapper.deleteClbumByCourseId(courseId);
    }

}

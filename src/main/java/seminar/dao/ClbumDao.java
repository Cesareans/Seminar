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
}

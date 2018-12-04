package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.ClbumSeminar;
import seminar.mapper.ClbumSeminarMapper;

import java.util.List;

/**
 * @author Cesare
 */
@Component
public class ClbumSeminarDAO {
    private final ClbumSeminarMapper clbumSeminarMapper;

    @Autowired
    public ClbumSeminarDAO(ClbumSeminarMapper clbumSeminarMapper) {
        this.clbumSeminarMapper = clbumSeminarMapper;
    }

    public List<ClbumSeminar> getClbumSeminarByClbumIdAndSeminarId(String clbumId, String seminarId){
        return clbumSeminarMapper.selectClbumSeminarByClbumIdAndSeminarId(clbumId,seminarId);
    }

    public List<ClbumSeminar> getClbumSeminarByClbumSeminarId(String clbumSeminarId){
        return clbumSeminarMapper.selectClbumSeminarById(clbumSeminarId);
    }
}

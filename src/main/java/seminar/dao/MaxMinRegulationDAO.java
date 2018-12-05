package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.MaxMinRegulation;
import seminar.mapper.MaxMinRegulationMapper;

import java.util.List;

/**
 * @author lyf
 */
@Component
public class MaxMinRegulationDAO {
    private final MaxMinRegulationMapper maxMinRegulationMapper;

    @Autowired
    public MaxMinRegulationDAO(MaxMinRegulationMapper maxMinRegulationMapper) {
        this.maxMinRegulationMapper = maxMinRegulationMapper;
    }

    /**
     * @author lyf
     */
    public boolean create(MaxMinRegulation maxminRegulation){
        List<MaxMinRegulation> maxMinRegulations = maxMinRegulationMapper.selectMaxMinRegulationByCourseId(maxminRegulation.getCourseId());
        if(maxMinRegulations.isEmpty()){
            maxMinRegulationMapper.insertMaxMinRegulation(maxminRegulation);
            return true;
        }
        else return false;
    }

    /**
     * @author lyf
     */
    public boolean update(MaxMinRegulation maxminRegulation){
        List<MaxMinRegulation> maxMinRegulations = maxMinRegulationMapper.selectMaxMinRegulationByCourseId(maxminRegulation.getCourseId());
        if(maxMinRegulations.isEmpty())
            return false;
        else{
            maxMinRegulationMapper.updateMaxMinRegulation(maxminRegulation);
            return true;
        }

    }

    /**
     * @author lyf
     */
    public List<MaxMinRegulation> getByCourseId(String CourseId){
        return maxMinRegulationMapper.selectMaxMinRegulationByCourseId(CourseId);
    }

    /**
     * @author lyf
     */
    public void deleteByCourseId(String courseId){
        maxMinRegulationMapper.deleteMaxMinRegulationByCourseId(courseId);
    }
}

package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.MaxMinRegulation;
import seminar.mapper.MaxMinRegulationMapper;

import javax.validation.constraints.Max;
import java.util.List;

@Component
public class MaxMinRegulationDAO {
    private final MaxMinRegulationMapper maxminRegulationMapper;

    @Autowired
    public MaxMinRegulationDAO(MaxMinRegulationMapper maxminRegulationMapper) {
        this.maxminRegulationMapper = maxminRegulationMapper;
    }

    /**
     * @author lyf
     */
    public boolean create(MaxMinRegulation maxminRegulation){
        List<MaxMinRegulation> maxMinRegulations = maxminRegulationMapper.selectMaxMinRegulationByCourseId(maxminRegulation.getCourseId());
        if(maxMinRegulations.isEmpty()){
            maxminRegulationMapper.insertMaxMinRegulation(maxminRegulation);
            return true;
        }
        else return false;
    }

    /**
     * @author lyf
     */
    public boolean update(MaxMinRegulation maxminRegulation){
        List<MaxMinRegulation> maxMinRegulations = maxminRegulationMapper.selectMaxMinRegulationByCourseId(maxminRegulation.getCourseId());
        if(maxMinRegulations.isEmpty())
            return false;
        else{
            maxminRegulationMapper.updateMaxMinRegulation(maxminRegulation);
            return true;
        }

    }

    /**
     * @author lyf
     */
    public List<MaxMinRegulation> getByCourseId(String CourseId){
        return maxminRegulationMapper.selectMaxMinRegulationByCourseId(CourseId);
    }
}

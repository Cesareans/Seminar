package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.MaxMinRegulation;
import seminar.mapper.MaxMinRegulationMapper;

import java.util.List;

@Component
public class MaxMinRegulationDAO {
    private final MaxMinRegulationMapper maxminRegulationMapper;

    @Autowired
    public MaxMinRegulationDAO(MaxMinRegulationMapper maxminRegulationMapper) {
        this.maxminRegulationMapper = maxminRegulationMapper;
    }

}

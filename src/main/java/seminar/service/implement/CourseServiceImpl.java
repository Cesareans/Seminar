package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.ClbumDao;
import seminar.dao.CourseDAO;
import seminar.dao.SeminarDAO;
import seminar.dao.MaxMinRegulationDAO;
import seminar.entity.Clbum;
import seminar.entity.Course;
import seminar.entity.MaxMinRegulation;
import seminar.entity.Seminar;
import seminar.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseDAO courseDAO;
    private final ClbumDao clbumDAO;
    private final SeminarDAO seminarDAO;
    private final MaxMinRegulationDAO maxMinRegulationDAO;

    @Autowired
    public CourseServiceImpl(CourseDAO courseDAO, ClbumDao clbumDAO, SeminarDAO seminarDAO, MaxMinRegulationDAO maxMinRegulationDAO){
        this.courseDAO = courseDAO;
        this.clbumDAO = clbumDAO;
        this.seminarDAO = seminarDAO;
        this.maxMinRegulationDAO = maxMinRegulationDAO;
    }


}

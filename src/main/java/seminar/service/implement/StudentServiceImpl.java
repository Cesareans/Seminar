package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.StudentDAO;
import seminar.entity.Student;
import seminar.entity.Team;
import seminar.service.StudentService;

import java.util.List;

/**
 * @author Cesare
 */
@Service
public class StudentServiceImpl implements StudentService {
    private StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    /**
     * @author SWJ
     * TODO:Need change when TeamDAO finish.
     */
    @Override
    public boolean createTeam(Team team){
        return true;
    }


}

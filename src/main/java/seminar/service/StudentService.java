package seminar.service;

import seminar.entity.Student;
import seminar.entity.Team;

import java.util.List;

/**
 * @author Cesare
 */
public interface StudentService {
    /**
     * TODO:Write Javadoc
     *
     * @param studentNum student'num
     * @return void
     */
    public List<Student> getStudentBySN(String studentNum);

    /**
     * TODO[SWJ]:
     * create a new team
     *
     * @param team new team
     * @author SWJ
     * @return boolean
     */
    public boolean createTeam(Team team);

}

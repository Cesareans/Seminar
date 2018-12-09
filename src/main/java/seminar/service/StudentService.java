package seminar.service;

import seminar.entity.Student;
import seminar.entity.Team;

import java.util.List;

/**
 * @author Cesare
 */
public interface StudentService {

    /**
     * Create a new team
     * @author SWJ
     * @param  team refer gist
     * @return success or fail
     */
    public boolean createTeam(Team team);

    /**
     * Leave from the team
     * @author SWJ
     * @param  studentId refer gist
     */
    public void leaveTeam(String studentId);
}

package seminar.service;

import seminar.entity.Student;
import seminar.entity.Team;

import java.util.List;

/**
 * @author Xinyu Shi
 */
public interface LeaderService {

    /**
     *
     * @author Xinyu Shi
     * @param teamId
     * @param studentId
     * @return
     */
    public boolean addGroupMember(String courseId, String teamId, String studentId);

    /**
     * @author Xinyu Shi
     * @param teamId
     */
    public void submitReviewRequest(String teamId);

    /**
     * @author Xinyu Shi
     * @param teamId
     * @param studentId
     */
    public void deleteGroupMember(String courseId, String teamId, String studentId);
}

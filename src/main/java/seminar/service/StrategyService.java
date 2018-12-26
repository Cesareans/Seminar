package seminar.service;

import seminar.entity.Team;

/**
 * @author Xinyu Shi
 */
public interface StrategyService {

    /**
     * validate the team.
     * @author Xinyu Shi
     * @param teamId
     * @param courseId
     * @return
     */
    boolean validate(String teamId, String courseId);

}

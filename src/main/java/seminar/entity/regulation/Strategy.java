package seminar.entity.regulation;

import seminar.entity.Team;

/**
 * @author Xinyu Shi
 */
public interface Strategy {
    /**
     * validate the team according to the atomic strategy.
     * @author Xinyu Shi
     * @param team
     * @return
     */
    boolean validate(Team team);

    /**
     * get error message of which strategy is conflicted.
     * @author Xinyu Shi
     * @return
     */
    String getErrorMsg();
}

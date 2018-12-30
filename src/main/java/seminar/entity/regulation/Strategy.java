package seminar.entity.regulation;

import seminar.entity.Team;

/**
 * @author Xinyu Shi
 */
public interface Strategy {
    /**
     * validate the team according to the atomic strategy.
     *
     * @param team
     * @return
     * @author Xinyu Shi
     */
    boolean validate(Team team);

    /**
     * get error message of which strategy is conflicted.
     *
     * @return
     * @author Xinyu Shi
     */
    String getErrorMsg();
}

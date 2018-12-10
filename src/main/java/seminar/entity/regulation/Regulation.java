package seminar.entity.regulation;

import seminar.entity.Team;

/**
 * @author Cesare
 */
public interface Regulation {
    /**
     * Use regulation to validate a team's structure.
     *
     * @param team the team that need validating
     * @return whether the team passed the validating.
     */
    boolean validate(Team team);

    /**
     * Get the regulation's msg if validation does not pass.
     *
     * @return the error message.
     */
    String getErrorMsg();
}

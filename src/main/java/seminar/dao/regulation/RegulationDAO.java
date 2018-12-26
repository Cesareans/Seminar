package seminar.dao.regulation;

import seminar.entity.Team;
import seminar.entity.regulation.Regulation;

/**
 * @author Xinyu Shi
 */
public interface RegulationDAO {

    void setRegulation(String regulationId);

    boolean validate(Team team);

    String getErrorMsg();
}

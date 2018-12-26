package seminar.entity.regulation;

import seminar.entity.Team;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Cesare
 */
public class RegulationComposition {
    private List<Regulation> regulations;

    public List<String> validate(Team team) {
        List<String> errorMessages = new LinkedList<>();
//        regulations.forEach(regulation -> {
//            if (!regulation.validate(team)) {
//                errorMessages.add(regulation.getErrorMsg());
//            }
//        });
        return errorMessages;
    }

    public List<Regulation> getRegulations() {
        return regulations;
    }

    public void setRegulations(List<Regulation> regulations) {
        this.regulations = regulations;
    }
}

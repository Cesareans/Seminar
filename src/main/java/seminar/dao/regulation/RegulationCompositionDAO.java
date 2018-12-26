package seminar.dao.regulation;

import seminar.entity.Team;
import seminar.entity.regulation.Regulation;

import java.util.LinkedList;
import java.util.List;

public class RegulationCompositionDAO {

    private List<Regulation> regulations;
    private final String DAO_MARKER = "DAO";
    private RegulationDAO regulationDAO;


    public List<String> validate(Team team) {
        List<String> errorMessages = new LinkedList<>();
        regulations.forEach(regulation -> {
            try {
                regulationDAO = (RegulationDAO) Class.forName(regulation.getStrategyName()+DAO_MARKER).newInstance();
                if (!regulationDAO.validate(team)) {
                    errorMessages.add(regulationDAO.getErrorMsg());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        });
        return errorMessages;
    }

    public List<Regulation> getRegulations() {
        return regulations;
    }

    public void setRegulations(List<Regulation> regulations) {
        this.regulations = regulations;
    }
}

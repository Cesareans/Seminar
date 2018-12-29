package seminar.service;


import seminar.entity.Team;
import seminar.pojo.dto.CourseCreateDTO;

/**
 * @author Xinyu Shi
 */
public interface StrategyService {
   /**
    * Validate a team
    * @param team the validate target
    */
   void handleVariation(Team team);

   /**
    * Validate a team via course's strategy
    * @param teamId the team refer gist
    * @param courseId the course refer gsit
    * @return whether valid
    */
   boolean validate(String teamId, String courseId);

   /**
    * create strategy and store into DB.
    * @author Xinyu Shi
    * @param courseCreateDTO the target dto
    * @param courseId the refer gist
    */
   void createStrategy(CourseCreateDTO courseCreateDTO, String courseId);

}

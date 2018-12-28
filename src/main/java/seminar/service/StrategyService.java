package seminar.service;


import seminar.pojo.dto.CourseCreateDTO;

/**
 * @author Xinyu Shi
 */
public interface StrategyService {
   /**
    * Validate a team via course's strategy
    * @param teamId the team refer gist
    * @param courseId the course refer gsit
    * @return whether valid
    */
   boolean validate(String teamId, String courseId);

   /**
    * @author Xinyu Shi
    * create strategy and store into DB.
    * @param courseCreateDTO the target dto
    * @param courseId the refer gist
    */
   void createStrategy(CourseCreateDTO courseCreateDTO, String courseId);

}

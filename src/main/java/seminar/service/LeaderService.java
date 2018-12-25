package seminar.service;

/**
 * @author Xinyu Shi
 */
public interface LeaderService {

   boolean addGroupMember(String studentId, String teamId);

   boolean deleteGroupMember(String studentId, String teamId);

   boolean createTeam(String studentId, String courseId, String klassId, String teamName);

   void dissolveTeam(String teamId);

}

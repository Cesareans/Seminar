package seminar.service;

/**
 * @author Xinyu Shi
 */
public interface LeaderService {

   boolean addGroupMember(String studentId, String courseId, String teamId);

   boolean deleteGroupMember(String studentId, String courseId, String teamId);

}

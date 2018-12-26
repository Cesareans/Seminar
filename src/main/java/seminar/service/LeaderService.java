package seminar.service;

import seminar.entity.Team;

/**
 * @author Xinyu Shi
 */
public interface LeaderService {

   boolean addGroupMember(String studentId, String teamId);

   boolean deleteGroupMember(String studentId, String teamId);

   boolean createTeam(Team team);

   void dissolveTeam(String teamId);

}

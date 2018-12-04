package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.GroupValidityMsg;
import seminar.mapper.GroupValidityMsgMapper;

import java.util.List;

/**
 * @author SWJ
 */
@Component
public class GroupValidityMsgDAO {
    private GroupValidityMsgMapper groupValidityMsgMapper;
    @Autowired
    public GroupValidityMsgDAO(GroupValidityMsgMapper groupValidityMsgMapper){
        this.groupValidityMsgMapper = groupValidityMsgMapper;
    }

    public void create(GroupValidityMsg groupValidityMsg){
        groupValidityMsgMapper.insertGroupValidityMsg(groupValidityMsg);
    }
    public void update(GroupValidityMsg groupValidityMsg){
        groupValidityMsgMapper.updateGroupValidityMsg(groupValidityMsg);
    }
    public List<GroupValidityMsg> getAll(){
        return groupValidityMsgMapper.selectAllGroupValidityMsg();
    }
    public List<GroupValidityMsg> getById(String id){
        return groupValidityMsgMapper.selectGroupValidityMsgById(id);
    }
    public List<GroupValidityMsg> getByTeacherId(String teacherId){
        return groupValidityMsgMapper.selectGroupValidityMsgByTeacherId(teacherId);
    }
    public List<GroupValidityMsg> getByTeamId(String teamId){
        return groupValidityMsgMapper.selectGroupValidityMsgByTeamId(teamId);
    }
    public void deleteById(String id){
        groupValidityMsgMapper.deleteGroupValidityMsgById(id);
    }
    public void deleteByTeacherId(String teacherId){
        groupValidityMsgMapper.deleteGroupValidityMsgByTeacherId(teacherId);
    }
    public void deleteByTeamId(String teamId){
        groupValidityMsgMapper.deleteGroupValidityMsgByTeamId(teamId);
    }
}

package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.message.GroupValidityMsg;
import seminar.mapper.GroupValidityMsgMapper;

import java.util.List;

/**
 * @author SWJ
 */
@Component
public class GroupValidityMsgDAO {
    private final GroupValidityMsgMapper groupValidityMsgMapper;

    @Autowired
    public GroupValidityMsgDAO(GroupValidityMsgMapper groupValidityMsgMapper) {
        this.groupValidityMsgMapper = groupValidityMsgMapper;
    }

    public void create(GroupValidityMsg groupValidityMsg) {
        groupValidityMsgMapper.insertGroupValidityMsg(groupValidityMsg);
    }

    public boolean update(GroupValidityMsg groupValidityMsg) {
        if (!groupValidityMsgMapper.selectGroupValidityMsgById(groupValidityMsg.getId()).isEmpty()) {
            groupValidityMsgMapper.updateGroupValidityMsg(groupValidityMsg);
            return true;
        }
        return false;
    }

    public List<GroupValidityMsg> getAll() {
        return groupValidityMsgMapper.selectAllGroupValidityMsg();
    }

    public List<GroupValidityMsg> getById(String id) {
        return groupValidityMsgMapper.selectGroupValidityMsgById(id);
    }

    public List<GroupValidityMsg> getByTeacherId(String teacherId) {
        return groupValidityMsgMapper.selectGroupValidityMsgByTeacherId(teacherId);
    }

    public List<GroupValidityMsg> getByTeamId(String teamId) {
        return groupValidityMsgMapper.selectGroupValidityMsgByTeamId(teamId);
    }

    public void deleteById(String id) {
        groupValidityMsgMapper.deleteGroupValidityMsgById(id);
    }

    public void deleteByTeacherId(String teacherId) {
        groupValidityMsgMapper.deleteGroupValidityMsgByTeacherId(teacherId);
    }

    public void deleteByTeamId(String teamId) {
        groupValidityMsgMapper.deleteGroupValidityMsgByTeamId(teamId);
    }
}

package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.Admin;
import seminar.mapper.AdminMapper;

import java.util.List;

/**
 * @author Cesare
 */
@Component
public class AdminDAO {
    private AdminMapper adminMapper;

    @Autowired
    public AdminDAO(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    public List<Admin> getByName(String name){
        return adminMapper.selectAdminByName(name);
    }
}

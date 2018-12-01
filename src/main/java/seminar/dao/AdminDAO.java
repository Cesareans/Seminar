package seminar.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seminar.entity.Administrator;
import seminar.mapper.AdministratorMapper;

import java.util.List;

/**
 * @author Cesare
 */
@Component
public class AdminDAO {
    private AdministratorMapper adminMapper;

    @Autowired
    public AdminDAO(AdministratorMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    public List<Administrator> getByName(String name) {
        return adminMapper.selectAdministratorByAdminName(name);
    }
}

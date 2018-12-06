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

    /**
     * @author lyf
     */
    public boolean create(Administrator administrator){

        if(adminMapper.selectAdministratorByAdminName(administrator.getAdminName()).isEmpty()) {
            adminMapper.insertAdministrator(administrator);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * @author lyf
     */
    public boolean deleteByName(String adminName){
        if(adminMapper.selectAdministratorByAdminName(adminName).isEmpty()) {
            return false;
        }
        else{
            adminMapper.deleteAdministratorByAdminName(adminName);
            return true;
        }

    }

    /**
     * @author lyf
     */
    public boolean update(Administrator administrator){
        if(adminMapper.selectAdministratorByAdminName(administrator.getAdminName()).isEmpty()) {
            return false;
        }
        else{
            adminMapper.updateAdministrator(administrator);
            return true;
        }

    }

}

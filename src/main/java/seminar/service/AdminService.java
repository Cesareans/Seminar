package seminar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.entity.Admin;
import seminar.mapper.AdminMapper;

import java.util.List;

/**
 * @author Cesare
 */
@Service
public class AdminService {
    private AdminMapper mapper;

    @Autowired
    public AdminService(AdminMapper mapper) {
        this.mapper = mapper;
    }

    public boolean adminVerify(Admin admin){
        List<Admin> foundAdmin = mapper.selectAdminByName(admin.getName());
        return foundAdmin.size() != 0 && foundAdmin.get(0).getPassword().equals(admin.getPassword());
    }
}

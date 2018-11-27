package seminar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import seminar.dao.AdminDAO;
import seminar.entity.Admin;
import seminar.mapper.AdminMapper;

import java.util.List;

/**
 * @author Cesare
 */
@Service
public class AdminService {
    private AdminDAO adminDAO;

    @Autowired
    public AdminService(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

}

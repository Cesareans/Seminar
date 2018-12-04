package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import seminar.dao.AdminDAO;
import seminar.entity.Administrator;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Cesare
 */
@Service
public class AdminDetailServiceImpl implements UserDetailsService {
    private final AdminDAO adminDAO;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AdminDetailServiceImpl(AdminDAO adminDAO, PasswordEncoder passwordEncoder) {
        this.adminDAO = adminDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> roleList = new LinkedList<>();
        List<Administrator> foundAdmin = adminDAO.getByName(username);
        if (foundAdmin.size() != 0) {
            roleList.add(new SimpleGrantedAuthority("ROLE_admin"));
            String password = passwordEncoder.encode(foundAdmin.get(0).getPassword());
            return new User(username, password, roleList);
        }
        throw new UsernameNotFoundException("Admin " + username + " not found!");
    }
}

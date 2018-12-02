package seminar.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import seminar.dao.AdminDAO;
import seminar.dao.StudentDAO;
import seminar.dao.TeacherDAO;
import seminar.entity.Administrator;
import seminar.entity.Student;
import seminar.entity.Teacher;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Cesare
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AdminDAO adminDAO;
    private final StudentDAO studentDAO;
    private final TeacherDAO teacherDAO;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserDetailsServiceImpl(PasswordEncoder passwordEncoder, AdminDAO adminDAO, StudentDAO studentDAO, TeacherDAO teacherDAO) {
        this.passwordEncoder = passwordEncoder;
        this.adminDAO = adminDAO;
        this.studentDAO = studentDAO;
        this.teacherDAO = teacherDAO;
    }

    /**
     * TODO[inferiority]: Such code is in a mess. Please refine if time is enough.
     *
     * @param username load user by given username
     * @return the found user
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        //New a list to contain user's role

        List<GrantedAuthority> roleList = new LinkedList<>();
        List<Administrator> foundAdmin = adminDAO.getByName(username);
        if (foundAdmin.size() != 0) {
            roleList.add(new SimpleGrantedAuthority("ROLE_admin"));
            String password = passwordEncoder.encode(foundAdmin.get(0).getPassword());
            return new User(username, password, roleList);
        }
        List<Teacher> foundTeacher = teacherDAO.getByTN(username);
        if (foundTeacher.size() != 0) {
            roleList.add(new SimpleGrantedAuthority("ROLE_teacher"));
            String password = passwordEncoder.encode(foundTeacher.get(0).getPassword());
            return new User(username, password, roleList);
        }
        List<Student> foundStudent = studentDAO.getBySN(username);
        if (foundStudent.size() != 0) {
            roleList.add(new SimpleGrantedAuthority("ROLE_student"));
            String password = passwordEncoder.encode(foundStudent.get(0).getPassword());
            return new User(username, password, roleList);
        }
        return new User("", passwordEncoder.encode(""), roleList);
    }
}

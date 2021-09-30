package web.service;

import org.springframework.stereotype.Service;
import web.dao.RoleDao;
import web.dao.UserDao;
import web.model.Role;
import web.model.User;
import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private RoleDao roleDao;

    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Override
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }

    @Override
    public void removeUser(int id) {
        this.userDao.removeUser(id);
    }

    @Override
    public User getUserById(long id) {
        return this.userDao.getUserById(id);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }

    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }
}

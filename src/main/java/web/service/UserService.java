package web.service;

import web.model.Role;
import web.model.User;
import java.util.List;

public interface UserService {
    public void addUser(User user);

    public void updateUser(User user);

    public void removeUser(int id);

    public User getUserById(long id);

    public List<User> listUsers();

    List<Role> getRoles();

    User findByName(String name);
}

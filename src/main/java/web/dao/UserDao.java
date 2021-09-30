package web.dao;

import web.model.User;
import java.util.List;


public interface UserDao {
    void addUser(User user);

    void updateUser(User user);

    void removeUser(int id);

    User getUserById(long id);

    List<User> listUsers();

    User findByName(String name);
}

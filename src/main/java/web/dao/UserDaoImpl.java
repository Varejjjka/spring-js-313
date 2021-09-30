package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("FROM User").getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void removeUser(int id) {
        User user = getUserById(id);
        entityManager.remove(user);
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User findByName(String name) {
             Query query = entityManager.createQuery("from User where name = :name", User.class)
                     .setParameter("name", name);
             return (User) query.getSingleResult();
    }
}

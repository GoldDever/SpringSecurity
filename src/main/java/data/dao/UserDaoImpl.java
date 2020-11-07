package data.dao;

import data.entity.User;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao{


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        return entityManager.createQuery
                ("select u from User u", User.class).getResultList();
    }

    @Override
    public User getById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(long id, User updatedUser) {
        entityManager.merge(updatedUser);
    }

    @Override
    public void remove(long id) {
        User user = getById(id);
        entityManager.remove(user);
    }

    @Override
    public User getUserByUserName(String login) {

        Query q = (Query) entityManager.createQuery("select user from User user where user.name = :name");
        q.setParameter("name", login);
        User user = (User) q.getSingleResult();
        //return (User) entityManager.createQuery("select u from User u where u=:login", User.class);
        return user;
    }
}

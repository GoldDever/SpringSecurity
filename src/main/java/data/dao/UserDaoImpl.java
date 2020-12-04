package data.dao;

import data.entity.Role;
import data.entity.User;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        User user = getById(id);
        user.setAge(updatedUser.getAge());
        user.setName(updatedUser.getName());
        user.setLastName(updatedUser.getLastName());
        user.setRoles(updatedUser.getRoles());
        user.setLogin(updatedUser.getLogin());
        user.setPassword(updatedUser.getPassword());
        entityManager.merge(user);
        System.out.println("Inside userDaoImpl");
    }

    @Override
    public void remove(long id) {
        User user = getById(id);
        System.out.println("in UserDaoImpl delete method");
        entityManager.remove(user);
        System.out.println("After delete method");
    }

    @Override
    public User getUserByUserName(String login) {
        Query q = (Query) entityManager.createQuery("SELECT u FROM User u WHERE u.login=:name");
        q.setParameter("name", login);
        User user = (User) q.getSingleResult();
        return user;
    }

    @Override
    public Role findRoleByName(String roleName) {
        TypedQuery<Role> query = entityManager.createQuery("SELECT r FROM Role r WHERE r.role = :role", Role.class);
        Role role = query.setParameter("role", roleName).getSingleResult();
        return role;
    }
}

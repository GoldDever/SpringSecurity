package data.dao;

import data.entity.Role;
import data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Set<Role> getAll() {
        List<Role> list = entityManager.createQuery(
                "select u from Role u", Role.class).getResultList();
        Set<Role> set = new HashSet<>();
        for (Role r: list) {
            set.add(r);
        }
        return set;
    }

    @Override
    public Role getById(long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public void save(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void remove(long id) {
        entityManager.remove(id);
    }



}

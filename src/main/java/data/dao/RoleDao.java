package data.dao;

import data.entity.Role;
import data.entity.User;

import java.util.List;
import java.util.Set;

public interface RoleDao {
    Set<Role> getAll();
    Role getById(long id);
    void save(Role role);
    void remove(long id);
}

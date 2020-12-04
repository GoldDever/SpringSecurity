package data.dao;

import data.entity.Role;
import data.entity.User;

import java.util.List;
import java.util.Set;

public interface UserDao {
    List<User> getAll();
    User getById(long id);
    void save(User user);
    void remove(long id);
    void update(long id, User user);
    User getUserByUserName(String name);
    public Role findRoleByName(String roleName);
}

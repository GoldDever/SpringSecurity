package data.dao;

import data.entity.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
    User getById(long id);
    void save(User user);
    void remove(long id);

    void update(long id, User user);
}

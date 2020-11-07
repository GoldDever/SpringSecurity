package data.service;

import data.dao.UserDao;
import data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User getById(long id) {
        return userDao.getById(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional
    public void update(long id, User updatedUser) {
        userDao.update(id, updatedUser);
    }

    @Override
    @Transactional
    public void remove(long id) {
        userDao.remove(id);
    }

    @Override
    public User getUserByUserName(String name) {
        return userDao.getUserByUserName(name);
    }
}

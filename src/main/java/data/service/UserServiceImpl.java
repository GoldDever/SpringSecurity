package data.service;

import data.dao.UserDao;
import data.entity.Role;
import data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


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

    @Override
    @Transactional
    public void update(long id, User updatedUser) {

        userDao.update(id, updatedUser);
    }

    @Override
    @Transactional
    public void remove(long id) {
        System.out.println("In userService Delete method");
        userDao.remove(id);
    }

    @Override
    public User getUserByUserName(String name) {
        return userDao.getUserByUserName(name);
    }

    @Override
    public Set<Role> newRoles(String[] roles) {
        System.out.println("new roles: " + roles);
        Set<Role> roleSet = new HashSet<>();
        for (String roleName : roles) {
            roleSet.add(userDao.findRoleByName(roleName));
        }
        return roleSet;
    }

}

package data.service;

import data.dao.RoleDao;
import data.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;

    @Override
    public Set<Role> getAll() {
        return roleDao.getAll();
    }

    @Override
    public Role getById(long id) {
        return roleDao.getById(id);
    }

    @Override
    @Transactional
    public void save(Role role) {
            roleDao.save(role);
    }

    @Override
    @Transactional
    public void remove(long id) {
        roleDao.remove(id);
    }


}


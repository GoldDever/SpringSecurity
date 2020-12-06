package data.service;

import data.entity.Role;

import java.util.Set;

public interface RoleService {
    Set<Role> getAll();
    Role getById(long id);
    void save(Role role);
    void remove(long id);
}

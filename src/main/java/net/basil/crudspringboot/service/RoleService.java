package net.basil.crudspringboot.service;

import net.basil.crudspringboot.model.Role;

import java.util.Set;

public interface RoleService {

    Set<Role> getRoleSet(Set<String> roles);

    Role getDefaultRole();

}

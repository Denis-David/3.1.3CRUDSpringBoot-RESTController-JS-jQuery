package net.basil.crudspringboot.service;

import net.basil.crudspringboot.model.Role;
import net.basil.crudspringboot.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Value("${defaultRoleName}")
    private String defaultRoleName;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Set<Role> getRoleSet(Set<String> roles) {
        return new HashSet<>(roleRepository.getRolesByNameIn(roles));
    }

    @Override
    public Role getDefaultRole() {
        return roleRepository.getRoleByName(defaultRoleName);
    }
}

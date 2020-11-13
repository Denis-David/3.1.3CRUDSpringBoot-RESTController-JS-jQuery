package net.basil.crudspringboot.service;

import net.basil.crudspringboot.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    void addUser(User user);

    List<User> getAllUsers();

    void deleteUser(Long id);

    void updateUser(User user);

    User getUserById(Long id);

    User getAuthUser();

    User findUserByEmail(String email);

}

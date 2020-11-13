package net.basil.crudspringboot.repository;

import net.basil.crudspringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByName(String name);

    User findUserByEmail(String email);

}

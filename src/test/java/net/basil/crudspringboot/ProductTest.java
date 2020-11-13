package net.basil.crudspringboot;

import net.basil.crudspringboot.model.Role;
import net.basil.crudspringboot.model.User;
import net.basil.crudspringboot.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.HashSet;
import java.util.Set;

@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class ProductTest {

    @Autowired
    private UserRepository userRepository;

    Long st = System.nanoTime();

    @Test
    public void testCreateProduct() {
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(new Role(1L, "ROLE_ADMIN"));
        roleSet.add(new Role(2L, "ROLE_USER"));
        Long id = 200L;
        for (int i = 200; i < 10200; i++, id++) {
            User user = new User(id, "Bob" + i, "123" + i, "email" + i, roleSet);
            userRepository.save(user);
            System.out.println(userRepository.findUserByName(user.getName()).toString());

        }

        Long en = System.nanoTime();
        double stTimeSec = (double) st / 1_000_000_000;
        double enTimeSec = (double) en / 1_000_000_000;
        double enstTimeSec = (double) (en - st) / 1_000_000_000;
        System.out.println(id);
        System.out.println(stTimeSec);
        System.out.println(enTimeSec);
        System.out.println(enstTimeSec);

    }
}

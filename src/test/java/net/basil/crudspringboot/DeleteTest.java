package net.basil.crudspringboot;

import net.basil.crudspringboot.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class DeleteTest {

    @Autowired
    private UserRepository userRepository;

    Long id = 10600L;

    Long st = System.nanoTime();

    @Test
    @Rollback(false)
    public void deleteById() {
        for (int i = 0 ; i < 1000; i++, id++) {
            userRepository.deleteById(id);
            id++;
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

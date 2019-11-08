package concatel.curso2019.demo;

import concatel.curso2019.demo.entities.User;
import concatel.curso2019.demo.repositorios.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

/**
 * @author fphilip@houseware.es
 */
@ActiveProfiles({"test", "h2"})
@RunWith(SpringRunner.class)
@SpringBootTest
@EntityScan(basePackageClasses = User.class)
public class MyJPATest {

    @Autowired
    UserRepository userRepository;


    @Sql("classpath:/sql/test/found_ok.sql")
    @Transactional(readOnly = true)
    @Test
    public void find_by_id_ok() {
        User u = userRepository.findById(77).get();

        Assert.assertEquals(u.getName(),"Francisco");
    }

    @Test(expected = NoSuchElementException.class)
    public void find_by_id_not_found() {
        userRepository.findById(77).get();
    }
}

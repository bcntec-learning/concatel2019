package concatel2019.demo.repositorios;

import concatel2019.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author fphilip@houseware.es
 */
//estereotipo  --> bean especifico
@Repository //--> redundante.- nombre defecto
public interface UserRepository extends JpaRepository<User, Integer> {
}

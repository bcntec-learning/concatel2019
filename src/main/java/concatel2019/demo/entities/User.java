package concatel2019.demo.entities;

import concatel2019.demo.UserDTO;
import lombok.Getter;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @author fphilip@houseware.es
 */
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @NotNull
    String name;
    @Email
    @Column(length = 200)
    String email;

    public static UserDTO convert(User user) {
        return new UserDTO(user.id, user.name, user.email);
        //jamas usar los fields siempre accesors
    }

    public static UserDTO dozer(User user) {
        Mapper mapper = new DozerBeanMapper();
        return mapper.map(user, UserDTO.class);
    }
}

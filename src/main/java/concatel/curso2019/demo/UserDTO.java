package concatel.curso2019.demo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fphilip@houseware.es
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel
public class UserDTO {
    private Integer id;
    private String name;
    private String email;



}

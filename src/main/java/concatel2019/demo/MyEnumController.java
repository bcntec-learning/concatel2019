package concatel2019.demo;

import concatel2019.demo.entities.MyEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author fphilip@houseware.es
 */
@Controller
@RequestMapping("/enums")
public class MyEnumController {

    @GetMapping("{value}")
    public MyEnum p(@PathVariable("value") MyEnum e){
        return e;
    }
}

package concatel2019.demo;

import concatel2019.demo.aspectj.Auditar;
import concatel2019.demo.entities.User;
import concatel2019.demo.repositorios.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author fphilip@houseware.es
 */

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController implements Controladores {


    private final UserRepository userRepository;
    private final MyBean myBean;

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping("/{id}")
    public UserDTO find(@PathVariable("id") Integer id) {

        User u = userRepository.findById(id).get();
        return new UserDTO(u.getId(), u.getName(), u.getEmail());
    }


    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping("/{id}/3")
    public User find3(@PathVariable("id") Integer id) {
        return userRepository.getOne(id); //esto da error
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping("/{id}/4")
    public UserDTO find3DTO(@PathVariable("id") Integer id) {
        return User.dozer(userRepository.getOne(id));
    }

    @Auditar
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping("/{id}/5")
    public UserDTO find5(@PathVariable("id") Integer id) {

        User u = userRepository.getOne(id);
        return new UserDTO(u.getId(), u.getName(), u.getEmail());
    }


    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping("/{id}/6")
    public UserDTO find6(@PathVariable("id") Integer id) {

        User u = userRepository.getOne(id);
        return User.convert(u);  //con fields
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @RequestMapping("/{id}/7")
    public UserDTO find7(@PathVariable("id") Integer id) {

        User u = userRepository.findById(id).get();
        return User.convert(u);  //con fields
    }


    @ResponseBody
    @RequestMapping("/{id}/2")
    public ResponseEntity<UserDTO> find2(@PathVariable("id") Integer id) {
        return null;//ResponseEntity.status(HttpStatus.OK).body(userRepository.findById(id).get());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/mvc")
    public ModelAndView findHTML(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        //modelAndView.setView(UsersView.class);
        modelAndView.setViewName("/users");
        modelAndView.addObject("user", userRepository.findById(id).get());
        return modelAndView;// --> ViewResolver -> ViewTempater
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/mvc2")
    public String findHTMLString(@PathVariable("id") Integer id) {

        return "/users";// --> ViewResolver -> ViewTempater
    }

    /*
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public UsersView findHTMLString(@PathVariable ("id") Integer id){

        return "/users";// --> ViewResolver -> ViewTempater
    }
     */

}

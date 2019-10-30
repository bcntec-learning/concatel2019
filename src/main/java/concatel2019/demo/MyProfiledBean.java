package concatel2019.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author fphilip@houseware.es
 */
@Slf4j
@Profile("profile1")
@Component
public class MyProfiledBean {

    @PostConstruct
    protected void p() {
        log.info("Hola, MyProfiledBean activado");
    }
}

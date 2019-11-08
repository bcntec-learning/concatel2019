package concatel.curso2019.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author fphilip@houseware.es
 */

@Slf4j
@ConditionalOnMissingBean(value = MyProfiledBean.class)
@Component
public class MyProfiledConditionalBean {

    @PostConstruct
    protected void p() {
        log.info("Hola, MyProfiledConditionalBean activado");
    }
}

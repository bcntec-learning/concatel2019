package concatel.curso2019.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * @author fphilip@houseware.es
 */

@ConditionalOnMissingBean(value = MyBean.class)
//@ConditionalOnBean(value = MyBean.class)
@ConditionalOnProperty(name = "concatel.fwk.debug", havingValue = "true", matchIfMissing = true)
@Component
public class MyConditionalBean {
}

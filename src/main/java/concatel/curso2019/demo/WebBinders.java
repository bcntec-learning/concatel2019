package concatel.curso2019.demo;

import concatel.curso2019.demo.entities.MyEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;

/**
 * @author fphilip@houseware.es
 */
@Component
public class WebBinders {
    @InitBinder
    public void register(WebDataBinder binder){
        binder.registerCustomEditor(MyEnum.class, new PropertyEditorSupport(){
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                super.setValue(MyEnum.valueOf(text));
            }
        });
    }
}

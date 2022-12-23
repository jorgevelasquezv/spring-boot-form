package co.com.jorge.springboot.form.app.editors;

import co.com.jorge.springboot.form.app.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;


@Component
public class RolePropertyEditor extends PropertyEditorSupport {

    @Autowired
    private RoleService service;

    @Override
    public void setAsText(String id) throws IllegalArgumentException {
        try {
            this.setValue(service.getById(Integer.valueOf(id)));
        }catch (NumberFormatException e){
            this.setValue(null);
        }
    }

}

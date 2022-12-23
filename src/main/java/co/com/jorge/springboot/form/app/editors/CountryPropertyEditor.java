package co.com.jorge.springboot.form.app.editors;

import co.com.jorge.springboot.form.app.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;


@Component
public class CountryPropertyEditor extends PropertyEditorSupport {

    @Autowired
    private CountryService service;

    @Override
    public void setAsText(String id) throws IllegalArgumentException {
        try {
            this.setValue(service.getById(Integer.valueOf(id)));
        }catch (NumberFormatException e){
            this.setValue(null);
        }
    }

}

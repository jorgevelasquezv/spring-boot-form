package co.com.jorge.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

public class NameUpperCaseEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(text.toUpperCase().trim());
    }
}

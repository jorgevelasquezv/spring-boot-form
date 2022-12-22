package co.com.jorge.springboot.form.app.controllers;

import co.com.jorge.springboot.form.app.editors.NameUpperCaseEditor;
import co.com.jorge.springboot.form.app.models.domain.User;
import co.com.jorge.springboot.form.app.validations.UserValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes("user")
public class FormController {

    @Autowired
    private UserValidator validator;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(validator);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat, false));
        binder.registerCustomEditor(String.class, "name", new NameUpperCaseEditor());
    }

    @ModelAttribute("countries")
    public List<String> countries(){
        return Arrays.asList("Colombia", "Ecuador", "Perú", "Mexico", "Chile", "Argentina");
    }

    @GetMapping("/form")
    public String form(Model model){
        User user = new User();
        user.setName("Isaac");
        user.setLastname("Velasquez");
        user.setId("1.245.546-D");
        model.addAttribute("titulo", "Formulario Usuario");
        model.addAttribute("user", user);

        return "form";
    }

    @PostMapping("/form")
    public String sendForm(@Valid User user, BindingResult result, Model model, SessionStatus status){
//        validator.validate(user, result);

        model.addAttribute("titulo", "Formulario Usuario");

        if (result.hasErrors()){
            return "form";
        }

        model.addAttribute("titulo", "Resultado form");
        model.addAttribute("user", user);
        status.setComplete(); // Elimina el objeto que se tenía guardado en session
        return "result";
    }
}

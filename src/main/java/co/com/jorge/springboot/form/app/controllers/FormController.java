package co.com.jorge.springboot.form.app.controllers;

import co.com.jorge.springboot.form.app.models.domain.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("user")
public class FormController {

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

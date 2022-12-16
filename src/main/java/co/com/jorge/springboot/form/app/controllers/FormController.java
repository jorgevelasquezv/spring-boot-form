package co.com.jorge.springboot.form.app.controllers;

import co.com.jorge.springboot.form.app.models.domain.User;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("titulo", "Formulario Usuario");
        model.addAttribute("user", new User());

        return "form";
    }

    @PostMapping("/form")
    public String sendForm(@Valid User user, BindingResult result, Model model){
        model.addAttribute("titulo", "Formulario Usuario");

        if (result.hasErrors()){
            return "form";
        }

        model.addAttribute("titulo", "Resultado form");
        model.addAttribute("user", user);
        return "result";
    }
}

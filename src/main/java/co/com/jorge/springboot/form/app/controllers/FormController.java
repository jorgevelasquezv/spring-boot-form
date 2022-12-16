package co.com.jorge.springboot.form.app.controllers;

import co.com.jorge.springboot.form.app.models.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("titulo", "Formulario Usuario");
        return "form";
    }

    @PostMapping("/form")
    public String sendForm(User user,
// La clase user se mapea automáticamente ya que los atributos coinciden con los nombres de los campos input
//                          @RequestParam String username,
//                           @RequestParam String password,
//                           @RequestParam String email,
                           Model model){

//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
//        user.setEmail(email);

        model.addAttribute("titulo", "Resultado form");
        model.addAttribute("user", user);



        return "result";
    }
}

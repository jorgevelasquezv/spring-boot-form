package co.com.jorge.springboot.form.app.controllers;

import co.com.jorge.springboot.form.app.editors.CountryPropertyEditor;
import co.com.jorge.springboot.form.app.editors.NameUpperCaseEditor;
import co.com.jorge.springboot.form.app.editors.RolePropertyEditor;
import co.com.jorge.springboot.form.app.models.domain.Country;
import co.com.jorge.springboot.form.app.models.domain.Role;
import co.com.jorge.springboot.form.app.models.domain.User;
import co.com.jorge.springboot.form.app.services.CountryService;
import co.com.jorge.springboot.form.app.services.RoleService;
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
import java.util.*;

@Controller
@SessionAttributes("user")
public class FormController {

    @Autowired
    private UserValidator validator;

    @Autowired
    private CountryService countryService;

    @Autowired
    private CountryPropertyEditor countryPropertyEditor;

    @Autowired
    private RolePropertyEditor rolePropertyEditor;

    @Autowired
    private RoleService roleService;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(validator);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class,new CustomDateEditor(dateFormat, false));
        binder.registerCustomEditor(String.class, "name", new NameUpperCaseEditor());
        binder.registerCustomEditor(Country.class, "country", countryPropertyEditor);
        binder.registerCustomEditor(Role.class, "roles", rolePropertyEditor);
    }

    @ModelAttribute("listCountries")
    public List<Country> listCountries(){
        return countryService.getAll();
    }

    @ModelAttribute("countries")
    public List<String> countries(){
        return Arrays.asList("Colombia", "Ecuador", "Perú", "Mexico", "Chile", "Argentina");
    }

    @ModelAttribute("countriesMap")
    public Map<String, String> countriesMap(){
        Map<String, String > countries = new HashMap<>();
        countries.put("CO", "Colombia");
        countries.put("EC", "Ecuador");
        countries.put("PE", "Perú");
        countries.put("MX", "Mexico");
        countries.put("CL", "Chile");
        countries.put("AR", "Argentina");
        return countries;
    }

    @ModelAttribute("rolesString")
    public List<String> rolesString(){
        return Arrays.asList(
                "ROLE_ADMIN",
                "ROLE_USER",
                "ROLE_MODERATOR"
        );
    }

    @ModelAttribute("rolesMap")
    public Map<String, String> rolesMap(){
        Map<String, String > roles = new HashMap<>();
        roles.put("ROLE_ADMIN", "Administrador");
        roles.put("ROLE_USER", "Usuario");
        roles.put("ROLE_MODERATOR", "Moderador");
        return roles;
    }

    @ModelAttribute("listRoles")
    public List<Role> listRoles(){
        return roleService.getAll();
    }


    @ModelAttribute("gender")
    public List<String> gender(){
        return Arrays.asList("Women", "Woman");
    }

    @GetMapping("/form")
    public String form(Model model){
        User user = new User();
        user.setName("Isaac");
        user.setLastname("Velasquez");
        user.setId("1.245.546-D");
        user.setEnable(true);
        user.setSecretValue("*52-89*");
        user.setCountry(new Country(4, "MX", "Mexico"));
        user.setRoles(Arrays.asList(new Role(2, "Usuario", "ROLE_USER")));
        model.addAttribute("titulo", "Formulario Usuario");
        model.addAttribute("user", user);

        return "form";
    }

    @PostMapping("/form")
    public String sendForm(@Valid User user, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("titulo", "Formulario Usuario");
            return "form";
        }
        return "redirect:/see";
    }

    @GetMapping("/see")
    public String see(@SessionAttribute(name="user", required = false) User user, Model model, SessionStatus status){
        if (user == null){
            return "redirect:/form";
        }
        model.addAttribute("titulo", "Resultado form");
        status.setComplete(); // Elimina el objeto que se tenía guardado en session
        return "result";
    }
}

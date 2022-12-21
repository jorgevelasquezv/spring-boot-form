package co.com.jorge.springboot.form.app.models.domain;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class User {

    private String id;

    @NotEmpty(message = "El nombre no puede ser vacío")
    private String name;

    @NotEmpty(message = "El apellido no puede ser vacío")
    private String lastname;

    @NotEmpty(message = "El nombre de usuario no puede ser vacío")
    @Size(min = 3, max = 8)
    private String username;

    @NotEmpty(message = "El password no puede ser vacío")
    @Size(min = 3, max = 8)
    private String password;

    @Email
    @NotEmpty(message = "Correo con formato incorrecto")
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

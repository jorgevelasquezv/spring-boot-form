package co.com.jorge.springboot.form.app.models.domain;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class User {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @Email
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
}

package co.com.jorge.springboot.form.app.models.domain;


import co.com.jorge.springboot.form.app.validations.IdentificadorRegex;
import co.com.jorge.springboot.form.app.validations.Requerido;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {

//    @Pattern(regexp = "[0-9]{2}[.,][0-9]{3}[.,][0-9]{3}-[A-Z]")
    @IdentificadorRegex
    private String id;

//    @NotEmpty
    private String name;

//    @NotEmpty
    @Requerido
    private String lastname;

    @NotBlank
    @Size(min = 3, max = 8)
    private String username;

    @NotBlank
    @Size(min = 3, max = 8)
    private String password;

    @Email
    @NotBlank
    private String email;

    @NotNull
    @Min(1)
    @Max(150)
    private Integer age;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    private Date birthDate;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}

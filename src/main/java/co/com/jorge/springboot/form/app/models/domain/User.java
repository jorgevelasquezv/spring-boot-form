package co.com.jorge.springboot.form.app.models.domain;


import co.com.jorge.springboot.form.app.validations.IdentificadorRegex;
import co.com.jorge.springboot.form.app.validations.Requerido;
import jakarta.validation.constraints.*;

import java.util.Date;
import java.util.List;

public class User {

    @IdentificadorRegex
    private String id;

    private String name;

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
    private Date birthDate;

    @NotNull
    private Country country;

    @NotEmpty
    private List<Role> roles;

    private Boolean enable;

    @NotEmpty
    private String gender;

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

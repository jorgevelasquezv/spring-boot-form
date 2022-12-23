package co.com.jorge.springboot.form.app.services;

import co.com.jorge.springboot.form.app.models.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAll();

    Role getById(Integer id);
}

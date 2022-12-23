package co.com.jorge.springboot.form.app.services;

import co.com.jorge.springboot.form.app.models.domain.Role;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    private List<Role> roles;

    public RoleServiceImpl(List<Role> roles) {
        this.roles = Arrays.asList(
                new Role(1, "Administrador", "ROLE_ADMIN"),
                new Role(2, "Usuario", "ROLE_USER"),
                new Role(3, "Moderador", "ROLE_MODERATOR")
        );
    }

    @Override
    public List<Role> getAll() {
        return roles;
    }

    @Override
    public Role getById(Integer id) {
        return roles.stream()
                .filter(role -> role.getId() == id)
                .findAny()
                .get();
    }
}

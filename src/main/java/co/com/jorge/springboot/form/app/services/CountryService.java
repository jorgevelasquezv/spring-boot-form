package co.com.jorge.springboot.form.app.services;

import co.com.jorge.springboot.form.app.models.domain.Country;

import java.util.List;

public interface CountryService {

    List<Country> getAll();

    Country getById(Integer id);
}

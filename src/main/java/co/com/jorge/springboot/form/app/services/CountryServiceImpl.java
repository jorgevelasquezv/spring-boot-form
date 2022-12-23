package co.com.jorge.springboot.form.app.services;

import co.com.jorge.springboot.form.app.models.domain.Country;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService{

    private List<Country> countries;

    public CountryServiceImpl() {
        this.countries = Arrays.asList(
                new Country(1, "CO", "Colombia"),
                new Country(2, "EC", "Ecuador"),
                new Country(3, "PE", "Perú"),
                new Country(4, "MX", "Mexico"),
                new Country(5, "CL", "Chile"),
                new Country(6, "AR", "Argentina")
        );
    }

    @Override
    public List<Country> getAll() {
        return countries;
    }

    @Override
    public Country getById(Integer id) {
        return countries.stream()
                .filter(country -> country.getId() == id)
                .findAny()
                .get();
    }
}

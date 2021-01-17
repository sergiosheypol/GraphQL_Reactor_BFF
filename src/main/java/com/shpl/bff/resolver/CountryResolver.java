package com.shpl.bff.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.shpl.bff.model.Country;
import com.shpl.bff.service.CountriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CountryResolver implements GraphQLQueryResolver {

    private final CountriesService countriesService;

    public List<Country> getCountries() {
        return countriesService.getAll();
    }

    public Country getCountry(final String code) {
        return countriesService.getOne(code);
    }

}

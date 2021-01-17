package com.shpl.bff.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.shpl.bff.model.City;
import com.shpl.bff.service.CitiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CityResolver implements GraphQLQueryResolver {

    private final CitiesService citiesService;

    public List<City> getCities() {
        return citiesService.getAll();
    }

    public City getCity(final String code) {
        return citiesService.getOne(code);
    }

}

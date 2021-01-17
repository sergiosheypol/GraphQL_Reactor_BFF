package com.shpl.bff.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.shpl.bff.model.Airport;
import com.shpl.bff.model.City;
import com.shpl.bff.model.Country;
import com.shpl.bff.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ShplResolver implements GraphQLQueryResolver {

    private final AirportsService airportsService;
    private final CountriesService countriesService;
    private final CitiesService citiesService;

    public List<Airport> getAirports() {
        return airportsService.getAll();
    }

    public Airport getAirport(final String iataCode) {
        return airportsService.getOne(iataCode);
    }

    public List<Country> getCountries() {
        return countriesService.getAll();
    }

    public Country getCountry(final String code) {
        return countriesService.getOne(code);
    }

    public List<City> getCities() {
        return citiesService.getAll();
    }

    public City getCity(final String code) {
        return citiesService.getOne(code);
    }

}

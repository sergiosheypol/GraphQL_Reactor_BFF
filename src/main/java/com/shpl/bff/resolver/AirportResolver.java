package com.shpl.bff.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.shpl.bff.model.Airport;
import com.shpl.bff.service.AirportsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AirportResolver implements GraphQLQueryResolver {

    private final AirportsService airportsService;

    public List<Airport> getAirports() {
        return airportsService.getAll();
    }

    public Airport getAirport(final String iataCode) {
        return airportsService.getOne(iataCode);
    }

}

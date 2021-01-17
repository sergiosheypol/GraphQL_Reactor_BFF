package com.shpl.bff.resolver.custom;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.shpl.bff.model.Airport;
import com.shpl.bff.model.Coordinates;
import org.springframework.stereotype.Component;

@Component
public class CoordinatesResolver implements GraphQLResolver<Airport> {

    public Coordinates getCoordinates(Airport airport) {
        return Coordinates.builder()
                .latitude(airport.getCoordinates().get("latitude"))
                .longitude(airport.getCoordinates().get("longitude"))
                .build();
    }

}

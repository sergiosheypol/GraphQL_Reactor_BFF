package com.shpl.bff.service;

import com.shpl.bff.cache.InMemoryCache;
import com.shpl.bff.model.Airport;
import com.shpl.bff.provider.DataProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Slf4j
@Service
public class AirportsService extends ServiceTemplate<Airport> {
    public AirportsService(final DataProvider dataProvider, final InMemoryCache<String, Airport> inMemoryCache) {
        super(dataProvider, inMemoryCache);
    }

    @Override
    Flux<Airport> getDataFromProvider() {
        return super.getDataProvider().getAirports();
    }

    @Override
    Airport getEmptyObject() {
        return Airport.builder().build();
    }

    @Override
    String getCacheCode(final Airport airport) {
        return airport.getIataCode();
    }
}

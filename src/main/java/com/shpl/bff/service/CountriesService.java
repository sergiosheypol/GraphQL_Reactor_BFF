package com.shpl.bff.service;

import com.shpl.bff.cache.InMemoryCache;
import com.shpl.bff.model.Country;
import com.shpl.bff.provider.DataProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Slf4j
@Service
public class CountriesService extends ServiceTemplate<Country> {
    
    public CountriesService(final DataProvider dataProvider, final InMemoryCache<String, Country> inMemoryCache) {
        super(dataProvider, inMemoryCache);
    }

    @Override
    Flux<Country> getDataFromProvider() {
        return super.getDataProvider().getCountries();
    }

    @Override
    Country getEmptyObject() {
        return Country.builder().build();
    }

    @Override
    String getCacheCode(final Country country) {
        return country.getCode();
    }
}

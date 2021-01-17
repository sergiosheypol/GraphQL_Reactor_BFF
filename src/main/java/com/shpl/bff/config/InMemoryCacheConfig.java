package com.shpl.bff.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.shpl.bff.cache.InMemoryCache;
import com.shpl.bff.model.Airport;
import com.shpl.bff.model.City;
import com.shpl.bff.model.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@RequiredArgsConstructor
public class InMemoryCacheConfig {

    private final InMemoryCacheProperties inMemoryCacheProperties;

    @Bean
    public Cache<String, City> cityCache() {
        return Caffeine.newBuilder()
                .expireAfterWrite(inMemoryCacheProperties.getTtl(), TimeUnit.HOURS)
                .maximumSize(inMemoryCacheProperties.getMaxSize())
                .build();
    }

    @Bean
    public InMemoryCache<String, City> cityInMemoryCache(final Cache<String, City> cityCache) {
        return new InMemoryCache<>(cityCache, true);
    }


    @Bean
    public Cache<String, Airport> airportCache() {
        return Caffeine.newBuilder()
                .expireAfterWrite(inMemoryCacheProperties.getTtl(), TimeUnit.HOURS)
                .maximumSize(inMemoryCacheProperties.getMaxSize())
                .build();
    }

    @Bean
    public InMemoryCache<String, Airport> airportInMemoryCache(final Cache<String, Airport> airportCache) {
        return new InMemoryCache<>(airportCache, true);
    }


    @Bean
    public Cache<String, Country> countryCache() {
        return Caffeine.newBuilder()
                .expireAfterWrite(inMemoryCacheProperties.getTtl(), TimeUnit.HOURS)
                .maximumSize(inMemoryCacheProperties.getMaxSize())
                .build();
    }

    @Bean
    public InMemoryCache<String, Country> countryInMemoryCache(final Cache<String, Country> countryCache) {
        return new InMemoryCache<>(countryCache, true);
    }


}

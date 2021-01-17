package com.shpl.bff.service;

import com.shpl.bff.cache.InMemoryCache;
import com.shpl.bff.provider.DataProvider;
import io.vavr.control.Option;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Optional.ofNullable;
import static java.util.function.Predicate.not;

@Slf4j
@Getter
@RequiredArgsConstructor
public abstract class ServiceTemplate<V> {
    private final DataProvider dataProvider;
    private final InMemoryCache<String, V> inMemoryCache;

    public List<V> getAll() {
        return this.doGetAll();
    }

    private ArrayList<V> doGetAll() {
        return Option.of(inMemoryCache.getCacheMap())
                .filter(not(Map::isEmpty))
                .map(Map::values)
                .map(ArrayList::new)
                .getOrElse(this::getItemsFromProvider);
    }

    public V getOne(final String code) {
        return Option.of(inMemoryCache.getCacheMap())
                .filter(not(Map::isEmpty))
                .map(__ -> findSingleValue(code))
                .getOrElse(() -> populateCacheAndFind(code));
    }

    private ArrayList<V> getItemsFromProvider() {
        return (ArrayList<V>) getDataFromProvider()
                .doOnEach(signal -> ofNullable(signal.get()).ifPresent(this::pushItemToCache))
                .collectList()
                .block();
    }

    private void pushItemToCache(V v) {
        inMemoryCache.push(getCacheCode(v), v);
    }

    private V populateCacheAndFind(String code) {
        log.info("Value for key '" + code + "' is not cached");
        this.doGetAll();
        log.info("Cache is now populated");
        return findSingleValue(code);
    }

    private V findSingleValue(String code) {
        return inMemoryCache.get(code).orElse(getEmptyObject());
    }

    abstract V getEmptyObject();

    abstract Flux<V> getDataFromProvider();

    abstract String getCacheCode(V v);

}

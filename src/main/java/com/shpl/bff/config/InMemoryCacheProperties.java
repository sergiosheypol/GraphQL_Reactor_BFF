package com.shpl.bff.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "in.memory.cache")
public class InMemoryCacheProperties {

    private boolean enabled;
    private Integer ttl;
    private Integer maxSize;

}
package com.shpl.bff.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Airport {
    private String iataCode;
    private String name;
    private String seoName;
    private String countryCode;
    private String regionCode;
    private String cityCode;
    private String currencyCode;
    private Map<String, String> coordinates;
    private List<String> routes;
}

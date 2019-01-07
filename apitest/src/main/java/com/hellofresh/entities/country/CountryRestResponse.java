package com.hellofresh.entities.country;

import lombok.Getter;

import java.util.List;

@Getter

public class CountryRestResponse {
    List<String> messages;
    CountryCode result;
}

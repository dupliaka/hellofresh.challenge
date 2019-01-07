package com.hellofresh.entities.countries;

import com.hellofresh.entities.country.CountryCode;
import lombok.Getter;

import java.util.List;

@Getter

public class CountriesRestResponse {
    List<String> messages;
    List<CountryCode> result;
}

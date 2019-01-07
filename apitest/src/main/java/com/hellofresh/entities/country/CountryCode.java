package com.hellofresh.entities.country;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CountryCode {

    String name;
    String alpha2_code;
    String alpha3_code;

}

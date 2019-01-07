package com.hellofresh;
import com.hellofresh.entities.countries.CountriesIsoCode;
import com.hellofresh.entities.country.CountryCode;
import com.hellofresh.entities.country.CountryIsoCode;
import com.hellofresh.restapi.CountryRequest;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class CountryTest {

    @Test
    public void getAllCountriesDeUsGbTest(){

        CountriesIsoCode countries = new CountryRequest().getAllCountries();
        assertThat(countries).extracting("RestResponse")
                .flatExtracting("result")
                .extracting("alpha2_code")
                .contains("DE", "US", "GB");
    }

    @Test
    public void getCountryTest(){

        //TODO: keep out via param test
        CountryCode countryIsoCodeExpected = CountryCode.newBuilder()
                .name("United Kingdom of Great Britain and Northern Ireland")
                .alpha2_code("GB")
                .alpha3_code("GBR").build();

        CountryIsoCode countryIsoCodeActual = new CountryRequest().getCountry("GB");
        assertThat(countryIsoCodeActual).extracting("RestResponse").extracting("result").isNotEmpty();
        assertThat(countryIsoCodeActual.getRestResponse().getResult()).isEqualToComparingFieldByField(countryIsoCodeExpected);
    }

    @Test
    public void getCountryNegativeTest(){

        CountryIsoCode countryIsoCodeActual = new CountryRequest().getCountry("Test");
        assertThat(countryIsoCodeActual)
                .extracting("RestResponse")
                .flatExtracting("messages")
                .containsOnlyOnce("No matching country found for requested code [Test].");
    }



}

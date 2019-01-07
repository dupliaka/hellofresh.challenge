package com.hellofresh;

import com.hellofresh.entities.countries.CountriesIsoCode;
import com.hellofresh.entities.country.CountryCode;
import com.hellofresh.entities.country.CountryIsoCode;
import com.hellofresh.restapi.CountryRequest;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
@RunWith(JUnitParamsRunner.class)
public class CountryTest {

    @Test
    public void getAllCountriesDeUsGbTest() {

        CountriesIsoCode countries = new CountryRequest().getAllCountries();
        assertThat(countries).extracting("RestResponse")
                .flatExtracting("result")
                .extracting("alpha2_code")
                .contains("DE", "US", "GB");
    }

    private Object[] parametersForGetCountryCodeTest() {
        return new Object[]{
                new Object[]{new CountryCode("Germany", "DE", "DEU")},
                new Object[]{new CountryCode("United Kingdom of Great Britain and Northern Ireland", "GB", "GBR")},
                new Object[]{new CountryCode("United States of America", "US", "USA")}
        };
    }

    @Parameters
    @Test
    public void getCountryCodeTest(CountryCode countryIsoCodeExpected) {
        CountryIsoCode countryIsoCodeActual = new CountryRequest().getCountry(countryIsoCodeExpected.getAlpha2_code());
        assertThat(countryIsoCodeActual).extracting("RestResponse").extracting("result").isNotEmpty();
        assertThat(countryIsoCodeActual.getRestResponse().getResult()).isEqualToComparingFieldByField(countryIsoCodeExpected);
    }

    @Test
    public void getCountryNegativeTest() {

        CountryIsoCode countryIsoCodeActual = new CountryRequest().getCountry("Test");
        assertThat(countryIsoCodeActual)
                .extracting("RestResponse")
                .flatExtracting("messages")
                .containsOnlyOnce("No matching country found for requested code [Test].");
    }

}

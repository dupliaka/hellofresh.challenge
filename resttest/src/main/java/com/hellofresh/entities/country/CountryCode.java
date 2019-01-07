package com.hellofresh.entities.country;

public class CountryCode {

    private String name;
    private String alpha2_code;
    private String alpha3_code;

    public String getName() {
        return name;
    }

    public String getAlpha2_code() {
        return alpha2_code;
    }

    public String getAlpha3_code() {
        return alpha3_code;
    }

    public static Builder newBuilder() {
        return new CountryCode().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder name(String name) {
            CountryCode.this.name = name;
            return this;
        }

        public Builder alpha2_code(String alpha2_code) {
            CountryCode.this.alpha2_code = alpha2_code;
            return this;
        }

        public Builder alpha3_code(String getAlpha3_code) {
            CountryCode.this.alpha3_code = getAlpha3_code;
            return this;
        }

        public CountryCode build() {
            return CountryCode.this;
        }

    }
}

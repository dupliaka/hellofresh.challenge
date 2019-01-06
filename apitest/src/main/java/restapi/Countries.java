package restapi;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.filter.log.LogDetail;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;
import com.jayway.restassured.specification.ResponseSpecification;
import entity.AllCountries;
import helpers.ConfigurationManager;

import static com.jayway.restassured.RestAssured.given;

public class Countries {
    private static final String pathAllCountries = "/country/get/all";

    private static final RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(ConfigurationManager.getHostUrl())
            .setPort(8080)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();
    //TODO: resolve dependency failure
//    ResponseSpecification responseSpec = new ResponseSpecBuilder()
//            .expectStatusCode(200)
//            .build();

    public AllCountries getAllCountries(){
        return given().spec(requestSpec).when().get(pathAllCountries).then()
                .log().ifError()
                .extract().body().as(AllCountries.class);
    }
}

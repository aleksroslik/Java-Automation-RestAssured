package WeatherRequest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class WeatherRequest {

    public static RequestSpecification getRequestSpecForCity(String city, String countryCode, String id) {
        return RestAssured.requestSpecification = new RequestSpecBuilder()
                .addParam("name", city)
                .addParam("sys.country", countryCode)
                .addParam("id", id)
                .build()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}

package Base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseTest {

    public static RequestSpecification getRequestSpec() {
        return RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.openweathermap.org/data/2.5/weather")
                .addParam("appid", "89a2ed8a594cc497a6273490e7ca59dd")
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification getResponseSpec() {
        return new ResponseSpecBuilder()
                .build()
                .statusCode(200);
    }
}

import Base.BaseTest;
import WeatherRequest.WeatherRequest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static io.restassured.RestAssured.given;

public class WeatherTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("DataProvider.CitySpec#data")
    @Tag("weather")
    public void shouldGetWeatherInfoForSpecifiedCities(String city, String countryCode, String id) {
        given()
                .spec(getRequestSpec())
                .spec(WeatherRequest.getRequestSpecForCity(city, countryCode, id))
        .when()
                .get()
        .then()
                .spec(getResponseSpec());
    }
}

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;

public class JsonPlaceHolderDemo extends BaseTest {

    private final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private final String USERS = "users";

    @Test
    public void shouldGetAllUsers() {
        given()
                .contentType(ContentType.JSON).
        when()
                .get(BASE_URL + USERS).
        then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void getFirstUser() {
        when()
                .get(BASE_URL + USERS + "/1").
        then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void getUserWithResponseExtraction() {
        Response response =
                when()
                    .get(BASE_URL + USERS + "/1").
                then()
                    .statusCode(200)
                    .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String username = jsonPath.get("username");
        assertThat(username).isEqualTo("Bret");
    }

    @Test
    public void getUserWithPathParam() {
        given()
                .pathParam("userId", "1").
        when()
                .get(BASE_URL + USERS + "/{userId}").
        then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void getUserWithName() {
        Response response =
                given().queryParam("website", "hildegard.org")
                       .queryParam("address.city", "Gwenborough").
                when()
                        .get(BASE_URL + USERS + "/1").
                then()
                        .statusCode(200)
                        .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String username = jsonPath.get("website");
        assertThat(username).isEqualTo("hildegard.org");
    }
}

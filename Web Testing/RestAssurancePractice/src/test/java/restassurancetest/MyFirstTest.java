package restassurancetest;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class MyFirstTest {
    public static final String REGISTER_USER_BODY_FORMAT = "{\n" + "\"email\": \"%s\",\n" + "\"password\": \"%s\"\n" + "}";
    public static final String BASE_URL = "https://reqres.in";

    @Test
    public void correctEmailReturned_when_getUserById() {


        String usersUri = "/api/users/2";

        Response response = given()
                .baseUri(BASE_URL)
                .get(usersUri);

        Assert.assertEquals(response.statusCode(), 200);

        Assert.assertEquals("janet.weaver@reqres.in", response.getBody().jsonPath().get("data.email").toString());
    }

    @Test
    public void correctDataReturned_when_registerUser() {

        String registerUri = "/api/register";

        System.out.println();
        Response response = given()
                .baseUri(BASE_URL)
                .body(String.format(REGISTER_USER_BODY_FORMAT, "eve.holt@reqres.in", "pistol"))
                .contentType("application/json")
                .post(registerUri);

        Assert.assertEquals(response.statusCode(), 200);

        Assert.assertEquals("4", response.getBody().jsonPath().get("id").toString());
    }
}

package restassured;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;


public class FirstTest {
    public static void main(String[] args) {
        Response res = given().get();
    }
}

package base;

import com.telerikacademy.api.tests.Constants;
import com.telerikacademy.api.tests.Endpoints;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseTestSetup {

    @BeforeMethod
    public void setup() {
        EncoderConfig encoderConfig = RestAssured.config().getEncoderConfig()
                .appendDefaultContentCharsetToContentTypeIfUndefined(false);
        RestAssured.config = RestAssured.config().encoderConfig(encoderConfig);
        RestAssured.baseURI = Endpoints.BASE_URL;
    }

    public RequestSpecification getApplicationJSONSpecificationAuth() {
        return RestAssured.given()
                .auth().preemptive().basic("username", "password");
    }

    public RequestSpecification getApplicationJSONSpecificationGoogle() {
        return RestAssured.given()
                .basePath(Endpoints.DISTANCE)
                .queryParam("units", "imperial")
                .queryParam("key", Constants.GOOGLE_API_KEY);
    }
}

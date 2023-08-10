package com.exam.trello.tests;

import com.exam.trello.utils.Constants;
import com.exam.trello.utils.Endpoints;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class BaseTestSetup {

    @BeforeMethod
    public void setup() {
        EncoderConfig encoderConfig = RestAssured.config().getEncoderConfig()
                .appendDefaultContentCharsetToContentTypeIfUndefined(false);

        RestAssured.config = RestAssured.config().encoderConfig(encoderConfig);
    }

    public RequestSpecification getApplicationJSONSpecificationTrello() {
        return RestAssured
                .given()
                .baseUri(Endpoints.BASE_URI)
                .queryParam("key", Constants.API_KEY)
                .queryParam("token", Constants.TOKEN)
                .contentType("application/json");
    }


}

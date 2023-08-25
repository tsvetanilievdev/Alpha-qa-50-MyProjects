package com.exam.trello.tests;

import com.exam.trello.utils.Constants;
import com.exam.trello.utils.Endpoints;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InitialSetupTests extends BaseTestSetup {


    @Test
    public void initialSetup_Return_CorrectData() {
        System.out.println("Test");
        RequestSpecification requestSpecification = getApplicationJSONSpecificationTrello();

        Response res = requestSpecification
                .given()
                .basePath(Endpoints.MEMBERS_URI)
                .when()
                .get();

        JsonPath jsonPath = res.jsonPath();
        String fullName = jsonPath.get("fullName");
        String username = jsonPath.get("username");

        Assert.assertEquals(res.getStatusCode(), 200, "Status code is not correct! Expected: 200 Actual: " + res.getStatusCode());
        Assert.assertEquals(fullName.toUpperCase(), Constants.FULL_NAME.toUpperCase(), "Full name is not correct! Expected: " + Constants.FULL_NAME + " Actual: " + fullName);
        Assert.assertEquals(username.toUpperCase(), Constants.USERNAME.toUpperCase(), "Username is not correct! Expected: " + Constants.USERNAME + " Actual: " + username);
    }
}

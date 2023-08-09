package com.exam.trello.tests;

import com.exam.trello.utils.Data;
import com.exam.trello.utils.Endpoints;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteCardTests extends BaseTestSetup {

    @Test
    public void deleteCard_IsSuccessful() {
        RequestSpecification requestSpecification = getApplicationJSONSpecificationTrello();

        Response response = requestSpecification
                .given()
                .basePath(Endpoints.BOARDS_URL + Data.BOARD_ID)
                .log().uri()
                .when()
                .delete();

        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not correct! Expected: 200 Actual: " + response.getStatusCode());
    }
}

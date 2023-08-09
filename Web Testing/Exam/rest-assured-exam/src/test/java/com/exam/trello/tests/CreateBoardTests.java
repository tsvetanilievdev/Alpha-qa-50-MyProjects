package com.exam.trello.tests;

import com.exam.trello.utils.Data;
import com.exam.trello.utils.Endpoints;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateBoardTests extends BaseTestSetup {
    private String body;

    @BeforeMethod
    public void setup() {
        body = String.format("{\n" +
                "    \"name\": \"%s\"\n" +
                "}", Data.BOARD_NAME);
    }

    @Test
    public void createdBoard_Return_WithProvidedName() {
        RequestSpecification requestSpecification = getApplicationJSONSpecificationTrello();

        Response response =
                requestSpecification
                        .given()
                        .body(body)
                        .when()
                        .post(Endpoints.BOARDS_URL);

        JsonPath jsonPath = response.jsonPath();
        String boardName = jsonPath.get("name");
        String boardId = jsonPath.get("id");
        Data.BOARD_ID = boardId;

        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not correct! Expected: 200 Actual: " + response.getStatusCode());
        Assert.assertEquals(boardName, Data.BOARD_NAME, "Board name is not correct! Expected: " + Data.BOARD_NAME + " Actual: " + boardName);
    }
}

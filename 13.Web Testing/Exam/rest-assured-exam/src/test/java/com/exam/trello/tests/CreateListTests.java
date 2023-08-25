package com.exam.trello.tests;

import com.exam.trello.utils.Data;
import com.exam.trello.utils.Endpoints;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateListTests extends BaseTestSetup {

    private String body;

    @BeforeMethod
    public void setup() {
        if (Data.BOARD_ID == null) {
            //TODO
        }

        body = String.format("{\n" +
                "    \"name\": \"%s\",\n" +
                "    \"idBoard\": \"%s\"\n" +
                "}", Data.LIST_NAME, Data.BOARD_ID);
    }

    @Test
    public void createdList_Return_WithProvidedData() {
        RequestSpecification requestSpecification = getApplicationJSONSpecificationTrello();

        Response response = requestSpecification
                .given()
                .body(body)
                .when()
                .post(Endpoints.LISTS_URL);

        JsonPath jsonPath = response.jsonPath();
        String listName = jsonPath.get("name");
        String boardId = jsonPath.get("idBoard");
        String listId = jsonPath.get("id");
        Data.LIST_ID = listId;

        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not correct! Expected: 200 Actual: " + response.getStatusCode());
        Assert.assertEquals(boardId, Data.BOARD_ID, "Board id is not correct! Expected: " + Data.BOARD_ID + " Actual: " + boardId);
        Assert.assertEquals(listName, Data.LIST_NAME, "List name is not correct! Expected: " + Data.LIST_NAME + " Actual: " + listName);
    }
}

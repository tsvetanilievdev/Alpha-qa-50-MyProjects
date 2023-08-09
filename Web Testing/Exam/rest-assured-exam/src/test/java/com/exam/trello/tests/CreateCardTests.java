package com.exam.trello.tests;

import com.exam.trello.utils.Data;
import com.exam.trello.utils.Endpoints;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateCardTests extends BaseTestSetup {
    private String body;

    @BeforeMethod
    public void setup() {
        //TODO
        body = String.format("{\n" +
                "    \"name\": \"%s\",\n" +
                "    \"idList\": \"%s\",\n" +
                "    \"desc\": \"%s\"\n" +
                "}", Data.CARD_NAME, Data.LIST_ID, Data.CARD_DESC);
    }

    @Test
    public void createdCard_Return_WithProvidedData() {
        RequestSpecification requestSpecification = getApplicationJSONSpecificationTrello();

        Response response = requestSpecification
                .given()
                .body(body)
                .when()
                .post(Endpoints.CARDS_URL);

        JsonPath jsonPath = response.jsonPath();
        String cardName = jsonPath.get("name");
        String cardDesc = jsonPath.get("desc");
        String listId = jsonPath.get("idList");
        String boardId = jsonPath.get("idBoard");

        String cardId = jsonPath.get("id");
        Data.CARD_ID = cardId;

        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not correct! Expected: 200 Actual: " + response.getStatusCode());
        Assert.assertEquals(cardName, Data.CARD_NAME, "Card name is not correct! Expected: " + Data.CARD_NAME + " Actual: " + cardName);
        Assert.assertEquals(cardDesc, Data.CARD_DESC, "Card description is not correct! Expected: " + Data.CARD_DESC + " Actual: " + cardDesc);
        Assert.assertEquals(listId, Data.LIST_ID, "List id is not correct! Expected: " + Data.LIST_ID + " Actual: " + listId);
        Assert.assertEquals(boardId, Data.BOARD_ID, "Board id is not correct! Expected: " + Data.BOARD_ID + " Actual: " + boardId);
    }
}

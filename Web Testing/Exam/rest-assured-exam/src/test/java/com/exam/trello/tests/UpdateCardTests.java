package com.exam.trello.tests;

import com.exam.trello.utils.Data;
import com.exam.trello.utils.Endpoints;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UpdateCardTests extends BaseTestSetup{
    private String body;
    @BeforeMethod
    public void setup() {
        body = String.format("{\n" +
                "    \"name\": \"%s\",\n" +
                "    \"idList\": \"%s\",\n" +
                "    \"desc\": \"%s\",\n" +
                "    \"cover\": {\n" +
                "        \"color\": \"%s\"\n" +
                "    }\n" +
                "}", Data.CARD_NAME_UPDATED,Data.LIST_ID, Data.CARD_DESC_UPDATED,Data.CARD_COVER_COLOR);

        String dsad = "{\n" +
                "    \"name\": \"{{updatedCardName}}\",\n" +
                "    \"idList\": \"{{listId}}\",\n" +
                "    \"desc\": \"{{updatedCardDescription}}\",\n" +
                "    \"cover\": {\n" +
                "        \"color\": \"{{coverColor}}\"\n" +
                "    }\n" +
                "}";
    }

    @Test
    public void updatedCard_Return_WithProvidedData() {
        RequestSpecification requestSpecification = getApplicationJSONSpecificationTrello();

        Response response = requestSpecification
                .given()
                .body(body)
                .when()
                .put(Endpoints.CARDS_URL + '/' + Data.CARD_ID);

        JsonPath jsonPath = response.jsonPath();
        String cardName = jsonPath.get("name");
        String cardDesc = jsonPath.get("desc");
        String listId = jsonPath.get("idList");
        String boardId = jsonPath.get("idBoard");

        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not correct! Expected: 200 Actual: " + response.getStatusCode());
        Assert.assertEquals(cardName, Data.CARD_NAME_UPDATED, "Card name is not correct! Expected: " + Data.CARD_NAME_UPDATED + " Actual: " + cardName);
        Assert.assertEquals(cardDesc, Data.CARD_DESC_UPDATED, "Card description is not correct! Expected: " + Data.CARD_DESC_UPDATED + " Actual: " + cardDesc);
        Assert.assertEquals(listId, Data.LIST_ID, "List id is not correct! Expected: " + Data.LIST_ID + " Actual: " + listId);
        Assert.assertEquals(boardId, Data.BOARD_ID, "Board id is not correct! Expected: " + Data.BOARD_ID + " Actual: " + boardId);
    }
}

package restassuredtests;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import restassuredtests.utils.JiraRequest;

import static io.restassured.RestAssured.given;

public class LinkStoryBugTests {
    Response storyResponse;
    Response bugResponse;
    Response linkResponse;
    String storyKey;
    String bugKey;

    @Before
    public void setUp() {
        storyResponse = JiraRequest.createStory();
        bugResponse = JiraRequest.createBug();

        if (storyResponse.statusCode() == 201 && bugResponse.statusCode() == 201) {
            storyKey = storyResponse.getBody().jsonPath().get("key").toString();
            bugKey = bugResponse.getBody().jsonPath().get("key").toString();
            linkResponse = JiraRequest.linkStoryAndBug(storyKey, bugKey);
        } else {
            Assert.fail("Story or Bug not created");
        }
    }

    @Test
    public void status201_Returned_when_linkStoryAndBug() {
        Assert.assertEquals(201, linkResponse.statusCode());
    }

    @Test
    public void emptyResponse_Returned_when_linkStoryAndBug() {
        Assert.assertTrue(linkResponse.getBody().asString().isEmpty());
    }
}

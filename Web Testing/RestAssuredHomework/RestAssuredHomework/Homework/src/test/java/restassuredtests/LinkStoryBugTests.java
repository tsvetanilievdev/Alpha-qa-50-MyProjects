package restassuredtests;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import restassuredtests.utils.JiraRequest;


public class LinkStoryBugTests {
    static Response storyResponse;
    static Response bugResponse;
    static Response linkResponse;
    static String storyKey;
    static String bugKey;

    @BeforeClass
    public static void setUp() {
        System.out.println("SetUp for LinkStoryBugTests");
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

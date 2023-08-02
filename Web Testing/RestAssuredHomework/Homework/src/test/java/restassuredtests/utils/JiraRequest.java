package restassuredtests.utils;

import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class JiraRequest {
    public static Response createBug(){
        Response response = given().baseUri(Constants.JIRA_URL).auth().preemptive().basic(Constants.JIRA_USERNAME, Constants.JIRA_TOKEN)
                .contentType("application/json")
                .body(Constants.BODY_BUG)
                .post(Constants.JIRA_URI_ISSUE);
        return response;
    }

    public static Response createStory(){
        Response response = given().baseUri(Constants.JIRA_URL).auth().preemptive().basic(Constants.JIRA_USERNAME, Constants.JIRA_TOKEN)
                .contentType("application/json")
                .body(Constants.BODY_STORY)
                .post(Constants.JIRA_URI_ISSUE);
        return response;
    }

    public static Response linkStoryAndBug(String storyKey, String bugKey){
        Response response = given().baseUri(Constants.JIRA_URL).auth().preemptive().basic(Constants.JIRA_USERNAME, Constants.JIRA_TOKEN)
                .contentType("application/json")
                .body(Constants.BODY_LINK_STORY_BUG.replace("STORY_KEY", storyKey).replace("BUG_KEY", bugKey))
                .post(Constants.JIRA_URI_LINK);
        Assert.assertEquals(201, response.statusCode());
        return response;
    }

}

package restassured;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.Constants;
import utils.Endpoints;

import static io.restassured.RestAssured.given;

public class TestBase {

    private RequestSpecification logIn(){
        RequestSpecification response = given()
                .baseUri(Endpoints.JIRA_URL)
                .auth().preemptive()
                .basic(Constants.JIRA_USERNAME, Constants.JIRA_TOKEN)
                .when();

        return response;
    }

    public Response createIssue(String body){
        Response response = logIn()
                .contentType("application/json")
                .body(body)
                .post(Endpoints.JIRA_URI_ISSUE);
        return response;
    }

    public Response linkIssues(String body){
        Response response = logIn()
                .contentType("application/json")
                .body(body)
                .post(Endpoints.JIRA_URI_LINK);
        return response;
    }

//    public Response addAttachmentToIssue(String filePath, String issueKey){
//        Response res = logIn().header("X-Atlassian-Token", "no-check")
//                .contentType("multipart/form-data")
//                .multiPart("file", filePath)
//                .post(Endpoints.JIRA_URI_ATTACHMENT.replace("ISSUE_KEY", issueKey));
//    }
}

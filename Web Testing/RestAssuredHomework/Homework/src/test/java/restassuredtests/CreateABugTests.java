package restassuredtests;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import restassuredtests.utils.Constants;
import restassuredtests.utils.JiraRequest;

public class CreateABugTests {
    private Response response;
    private String stringResponse;
    @Before public void setUp() {
        response = JiraRequest.createBug();
        stringResponse = response.getBody().asString();
    }
    @Test
    public void status201_Returned_when_createABug() {
        Assert.assertEquals(201, response.statusCode());
    }
    @Test
    public void notEmptyResult_Returned_whenCreateABug(){
        Assert.assertFalse(response.getBody().asString().isEmpty());
    }
    @Test
    public void requiredField_ID_Returned_whenCreateABug(){
        Assert.assertTrue(stringResponse.contains("id"));
    }
    @Test
    public void requiredField_Key_Returned_whenCreateABug(){
        Assert.assertTrue(stringResponse.contains("key"));
    }
    @Test
    public void requiredField_Self_Returned_whenCreateABug(){
        Assert.assertTrue(stringResponse.contains("self"));
    }
    @Test
    public void requiredField_Key_ContainsProjectKey_whenCreateABug(){
        System.out.println(stringResponse);
        Assert.assertTrue(stringResponse.contains("\"key\":\""+ Constants.PROJECT_KEY));
    }
}

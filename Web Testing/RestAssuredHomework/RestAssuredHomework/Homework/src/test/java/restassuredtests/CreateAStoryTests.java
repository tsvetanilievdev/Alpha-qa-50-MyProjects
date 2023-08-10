package restassuredtests;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import restassuredtests.utils.Constants;
import restassuredtests.utils.JiraRequest;

public class CreateAStoryTests {
    private static Response response;
    private static String stringResponse;
    @BeforeClass
    public static void setUp() {
        response = JiraRequest.createStory();
        stringResponse = response.getBody().asString();
    }
    @Test
    public void status201_Returned_when_createAStory() {
        System.out.println("CreateAStoryTest1");
        Assert.assertEquals(201, response.statusCode());
    }
    @Test
    public void notEmptyResult_Returned_whenCreateAStory(){
        Assert.assertFalse(response.getBody().asString().isEmpty());
    }
    @Test
    public void requiredField_ID_Returned_whenCreateAStory(){
        Assert.assertTrue(stringResponse.contains("id"));
    }
    @Test
    public void requiredField_Key_Returned_whenCreateAStory(){
        Assert.assertTrue(stringResponse.contains("key"));
    }
    @Test
    public void requiredField_Self_Returned_whenCreateAStory(){
        Assert.assertTrue(stringResponse.contains("self"));
    }
    @Test
    public void requiredField_Key_ContainsProjectKey_whenCreateAStory(){
        System.out.println(stringResponse);
        Assert.assertTrue(stringResponse.contains("\"key\":\""+ Constants.PROJECT_KEY));
    }
}

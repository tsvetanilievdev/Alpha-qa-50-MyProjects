package restassured;

import com.tngtech.java.junit.dataprovider.DataProvider;
import io.restassured.response.Response;
import org.junit.Test;
import utils.Constants;
import utils.Methods;

public class CreateStory extends TestBase {
    @Test
    public void createStory() {
        String body = Methods.createBodyJson("Story", "Story description", Constants.PROJECT_KEY, "Story");
        Response res = createIssue(body);
    }


    @DataProvider
    public static Object[][] createStoryData() {
        return new Object[][]{};
    }

}
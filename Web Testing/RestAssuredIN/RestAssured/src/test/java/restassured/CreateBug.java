package restassured;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.Constants;
import utils.Methods;

public class CreateBug extends TestBase {
    Response res;

    @Before
    public void setUp() {
        String body = Methods.createBodyJson("Bug", "Bug description", Constants.PROJECT_KEY, "Bug");
        res = createIssue(Constants.BODY_BUG);
        System.out.println(res.getBody().asString());

    }

    @Test
    public void status201Returned_when_createBugSuccessful() {
        Assert.assertEquals(201, res.statusCode());
    }
}

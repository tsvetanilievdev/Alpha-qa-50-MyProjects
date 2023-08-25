package base;

import com.telerikacademy.api.tests.Constants;
import com.telerikacademy.api.tests.HelperMethods;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DistanceMatrixTests extends BaseTestSetup {

    @BeforeMethod
    public void setupDistance() {
    }
    @Test
    public void test() {
        Response res =
                getApplicationJSONSpecificationGoogle()
                        .queryParam("origins", "Chicago")
                        .queryParam("destinations", "Los Angeles")
                        .when()
                        .get();

        assertMilesAreCorrect(res, 3250);
    }


    public void assertMilesAreCorrect(Response response, int expecctedMiles){
        response.then().log().body();
        HelperMethods.isValidJSON(response.toString());
        int distance = response.jsonPath().get("rows[0].elements[0].distance.value");
        Assert.assertEquals(distance / 1000, expecctedMiles, String.format("Miles are not correct! Expected: %d", expecctedMiles));
    }

}

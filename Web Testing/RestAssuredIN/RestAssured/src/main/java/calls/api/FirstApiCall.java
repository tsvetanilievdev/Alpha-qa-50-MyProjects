package calls.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class FirstApiCall {
    public static void main(String[] args) {
        //given - all input details
        //when - submit the API - resource, http method
        //then - validate the response

        RestAssured.baseURI = "https://tsvetan-qa50.atlassian.net";
        Response res  = given()
                .auth()
                .preemptive()
                .basic("tsvetanilievdev@gmail.com","ATATT3xFfGF0C1SgJMdnU2e0GNfiUxQLgydlQqiVHR1UZQx2LuQd-RURzUUKAd4OqTzD2_EGwDk8lw2q65Os6u6v04aG325MPpqUo6Kt1gU8JA3D3tLRYLEi1umdFeEDAHkDQoyg9x-YNt1YrOpdyb7JZwWeg3yIkD5FREokxgxPAs7sYdtQYxw=1D2CEEC0")
                .contentType("application/json")
                .body("{\n" +
                        "    \"fields\": {\n" +
                        "        \"project\": {\n" +
                        "            \"key\": \"BBT\"\n" +
                        "        },\n" +
                        "        \"summary\": \"Test bug 434\",\n" +
                        "        \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\n" +
                        "        \"issuetype\": {\n" +
                        "            \"name\": \"Bug\"\n" +
                        "        }\n" +
                        "    }\n" +
                        "}")
                .post("/rest/api/2/issue")
                .then()
                .log()
                .all()
                .extract().response();

        System.out.println(res.getBody().jsonPath().get("key").toString());
    }
}

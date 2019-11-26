import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

/**
 * TASK 3
 */
public class ApiTests {
    private static final String URL = "http://127.0.0.1:3001";

    @Test
    public void getCustomers(){
        given().body("{\"name\": \"Bill Paxton\"")
        .when().post(URL + "/")
        .then().statusCode(200);
    }

    @Test
    public void smallCompanySize(){
        given().body("{\"name\": \"John Smith\"")
        .when().post(URL + "/")
        .then().body("customers[0].size", CoreMatchers.equalTo("Small"));
    }

    /**
     * !! issue here
     */
    @Test
    public void mediumCompanySize(){
        given().body("{\"name\": \"Daniel Zuck\"")
        .when().post(URL+ "/")
        .then().body("customers[0].size", CoreMatchers.equalTo("Medium"));
    }

    /**
     * !! issue here
     */
    @Test
    public void bigCompanySize(){
        given().body("{\"name\": \"Xavier Hernandez\"")
        .when().post(URL + "/")
        .then().body("customers[0].size", CoreMatchers.equalTo("Big"));
    }

    @Test
    public void noContactInfo(){
        // not sure how to test this scenario
        // we're quering by the customer name which
        // is stored under contact information object
        // in case of contact information object absense
        // there's no way to locate customer without contact information
    }
}

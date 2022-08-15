package steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.json.JSONObject;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import utils.BaseTest;

public class AddItemSteps extends BaseTest {

    public Response response;
    
    @Step("Add ToDo Items to the list {0}")
    public void addItems(String item) {
    	//Adding description to the json object to use in the response body
    	JSONObject data = new JSONObject();
        data.put("description", item);
        
        response = SerenityRest.given()
        		.header("Content-Type", "application/json")
        		.body(data.toString())
                .when().post(BASE_URI + "api/todoItems");
    }
    
    @Step("Verify the status code {0}")
    public void verifyStatusCode(int expectedStatusCode) {
    	assertEquals(expectedStatusCode,response.statusCode());
    }
 
    @Step("Verify the success response body")
    public void verifySuccessResponseBody() {
    	assertNotNull(response);
    }
    
    @Step("Verify the failure response body {0}")
    public void verifyFailuresResponseBody(String expectedMsg) {
    	assertTrue(response.body().asString().contains(expectedMsg));
    }
    
   
}

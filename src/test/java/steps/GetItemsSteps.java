package steps;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import utils.BaseTest;

public class GetItemsSteps extends BaseTest {
	
	public Response response;
	public HashMap<String, String> getItems;
	
	@Step("Get ToDo Items from the list")
    public void getItems() {
        response = SerenityRest.given()
        		.header("Content-Type", "application/json")
                .when().get(BASE_URI + "api/todoItems");
    }
	
	@Step("Retrieve ToDo Items from the list")
    public HashMap<String, String> retrieveItems() {
		//Retrieve the item lists once added using POST call and this has been used for further verification
        JSONArray jsonarray = new JSONArray(response.body().asString());
        for (int i = 0; i < jsonarray.length(); i++) {
	        JSONObject jsonobject = jsonarray.getJSONObject(i);
	        String id = jsonobject.getString("id");
	        String description = jsonobject.getString("description");
	        getItems = new HashMap<String, String>();
	        getItems.put(id, description);
        }
		return getItems;
    }
	 

}

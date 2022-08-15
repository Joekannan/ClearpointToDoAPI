package steps;


import static org.junit.Assert.assertFalse;

import java.util.Map;

import org.json.JSONObject;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import utils.BaseTest;

public class RemoveItemsSteps extends BaseTest {
	
	public Response response;
	GetItemsSteps getItemSteps = new GetItemsSteps();
	public int noOfItems;
	public String removedKey;
	
	@Step("Mark ToDo Items from the list as completed")
    public void markItemAsCompleted() {
		getItemSteps.getItems();
		noOfItems = getItemSteps.retrieveItems().size();
		//If the list is not empty, then mark the item as 
		//completed using the id and description of the items by setting isCompleted flag as true
		if(noOfItems > 0) {
			for (Map.Entry<String, String> set : getItemSteps.retrieveItems().entrySet()) {
			
				removedKey = set.getKey();
				
				//Adding the body attributes as an JSON object
				JSONObject data = new JSONObject();
				data.put("description", set.getValue());
				data.put("id", set.getKey());
				data.put("isCompleted", true);
	           
				response = SerenityRest.given().log().all()
	           		.header("Content-Type", "application/json")
	           		.body(data.toString())
	                .when().put(BASE_URI + "api/todoItems/"+set.getKey());
	           
	       }
		}
    }
	
	@Step("Verify item list is empty after marking all items are completed")
    public void verifyItemLists() {
		getItemSteps.getItems();
		noOfItems = getItemSteps.retrieveItems().size();
		//If the list is not empty, verify the id is not available in the list of items
		if(noOfItems > 0) {
			assertFalse(getItemSteps.retrieveItems().containsKey(removedKey));
		}
		
    }
}

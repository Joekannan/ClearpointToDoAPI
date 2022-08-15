package stepDef;

import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.RandomStringUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import steps.AddItemSteps;
import steps.GetItemsSteps;

public class AddItemStepDef {
	
	@Steps
	AddItemSteps addItemSteps;

	@Steps
	GetItemsSteps getItemsSteps;
	
	@Given("User enters the unique ToDo Item")
	public void user_enters_the_unique_to_do_item() {
		//This line is used to randomly generate string and add as an item
		String generatedString = RandomStringUtils.randomAlphabetic(10);
		addItemSteps.addItems(generatedString);
		getItemsSteps.getItems();
		
	}
	@Then("Item should be added successfully")
	public void item_should_be_added_successfully() {
		addItemSteps.verifyStatusCode(201);
		addItemSteps.verifySuccessResponseBody();
		assertTrue(getItemsSteps.retrieveItems().size()>0);
	}

	@Given("User enters the already existing ToDo Item")
	public void user_enters_the_already_existing_to_do_item() {
		getItemsSteps.getItems();
		//Check if the Clean House item is already available in the list, if not add it twice to get an error
		if(getItemsSteps.retrieveItems().values().contains("Clean House")) {
			addItemSteps.addItems("Clean House");
		}
		else {
			addItemSteps.addItems("Clean House");
			addItemSteps.addItems("Clean House");
		}
	}

	@Then("User should get item already exist error")
	public void user_should_get_item_already_exist_error() {
		addItemSteps.verifyStatusCode(409);
		addItemSteps.verifyFailuresResponseBody("A todo item with description already exists");
	}

	@Given("User enters the empty ToDo Item")
	public void user_enters_the_empty_to_do_item() {
		addItemSteps.addItems("");
	}

	@Then("User should get item can not be empty error")
	public void user_should_get_item_can_not_be_empty_error() {
		addItemSteps.verifyStatusCode(400);
		addItemSteps.verifyFailuresResponseBody("Description field can not be empty");
	}

}

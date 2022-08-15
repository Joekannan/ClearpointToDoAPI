package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import steps.RemoveItemsSteps;

public class RemoveItemStepDef {
	
	@Steps
	RemoveItemsSteps removeItemsSteps;
	
	@Given("User marks item as completed")
	public void user_marks_item_as_completed() {
		removeItemsSteps.markItemAsCompleted();
	}

	@Then("User should not see the completed item in the list")
	public void user_should_not_see_the_completed_item_in_the_list() {
		removeItemsSteps.verifyItemLists();
	}

}

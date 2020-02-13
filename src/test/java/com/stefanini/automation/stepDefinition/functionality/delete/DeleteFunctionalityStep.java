package com.stefanini.automation.stepDefinition.functionality.delete;

import org.springframework.http.ResponseEntity;

import com.stefanini.automation.rest.functionality.FunctionalityApiResource;

import cucumber.api.java.en.Given;

public class DeleteFunctionalityStep {


	@Given("try to delete functionality {string}")
	public void try_to_delete_role_(String name) {
		this.deleteFunctionality(name);
	}
	
	@Given("a user delete a functionality {string}")
	public void a_user_delete_the_role_(String name) {
		this.deleteFunctionality(name);
	}

	private void deleteFunctionality(String name) {
		ResponseEntity<String> deleteFunctionality = new FunctionalityApiResource().deleteFunctionality(name);
		if (deleteFunctionality != null) {
			switch (deleteFunctionality.getStatusCode().value()) {
			case 200:
				System.out.println("Functionality ["+name+"] Delete Successfully");
				break;
			default:
				System.out.println("Functionality ["+name+"] wasn't able to be deleted. ["+deleteFunctionality+"]");
			}
		}
	}

}

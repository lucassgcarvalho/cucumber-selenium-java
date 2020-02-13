package com.stefanini.automation.stepDefinition.account.delete;

import org.springframework.http.ResponseEntity;

import com.stefanini.automation.rest.account.AccountApiResource;

import cucumber.api.java.en.Given;

public class DeleteAccountStep {

    @Given("try to delete account {string}")
	public void try_to_delete_role_(String name) {
		this.deleteAccount(name);
	}
	
	@Given("a user delete a account {string}")
	public void a_user_delete_the_role_(String id) {
		this.deleteAccount(id);
	}

	private void deleteAccount(String id) {
		ResponseEntity<String> deleteAccount = new AccountApiResource().deleteAccount(id);
		if (deleteAccount != null) {
			switch (deleteAccount.getStatusCode().value()) {
			case 200:
				System.out.println("Account ["+id+"] Delete Successfully");
				break;
			default:
				System.out.println("Account ["+id+"] wasn't able to be deleted. ["+deleteAccount+"]");
			}
		}
	}

}

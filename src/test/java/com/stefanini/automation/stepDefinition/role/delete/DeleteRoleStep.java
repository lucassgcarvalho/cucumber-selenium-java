package com.stefanini.automation.stepDefinition.role.delete;

import org.springframework.http.ResponseEntity;

import com.stefanini.automation.page.BasePage;
import com.stefanini.automation.rest.role.RoleApiResource;

import cucumber.api.java.en.Given;

public class DeleteRoleStep extends BasePage {

    @Given("try to delete role {string}")
    public void try_to_delete_role_(String name) {
    	this.deleteRole(name);
    }
    
    @Given("a user delete the role {string}")
    public void a_user_delete_the_role_ (String name) {
    	this.deleteRole(name);
    }
    
    private void deleteRole(String name) {
    	ResponseEntity<String> deleteRole = new RoleApiResource().deleteRole(name);
        if(deleteRole != null) {
        	switch (deleteRole.getStatusCode().value()) {
			case 200:
				System.out.println("Role ["+name+"] Delete Successfully");
				break;
			default:
				System.out.println("Role ["+name+"] wasnt able to be deleted. Status ["+deleteRole+"] ");
			}
        }
    }
}

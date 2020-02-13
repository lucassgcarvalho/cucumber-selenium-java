package com.stefanini.automation.stepDefinition.role;

import static org.junit.Assert.assertTrue;

import com.stefanini.automation.page.role.RolePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RoleStep {

    private RolePage rolePage;

    public RoleStep() {
        this.rolePage = new RolePage();
    }
    
    @When("user select a role")
    public void user_select_a_role() {
    	this.rolePage.getFirstLinkOfTable().click();
    }

    @Given("a user access the role menu")
    public void a_user_access_the_role_menu() {
    	this.rolePage.getRoleMenu().click();
    }


    @Then("check if functionality appears is equals to role description")
    public void check_if_functionality_appears_is_equals_to_role_description() {
		String textElement = this.rolePage.getLabelTableFunctionality().getText();
		assertTrue(textElement.contains(this.rolePage.getFirstLinkOfTable().getText()));
    }

    @Then("close access role")
    public void close_access_role() {
    	this.rolePage.closeBrowser();
    }
    
}

package com.stefanini.automation.stepDefinition.functionality;

import static org.junit.Assert.assertTrue;

import com.stefanini.automation.page.functionality.FunctionalityPage;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FunctionalityStep {

    private FunctionalityPage functionalityPage;
    
    public FunctionalityStep() {
        this.functionalityPage = new FunctionalityPage();
    }
    
    @Given("A user access the functionality menu")
    public void a_user_access_the_functionality_menu() {
    	this.functionalityPage.getFunctionalityMenu().click();;
    }

    @When("user select a functionality")
    public void user_select_a_functionality() {
    	this.functionalityPage.getFirstLinkOfTable().click();
    }

    @Then("check if role appears is equals to functionality")
    public void role_appears() {
    	String textElement = this.functionalityPage.getTabRole().getText();
		assertTrue("ERROR-> Functionality is not equals to role", 
				textElement.contains(this.functionalityPage.getFirstLinkOfTable().getText()));
    }
    
//    @After("@accessFunctionality")
//    public void close_access_functionality() {
//    	this.functionalityPage.closeBrowser();
//    }
    

}

package com.stefanini.automation.stepDefinition.functionality.create;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebElement;

import com.stefanini.automation.page.functionality.FunctionalityPage;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CreateFunctionalityStep {

    private FunctionalityPage functionalityPage;
    
    public CreateFunctionalityStep() {
        this.functionalityPage = new FunctionalityPage();
    }
    
    @Given("click on new functionality")
    public void click_on_new_functionality() {
    	this.functionalityPage.getBtnCreateNewFunctionality().click();
    }
    
    @And("wait the popUp create new functionality")
    public void wait_the_popUp_create_new_functionality() {
    	this.functionalityPage.checkPopUpNewFunctionality();
    }
    
    @And("input name {string} and description {string}")
    public void input_name_and_description(String name, String description) {
    	WebElement inputNamePopUpNewFunctionality = this.functionalityPage.getInputNamePopUpNewFunctionality();
    	
    	//String ascii = this.functionalityPage.toASCII();//TODO: remove
    	this.functionalityPage.setProperty("functionality.name", name);
    	inputNamePopUpNewFunctionality.sendKeys(name);
    	
    	WebElement inputDescriptionPopUpNewFunctionality = this.functionalityPage.getInputDescriptionPopUpNewFunctionality();
    	this.functionalityPage.setProperty("functionality.description", description);
    	inputDescriptionPopUpNewFunctionality.sendKeys(description);
    }
    
    @And("click on create new functionality")
    public void click_on_create_new_functionality() {
    	this.functionalityPage.getBtnSaveNewFunctionality().click();
    }
    
    @Then("check if functionality was successfully added")
    public void check_if_functionality_was_successfully_added() {
    	//this.functionalityPage.checkPopUpEditFunctionality();
    	this.functionalityPage.getBtnClosePopUpSuccessFunctionality().click();
    	
    	WebElement functionalityFromTable = this.functionalityPage.
    				getFunctionalityFromTable(this.functionalityPage.getProperty("functionality.name"));
    	
    	functionalityFromTable.click();
    	
    	String tabRoleText = this.functionalityPage.getTabRole().getText();
		assertTrue("Error - > Selected Functionality doesn't appearns on Tab Role. "
				+ "functionality From Table ["+functionalityFromTable.getText()+"] <> Text From Tab Role ["+tabRoleText+"] ", 
				tabRoleText.contains(functionalityFromTable.getText()));
    }
    
    @After(value = "@newFunctionality")
    public void close_Create_New_functionality() {
    	this.functionalityPage.closeBrowser();
    }
}

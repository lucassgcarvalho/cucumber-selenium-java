package com.stefanini.automation.stepDefinition.functionality.update;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebElement;

import com.stefanini.automation.enums.Status;
import com.stefanini.automation.page.functionality.FunctionalityPage;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class UpdateFunctionalityStep {

    private FunctionalityPage functionalityPage;
    
    public UpdateFunctionalityStep() {
        this.functionalityPage = new FunctionalityPage();
    }
    
    @And("select a functionality {string} to edit")
    public void select_a_functionality_to_edit(String name) {
    	this.functionalityPage.setProperty("functionality.name", name);
    	
    	this.functionalityPage.getFunctionalityFromTable(name).click();

    	assertTrue("Error - > Selected Functionality doesn't appearns on Tab Role.", 
    			this.functionalityPage.getTabRole().getText().contains(name));
    }
    
    @And("click on edit functionality")
    public void click_on_edit_functionality() {
    	this.functionalityPage.getBtnEditFunctionality().click();
    }
    
    @And("wait the popUp edit functionality")
    public void wait_the_popUp_edit_functionality() {
    	this.functionalityPage.checkPopUpEditFunctionality();
    }

    
    @And("input description {string}")
    public void input_description(String description) {
    	this.functionalityPage.setProperty("functionality.edit.description", description);
    	WebElement input = this.functionalityPage.getInputDescriptionPopUpEditFunctionality();
    	input.clear();
    	input.sendKeys(description);
    }

    
    @And("change the status {string}")
    public void change_the_status(String status) {
    	WebElement switchStatus = this.functionalityPage.getSwitchStatusPopUpEditFunctionality();
    	WebElement switchStatusSpanClickable = this.functionalityPage.getSwitchStatusPopUpEditFunctionalitySpan();
    	
    	String statusSelected = switchStatus.getAttribute("aria-checked");
    	boolean statusSelectedConverted = false;

    	if(statusSelected.toLowerCase().contains("true") || statusSelected.toLowerCase().contains("false")){
    		statusSelectedConverted = new Boolean(statusSelected).booleanValue();
    	}else
    		assertNotNull("Attribute 'aria-checked' not localized. ", null);
    	
    	if(status !=null && Status.findType(status) !=null 
    			&& statusSelectedConverted != Status.findType(status).getStatus()) {
    		switchStatusSpanClickable.click();
    	}
    	
    	statusSelected = switchStatus.getAttribute("aria-checked");
		this.functionalityPage.setProperty("functionality.status", String.valueOf(statusSelected));
    }

    @And("click on save button to edit functionality")
    public void click_on_save_button_to_edit_functionality() {
    	this.functionalityPage.getBtnSaveEditedFunctionality().click();
    }
    
    @Then("check if functionality was successfully edited")
    public void check_if_functionality_was_successfully_edited() {
    	
    	this.checkPopUpSaveFunctionalityOpened();
    	this.functionalityPage.getBtnClosePopUpSuccessFunctionality().click();
    	
    	this.functionalityPage.getWait().forLoading(5);
    	this.functionalityPage.getTabFunctionality();
    	
    	String name = this.functionalityPage.getProperty("functionality.name");
    	
    	WebElement elementFound = this.functionalityPage.getFunctionalitiesTableOnWait(name);
		if(elementFound.isDisplayed()) {
			elementFound.click();
			
			String tabRoleText = this.functionalityPage.getTabRole().getText();
			assertTrue("Error - > Selected Functionality doesn't appearns on Tab Role.", 
					tabRoleText.contains(elementFound.getText()));
			
			WebElement elementStatusFound = this.functionalityPage.getStatusFromFunctionalitiesTableOfElement(name);
			String status = this.functionalityPage.getProperty("functionality.status");
			assertEquals("Error - > Status didn't change", Status.findType(elementStatusFound.getText()).getStatus(), new Boolean(status).booleanValue());
		}
    }

    private void checkPopUpSaveFunctionalityOpened() {
    	this.functionalityPage.getHeaderPopUpSuccessFunctionality();
    	assertEquals("Wrong Message from modal Success",this.functionalityPage.getModalBody().getText(),"Funcionalidade alterada com sucesso.");
    	this.functionalityPage.getBtnClosePopUpSuccessFunctionality();
	}

    
//    @After("@updateFunctionality")
//    public void closeBrowser() {
//    	this.functionalityPage.closeBrowser();
//    }
    

}

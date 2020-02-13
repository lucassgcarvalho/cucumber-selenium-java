package com.stefanini.automation.stepDefinition.user;

import static org.junit.Assert.assertEquals;

import com.stefanini.automation.page.user.UserPage;

import cucumber.api.java.After;
import cucumber.api.java.en.Then;

public class UserStep {

    private UserPage userPage;
	
    public UserStep() {
    	this.userPage = new UserPage();
    }

    @Then("check if the header {string} appears")
    public void check_if_the_header_appears(String header){
    	String headerFound = this.userPage.getHeaderUsers().getText();
    	assertEquals("Wrong header was found ["+headerFound+"]", header, headerFound);
    }
    
    @After(value = "@accessUser")
	public void closeBrowser() {
		this.userPage.closeBrowser();
	}
}

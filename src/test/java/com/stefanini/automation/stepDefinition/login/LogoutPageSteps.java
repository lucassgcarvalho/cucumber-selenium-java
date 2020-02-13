package com.stefanini.automation.stepDefinition.login;

import com.stefanini.automation.page.logout.LogoutPage;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LogoutPageSteps {

    private LogoutPage logoutPage;

    public LogoutPageSteps() {
        this.logoutPage = new LogoutPage();
    }
    
	@Given("User is Logged in")
	public void user_is_Logged_in() {
		this.logoutPage.checkHeaderIsDisplayed();
	}
	
	@Then("click on logout button")
	public void click_on_logout_button() {
		this.logoutPage.clickExitButton();
	}
	
    @And("check if is already logged out")
    public void check_if_is_already_logged_out() {
    	 this.logoutPage.checkLabelLoginIsDisplayed();
    }
	
//    @After("@logout")
//    public void afterLogout() {
//    	 this.logoutPage.closeBrowser();
//    }
//    
}


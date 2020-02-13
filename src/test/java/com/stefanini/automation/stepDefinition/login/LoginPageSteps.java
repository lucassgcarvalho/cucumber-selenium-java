package com.stefanini.automation.stepDefinition.login;

import org.openqa.selenium.WebElement;

import com.stefanini.automation.page.login.LoginPage;
import com.stefanini.automation.page.logout.LogoutPage;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginPageSteps {

    private LoginPage loginPage;

    public LoginPageSteps() {
        this.loginPage = new LoginPage();
    }
    
    @Given("A user must be loggedin user {string} password {string} in web page {string}")
    public void callLoginStep(String user, String password, String loginPage) {
        a_user_navigates_to_login_page(loginPage);
//        this.loginPage.getWait().forLoading(5);
//        logout();
//        this.loginPage.getWait().forLoading(5);
        fields_are_displayed();
        input_user(user);
        input_password(password);
        click_on_button_login();
        check_if_user_is_logged_In();
    }
    
    private void logout() {
    	WebElement  mutateButtom = this.loginPage.getBtnHeaderMutate();
    	if(mutateButtom !=null && mutateButtom.isEnabled()) {
    		new LogoutPage().clickExitButton();
    		this.loginPage.getWait().forLoading(5);
        }		
	}

	@Given("A user navigates to login page {string}")
    public void a_user_navigates_to_login_page(String loginPage) {
        this.loginPage.goToLoginPage(loginPage);
    }

    @Given("login fields are displayed")
    public void fields_are_displayed() {
//    	this.loginPage.getWait().forLoading(5);
//        logout();
//        this.loginPage.getWait().forLoading(5);
        this.loginPage.waitForElementsToBeDisplayed();
    }

    @Given("input user {string}")
    public void input_user(String user) {
    	String userFromProperties = this.loginPage.getProperty("login.user");
    	if(userFromProperties==null) {
    		this.loginPage.setProperty("login.user", user);
    	}
     	this.loginPage.getUser().sendKeys(user);
    }

    @Given("input password {string}")
    public void input_password(String password) {
    	String passwordFromProperties = this.loginPage.getProperty("login.password");
    	if(passwordFromProperties==null) {
    		this.loginPage.setProperty("login.password", password);
    	}
     	this.loginPage.getPassword().sendKeys(password);
    }

    @Given("click on button login")
    public void click_on_button_login() {
    	 this.loginPage.clickButtonLogin();
    }

    @Then("check if user is logged-In")
    public void check_if_user_is_logged_In() {
    	 this.loginPage.checkHeaderDisplayed();
    }
    
//    @After("@login")
//    public void afterLogin() {
//    	 this.loginPage.closeBrowser();
//    }
//    
}


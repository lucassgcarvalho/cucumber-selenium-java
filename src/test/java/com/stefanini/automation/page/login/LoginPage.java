package com.stefanini.automation.page.login;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stefanini.automation.page.BasePage;

public class LoginPage extends BasePage {

    @FindBy(id = "user")
    private WebElement user;
    
    @FindBy(id = "password")
    private WebElement password;
    
    @FindBy(id = "loginButton")//localHost loginButtonFake
    private WebElement loginButton;
    
    @FindBy(className = "navbar")
    private WebElement header;

    public LoginPage() {
        PageFactory.initElements(super.getDriver(), this);
      
    }

    public void goToLoginPage(String loginPage){
        super.getDriver().navigate().to(loginPage);
        super.getWait().forLoading(10);
    }

    public void waitForElementsToBeDisplayed() {
    	super.getWait().forElementToBeDisplayed( this.user, "user");
    	super.getWait().forElementToBeDisplayed( this.password, "password");
    	super.getWait().forElementToBeDisplayed( this.loginButton, "ButtonLogin");
    }

    public void checkHeaderDisplayed() {
    	super.getWait().forElementToBeDisplayed( this.header, "header");
		Assert.assertTrue(this.header.isDisplayed());
    }
    
    
    public void clickButtonLogin() {
    	 this.loginButton.click();
    }

	public WebElement getUser() {
		super.getWait().forElementToBeDisplayed( this.user, "user");
		return user;
	}

	public void setUser(WebElement user) {
		this.user = user;
	}

	public WebElement getPassword() {
		super.getWait().forElementToBeDisplayed( this.password, "password");
		return password;
	}

	public void setPassword(WebElement password) {
		this.password = password;
	}

	public WebElement getLoginButton() {
		super.getWait().forElementToBeDisplayed( this.loginButton, "loginButton");
		return loginButton;
	}

	public void setLoginButton(WebElement loginButton) {
		this.loginButton = loginButton;
	}

	public WebElement getHeader() {
		super.getWait().forElementToBeDisplayed( this.header, "header");
		return header;
	}
	public WebElement getHeaderWithoutWait() {
		return header;
	}

	public void setHeader(WebElement header) {
		this.header = header;
	}
}

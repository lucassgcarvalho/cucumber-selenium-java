package com.stefanini.automation.page.logout;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stefanini.automation.page.BasePage;


public class LogoutPage extends BasePage {

    private static final String LOGIN_PAGE_URL = "http://localhost:3000"; //10.55.15.5
    
    @FindBy(className = "navbar")
    private WebElement header;
    
    @FindBy(xpath = "//h1[contains(text(),'Login')]")
    private WebElement loginText;
    
    @FindBy(xpath = "//li[@class='mt-auto nav-item']//a[contains(text(),'Sair')]")
    private WebElement exitButton;
  
    public LogoutPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void goToLoginPage(){
        super.getDriver().navigate().to(LOGIN_PAGE_URL);
        super.getWait().forLoading(10);
    }

    public void checkHeaderIsDisplayed() {
    	super.getWait().forElementToBeDisplayed( this.header, "header");
		Assert.assertTrue(this.header.isDisplayed());
    }
    
    public void checkLabelLoginIsDisplayed() {
    	super.getWait().forElementToBeDisplayed( this.loginText, "loginText");
		Assert.assertTrue(this.loginText.isDisplayed());
    }
    
    public void clickExitButton() {
    	super.getWait().forElementToBeDisplayed( this.exitButton, "exitButton");
   	 	this.exitButton.sendKeys(Keys.ENTER);
   }
}

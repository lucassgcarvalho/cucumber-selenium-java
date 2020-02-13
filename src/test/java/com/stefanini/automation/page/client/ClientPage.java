package com.stefanini.automation.page.client;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.stefanini.automation.page.BasePage;

public class ClientPage extends BasePage {

	@FindBy(id = "customer-menu")
	private WebElement userMenu;

	@FindBy(xpath = "//div[@class='card-header']//*[contains(text(),'Clientes')]")
	private WebElement headerClients;

	@FindBy(id = "filter")
	private WebElement comboGroups;
	
	
	public WebElement getUserMenu() {
		super.getWait().forElementToBeDisplayed( this.userMenu, "userMenu");
		return userMenu;
	}

	public void setUserMenu(WebElement userMenu) {
		this.userMenu = userMenu;
	}

	public WebElement getHeaderClients() {
		super.getWait().forElementToBeDisplayed( this.headerClients, "headerClients");
		return headerClients;
	}

	public void setHeaderClients(WebElement headerClients) {
		this.headerClients = headerClients;
	}
	
}

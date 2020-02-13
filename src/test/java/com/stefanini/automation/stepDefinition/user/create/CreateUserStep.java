package com.stefanini.automation.stepDefinition.user.create;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.openqa.selenium.WebElement;

import com.stefanini.automation.page.user.UserPage;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CreateUserStep {

    private UserPage userPage;
    
    public CreateUserStep() {
        this.userPage = new UserPage();
    }
    
    @Given("access the User menu")
    public void a_user_access_the_User_menu() {
    	this.userPage.getUserMenu().click();
    }
	
	@And("click on new user")
	public void click_on_new_user() {
		this.userPage.getBtnCreateUser().click();
		this.checkModalNewUserAppears();
	}
	
	@And("input user fullName {string}")
	public void input_user_fullName_(String string) {
		this.userPage.setProperty("user.create.fullname", string);
		this.userPage.getInputNewFullName().sendKeys(string);
	}
	
	@And("input user firstName {string}")
	public void input_user_firstName_(String string) {
		this.userPage.setProperty("user.create.firstName", string);
		this.userPage.getInputNewFirstName().sendKeys(string);
	}
	
	@And("input user lastName {string}")
	public void input_user_lastName_(String string) {
		this.userPage.setProperty("user.create.lastName", string);
		this.userPage.getInputNewLastName().sendKeys(string);
	}
	
	@And("input user cpf {string}")
	public void input_user_cpf_(String string) {
		this.userPage.setProperty("user.create.cpf", string);
		this.userPage.getInputNewCpf().sendKeys(string);
	}
	
	@And("input user email {string}")
	public void input_user_email_(String string) {
		this.userPage.setProperty("user.create.email", string);
		this.userPage.getInputNewEmail().sendKeys(string);
	}
	
	@Then("click on create new user")
	public void click_on_create_new_user() {
		this.userPage.getBtnRegisterModal().click();
	}
	
	@And("check if user was successfully created")
	public void check_if_user_was_successfully_created() {
		
		
		if(!this.userPage.getModal().isDisplayed()) {
			assertNotNull("Modal on Success/Error Didn't appears.", null);
		}
		
		WebElement btnConfigAccessModalOnSuccess = this.userPage.getBtnConfigAccessModalOnSuccess();
		
		String modalTitle = this.userPage.getModalTitle().getText();
		assertEquals("Modal on Success doesn't have right label [Sucesso]. Actual Label "+
				modalTitle+".", "Sucesso", modalTitle.trim());
		
		assertEquals("Modal on Success doesn't have right label [Usuário cadastrado com sucesso.] . Actual Label "+
				this.userPage.getModalBody().getText(), this.userPage.getModalBody().getText(), "Usuário cadastrado com sucesso");
		
		btnConfigAccessModalOnSuccess.click();
		
		this.userPage.getWait().forLoading(5);
		
		checkUserData();
	}
 
    
	public void checkUserData() {
		assertEquals("User ["+this.userPage.getCardHeaderStrong().getText()+"] in tab Edit"
				+ " Its not the same as "+this.userPage.getProperty("user.create.fullname")+"", 
				this.userPage.getCardHeaderStrong().getText().trim(), this.userPage.getProperty("user.create.fullname").trim());
		
		WebElement inputFullnameEditUser = this.userPage.getInputFullnameEditUser();
		String fullnameMemory = this.userPage.getProperty("user.create.fullname");
		assertEquals("FullName in edition tab ["+inputFullnameEditUser.getAttribute("value")+"] it's not the same as FullName Registred ["+fullnameMemory+"].", 
				fullnameMemory, inputFullnameEditUser.getAttribute("value"));
		
		WebElement inputFirstnameEditUser = this.userPage.getInputFirstnameEditUser();
		String firstnameMemory = this.userPage.getProperty("user.create.firstName");
		assertEquals("FirstName in edition tab ["+inputFirstnameEditUser.getAttribute("value")+"] it's not the same as FirstName Registred ["+firstnameMemory+"].", 
				firstnameMemory, inputFirstnameEditUser.getAttribute("value"));
		
		
		WebElement inputLastnameEditUser = this.userPage.getInputLastnameEditUser();
		String lastnameMemory = this.userPage.getProperty("user.create.lastName");
		assertEquals("LastName in edition tab ["+inputLastnameEditUser.getAttribute("value")+"] it's not the same as LastName Registred ["+lastnameMemory+"].", 
				lastnameMemory, inputLastnameEditUser.getAttribute("value"));
		
		
		WebElement inputEmailEditUser = this.userPage.getInputEmailEditUser();
		String emailMemory = this.userPage.getProperty("user.create.email");
		assertEquals("Email in edition tab ["+inputEmailEditUser.getAttribute("value")+"] it's not the same as Email Registred ["+emailMemory+"].", 
				emailMemory, inputEmailEditUser.getAttribute("value"));
		
		
		WebElement inputCpfEditUser = this.userPage.getInputCpfEditUser();
		String cpfMemory = this.userPage.getProperty("user.create.cpf");
		assertEquals("CPF in edition tab ["+inputCpfEditUser.getAttribute("value")+"] it's not the same as CPF Registred ["+cpfMemory+"].", 
				cpfMemory.replace(".", "").replace("-", ""), 
				inputCpfEditUser.getAttribute("value").replace(".", "").replace("-", ""));
		
		assertEquals("User has been create with status inative.", 
				this.getStatusEditUser(), "On");
 	}
	
	public String getStatusEditUser() {
		return this.userPage.getSwitchSliderStatusEditUser().getAttribute("data-checked");
    }
	
 	public void checkModalNewUserAppears() {
 		this.userPage.getModal();
 	}
	
 	
 	@After(value = "@newUser")
	public void closeBrowser() {
		this.userPage.closeBrowser();
	}
}

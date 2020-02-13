package com.stefanini.automation.stepDefinition.user.update;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.stefanini.automation.page.user.UserPage;
import com.stefanini.automation.page.user.model.CorrelationPojo;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import gherkin.deps.com.google.gson.Gson;

public class UpdateUserStep {

    private UserPage userPage;
    
    public UpdateUserStep() {
        this.userPage = new UserPage();
    }
    
    @And("input the search value fullName {string} or cpf {string} or e-mail {string} of {string}")
	public void And_select_the_search_type_(String fullName, String cpf, String email, String searchType) {
    	
    	this.userPage.setProperty("user.edit.fullname", fullName);
    	this.userPage.setProperty("user.edit.cpf", cpf);
    	this.userPage.setProperty("user.edit.searchType", searchType);
    	
    	switch (searchType) {
		case "CPF":
			this.userPage.getRadioCpfSearch().click();
			this.userPage.getInputCpfSearch().sendKeys(cpf);
			break;
		case "E-mail":
			this.userPage.getRadioEmailSearch().click();
			this.userPage.getInputEmailSearch().sendKeys(email);
			break;
		case "Nome":
			this.userPage.getRadioNameSearch().click();
			this.userPage.getInputNameSearch().sendKeys(fullName);
			break;
		default:
			assertNotNull("SearchType "+searchType+" doesn't exists.  ", null);
		}
	}
    
	@And("click on search user")
	public void click_on_search_user() {
		this.userPage.getBtnSearch().click();
	}
	
	@And("select user to be edited")
	public void select_user_to_be_edited() {
    	this.getClickableUserFromTableRegister().click();
	}
	
	@And("click on edit user")
	public void click_on_edit_user() {
		this.userPage.getBtnEditUser().click();
		this.checkModalEditUserAppears();
	}
	
	@And("input user edited fullName {string}")
	public void input_user_edited_fullName_(String string) {
		this.userPage.setProperty("user.edit.fullname", string);
		this.userPage.getInputEditFullName().clear();
		this.userPage.getInputEditFullName().sendKeys(string);
	}
	
	@And("input user edited firstName {string}")
	public void input_user_edited_firstName_(String string) {
		this.userPage.setProperty("user.edit.firstName", string);
		this.userPage.getInputEditFirstName().clear();
		this.userPage.getInputEditFirstName().sendKeys(string);
	}
	
	@And("input user edited lastName {string}")
	public void input_user_edited_lastName_(String string) {
		this.userPage.setProperty("user.edit.lastName", string);
		this.userPage.getInputEditLastName().clear();
		this.userPage.getInputEditLastName().sendKeys(string);
	}
	
	@And("input user edited email {string}")
	public void input_user_edited_email_(String string) {
		this.userPage.setProperty("user.edit.email", string);
		this.userPage.getInputEditEmail().clear();
		this.userPage.getInputEditEmail().sendKeys(string);
	}
	
	
	@And("change edited user status")
	public void change_status () {
		this.changeStatusPopUp();
	}
	
	@Then("click on save edit user")
	public void click_on_create_edit_user() {
		this.userPage.getBtnSaveEditedUser().click();
	}
	
	@And("check if user was successfully edited")
	public void check_if_user_was_successfully_created() {
		
		if(!this.userPage.getModal().isDisplayed()) {
			assertNotNull("Modal on Success/Error Didn't appears.", null);
		}
		
		WebElement btnCloseModal = this.userPage.getBtnCloseModalOnSuccess();
		
		String modalTitle = this.userPage.getModalTitle().getText();
		assertEquals("Modal on Success doesn't have right label [Sucesso]. Actual Label "+
				modalTitle+".", "Sucesso", modalTitle.trim());
		
		assertEquals("Modal on Success doesn't have right label [Usuário editado com sucesso.] . Actual Label "+
				this.userPage.getModalBody().getText(), this.userPage.getModalBody().getText(), "Usuário editado com sucesso.");
		
		btnCloseModal.click();
		
		this.userPage.getWait().forLoading(5);
		checkUserData();
	}
	
	@And("click on select client")
	public void click_on_select_client() {
		this.userPage.getBtnSelectClient().click();
	}
	
	@And("select client from economic group")
	public void select_client_from_economic_group() {
		this.userPage.getOptionEconomicGroupOne().click();
		
		WebElement tableClientFirstInput = this.userPage.getTableClientFirstInput();
		this.userPage.setProperty("user.edit.correlation.attributes", tableClientFirstInput.getAttribute("value"));
		tableClientFirstInput.click();
	}
	
	@And("select account to edit correlation")
	public void select_account() {
		WebElement optionSelectedAccountFirst = this.userPage.getOptionSelectedAccountFirst();
		optionSelectedAccountFirst.click();
	}
	
	@And("click on button select account")
	public void click_on_button_select_account() {
		this.userPage.getBtnSelectAccount().click();
	}

	@Then("check data filled in form")
	public void check_data_filled_in_form() {
		String valueMemory = this.userPage.getProperty("user.edit.correlation.attributes");
		
		CorrelationPojo pojoFromMemory = new Gson().fromJson(valueMemory, CorrelationPojo.class);
		
		assertEquals("Error -> Selected Option not the same.", 
				pojoFromMemory.getId()+" - "+pojoFromMemory.getName() , 
					this.userPage.getCustomerToCorrelate().getAttribute("value"));
		
		assertEquals("Error -> Selected Account not the same.", 
				pojoFromMemory.getAccounts()[0].getId()+" - "+pojoFromMemory.getAccounts()[0].getName(), 
					this.userPage.getAccountToCorrelate().getAttribute("value"));
		
		assertEquals("Error -> Selected Type not the same.", 
				pojoFromMemory.getAccounts()[0].getType(), 
					this.userPage.getAccountTypeToCorrelate().getAttribute("value"));
	}
	
	@And("select roles to correlation")
	public void select_roles_to_correlation() {
		WebElement rolesSwitchesSpan1Div = this.userPage.getRolesSwitchesSpan1Div();
		this.userPage.setProperty("user.edit.correlation.role", rolesSwitchesSpan1Div.getText());
		rolesSwitchesSpan1Div.click();
	}
	
	@And("click on button effective correlations")
	public void click_on_button_effective_correlations() {
		this.userPage.getBtnEffectiveCorrelation().click();
	}
	
	@Then("check if users correlations was successfully edited")
	public void check_if_users_correlations_was_successfully_edited() {
		assertTrue("Error -> Modal success.", this.userPage.getModalHeader().getText().contains("Sucesso"));
		assertTrue("Error -> Modal Success body.", this.userPage.getModalBody().getText().contains("Correlação criada com sucesso."));
		this.userPage.getBtnCloseModalOnSuccess().click();
		this.validateCorrelationsTableValues();
	}
	
	
	private void validateCorrelationsTableValues() {
		String error = "";
		boolean validated = false;
		for (int i = 0; i < this.userPage.getTableCorrelationValues(null).size(); i++) {
			String valueMemory = this.userPage.getProperty("user.edit.correlation.attributes");
			CorrelationPojo pojoFromMemory = new Gson().fromJson(valueMemory, CorrelationPojo.class);

			String clientFull = pojoFromMemory.getName();
			String clientInTable = this.userPage.getTableCorrelationValues(clientFull)
						.get(i).findElement(By.xpath(".//td[1]")).getText();
			error = "Client = "+clientFull + " -> Client Table = " +clientInTable ;
			if(clientFull.equals(clientInTable)) {
				
				String accountFull = pojoFromMemory.getAccounts()[0].getId()+" - "+pojoFromMemory.getAccounts()[0].getName();
				String accountTable = this.userPage.getTableCorrelationValues(clientFull).get(i)
						.findElement(By.xpath(".//td[2]")).getText();
				error = "Account = "+accountFull+ " -> Account Table = " +accountTable;
				if(accountFull.equals(accountTable)) {
					
					String typeFull = pojoFromMemory.getAccounts()[0].getType();
					String typeTable = this.userPage.getTableCorrelationValues(clientFull)
							.get(i).findElement(By.xpath(".//td[3]")).getText();
					error = "Type = "+typeFull+ " -> Type Table = " +typeTable;
					if(typeFull.equals(typeTable)) {

						String roleFull = this.userPage.getProperty("user.edit.correlation.role");
						String roleTable = this.userPage.getTableCorrelationValues(clientFull)
								.get(i).findElement(By.xpath(".//td[4]")).getText();
						error = "Role= "+roleFull+ " -> Role Table = " +roleTable;
						if(roleFull.equals(roleTable)) {
							validated = true;
						}
					}
				}
			}
		}
		assertTrue("Error -> Records in table didn't match included correlation. Error: " + error, validated);
	}

	@After(value = "@updateUser")
	public void closeBrowser() {
		this.userPage.closeBrowser();
	}
	
	@After(value = "@updateCorrelationUser")
	public void closeBrowserCorrelation() {
		this.userPage.closeBrowser();
	}
	
	public void changeStatusPopUp() {
		WebElement switchStatusEditUserPopUp = this.userPage.getSwitchStatusEditUserPopUp();
    	String statusClicked = switchStatusEditUserPopUp.getAttribute("aria-checked");
    	if(statusClicked != null && 
    			(statusClicked.toLowerCase().contains("true") || statusClicked.toLowerCase().contains("false"))) {
    		this.userPage.setProperty("user.edit.status.popup", statusClicked);
    		this.userPage.getModalBody().findElement(By.xpath(".//span[@class='switch-slider']")).click();
    		this.userPage.setProperty("user.edit.status.popup.edited", switchStatusEditUserPopUp.getAttribute("aria-checked"));
    	}else {
    		assertNotNull(statusClicked);
    	}
    }
    
	public void checkUserData() {
		String fullNameMemory = this.userPage.getProperty("user.edit.fullname");
		assertEquals("User ["+this.userPage.getCardHeaderStrong().getText()+"] in tab Edit"
				+ " Its not the same as "+fullNameMemory+"", 
				this.userPage.getCardHeaderStrong().getText().trim(), fullNameMemory.trim());
		
		WebElement inputFullnameEditUser = this.userPage.getInputFullnameEditUser();
		String fullnameMemory = this.userPage.getProperty("user.edit.fullname");
		assertEquals("FullName in edition tab ["+inputFullnameEditUser.getAttribute("value")+"] it's not the same as FullName Registred ["+fullnameMemory+"].", 
				fullnameMemory, inputFullnameEditUser.getAttribute("value"));
		
		WebElement inputFirstnameEditUser = this.userPage.getInputFirstnameEditUser();
		String firstnameMemory = this.userPage.getProperty("user.edit.firstName");
		assertEquals("FirstName in edition tab ["+inputFirstnameEditUser.getAttribute("value")+"] it's not the same as FirstName Registred ["+firstnameMemory+"].", 
				firstnameMemory, inputFirstnameEditUser.getAttribute("value"));
		
		
		WebElement inputLastnameEditUser = this.userPage.getInputLastnameEditUser();
		String lastnameMemory = this.userPage.getProperty("user.edit.lastName");
		assertEquals("LastName in edition tab ["+inputLastnameEditUser.getAttribute("value")+"] it's not the same as LastName Registred ["+lastnameMemory+"].", 
				lastnameMemory, inputLastnameEditUser.getAttribute("value"));
		
		
		WebElement inputEmailEditUser = this.userPage.getInputEmailEditUser();
		String emailMemory = this.userPage.getProperty("user.edit.email");
		assertEquals("Email in edition tab ["+inputEmailEditUser.getAttribute("value")+"] it's not the same as Email Registred ["+emailMemory+"].", 
				emailMemory, inputEmailEditUser.getAttribute("value"));
		
		assertEquals("User has been create with status inative.", 
				this.userPage.getStatusFromSwitch(this.userPage.getSwitchStatusEditUser()), 
				this.userPage.getProperty("user.edit.status.popup.edited"));
 	}
	
	
	public String getStatusEditUser() {
		return this.userPage.getSwitchSliderStatusEditUser().getAttribute("data-checked");
    }
	
 	public void checkModalNewUserAppears() {
 		this.userPage.getModal();
 	}
 	
 	public void checkModalEditUserAppears() {
 		this.userPage.getModal();
 		assertEquals("Wrong title to Modal Edit User.", this.userPage.getModalTitle().getText(), "Editar usuário");
 	}
	
 	public WebElement getClickableUserFromTableRegister() {
 		return this.userPage.getUserFromRegisterTableByCpf(this.userPage.getProperty("user.edit.cpf"));
 	}
 	
}

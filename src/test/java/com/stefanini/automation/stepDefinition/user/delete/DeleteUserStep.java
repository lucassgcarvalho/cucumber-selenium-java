package com.stefanini.automation.stepDefinition.user.delete;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.springframework.http.ResponseEntity;

import com.stefanini.automation.page.user.UserPage;
import com.stefanini.automation.rest.correlation.CorrelationApiResource;
import com.stefanini.automation.rest.user.UserApiResource;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class DeleteUserStep {
	
	private UserPage userPage;
	    
	public DeleteUserStep() {
        this.userPage = new UserPage();
    }
    
    @Given("user is deleted by name {string}")
    public void  user_is_deleted_by_name (String name) {
    	this.deleteUser(name);
    }
    

    @And("select user to delete correlation")
    public void select_user_to_be_edited() {
    	WebElement selectUserFromTableRegister = this.selectUserFromTableRegister();
    	if(selectUserFromTableRegister!=null) {
    		selectUserFromTableRegister.click();
    	}else {
    		System.out.println("There is no User registred with this property.");
    	}
    }
    
    @Then("delete correlations")
    public void delete_correlations() {
    	this.deleteCorrelationsFromTableValues();
    }
    
    @After(value = "@deleteCorrelationUser")
    public void closeBrowserDeleteCorrelation() {
    	this.userPage.closeBrowser();
    }
    
    private void deleteUser(String name) {
    	ResponseEntity<String> deleteUser = new UserApiResource().deleteUser(name);
        if(deleteUser != null) {
        	switch (deleteUser.getStatusCode().value()) {
			case 200:
				System.out.println("User ["+name+"] Delete Successfully");
				break;
			default:
				System.out.println("User ["+name+"] wasnt able to be deleted. Status ["+deleteUser+"] ");
			}
        }
    }
    
	
	public WebElement selectUserFromTableRegister() {
		return this.userPage.getUserFromRegisterTableByCpfToDeleteCorrelation(this.userPage.getProperty("user.edit.cpf"));
 	}
	
	private void deleteCorrelationsFromTableValues() {
		List<WebElement> tableCorrelationExclude = this.userPage.getTableCorrelationExclude();
		if(tableCorrelationExclude == null || tableCorrelationExclude.size() < 1) {
			System.out.println("There is no Correlation to this user.");
		}else {
			for (int i = 0; i < tableCorrelationExclude.size(); i++) {
				String idCorrelationToExclude = this.userPage.getTableCorrelationExclude().get(i).getAttribute("id");
				ResponseEntity<String> deleteCorrelation = new CorrelationApiResource().deleteCorrelation(idCorrelationToExclude);
		        if(deleteCorrelation != null) {
		        	switch (deleteCorrelation.getStatusCode().value()) {
					case 200:
						System.out.println("Correlation ["+idCorrelationToExclude+"] Delete Successfully");
						break;
					default:
						System.out.println("Correlation ["+idCorrelationToExclude+"] wasnt able to be deleted. Status ["+deleteCorrelation+"] ");
					}
		        }
			}
		}
	}
	
    
}
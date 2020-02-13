package com.stefanini.automation.stepDefinition.role.update;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.stefanini.automation.page.role.RolePage;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import gherkin.deps.com.google.gson.Gson;

public class UpdateRoleStep {

    private RolePage rolePage;

    public UpdateRoleStep() {
        this.rolePage = new RolePage();
    }
    
    @And("select a role {string}")
    public void select_a_role_(String name) {
    	this.rolePage.setProperty("role.name", name);
    	WebElement roleFromTable = this.rolePage.getRoleFromTable(name);
    	roleFromTable.click();
    }
    
    @And("click on edit role")
    public void click_on_edit_role() {
    	this.rolePage.getBtnEditRole().click();
    	this.rolePage.getEditForm();
    	this.rolePage.getInputNameRole();
    	this.rolePage.getInputDescriptionRole();
    	this.rolePage.getFunctionalitiesDiv();
    	this.rolePage.getBtnSaveModalRole();
    	this.rolePage.getBtnCancelModalRole();
    }
    

	@And("change role description {string}")
	public void change_role_description_(String newDescription) {
		this.rolePage.setProperty("role.edit.name", newDescription);
		this.rolePage.getInputDescriptionRole().clear();
		this.rolePage.getInputDescriptionRole().sendKeys(newDescription);
	}

	
	@And("change status")
	public void change_status() {
		this.changeStatusPopUp();
	}
	
    @And("select functionalities to edit")
    public void select_functionalities_to_edit(List<String> listFunctionalities) {
    	this.rolePage.setProperty("role.list.functionalities", String.join(",", listFunctionalities));
    	Map<String, String> mapFunctionalities =  new HashMap<String, String>();
    	for (String elementToSearch : listFunctionalities) {
    		this.rolePage.getWait().forPresenceOfElements(5, By.xpath("//div[@id='functionalities-div']//span"), "Combo of Functionalities -> //div[@id='functionalities-div']//span");
    		WebElement findElement = this.rolePage.getFunctionalitiesDiv().findElement(By.id(elementToSearch));
    		if(findElement.isEnabled()) {
    			findElement.click();
    			mapFunctionalities.put(elementToSearch, String.valueOf(findElement.isSelected()));
    		}
		}
    	this.rolePage.setProperty("role.map.functionalities", mapFunctionalities.toString() );
    }
	
    @Then("click on save edited role")
	public void click_on_save_edited_role() {
    	this.rolePage.getBtnSaveModalRole().click();
	}
    
    @SuppressWarnings("unchecked")
	@And("check if role was successfully edited")
	public void check_if_role_was_successfully_edited() {
		this.rolePage.checkPopUpRoleEdited("Sucesso", "Perfil alterado com sucesso.");
		
		String roleName = this.rolePage.getProperty("role.name");
		
		select_a_role_(roleName);
		
		String labelTableFunctionalities = this.rolePage.getLabelTableFunctionality().getText();
    	assertTrue("Error, Table Functionalities "+labelTableFunctionalities+" doesn't contains the right Role name ["+roleName+"]", 
    			labelTableFunctionalities.contains(roleName));
    	
    	List<WebElement> listFunctionalities = this.rolePage.getTableFunctionalities().findElements(By.xpath(".//tbody//tr/td[1]"));

    	String mapString = this.rolePage.getProperty("role.map.functionalities");
		HashMap<String, Boolean> mapFunctionalities = new Gson().fromJson(mapString, HashMap.class);
		
		int countElementsEnableds = 0;
		int countElementsFounds = 0;
		for (WebElement element : listFunctionalities) {
			if(mapFunctionalities.containsKey(element.getText())) {
				countElementsFounds++;//elements with value FALSE, doesnt appearns in table
        		if(mapFunctionalities.get(element.getText())) {
        			countElementsEnableds++;
        		}
        	}
		}
    	assertTrue("Error, number of functionalities added are diffrent than registred in scenario. "
    			+ "Registred "+mapFunctionalities.toString(), 
    			countElementsEnableds == countElementsFounds);
	}
	
	public void changeStatusPopUp() {
    	String statusClicked = this.rolePage.getSwitchStatusPopUp().getAttribute("aria-checked");
    	if(statusClicked != null && (statusClicked.toLowerCase().contains("true") || statusClicked.toLowerCase().contains("false"))) {
    		this.rolePage.setProperty("role.edit.status", statusClicked);
    	}else {
    		assertNotNull(statusClicked);
    	}
    }
	
	
//	@After("@updateRole")
//    public void afterLogin() {
//    	 this.rolePage.closeBrowser();
//    }
	

}

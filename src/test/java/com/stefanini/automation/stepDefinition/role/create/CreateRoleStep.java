package com.stefanini.automation.stepDefinition.role.create;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.stefanini.automation.page.role.RolePage;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class CreateRoleStep {

    private RolePage rolePage;
    

    public CreateRoleStep() {
        this.rolePage = new RolePage();
    }
    
    @And("click on new role")
    public void click_on_new_role() {
    	this.rolePage.getBtnCreateNewRole().click();
    	this.rolePage.getCreationForm();
    	this.rolePage.getInputNameRole();
    	this.rolePage.getInputDescriptionRole();
    	this.rolePage.getFunctionalitiesDiv();
    	this.rolePage.getBtnSaveNewRole();
    	this.rolePage.getBtnCloseNewRole();
    }

    @And("input role name {string} and description {string}")
    public void input_name_and_description(String name, String description) {
    	this.rolePage.setProperty("role.create.name", name);

    	WebElement inputNameNewRole = this.rolePage.getInputNameRole();
    	inputNameNewRole.sendKeys(name);
    	
    	WebElement inputDescriptionNewRole = this.rolePage.getInputDescriptionRole();
		inputDescriptionNewRole.sendKeys(description);
    }
    
    @And("select functionalities")
    public void input_name_and_description(List<String> listFunctionalities) {
    	this.rolePage.setProperty("role.list.functionalities", String.join(",", listFunctionalities));
    	
    	List<String> selectedElements = listFunctionalities
    			.stream()
    			.filter( elementToSearch -> {
		    		WebElement findElement = this.rolePage.getFunctionalitiesDiv().findElement(By.id(elementToSearch));
		    		if(findElement.isEnabled() && !findElement.isSelected()) {
		    			findElement.click();
		    			return true;
		    		}else
		    			return false;
		    	}).collect(Collectors.toList());
    	
    	
    	
    	assertTrue("Error to find Functionalities -> Found "+selectedElements.toString()+ ""
    			+ " | Parameters "+listFunctionalities.toString()+" ",
    			(selectedElements !=null && selectedElements.size() == listFunctionalities.size()));
    }
    
    
    @And("click on create new role")
    public void click_on_create_new_role() {
    	this.rolePage.getBtnSaveNewRole().click();
    }

    @Then("check if role was successfully added")
    public void check_if_role_was_successfully_added() {
    	
    	this.checkPopUpRoleCreatedSuccess();
    	
    	String roleName = this.rolePage.getProperty("role.create.name");
    	WebElement roleFromTable = this.rolePage.getRoleFromTable(roleName);
    	roleFromTable.click();
    	
    	String labelTableFunctionalities = this.rolePage.getLabelTableFunctionality().getText();
    	assertTrue("Error, Table Functionalities "+labelTableFunctionalities+" doesn't contains the right Role name ["+roleName+"]", 
    			labelTableFunctionalities.contains(roleName));
    	
    	List<WebElement> listFunctionalities = this.rolePage.getTableFunctionalities().findElements(By.xpath(".//tbody//tr/td[1]"));
    	List<String> asList = Arrays.asList(this.rolePage.getProperty("role.list.functionalities").split(","));
    	List<String> listErrorFunctionalities = listFunctionalities
    			.stream()
                .filter(element -> !asList.contains(element.getText()))
                .map(WebElement::getText)
                .collect(Collectors.toList());
    	
    	
    	assertTrue("Error, number of functionalities added are diffrent than registred in scenario. "
    			+ "Registred "+asList.toString(), listErrorFunctionalities.size() == 0);
    }

    private void checkPopUpRoleCreatedSuccess() {
    	this.rolePage.getModalRole();
    	this.rolePage.getModalFooterModalRole();

    	WebElement modalHeaderSaveNewRole = this.rolePage.getModalHeaderModalRole();
    	WebElement modalBodySaveNewRole = this.rolePage.getModalBodyModalRole();
    	WebElement btnCloseModalNewRole = this.rolePage.getBtnCloseModalRole();
    	
    	assertTrue("Error, Modal doesn't match label [ 'Sucesso' :"+modalHeaderSaveNewRole.getText()+" ]", 
    			modalHeaderSaveNewRole.getText().contains("Sucesso"));
    	assertTrue("Error, Modal doesn't match label [ 'Perfil cadastrado com sucesso.' :"+modalBodySaveNewRole.getText()+" ]", 
    			modalBodySaveNewRole.getText().contains("Perfil cadastrado com sucesso."));
    	btnCloseModalNewRole.click();		
	}

	@After(value = "@newRole")
    public void close_Create_new_role() {
    	this.rolePage.closeBrowser();
    }

}

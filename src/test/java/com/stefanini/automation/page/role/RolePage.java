package com.stefanini.automation.page.role;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stefanini.automation.page.BasePage;

public class RolePage extends BasePage {

	@FindBy(id = "role-menu")
	private WebElement roleMenu;
	
	@FindBy(id = "user-menu")
	private WebElement userMenu;

	@FindBy(xpath = "//div[contains(text(),'Perfis de acesso')]")
	private WebElement tabRole;//
	
	@FindBy(xpath = "//div[contains(text(),'Perfis de acesso')]//following-sibling::*/child::*/table")
	private WebElement tableRole;//
	
	@FindBy(xpath = "//div[contains(text(),'Funcionalidades')]")
	private WebElement labelTableFunctionality;//

	@FindBy(xpath = "//div[contains(text(),'Funcionalidades')]//following-sibling::*/child::*/table")
	private WebElement tableFunctionalities;//
	
	@FindBy(xpath = "//table[@class='table-striped table table-hover']//tr[1]//td[1]//a")
	private WebElement firstLinkOfTable;//
	
	@FindBy(id = "creation-form")
	private WebElement creationForm;
	
	@FindBy(id = "edit-form")
	private WebElement editForm;
	
	@FindBy(id = "description")
	private WebElement inputDescriptionRole;
	
	@FindBy(id = "name")
	private WebElement inputNameRole;
	
	@FindBy(id = "functionalities-div")
	private WebElement functionalitiesDiv;
	
	//document.querySelector("#functionalities-div")
	@FindBy(xpath = "//div[@id='functionalities-div']//span//div//div//label")
	private List<WebElement> listFunctionalitiesRadioButtons;
	
	@FindBy(xpath = "//button[@type='submit'][contains(text(),'Cadastrar')]")
	private WebElement btnSaveNewRole;
	
	@FindBy(xpath = "//button[@type='button'][contains(text(),'Editar perfil')]")
	private WebElement btnEditRole;
	
	@FindBy(xpath = "//button[@type='button'][contains(text(),'Novo perfil')]")
	private WebElement btnCreateNewRole;
	
	@FindBy(xpath = "//button[@type='button'][contains(text(),'Cancelar')]")
	private WebElement btnCloseNewRole;
	
	@FindBy(xpath = "//div[@class='modal-content']")
	private WebElement modalRole;
	
	@FindBy(xpath = "//div[@class='modal-header']")
	private WebElement modalHeaderModalRole;
	
	@FindBy(xpath = "//div[@class='modal-body']")
	private WebElement modalBodyModalRole;
	
	@FindBy(xpath = "//div[@class='modal-footer']")
	private WebElement modalFooterModalRole;
	
	@FindBy(xpath = "//button[@type='button'][contains(text(),'Fechar')]")
	private WebElement btnCloseModalRole;
	
	@FindBy(xpath = "//button[@type='button'][contains(text(),'Cancelar')]")
	private WebElement btnCancelModalRole;
	
	@FindBy(xpath = "//button[@type='submit'][contains(text(),'Salvar')]")
	private WebElement btnSaveModalRole;
	
	@FindBy(id = "status")
	private WebElement switchStatusPopUp; 
	private static final String STRING_SPAN_STATUS = "//span[@class='switch-slider']";
	
	
	public RolePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public WebElement getRoleFromTable(String role) {
		super.getWait().forElementToBeDisplayed( this.tableRole, "tableRole -> Perfis de acesso");
		
		if(role == null) {
			role = super.getProperty("role.create.name");
		}
		
		super.getWait().forPresenceOfElements(5, By.xpath(".//a[text()='"+role+"']"), "functionalitiesTable -> text["+role+"]");
		
		WebElement elementFound = this.tableRole.findElement(By.xpath(".//a[text()='"+role+"']"));
		super.getWait().forElementToBeDisplayed( elementFound, "tableRole > elementToSearch ->'"+role+"'");
		
		if(elementFound.isDisplayed()) {
			return elementFound;
		}else {
			assertNull("Role not found", null);
			return null;
		}
	}
	
	public void clickOnRoleMenu() {
		super.getWait().forElementToBeDisplayed( this.roleMenu, "roleMenu");
		this.roleMenu.click();
	}
	
    public void checkPopUpRoleEdited(String status, String message) {
    	this.getModalRole();
    	this.getModalFooterModalRole();

    	WebElement modalHeaderSaveNewRole = this.getModalHeaderModalRole();
    	WebElement modalBodySaveNewRole = this.getModalBodyModalRole();
    	WebElement btnCloseModalNewRole = this.getBtnCloseModalRole();

    	assertTrue("Error, Modal doesn't match label [ "+status+" :"+modalHeaderSaveNewRole.getText()+" ]", 
    			modalHeaderSaveNewRole.getText().contains(status));
    	assertTrue("Error, Modal doesn't match label [ "+message+" :"+modalBodySaveNewRole.getText()+" ]", 
    			modalBodySaveNewRole.getText().contains(message));
    	
    	btnCloseModalNewRole.click();		
	}

	public void waitLoadTabFunctionality() {
		super.getWait().forElementToBeDisplayed( this.tabRole, "tabRole");
	}

	public void checkRoleTabValues() {
		super.getWait().forElementToBeDisplayed( this.labelTableFunctionality, "tabFunctionality");

	}

	public void clickFirstLink() {
		super.getWait().forElementToBeDisplayed( this.firstLinkOfTable, "firstLinkOfTable");
		this.firstLinkOfTable.click();
	}

	public WebElement getRoleMenu() {
		super.getWait().forElementToBeDisplayed( this.userMenu, "roleMenu");
		return roleMenu;
	}

	public void setRoleMenu(WebElement roleMenu) {
		this.roleMenu = roleMenu;
	}

	public WebElement getTabRole() {
		super.getWait().forElementToBeDisplayed( this.tabRole, "tabRole");
		return tabRole;
	}

	public void setTabRole(WebElement tabRole) {
		this.tabRole = tabRole;
	}


	public WebElement getFirstLinkOfTable() {
		super.getWait().forElementToBeDisplayed( this.firstLinkOfTable, "firstLinkOfTable");
		return firstLinkOfTable;
	}

	public void setFirstLinkOfTable(WebElement firstLinkOfTable) {
		this.firstLinkOfTable = firstLinkOfTable;
	}

	public WebElement getCreationForm() {
		super.getWait().forElementToBeDisplayed( this.creationForm, "creationForm");
		return creationForm;
	}

	public void setCreationForm(WebElement creationForm) {
		this.creationForm = creationForm;
	}

	public WebElement getFunctionalitiesDiv() {
		super.getWait().forElementToBeDisplayed( this.functionalitiesDiv, "functionalitiesDiv");
		return functionalitiesDiv;
	}

	
	public void setFunctionalitiesDiv(WebElement functionalitiesDiv) {
		this.functionalitiesDiv = functionalitiesDiv;
	}

	public List<WebElement> getListFunctionalitiesRadioButtons() {
		return listFunctionalitiesRadioButtons;
	}

	public void setListFunctionalitiesRadioButtons(List<WebElement> listFunctionalitiesRadioButtons) {
		this.listFunctionalitiesRadioButtons = listFunctionalitiesRadioButtons;
	}

	public WebElement getBtnSaveNewRole() {
		super.getWait().forElementToBeDisplayed( this.btnSaveNewRole, "btnSaveNewRole");
		return btnSaveNewRole;
	}

	public void setBtnSaveNewRole(WebElement btnSaveNewRole) {
		this.btnSaveNewRole = btnSaveNewRole;
	}

	public WebElement getBtnCloseNewRole() {
		super.getWait().forElementToBeDisplayed( this.btnCloseNewRole, "btnCloseNewRole");
		return btnCloseNewRole;
	}

	public void setBtnCloseNewRole(WebElement btnCloseNewRole) {
		this.btnCloseNewRole = btnCloseNewRole;
	}

	public WebElement getBtnCreateNewRole() {
		super.getWait().forElementToBeDisplayed( this.btnCreateNewRole, "btnCreateNewRole");
		return btnCreateNewRole;
	}

	public void setBtnCreateNewRole(WebElement btnCreateNewRole) {
		this.btnCreateNewRole = btnCreateNewRole;
	}

	public WebElement getInputDescriptionRole() {
		super.getWait().forElementToBeDisplayed( this.inputDescriptionRole, "inputDescriptionRole");
		return inputDescriptionRole;
	}

	public void setInputDescriptionRole(WebElement inputDescriptionRole) {
		this.inputDescriptionRole = inputDescriptionRole;
	}

	public WebElement getInputNameRole() {
		super.getWait().forElementToBeDisplayed( this.inputNameRole, "inputNameRole");
		return inputNameRole;
	}

	public void setInputNameRole(WebElement inputNameRole) {
		this.inputNameRole = inputNameRole;
	}

	public WebElement getTableRole() {
		return tableRole;
	}

	public void setTableRole(WebElement tableRole) {
		this.tableRole = tableRole;
	}

	public WebElement getTableFunctionalities() {
		super.getWait().forElementToBeDisplayed( this.tableFunctionalities, "tableFunctionalities");
		return tableFunctionalities;
	}

	public void setTableFunctionalities(WebElement tableFunctionalities) {
		this.tableFunctionalities = tableFunctionalities;
	}

	public WebElement getLabelTableFunctionality() {
		super.getWait().forElementToBeDisplayed( this.labelTableFunctionality, "labelTableFunctionality");
		return labelTableFunctionality;
	}

	public void setLabelTableFunctionality(WebElement labelTableFunctionality) {
		this.labelTableFunctionality = labelTableFunctionality;
	}


	public WebElement getModalRole() {
		super.getWait().forElementToBeDisplayed( this.modalRole, "modalRole");
		return modalRole;
	}


	public void setModalRole(WebElement modalRole) {
		this.modalRole = modalRole;
	}


	public WebElement getModalHeaderModalRole() {
		super.getWait().forElementToBeDisplayed( this.modalHeaderModalRole, "modalHeaderRole");
		return modalHeaderModalRole;
	}


	public void setModalHeaderModalRole(WebElement modalHeaderRole) {
		this.modalHeaderModalRole = modalHeaderRole;
	}


	public WebElement getModalBodyModalRole() {
		super.getWait().forElementToBeDisplayed( this.modalBodyModalRole, "modalBodyRole");
		return modalBodyModalRole;
	}


	public void setModalBodyModalRole(WebElement modalBodyRole) {
		this.modalBodyModalRole = modalBodyRole;
	}


	public WebElement getModalFooterModalRole() {
		super.getWait().forElementToBeDisplayed( this.modalFooterModalRole, "modalFooterModalRole");
		return modalFooterModalRole;
	}


	public void setModalFooterModalRole(WebElement modalFooterRole) {
		this.modalFooterModalRole = modalFooterRole;
	}


	public WebElement getBtnCloseModalRole() {
		super.getWait().forElementToBeDisplayed( this.btnCloseModalRole, "btnCloseRole");
		return btnCloseModalRole;
	}


	public void setBtnCloseModalRole(WebElement btnCloseRole) {
		this.btnCloseModalRole = btnCloseRole;
	}


	public WebElement getBtnCancelModalRole() {
		super.getWait().forElementToBeDisplayed( this.btnCancelModalRole, "btnCancelRole");
		return btnCancelModalRole;
	}


	public void setBtnCancelModalRole(WebElement btnCancelRole) {
		this.btnCancelModalRole = btnCancelRole;
	}


	public WebElement getBtnSaveModalRole() {
		super.getWait().forElementToBeDisplayed( this.btnSaveModalRole, "btnSaveModalRole");
		return btnSaveModalRole;
	}


	public void setBtnSaveModalRole(WebElement btnSaveRole) {
		this.btnSaveModalRole = btnSaveRole;
	}

	
//	public void unselectAllFunctionalities() {
//		List<String> selectedElements = this.getFunctionalitiesDiv().parallelStream().filter( elementToSearch -> {
//    		WebElement findElement = this.rolePage.getFunctionalitiesDiv().findElement(By.id(elementToSearch));
//    		if(findElement.isEnabled() && !findElement.isSelected()) {
//    			findElement.click();
//    			return true;
//    		}else
//    			return false;
//    	}).collect(Collectors.toList());
//	}

	public WebElement getSwitchStatusPopUp() {
		assertTrue("switchStatusPopUp doesn't able to be selected",this.switchStatusPopUp.isEnabled());
		return switchStatusPopUp;
	}


	public void setSwitchStatusPopUp(WebElement switchStatusPopUpEditFunctionality) {
		this.switchStatusPopUp = switchStatusPopUpEditFunctionality;
	}

	public WebElement getBtnEditRole() {
		super.getWait().forElementToBeDisplayed( this.btnEditRole, "btnEditRole");
		return btnEditRole;
	}

	public void setBtnEditRole(WebElement btnEditRole) {
		this.btnEditRole = btnEditRole;
	}

	public WebElement getEditForm() {
		super.getWait().forElementToBeDisplayed( this.editForm, "editForm");
		return editForm;
	}

	public void setEditForm(WebElement editForm) {
		this.editForm = editForm;
	}
	
}

package com.stefanini.automation.page.functionality;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stefanini.automation.page.BasePage;

public class FunctionalityPage extends BasePage {

	@FindBy(id = "functionality-menu")
	private WebElement functionalityMenu;

	@FindBy(xpath = "//div[contains(text(),'Funcionalidades dos portais')]")
	private WebElement tabFunctionality;//

	@FindBy(xpath = "//div[contains(text(),'Perfis associados')]")
	private WebElement tabRole;//

	@FindBy(xpath = "//table[@class='table-striped table']//tr[1]//td[1]//a")
	private WebElement firstLinkOfTable;//
	
	@FindBy(xpath = "//table[@class='table-striped table']")
	private WebElement functionalitiesTable;//
	
	@FindBy(xpath = "//button[@type='button'][contains(text(),'Nova funcionalidade')]")
	private WebElement btnCreateNewFunctionality;
	
	@FindBy(xpath = "//button[@type='button'][contains(text(),'Editar funcionalidade')]")
	private WebElement btnEditFunctionality;
	
	
//Modal New Functionality
	@FindBy(id = "newName")
	private WebElement inputNamePopUpNewFunctionality;
	
	@FindBy(id = "newDescription")
	private WebElement inputDescriptionPopUpNewFunctionality; 
	
	@FindBy(xpath = "//h5[@class='modal-title'][contains(text(),'Nova Funcionalidade')]")
	private WebElement popUpNewFunctionality;
	
	@FindBy(xpath = "//button[@type='submit'][contains(text(),'Cadastrar')]")
	private WebElement btnSaveNewFunctionality;
	
	@FindBy(xpath = "//button[@type='button'][contains(text(),'Cancelar')]")
	private WebElement btnClosePopUpNewFunctionality;
// ====== Modal New Functionality
	
	
	@FindBy(xpath = "//h5[@class='modal-title'][contains(text(),'Sucesso')]")
	private WebElement headerPopUpSuccessFunctionality;
	
	@FindBy(xpath = "//div[@class='modal-body'][contains(text(),'Funcionalidade cadastrado com sucesso.')]")
	private WebElement messagePopUpSuccessFunctionality;
	
	@FindBy(xpath = "//div[@class='modal-body']")
	private WebElement modalBody;
	
	@FindBy(xpath = "//button[@type='button'][contains(text(),'Fechar')]")
	private WebElement btnClosePopUpSuccessFunctionality;
	
	
//Modal Edit Functionality
	@FindBy(xpath = "//h5[@class='modal-title'][contains(text(),'Editar Funcionalidade')]")
	private WebElement popUpEditFunctionality;

	@FindBy(id = "editName")
	private WebElement inputNamePopUpEditFunctionality;
	
	@FindBy(id = "description")
	private WebElement inputDescriptionPopUpEditFunctionality; 
	
	@FindBy(id = "status")
	private WebElement switchStatusPopUpEditFunctionality; 
	private static final String STRING_SPAN_STATUS = "//span[@class='switch-slider']";
	
	@FindBy(xpath = "//button[@type='button'][text()='Salvar']")
	private WebElement btnSaveEditedFunctionality;
	
	@FindBy(xpath = "//button[@type='button'][text()='Cancelar']")
	private WebElement btnClosePopUpEditFunctionality;
	
	private boolean editedStatus;
// ====== Modal Edit Functionality
	
	
	public FunctionalityPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public WebElement getFunctionalityMenu() {
		super.getWait().forElementToBeDisplayed( this.functionalityMenu, "functionalityMenu");
		return functionalityMenu;
	}
	
	public void clickOnNewFunctionalityButton() {
		super.getWait().forElementToBeDisplayed( this.btnCreateNewFunctionality, "btnCreateNewFunctionality");
		this.btnCreateNewFunctionality.click();
	}
	
	public WebElement getBtnCreateNewFunctionality() {
		super.getWait().forElementToBeDisplayed( this.btnCreateNewFunctionality, "btnCreateNewFunctionality");
		return this.btnCreateNewFunctionality;
	}
	
	
	
	public WebElement getBtnSaveNewFunctionality() {
		super.getWait().forElementToBeDisplayed( this.btnSaveNewFunctionality, "btnSaveNewFunctionality");
		return this.btnSaveNewFunctionality;
	}
//	
//	public void clickOnCreateNewFunctionalityButton() {
//		super.getWait().forElementToBeDisplayed( this.btnSaveNewFunctionality, "btnSaveNewFunctionality");
//		this.btnSaveNewFunctionality.click();
//	}

	public void clickOnEditFunctionalityButton() {
		super.getWait().forElementToBeDisplayed( this.btnEditFunctionality, "btnEditFunctionality");
		this.btnEditFunctionality.click();
	}
	
	public void checkPopUpNewFunctionality() {
		super.getWait().forElementToBeDisplayed( this.inputDescriptionPopUpNewFunctionality, "inputDescriptionPopUpNewFunctionality");
		super.getWait().forElementToBeDisplayed( this.inputNamePopUpNewFunctionality, "inputNamePopUpNewFunctionality");
		super.getWait().forElementToBeDisplayed( this.popUpNewFunctionality, "popUpNewFunctionality");
		super.getWait().forElementToBeDisplayed( this.btnSaveNewFunctionality, "btnSaveNewFunctionality");
		super.getWait().forElementToBeDisplayed( this.btnClosePopUpNewFunctionality, "btnClosePopUpNewFunctionality");
	}

	public void checkPopUpEditFunctionality() {
		super.getWait().forElementToBeDisplayed( this.popUpEditFunctionality, "HEADER -> popUpEditFunctionality");
		super.getWait().forElementToBeDisplayed( this.inputDescriptionPopUpEditFunctionality, "inputDescriptionPopUpEditFunctionality");
		super.getWait().forElementToBeDisplayed( this.inputNamePopUpEditFunctionality, "inputNamePopUpEditFunctionality");
		assertTrue("switchStatusPopUpEditFunctionality doesn't able to be selected",this.switchStatusPopUpEditFunctionality.isEnabled());
		super.getWait().forElementToBeDisplayed( this.btnEditFunctionality, "btnEditFunctionality");
		super.getWait().forElementToBeDisplayed( this.btnClosePopUpEditFunctionality, "btnClosePopUpEditFunctionality");
	}

	public void waitLoadTabFunctionality() {
		super.getWait().forElementToBeDisplayed( this.tabFunctionality, "tabFunctionality");
	}

	public WebElement getTabRole() {
		super.getWait().forElementToBeDisplayed( this.tabRole, "tabRole");
		return tabRole;
	}
	
	public WebElement getBtnClosePopUpSuccessFunctionality() {
		super.getWait().forElementToBeDisplayed( this.btnClosePopUpSuccessFunctionality, "btnClosePopUpSuccessFunctionality");
		return this.btnClosePopUpSuccessFunctionality;
	}
	
	public WebElement getStatusFromFunctionalitiesTableOfElement(String elementToFind) {
		super.getWait().forElementToBeDisplayed( this.functionalitiesTable, "functionalitiesTable");
		WebElement elementFound = this.functionalitiesTable.findElement(By.xpath(".//a[text()='"+elementToFind+"']/.."));
		if(elementFound.isDisplayed()) {
			WebElement elementStatusFound = elementFound.findElement(By.xpath(".//following-sibling::td/span"));
			super.getWait().forElementToBeDisplayed( elementStatusFound, "Status from selected element of Functionalities Table");
			return elementStatusFound;
		}
		return null;
	}
	
	
	public WebElement getFunctionalityFromTable(String functionality) {
		super.getWait().forElementToBeDisplayed( this.functionalitiesTable, "functionalitiesTable");
		
		if(functionality == null) {
			functionality = super.getProperty("functionality.name");
		}
		
		super.getWait().forPresenceOfElements(5, By.xpath(".//a[text()='"+functionality+"']"), "functionalitiesTable -> text["+functionality+"]");
		
		WebElement elementFound = this.functionalitiesTable.findElement(By.xpath(".//a[text()='"+functionality+"']"));
		super.getWait().forElementToBeDisplayed( elementFound, "functionalitiesTable > elementToSearch ->'"+functionality+"'");
		
		if(elementFound.isDisplayed()) {
			return elementFound;
		}else {
			assertNull("Functionality not found", null);
			return null;
		}
	}
	
	public WebElement getFirstLinkOfTable() {
		super.getWait().forElementToBeDisplayed( this.firstLinkOfTable, "firstLinkOfTable");
		return this.firstLinkOfTable;
	}
	
	
	public WebElement getInputNamePopUpNewFunctionality() {
		super.getWait().forElementToBeDisplayed( this.inputNamePopUpNewFunctionality, "inputNamePopUpNewFunctionality");
		return this.inputNamePopUpNewFunctionality;
    }
	
	public WebElement getInputDescriptionPopUpNewFunctionality() {
		super.getWait().forElementToBeDisplayed( this.inputDescriptionPopUpNewFunctionality, "inputDescriptionPopUpNewFunctionality");
    	return this.inputDescriptionPopUpNewFunctionality;
    }
	
	public void inputDescriptionPopUpEditFunctionality() {
		super.getWait().forElementToBeDisplayed( this.inputDescriptionPopUpEditFunctionality, "inputDescriptionPopUpEditFunctionality");
    	String description = super.getProperty("functionality.edit.description");
    	this.inputDescriptionPopUpEditFunctionality.clear();
    	this.inputDescriptionPopUpEditFunctionality.sendKeys(description);
    }
	
	
	public void changeStatusPopUpEditFunctionality() {
		assertTrue("switchStatusPopUpEditFunctionality doesn't able to be selected",this.switchStatusPopUpEditFunctionality.isEnabled());
		//this.clickOnSwitchStatusOnEditPopUp();
    	String statusClicked = this.switchStatusPopUpEditFunctionality.getAttribute("aria-checked");
    	if(statusClicked != null && (statusClicked.toLowerCase().contains("true") || statusClicked.toLowerCase().contains("false"))) {
    		this.editedStatus = new Boolean(statusClicked);
    	}else {
    		assertNotNull(statusClicked);
    	}
    }
	
	
	
	public WebElement getSwitchStatusPopUpEditFunctionalitySpan() {
		return this.switchStatusPopUpEditFunctionality.findElement(By.xpath(STRING_SPAN_STATUS));
	}
	
	
	public boolean isEditedStatus() {
		return editedStatus;
	}

	public void setEditedStatus(boolean editedStatus) {
		this.editedStatus = editedStatus;
	}

	public WebElement getTabFunctionality() {
		super.getWait().forElementToBeDisplayed( this.tabFunctionality, "tabFunctionality");
		return tabFunctionality;
	}

	public void setTabFunctionality(WebElement tabFunctionality) {
		this.tabFunctionality = tabFunctionality;
	}

	public WebElement getFunctionalitiesTable() {
		super.getWait().forElementToBeDisplayed( this.functionalitiesTable, "functionalitiesTable");
		return functionalitiesTable;
	}

	public void setFunctionalitiesTable(WebElement functionalitiesTable) {
		this.functionalitiesTable = functionalitiesTable;
	}

	public WebElement getBtnEditFunctionality() {
    	super.getWait().forElementToBeDisplayed( this.btnEditFunctionality, "btnEditFunctionality");
		return btnEditFunctionality;
	}

	public void setBtnEditFunctionality(WebElement btnEditFunctionality) {
		this.btnEditFunctionality = btnEditFunctionality;
	}

	public WebElement getPopUpNewFunctionality() {
		super.getWait().forElementToBeDisplayed( this.popUpNewFunctionality, "popUpNewFunctionality");
		return popUpNewFunctionality;
	}

	public void setPopUpNewFunctionality(WebElement popUpNewFunctionality) {
		this.popUpNewFunctionality = popUpNewFunctionality;
	}

	public WebElement getBtnClosePopUpNewFunctionality() {
		super.getWait().forElementToBeDisplayed( this.btnClosePopUpNewFunctionality, "btnClosePopUpNewFunctionality");
		return btnClosePopUpNewFunctionality;
	}

	public void setBtnClosePopUpNewFunctionality(WebElement btnClosePopUpNewFunctionality) {
		this.btnClosePopUpNewFunctionality = btnClosePopUpNewFunctionality;
	}

	public WebElement getHeaderPopUpSuccessFunctionality() {
		super.getWait().forElementToBeDisplayed( this.headerPopUpSuccessFunctionality, "headerPopUpSuccessFunctionality");
		return headerPopUpSuccessFunctionality;
	}

	public void setHeaderPopUpSuccessFunctionality(WebElement headerPopUpSuccessFunctionality) {
		this.headerPopUpSuccessFunctionality = headerPopUpSuccessFunctionality;
	}

	public WebElement getMessagePopUpSuccessFunctionality() {
		super.getWait().forElementToBeDisplayed( this.messagePopUpSuccessFunctionality, "messagePopUpSuccessFunctionality");
		return messagePopUpSuccessFunctionality;
	}

	public void setMessagePopUpSuccessFunctionality(WebElement messagePopUpSuccessFunctionality) {
		this.messagePopUpSuccessFunctionality = messagePopUpSuccessFunctionality;
	}

	public WebElement getPopUpEditFunctionality() {
		super.getWait().forElementToBeDisplayed( this.popUpEditFunctionality, "popUpEditFunctionality");
		return popUpEditFunctionality;
	}

	public void setPopUpEditFunctionality(WebElement popUpEditFunctionality) {
		this.popUpEditFunctionality = popUpEditFunctionality;
	}

	public WebElement getInputNamePopUpEditFunctionality() {
		super.getWait().forElementToBeDisplayed( this.inputNamePopUpEditFunctionality, "inputNamePopUpEditFunctionality");
		return inputNamePopUpEditFunctionality;
	}

	public void setInputNamePopUpEditFunctionality(WebElement inputNamePopUpEditFunctionality) {
		this.inputNamePopUpEditFunctionality = inputNamePopUpEditFunctionality;
	}

	public WebElement getInputDescriptionPopUpEditFunctionality() {
		super.getWait().forElementToBeDisplayed( this.inputDescriptionPopUpEditFunctionality, "inputDescriptionPopUpEditFunctionality");
		return inputDescriptionPopUpEditFunctionality;
	}

	public void setInputDescriptionPopUpEditFunctionality(WebElement inputDescriptionPopUpEditFunctionality) {
		this.inputDescriptionPopUpEditFunctionality = inputDescriptionPopUpEditFunctionality;
	}

	public WebElement getSwitchStatusPopUpEditFunctionality() {
		assertTrue("switchStatusPopUpEditFunctionality doesn't able to be selected",this.switchStatusPopUpEditFunctionality.isEnabled());
		//super.getWait().forElementToBeDisplayed( this.switchStatusPopUpEditFunctionality, "switchStatusPopUpEditFunctionality");
		return switchStatusPopUpEditFunctionality;
	}

	public void setSwitchStatusPopUpEditFunctionality(WebElement switchStatusPopUpEditFunctionality) {
		this.switchStatusPopUpEditFunctionality = switchStatusPopUpEditFunctionality;
	}

	public WebElement getBtnSaveEditedFunctionality() {
		super.getWait().forElementToBeDisplayed( this.btnSaveEditedFunctionality, "btnSaveEditedFunctionality");
		return btnSaveEditedFunctionality;
	}

	public void setBtnSaveEditedFunctionality(WebElement btnSaveEditedFunctionality) {
		this.btnSaveEditedFunctionality = btnSaveEditedFunctionality;
	}

	public WebElement getBtnClosePopUpEditFunctionality() {
		super.getWait().forElementToBeDisplayed( this.btnClosePopUpEditFunctionality, "btnClosePopUpEditFunctionality");
		return btnClosePopUpEditFunctionality;
	}

	public void setBtnClosePopUpEditFunctionality(WebElement btnClosePopUpEditFunctionality) {
		this.btnClosePopUpEditFunctionality = btnClosePopUpEditFunctionality;
	}

	public static String getStringSpanStatus() {
		return STRING_SPAN_STATUS;
	}

	public void setFunctionalityMenu(WebElement functionalityMenu) {
		this.functionalityMenu = functionalityMenu;
	}

	public void setTabRole(WebElement tabRole) {
		this.tabRole = tabRole;
	}

	public void setFirstLinkOfTable(WebElement firstLinkOfTable) {
		this.firstLinkOfTable = firstLinkOfTable;
	}

	public void setBtnCreateNewFunctionality(WebElement btnCreateNewFunctionality) {
		super.getWait().forElementToBeDisplayed( this.btnCreateNewFunctionality, "btnCreateNewFunctionality");
		this.btnCreateNewFunctionality = btnCreateNewFunctionality;
	}

	public void setInputNamePopUpNewFunctionality(WebElement inputNamePopUpNewFunctionality) {
		this.inputNamePopUpNewFunctionality = inputNamePopUpNewFunctionality;
	}

	public void setInputDescriptionPopUpNewFunctionality(WebElement inputDescriptionPopUpNewFunctionality) {
		this.inputDescriptionPopUpNewFunctionality = inputDescriptionPopUpNewFunctionality;
	}

	public void setBtnSaveNewFunctionality(WebElement btnSaveNewFunctionality) {
		this.btnSaveNewFunctionality = btnSaveNewFunctionality;
	}

	public void setBtnClosePopUpSuccessFunctionality(WebElement btnClosePopUpSuccessFunctionality) {
		this.btnClosePopUpSuccessFunctionality = btnClosePopUpSuccessFunctionality;
	}

	public WebElement getModalBody() {
		super.getWait().forElementToBeDisplayed( this.modalBody, "modalBody");
		return modalBody;
	}

	public void setModalBody(WebElement modalBody) {
		this.modalBody = modalBody;
	}
	
	public WebElement getFunctionalitiesTableOnWait(String name) {
		getWait().forPresenceOfElements(10, By.xpath("//div[contains(text(),'Funcionalidades dos portais')]//following-sibling::*/child::*//tr//a[contains(text(), '"+name+"')]"), "Functionalities table");
		return getDriver().findElement(By.xpath("//div[contains(text(),'Funcionalidades dos portais')]//following-sibling::*/child::*//tr//a[contains(text(), '"+name+"')]"));
	}

}

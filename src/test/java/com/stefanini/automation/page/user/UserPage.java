package com.stefanini.automation.page.user;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.base.Strings;
import com.stefanini.automation.page.BasePage;
import com.stefanini.automation.utils.Formatter;

public class UserPage extends BasePage {
	
	public static String XPATH_TABLE_CORRELATION_TR = "//div[@class='card-header']//strong[contains(text(), 'Correlações')]//following::*/child::*/table/tbody//tr";
	public static String XPATH_TABLE_CORRELATION_LOADING = "//div[@class='card-header']//strong[contains(text(), 'Correlações')]//following::*/child::*/table/tbody//*[contains(text(), '%s')]";
	public static String XPATH_TABLE_CORRELATION_EXCLUSION_I = "//div[@class='card-header']//strong[contains(text(), 'Correlações')]//following::*/child::*/table/tbody//tr//td[5]//i";


	@FindBy(id = "user-menu")
	private WebElement userMenu;

	@FindBy(xpath = "//div[@class='card-header']//*[contains(text(),'Usuários')]")
	private WebElement headerUsers;

	@FindBy(id = "cpfSearch")
	private WebElement radioCpfSearch;

	@FindBy(id = "searchCpf")
	private WebElement inputCpfSearch;

	@FindBy(id = "emailSearch")
	private WebElement radioEmailSearch;

	@FindBy(id = "searchEmail")
	private WebElement inputEmailSearch;

	@FindBy(id = "nameSearch")
	private WebElement radioNameSearch;

	@FindBy(id = "searchName")
	private WebElement inputNameSearch;

	@FindBy(id = "search-button")
	private WebElement btnSearch;

	@FindBy(id = "user-create-button")
	private WebElement btnCreateUser;

	@FindBy(xpath = "//div[@class='card-header' and contains(text(),'Cadastro')]")
	private WebElement headerRegister;

	@FindBy(xpath = "//div[contains(text(),'Cadastro')]//following-sibling::*/child::*/table")
	private WebElement tableRegister;

	@FindBy(xpath = "//div[contains(text(),'Cadastro')]//following-sibling::*/child::*/table/tbody")
	private WebElement tableBodyRegister;
	
	@FindBy(xpath = "//div[contains(text(),'Cadastro')]//following-sibling::*/child::*/table/tbody//tr")
	private List<WebElement> tableBodyRegisterElements;
	
	@FindBy(id = "newUserFullName")
	private WebElement inputNewFullName;
	
	@FindBy(id = "newUserFirstName")
	private WebElement inputNewFirstName;
	
	@FindBy(id = "newUserLastName")
	private WebElement inputNewLastName;
	
	@FindBy(id = "newUserCpf")
	private WebElement inputNewCpf;
	
	@FindBy(id = "newUserEmail")
	private WebElement inputNewEmail;
	
	@FindBy(xpath = "//div[@class='modal-content']")
	private WebElement modal;
	
	@FindBy(xpath = "//h5[@class='modal-title']")
	private WebElement modalTitle;
	
	@FindBy(xpath = "//div[@class='modal-header']")
	private WebElement modalHeader;
	
	@FindBy(xpath = "//div[@class='modal-body']")
	private WebElement modalBody;
	
	@FindBy(xpath = "//div[@class='modal-footer']")
	private WebElement modalFooter;
	
	@FindBy(xpath = "//div[@class='modal-footer']//button[contains(text(), 'Configurar acessos')]")
	private WebElement btnConfigAccessModalOnSuccess;
	
	@FindBy(xpath = "//div[@class='modal-footer']//button[contains(text(), 'Fechar')]")
	private WebElement btnCloseModalOnSuccess;
	
	@FindBy(xpath = "//div[@class='modal-footer']//button[@type='button'][contains(text(),'Cancelar')]")
	private WebElement btnCancelModal;
	
	@FindBy(xpath = "//div[@class='modal-footer']//button[@type='submit'][contains(text(),'Cadastrar')]")
	private WebElement btnRegisterModal;
	
	@FindBy(id = "fullname")
	private WebElement inputFullnameEditUser;
	
	@FindBy(id = "firstname")
	private WebElement inputFirstnameEditUser;
	
	@FindBy(id = "lastname")
	private WebElement inputLastnameEditUser;
	
	@FindBy(id = "email")
	private WebElement inputEmailEditUser;
	
	@FindBy(id = "cpf")
	private WebElement inputCpfEditUser;
	
	@FindBy(xpath = "//div[@class='card-header']//strong")
	private WebElement cardHeaderStrong;
	
	@FindBy(id = "status")
	private WebElement switchStatusEditUser; 
	
	@FindBy(xpath = "//span[@class='switch-slider']")
	private WebElement switchSliderStatusEditUser; 
	
	@FindBy(xpath = "//div[@class='card-footer']//button[@type='button'][contains(text(),'Editar')]")
	private WebElement btnEditUser;
	
	@FindBy(id = "editUserFullName")
	private WebElement inputEditFullName;
	
	@FindBy(id = "editUserFirstName")
	private WebElement inputEditFirstName;
	
	@FindBy(id = "editUserLastName")
	private WebElement inputEditLastName;
	
	@FindBy(id = "editUserCpf")
	private WebElement inputEditCpf;
	
	@FindBy(id = "editUserEmail")
	private WebElement inputEditEmail;
	
	@FindBy(id = "editUserStatus")
	private WebElement switchStatusEditUserPopUp;
	
	@FindBy(xpath = "//div[@class='modal-footer']//button[@type='submit'][contains(text(),'Salvar')]")
	private WebElement btnSaveEditeduser;
	
	@FindBy(id = "customerToCorrelate")
	private WebElement customerToCorrelate;
	
	@FindBy(id = "filter")
	private WebElement filterCorrelation;
	
	@FindBy(id = "accountToCorrelate")
	private WebElement accountToCorrelate;
	
	@FindBy(id = "accountTypeToCorrelate")
	private WebElement accountTypeToCorrelate;
	
	@FindBy(id = "roles-switches")
	private WebElement rolesSwitches;
	
	@FindBy(xpath = "//div[@id='roles-switches']//span[1]/div")
	private WebElement rolesSwitchesSpan1Div;
	
	@FindBy(id = "customerSelectButton")
	private WebElement btnSelectClient;
	
	//select[@id='filter']//optgroup[@label='Por grupo econômico']
	@FindBy(xpath = "//select[@id='filter']//optgroup[@label='Por grupo econômico']//option[1]")
	private WebElement optionEconomicGroupOne;
	
	@FindBy(xpath = "//div[@class='modal-body']//following::*/child::*/table/tbody//tr[1]//td[1]//input")
	private WebElement tableClientFirstInput;
	
	@FindBy(id = "selectedAccount")
	private WebElement optionSelectedAccount;
	
	@FindBy(xpath = "//select[@id='selectedAccount']//option[2]")
	private WebElement optionSelectedAccountFirst;
	
	@FindBy(xpath = "//button[contains(text(),'Selecionar conta')]")
	private WebElement btnSelectAccount;
	
	@FindBy(xpath = "//button[contains(text(),'Cancelar')]")
	private WebElement btnCancelEditCorrelation;
	
	@FindBy(id = "correlationButton")
	private WebElement btnEffectiveCorrelation;
	
	//div[@class='card-header']//strong[contains(text(), 'Correlações')]
	
	
	public UserPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String getStatusFromSwitch(WebElement switchWebDrive) {
    	String statusClicked = switchWebDrive.getAttribute("aria-checked");
    	if(statusClicked != null && 
    			(statusClicked.toLowerCase().contains("true") || statusClicked.toLowerCase().contains("false"))) {
    		return statusClicked;
    	}else {
    		assertNotNull(statusClicked);
    	}
    	return null;
    }
	

	public WebElement getTableRegister() {
		super.getWait().forElementToBeDisplayed( this.tableRegister, "tableRegister");
		return tableRegister;
	}

	public void setTableRegister(WebElement tableRegister) {
		this.tableRegister = tableRegister;
	}

	public WebElement getTableBodyRegister() {
		super.getWait().forElementToBeDisplayed( this.tableBodyRegister, "tableBodyRegister");
		return tableBodyRegister;
	}

	public void setTableBodyRegister(WebElement tableBodyRegister) {
		this.tableBodyRegister = tableBodyRegister;
	}

	public WebElement getUserMenu() {
		super.getWait().forElementToBeDisplayed( this.userMenu, "userMenu");
		return userMenu;
	}

	public void setUserMenu(WebElement userMenu) {
		this.userMenu = userMenu;
	}

	public WebElement getHeaderUsers() {
		super.getWait().forElementToBeDisplayed( this.headerUsers, "headerUsers");
		return headerUsers;
	}

	public void setHeaderUsers(WebElement headerUsers) {
		this.headerUsers = headerUsers;
	}

	public WebElement getRadioCpfSearch() {
		super.getWait().forPresenceOfElements(5, By.id("cpfSearch"), "cpfSearch");
		return radioCpfSearch;
	}

	public void setRadioCpfSearch(WebElement radioCpfSearch) {
		this.radioCpfSearch = radioCpfSearch;
	}

	public WebElement getInputCpfSearch() {
		super.getWait().forElementToBeDisplayed( this.inputCpfSearch, "inputCpfSearch");
		return inputCpfSearch;
	}

	public void setInputCpfSearch(WebElement inputCpfSearch) {
		this.inputCpfSearch = inputCpfSearch;
	}

	public WebElement getRadioEmailSearch() {
		super.getWait().forElementToBeDisplayed( this.radioEmailSearch, "radioEmailSearch");
		return radioEmailSearch;
	}

	public void setRadioEmailSearch(WebElement radioEmailSearch) {
		this.radioEmailSearch = radioEmailSearch;
	}

	public WebElement getInputEmailSearch() {
		super.getWait().forElementToBeDisplayed( this.inputEmailSearch, "inputEmailSearch");
		return inputEmailSearch;
	}

	public void setInputEmailSearch(WebElement inputEmailSearch) {
		this.inputEmailSearch = inputEmailSearch;
	}

	public WebElement getRadioNameSearch() {
		super.getWait().forElementToBeDisplayed( this.radioNameSearch, "radioNameSearch");
		return radioNameSearch;
	}

	public void setRadioNameSearch(WebElement radioNameSearch) {
		this.radioNameSearch = radioNameSearch;
	}

	public WebElement getInputNameSearch() {
		super.getWait().forElementToBeDisplayed( this.inputNameSearch, "inputNameSearch");
		return inputNameSearch;
	}

	public void setInputNameSearch(WebElement inputNameSearch) {
		this.inputNameSearch = inputNameSearch;
	}

	public WebElement getBtnSearch() {
		super.getWait().forElementToBeDisplayed( this.btnSearch, "btnSearch");
		return btnSearch;
	}

	public void setBtnSearch(WebElement buttonSearch) {
		this.btnSearch = buttonSearch;
	}

	public WebElement getBtnCreateUser() {
		super.getWait().forElementToBeDisplayed( this.btnCreateUser, "btnCreateUser");
		return btnCreateUser;
	}

	public void setBtnCreateUser(WebElement buttonCreateUser) {
		this.btnCreateUser = buttonCreateUser;
	}

	public WebElement getHeaderRegister() {
		super.getWait().forElementToBeDisplayed( this.headerRegister, "headerRegister");
		return headerRegister;
	}

	public void setHeaderRegister(WebElement headerRegister) {
		this.headerRegister = headerRegister;
	}

	public WebElement getInputNewFullName() {
		super.getWait().forElementToBeDisplayed( this.inputNewFullName, "inputNewFullName");
		return inputNewFullName;
	}

	public void setInputNewFullName(WebElement inputNewFullName) {
		this.inputNewFullName = inputNewFullName;
	}

	public WebElement getInputNewFirstName() {
		super.getWait().forElementToBeDisplayed( this.inputNewFirstName, "inputNewFirstName");
		return inputNewFirstName;
	}

	public void setInputNewFirstName(WebElement inputNewFirstName) {
		this.inputNewFirstName = inputNewFirstName;
	}

	public WebElement getInputNewLastName() {
		super.getWait().forElementToBeDisplayed( this.inputNewLastName, "inputNewLastName");
		return inputNewLastName;
	}

	public void setInputNewLastName(WebElement inputNewLastName) {
		this.inputNewLastName = inputNewLastName;
	}

	public WebElement getInputNewCpf() {
		super.getWait().forElementToBeDisplayed( this.inputNewCpf, "inputNewCpf");
		return inputNewCpf;
	}

	public void setInputNewCpf(WebElement inputNewCpf) {
		this.inputNewCpf = inputNewCpf;
	}

	public WebElement getInputNewEmail() {
		super.getWait().forElementToBeDisplayed( this.inputNewEmail, "inputNewEmail");
		return inputNewEmail;
	}

	public void setInputNewEmail(WebElement inputNewEmail) {
		this.inputNewEmail = inputNewEmail;
	}

	public WebElement getModal() {
		super.getWait().forElementToBeDisplayed( this.modal, "modal");
		return modal;
	}

	public void setModal(WebElement modal) {
		this.modal = modal;
	}

	public WebElement getModalTitle() {
		super.getWait().forElementToBeDisplayed( this.modalTitle, "modalTitle");
		return modalTitle;
	}

	public void setModalTitle(WebElement modalTitle) {
		this.modalTitle = modalTitle;
	}

	public WebElement getModalHeader() {
		super.getWait().forElementToBeDisplayed( this.modalHeader, "modalHeader");
		return modalHeader;
	}

	public void setModalHeader(WebElement modalHeader) {
		this.modalHeader = modalHeader;
	}

	public WebElement getModalBody() {
		super.getWait().forElementToBeDisplayed( this.modalBody, "modalBody");
		return modalBody;
	}

	public void setModalBody(WebElement modalBody) {
		this.modalBody = modalBody;
	}

	public WebElement getModalFooter() {
		super.getWait().forElementToBeDisplayed( this.modalFooter, "modalFooter");
		return modalFooter;
	}

	public void setModalFooter(WebElement modalFooter) {
		this.modalFooter = modalFooter;
	}

	public WebElement getBtnCancelModal() {
		super.getWait().forElementToBeDisplayed( this.btnCancelModal, "btnCancelModal");
		return btnCancelModal;
	}

	public void setBtnCancelModal(WebElement btnCancelModal) {
		this.btnCancelModal = btnCancelModal;
	}

	public WebElement getBtnRegisterModal() {
		super.getWait().forElementToBeDisplayed( this.btnRegisterModal, "btnRegisterModal");
		return btnRegisterModal;
	}

	public void setBtnRegisterModal(WebElement btnRegisterModal) {
		this.btnRegisterModal = btnRegisterModal;
	}


	public WebElement getBtnConfigAccessModalOnSuccess() {
		super.getWait().forElementToBeDisplayed( this.btnConfigAccessModalOnSuccess, "btnConfigAccessModalOnSuccess");
		return btnConfigAccessModalOnSuccess;
	}


	public void setBtnConfigAccessModalOnSuccess(WebElement btnConfigAccessModalOnSuccess) {
		this.btnConfigAccessModalOnSuccess = btnConfigAccessModalOnSuccess;
	}


	public WebElement getBtnCloseModalOnSuccess() {
		super.getWait().forElementToBeDisplayed( this.btnCloseModalOnSuccess, "btnCloseModalOnSuccess");
		return btnCloseModalOnSuccess;
	}


	public void setBtnCloseModalOnSuccess(WebElement btnCloseModalOnSuccess) {
		this.btnCloseModalOnSuccess = btnCloseModalOnSuccess;
	}


	public WebElement getInputFullnameEditUser() {
		super.getWait().forElementToBeDisplayed( this.inputFullnameEditUser, "inputFullnameEditUser");
		return inputFullnameEditUser;
	}


	public void setInputFullnameEditUser(WebElement inputFullnameEditUser) {
		this.inputFullnameEditUser = inputFullnameEditUser;
	}


	public WebElement getInputFirstnameEditUser() {
		super.getWait().forElementToBeDisplayed( this.inputFirstnameEditUser, "inputFirstnameEditUser");
		return inputFirstnameEditUser;
	}


	public void setInputFirstnameEditUser(WebElement inputFirstnameEditUser) {
		this.inputFirstnameEditUser = inputFirstnameEditUser;
	}


	public WebElement getInputLastnameEditUser() {
		super.getWait().forElementToBeDisplayed( this.inputLastnameEditUser, "inputLastnameEditUser");
		return inputLastnameEditUser;
	}


	public void setInputLastnameEditUser(WebElement inputLastnameEditUser) {
		this.inputLastnameEditUser = inputLastnameEditUser;
	}


	public WebElement getInputEmailEditUser() {
		super.getWait().forElementToBeDisplayed( this.inputEmailEditUser, "inputEmailEditUser");
		return inputEmailEditUser;
	}


	public void setInputEmailEditUser(WebElement inputEmailEditUser) {
		this.inputEmailEditUser = inputEmailEditUser;
	}


	public WebElement getInputCpfEditUser() {
		super.getWait().forElementToBeDisplayed( this.inputCpfEditUser, "inputCpfEditUser");
		return inputCpfEditUser;
	}


	public void setInputCpfEditUser(WebElement inputCpfEditUser) {
		this.inputCpfEditUser = inputCpfEditUser;
	}


	public WebElement getCardHeaderStrong() {
		super.getWait().forElementToBeDisplayed( this.cardHeaderStrong, "cardHeaderStrong");
		return cardHeaderStrong;
	}


	public void setCardHeaderStrong(WebElement cardHeaderStrongEditUser) {
		this.cardHeaderStrong = cardHeaderStrongEditUser;
	}


	public WebElement getSwitchStatusEditUser() {
		return switchStatusEditUser;
	}


	public void setSwitchStatusEditUser(WebElement switchStatusEditUser) {
		this.switchStatusEditUser = switchStatusEditUser;
	}


	public WebElement getSwitchSliderStatusEditUser() {
		super.getWait().forElementToBeDisplayed( this.switchSliderStatusEditUser, "switchSliderStatusEditUser");
		return switchSliderStatusEditUser;
	}


	public void setSwitchSliderStatusEditUser(WebElement switchSliderStatusEditUser) {
		this.switchSliderStatusEditUser = switchSliderStatusEditUser;
	}


	public WebElement getBtnEditUser() {
		super.getWait().forElementToBeDisplayed( this.btnEditUser, "btnEditUser");
		return btnEditUser;
	}


	public void setBtnEditUser(WebElement btnEditUser) {
		this.btnEditUser = btnEditUser;
	}


	public WebElement getInputEditFullName() {
		super.getWait().forElementToBeDisplayed( this.inputEditFullName, "inputEditFullName");
		return inputEditFullName;
	}


	public void setInputEditFullName(WebElement inputEditFullName) {
		this.inputEditFullName = inputEditFullName;
	}


	public WebElement getInputEditFirstName() {
		super.getWait().forElementToBeDisplayed( this.inputEditFirstName, "inputEditFirstName");
		return inputEditFirstName;
	}


	public void setInputEditFirstName(WebElement inputEditFirstName) {
		this.inputEditFirstName = inputEditFirstName;
	}


	public WebElement getInputEditLastName() {
		super.getWait().forElementToBeDisplayed( this.inputEditLastName, "inputEditLastName");
		return inputEditLastName;
	}


	public void setInputEditLastName(WebElement inputEditLastName) {
		this.inputEditLastName = inputEditLastName;
	}


	public WebElement getInputEditCpf() {
		super.getWait().forElementToBeDisplayed( this.inputEditCpf, "inputEditCpf");
		return inputEditCpf;
	}


	public void setInputEditCpf(WebElement inputEditCpf) {
		this.inputEditCpf = inputEditCpf;
	}


	public WebElement getInputEditEmail() {
		super.getWait().forElementToBeDisplayed( this.inputEditEmail, "inputEditEmail");
		return inputEditEmail;
	}


	public void setInputEditEmail(WebElement inputEditEmail) {
		this.inputEditEmail = inputEditEmail;
	}


	public WebElement getSwitchStatusEditUserPopUp() {
		return switchStatusEditUserPopUp;
	}


	public void setSwitchStatusEditUserPopUp(WebElement switchStatusEditUserPopUp) {
		this.switchStatusEditUserPopUp = switchStatusEditUserPopUp;
	}


	public WebElement getBtnSaveEditedUser() {
		super.getWait().forElementToBeDisplayed( this.btnSaveEditeduser, "btnSaveEditeduser");
		return btnSaveEditeduser;
	}


	public void setBtnSaveEditeduser(WebElement btnSaveEditeduser) {
		this.btnSaveEditeduser = btnSaveEditeduser;
	}


	public List<WebElement> getTableBodyRegisterElements() {
		List<WebElement> findElement = super.getDriver().findElements(By.xpath("//div[contains(text(),'Cadastro')]//following-sibling::*/child::*/table/tbody//tr"));
		
		super.getDriver().findElements(By.xpath("//tbody"));
		super.getWait().getWebDriverWait()
			.until(ExpectedConditions.visibilityOfAllElements(findElement));
		 return findElement;
	}


	public void setTableBodyRegisterElements(List<WebElement> tableBodyRegisterElements) {
		this.tableBodyRegisterElements = tableBodyRegisterElements;
	}
	
	public WebElement getUserFromRegisterTableByCpf(String cpf) {
 		this.getWait().forPresenceOfElements(5, By.xpath("//div[contains(text(),'Cadastro')]//following-sibling::*/child::*/table/tbody//td[2]"), "Table's itens");
 		return this.getDriver()
 		 		.findElement(By.xpath("//div[contains(text(),'Cadastro')]//following-sibling::*/child::*/table/tbody//td[2][contains(text(), '"+Formatter.cpfFormatter(cpf)+"')]//preceding-sibling::*//a"));
 	}
	
	public WebElement getUserFromRegisterTableByCpfToDeleteCorrelation(String cpf) {
		try {
			return getUserFromRegisterTableByCpf(cpf);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
 	}

	public WebElement getCustomerToCorrelate() {
		super.getWait().forElementToBeDisplayed( this.customerToCorrelate, "customerToCorrelate");
		return customerToCorrelate;
	}

	public void setCustomerToCorrelate(WebElement customerToCorrelate) {
		this.customerToCorrelate = customerToCorrelate;
	}

	public WebElement getFilterCorrelation() {
		super.getWait().forElementToBeDisplayed( this.filterCorrelation, "filterCorrelation");
		return filterCorrelation;
	}

	public void setFilterCorrelation(WebElement filter) {
		this.filterCorrelation = filter;
	}

	public WebElement getAccountToCorrelate() {
		super.getWait().forElementToBeDisplayed( this.accountToCorrelate, "accountToCorrelate");
		return accountToCorrelate;
	}

	public void setAccountToCorrelate(WebElement accountToCorrelate) {
		this.accountToCorrelate = accountToCorrelate;
	}

	public WebElement getAccountTypeToCorrelate() {
		super.getWait().forElementToBeDisplayed( this.accountTypeToCorrelate, "accountTypeToCorrelate");
		return accountTypeToCorrelate;
	}

	public void setAccountTypeToCorrelate(WebElement accountTypeToCorrelate) {
		this.accountTypeToCorrelate = accountTypeToCorrelate;
	}

	public WebElement getRolesSwitches() {
		super.getWait().forElementToBeDisplayed( this.rolesSwitches, "rolesSwitches");
		return rolesSwitches;
	}

	public void setRolesSwitches(WebElement rolesSwitches) {
		this.rolesSwitches = rolesSwitches;
	}

	public WebElement getRolesSwitchesSpan1Div() {
		super.getWait().forElementToBeDisplayed( this.rolesSwitchesSpan1Div, "rolesSwitchesSpan1Div");
		return rolesSwitchesSpan1Div;
	}

	public void setRolesSwitchesSpan1Div(WebElement rolesSwitchesSpan1Div) {
		this.rolesSwitchesSpan1Div = rolesSwitchesSpan1Div;
	}


	public WebElement getOptionEconomicGroupOne() {
		super.getWait().forElementToBeDisplayed( this.optionEconomicGroupOne, "optionEconomicGroupOne");
		return optionEconomicGroupOne;
	}

	public void setOptionEconomicGroupOne(WebElement optionEconomicGroupOne) {
		this.optionEconomicGroupOne = optionEconomicGroupOne;
	}

	public WebElement getOptionSelectedAccount() {
		super.getWait().forElementToBeDisplayed( this.optionSelectedAccount, "optionSelectedAccount");
		return optionSelectedAccount;
	}

	public void setOptionSelectedAccount(WebElement selectedAccount) {
		this.optionSelectedAccount = selectedAccount;
	}

	public WebElement getOptionSelectedAccountFirst() {
		super.getWait().forElementToBeDisplayed( this.optionSelectedAccountFirst, "optionSelectedAccountFirst");
		return optionSelectedAccountFirst;
	}

	public void setOptionSelectedAccountFirst(WebElement selectedAccountOption) {
		this.optionSelectedAccountFirst = selectedAccountOption;
	}

	public WebElement getBtnSelectAccount() {
		super.getWait().forElementToBeDisplayed( this.btnSelectAccount, "btnSelectAccount");
		return btnSelectAccount;
	}

	public void setBtnSelectAccount(WebElement btnSelectAccount) {
		this.btnSelectAccount = btnSelectAccount;
	}

	public WebElement getBtnCancelEditCorrelation() {
		super.getWait().forElementToBeDisplayed( this.btnCancelEditCorrelation, "btnCancelEditCorrelation");
		return btnCancelEditCorrelation;
	}

	public void setBtnCancelEditCorrelation(WebElement btnCancelEditCorrelation) {
		this.btnCancelEditCorrelation = btnCancelEditCorrelation;
	}

	public WebElement getBtnEffectiveCorrelation() {
		super.getWait().forElementToBeDisplayed( this.btnEffectiveCorrelation, "btnEffectiveCorrelation");
		return btnEffectiveCorrelation;
	}

	public void setBtnEffectiveCorrelation(WebElement btnCorrelationButton) {
		this.btnEffectiveCorrelation = btnCorrelationButton;
	}

	public WebElement getBtnSelectClient() {
		super.getWait().forElementToBeDisplayed( this.btnSelectClient, "btnSelectClient");
		return btnSelectClient;
	}

	public void setBtnSelectClient(WebElement btnSelectClient) {
		this.btnSelectClient = btnSelectClient;
	}

	public WebElement getTableClientFirstInput() {
		this.getWait().forPresenceOfElements(5, By.xpath("//div[@class='modal-body']//following::*/child::*/table/tbody//tr[1]//td[1]//input"), "Table's CLient");
		return getDriver().findElement(By.xpath("//div[@class='modal-body']//following::*/child::*/table/tbody//tr[1]//td[1]//input"));
	}

	public WebElement getTableClientFirstInputValue() {
		String xpath = "//div[@class='modal-body']//following::*/child::*/table/tbody//tr[1]//td[3]";
		this.getWait().forPresenceOfElements(5, By.xpath(xpath), "Table's Client value");
		return getDriver().findElement(By.xpath(xpath));
	}

	public List<WebElement> getTableCorrelationValues(String value) {
		if(!Strings.isNullOrEmpty(value))
			this.getWait().forPresenceOfElements(10, By.xpath(String.format(XPATH_TABLE_CORRELATION_LOADING, value)), "Table's Correlation value "+value);
		this.getWait().forPresenceOfElements(10, By.xpath(XPATH_TABLE_CORRELATION_TR), "Table's Correlation value");
		this.getWait().forElementToBeDisplayed( getDriver().findElements(By.xpath(XPATH_TABLE_CORRELATION_TR)).get(0), "Table's Correlation value");
		return getDriver().findElements(By.xpath(XPATH_TABLE_CORRELATION_TR));
	}
	
	public List<WebElement> getTableCorrelationExclude() {
		try {
			this.getWait().forPresenceOfElements(10, By.xpath(XPATH_TABLE_CORRELATION_EXCLUSION_I), "Table's Correlation value");
			this.getWait().forElementToBeDisplayed( getDriver().findElements(By.xpath(XPATH_TABLE_CORRELATION_EXCLUSION_I)).get(0), "Table's Correlation exclusion");
			return getDriver().findElements(By.xpath(XPATH_TABLE_CORRELATION_EXCLUSION_I));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
	
	public void setTableClientFirstInput(WebElement tableClientFirstInput) {
		this.tableClientFirstInput = tableClientFirstInput;
	}


}

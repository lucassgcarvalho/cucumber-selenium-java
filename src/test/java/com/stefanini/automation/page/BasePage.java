package com.stefanini.automation.page;

import java.util.Date;
import java.util.Properties;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.stefanini.automation.infrastructure.config.PropertieConfig;
import com.stefanini.automation.infrastructure.driver.Setup;
import com.stefanini.automation.utils.AssertionMethods;
import com.stefanini.automation.utils.InputMethods;
import com.stefanini.automation.utils.NavigateMethods;
import com.stefanini.automation.utils.Wait;

/**
 * @author Stefanini
 *
 */
public class BasePage {

	
//	@FindBy(id = "mutate-button")
//	private WebElement btnHeaderMutate;
	
	private WebDriver driver;
	private Wait wait;
	private Properties properties = PropertieConfig.properties;
	private static Long longForname;
	private NavigateMethods navigateMethods;
	private AssertionMethods assertionMethods;
	private InputMethods inputMethods;

	public InputMethods getInputMethods() {
		return inputMethods;
	}

	public BasePage() {
		this.driver = Setup.driver;
		if(driver!=null)
			this.wait = new Wait(this.driver);
	}

	public AssertionMethods getAssertionMethods() {
		return assertionMethods;
	}

	public void closeBrowser() {
		this.driver.quit();
	}

	public String getProperty(String propertie) {
		return properties.getProperty(propertie);
	}

	public void setProperty(String propertie, String value) {
		properties.setProperty(propertie, value);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public Wait getWait() {
		return wait;
	}

	// Delete this function - Only to test creation while delete doesnt exists
	public String toASCII() {
		Long time = new Date().getTime();
		if (longForname == null) {
			longForname = time;
		}

		StringBuilder builder = new StringBuilder();
		char[] charArray = longForname.toString().toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			char charInitial = charArray[i];
			char charFinal = 3;
			if (i < charArray.length - 1) {
				charFinal = charArray[i + 1];
			}

			char newChar = ((char) (charInitial + charFinal));

			boolean matches = Pattern.matches("[a-zA-Z]", String.valueOf(new char[] { newChar }));
			if (matches) {
				builder.append((char) (charInitial + charFinal));
			}
		}

		return builder.toString();
	}

	public NavigateMethods getNavigateMethods() {
		return navigateMethods;
	}

	public WebElement getBtnHeaderMutate() {
		WebElement findElement = null;
		try {
			findElement = getDriver().findElement(By.id("mutate-button"));
			return findElement.isEnabled()?findElement:null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

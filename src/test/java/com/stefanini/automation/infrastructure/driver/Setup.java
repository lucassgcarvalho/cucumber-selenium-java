package com.stefanini.automation.infrastructure.driver;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.ErrorHandler;

import com.stefanini.automation.infrastructure.config.PropertieConfig;

import cucumber.api.java.Before;

public class Setup {

	public static WebDriver driver;
	private Properties properties = PropertieConfig.properties;
	
//	@Value("${browser.name}")
//	private String browserName;
//
//	@Value("${javascript.enable}")
//	private String javascriptEnable;
//
//	@Value("${capabilities.screenshot}")
//	private String capabilitiesScreenshot;
//
//	@Value("${system.key}")
//	private String systemKey;
//
//	@Value("${driver.system.value}")
//	private String pathDriver;
//
//	@Value("${driver.name}")
//	private String driverName;

	@Before(value = {"~@deleteRole", "~@deleteFunctionality", "~@deleteAccount", "~@deleteCorrelation", "~@deleteType", "~@deleteUser"})
	public void setWebDriver() throws Exception {
		setSystemProperties();
		
		String browser = properties.getProperty("browser.name");
		switch (browser) {
			case "chrome":
				loadChromeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				break;
		default:
			throw new IllegalArgumentException("Browser \"" + browser + "\" isn't supported.");
		}
	}

	
	private void loadChromeDriver() {
		try {
			driver = new ChromeDriver(loadCapabilities());
			loadErrorHandle();
		} catch (Exception e) {
			System.out.println("Error to load Chrome Driver");
			e.printStackTrace();
		}
	}

	private ChromeOptions loadCapabilities() {
		try {
			DesiredCapabilities capabilities = null;
			capabilities = DesiredCapabilities.chrome();
			
			capabilities.setJavascriptEnabled(new Boolean(properties.getProperty("javascript.enable")));
			capabilities.setCapability("takesScreenshot", new Boolean(properties.getProperty("capabilities.screenshot")));

			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("start-maximized");
			capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
			
			return chromeOptions;
		} catch (Exception e) {
			System.out.println("Error to load Chrome Driver");
			e.printStackTrace();
			return null;
		}
	}

	private void loadErrorHandle() {
		try {
			ErrorHandler handler = new ErrorHandler();
			handler.setIncludeServerErrors(false);
			((ChromeDriver) driver).setErrorHandler(handler);
		} catch (Exception e) {
			System.out.println("Error to load Chrome Driver");
			e.printStackTrace();
		}
	}

	private void setSystemProperties() {
		try {
			String systemKey = properties.getProperty("system.key");
			String pathDriver = properties.getProperty("driver.system.value");
			String driverName = properties.getProperty("driver.name");
			System.setProperty(systemKey, pathDriver.concat(driverName));
		} catch (Exception e) {
			System.out.println("Error to set properties System");
			e.printStackTrace();
		}
	}


}

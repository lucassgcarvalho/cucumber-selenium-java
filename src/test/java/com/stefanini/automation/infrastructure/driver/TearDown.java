package com.stefanini.automation.infrastructure.driver;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.stefanini.automation.infrastructure.config.PropertieConfig;
import com.stefanini.automation.utils.ScreenShotMethods;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class TearDown {

    private WebDriver driver;
    private Properties properties = PropertieConfig.properties;

    public TearDown() {
        this.driver = Setup.driver;
    }

    @After
    public void quitOnFailScenario(Scenario scenario){
        if(scenario.isFailed()){
        	
        	boolean isScreenshotInScenarione = new Boolean(properties.getProperty("screenShots.save.scenario"));
        	boolean isScreenshotInFolder = new Boolean(properties.getProperty("screenShots.save.folder"));

        	if(isScreenshotInScenarione)this.saveScreenshotInScenario(scenario, this.driver);
        	if(isScreenshotInFolder)this.saveScreenshotInFolder(scenario, this.driver);
        }
		
    	if(this.driver != null) {
    		this.driver.quit();
    	}
    }

    private void saveScreenshotInScenario(final Scenario scenario, WebDriver driver) {
    	try {
			ScreenShotMethods.takeScreenShotScenario(scenario, driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    private void saveScreenshotInFolder(final Scenario scenario, WebDriver driver) {
    	try {
			ScreenShotMethods.takeScreenShotFolder(scenario.getName(), driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}

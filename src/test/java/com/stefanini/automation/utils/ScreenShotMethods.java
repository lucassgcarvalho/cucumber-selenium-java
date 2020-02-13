package com.stefanini.automation.utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.stefanini.automation.infrastructure.config.PropertieConfig;

import cucumber.api.Scenario;

/**
 * @author Stefanini
 *
 */
public class ScreenShotMethods {
	
	private static Properties properties = PropertieConfig.properties;

	/** Method to take screen shot and save in ./Screenshots folder as a File Archive
	 * @param driver 
	 * @return 
	 * @return */
	public static void takeScreenShotFolder(String scenarioName, WebDriver driver) throws IOException {
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String screenshotdateFormat = properties.getProperty("screenShots.save.date.format");
		DateFormat dateFormat = new SimpleDateFormat(screenshotdateFormat);
		
		DateFormat folderDateFormat = new SimpleDateFormat(properties.getProperty("screenShots.save.date.format.folder"));
		DateFormat monthFolderDateFormat = new SimpleDateFormat(properties.getProperty("screenShots.save.date.format.folder.month"));
		DateFormat dayFolderDateFormat = new SimpleDateFormat(properties.getProperty("screenShots.save.date.format.folder.day"));
		
		String folderName = properties.getProperty("screenShots.save.folder.name");
		String imageExtension = properties.getProperty("screenShots.save.image.extension");
		String fileName = properties.getProperty("screenShots.save.name");

		File currentDirFile = new File(folderName);
		String path = currentDirFile.getAbsolutePath();
		Calendar cal = Calendar.getInstance();
		System.out.println("****\n" + path + "\\"+folderDateFormat.format(cal.getTime())+ "\\"+fileName+ dateFormat.format(cal.getTime()) + imageExtension );

		FileUtils.copyFile(screenshotFile, 
				new File(path 
							+ "\\" 
							+monthFolderDateFormat.format(cal.getTime())
							
							+ "\\" 
							+dayFolderDateFormat.format(cal.getTime())
							
							+ "\\" 
							+folderDateFormat.format(cal.getTime())
							
							+ "\\"
							+scenarioName
							+ "\\"
							+ fileName
							+ dateFormat.format(cal.getTime()) 
							+ imageExtension));
	}
	
	/** Method to take screen shot and save in embedded scenario 
	 * @param driver 
	 * @return 
	 * @return */
	public static void takeScreenShotScenario(Scenario scenario, WebDriver driver) throws IOException {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	    scenario.embed(screenshot, properties.getProperty("screenShots.type"));
	}
	
	
}

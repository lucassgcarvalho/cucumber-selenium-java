package com.stefanini.automation.infrastructure.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertieConfig {

	private static String PROPERTIES_PATH = ".\\src\\test\\resources\\application.properties";

	public static Properties properties;

	public PropertieConfig() {
		loadProperties();
	}

	private static void loadProperties() {
		if (properties == null) {
			try (InputStream inputProperties = new FileInputStream(PROPERTIES_PATH)) {
				Properties prop = new Properties();
				prop.load(inputProperties);
				properties = prop;
			} catch (IOException io) {
				System.out.println("Error to load properties.");
				io.printStackTrace();
			}
		}
	}

}

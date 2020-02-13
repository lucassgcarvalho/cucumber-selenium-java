package com.stefanini.automation.runnable.setup;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.stefanini.automation.infrastructure.config.PropertieConfig;

public class SetupExecution {
	
	@BeforeClass
	public static void startProperties() {
		new PropertieConfig();
	}
	
	@AfterClass
	public static void afterClass() {}
}

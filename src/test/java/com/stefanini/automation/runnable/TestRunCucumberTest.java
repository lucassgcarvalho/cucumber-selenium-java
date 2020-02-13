package com.stefanini.automation.runnable;

import org.junit.runner.RunWith;

import com.stefanini.automation.runnable.setup.SetupExecution;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/"},
        plugin = {"pretty","json:target/cucumber_json_reports/full-features.json", "html:target/full-features-html"},
        glue = {"com.stefanini.automation"})
public class TestRunCucumberTest extends SetupExecution{}

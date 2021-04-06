package com.poc.testRunner;

import org.junit.After;
import org.junit.runner.RunWith;

import com.poc.config.BaseClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="E:\\WorkSpace\\Hemant\\Cucumber_POC\\features",
		glue = {"com.poc.stepDef", "com.poc.testRunner"},
//		plugin= {"pretty", "html:Reports/Report.html"},
		plugin= {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome=true,
		tags=""
		)
public class TestRunner {
	
	@After
	public void tearDown() {
//		BaseClass.driver.quit();
	}
}

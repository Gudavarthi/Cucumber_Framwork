package com.poc.testRunner;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.poc.config.BaseClass;
import com.poc.utils.Util;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Configuration {

	private BaseClass base;
	private WebDriver driver;
	private Util util;
	Properties prop;

	@Before(order = 0)
	public void getProperty() {
		util = new Util();
		prop = util.init_prop();
//		System.out.println("***************************************************Hiiiiiiiii");
	}

//	@Before(order = 1)
//	public void launchBrowser() {
//		String browserName = prop.getProperty("browser");
//		String url = prop.getProperty("url");
//		System.out.println("******************************"+ browserName+ " ---  "+ url+ "************************************");
//		base = new BaseClass();
//		driver = BaseClass.launchBrowser(browserName, url);
//	}

	@After(order = 0)
	public void quitBrowser(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}else {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
		BaseClass.driver.quit();
	}

//	@After(order = 1)
//	public void tearDown(Scenario scenario) {
//		if (scenario.isFailed()) {
//			String screenshotName = scenario.getName().replaceAll(" ", "_");
//			byte[] sourcePath = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.BYTES);
//			scenario.attach(sourcePath, "image/png", screenshotName);
//		}
//	}

}

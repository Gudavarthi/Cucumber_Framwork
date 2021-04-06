package com.poc.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.poc.config.BaseClass;

public class Util {
	
	private Properties prop;
	
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("E:\\WorkSpace\\Hemant\\Cucumber_POC\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	
	public static void sendKeys(WebDriver driver, WebElement element, String Value2Put,	String Desc) {
		try {
			waitForElement(driver, element);
			element.clear();
			element.sendKeys(Value2Put);
			waitForPageToLoad(driver);
			BaseClass.log.info("Entered '"+Desc+"' into text field.");
		} catch (Exception e) {
			BaseClass.log.error("Unable to enter '"+Desc+"' into text field."+e.getMessage());
		}

	}
	
	public static void click(WebDriver driver, WebElement element,String Desc) {
		try {
			waitForElementTobeClickable(driver, element);
			element.click();
			waitForPageToLoad(driver);
			BaseClass.log.info(Desc+" button clicked.");
		} catch (Exception e) {
			BaseClass.log.error("Unable to click on "+Desc);
		}

	}
	
	public static void waitForElement(WebDriver driver, WebElement element) {
		waitForPageToLoad(driver);
		try {
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public static void waitForElementTobeClickable(WebDriver driver, WebElement element) {
		waitForPageToLoad(driver);
		try {
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.getMessage();

		}
	}
	
	public static void switchToFrame(WebDriver driver, WebElement name) {
		try {
			WebDriverWait wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(name));
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public static void waitForPageToLoad(WebDriver driver) {
		try {
			String pageLoadStatus;
			do {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				pageLoadStatus = (String) js.executeScript("return document.readyState");
				hardWait(1000);
				System.out.print(".");
			} while (!pageLoadStatus.equals("complete"));
			System.out.println();
			System.out.println("Page Loaded.");
		} catch (Exception e) {
			e.getMessage();
		}
	}


	public static void hardWait(int i) {
		try {
			Thread.sleep(i);
		}catch (Exception e) {
		}
		
	}
	

}

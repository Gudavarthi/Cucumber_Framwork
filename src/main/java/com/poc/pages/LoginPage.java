package com.poc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.poc.config.BaseClass;
import com.poc.utils.Util;

public class LoginPage {
	
	private WebDriver driver;

	@FindBy(id="email")
	private WebElement emailId;
	
	@FindBy(id="passwd")
	private WebElement password;
	
	@FindBy(id="SubmitLogin")
	private WebElement signInButton;
	
	@FindBy(linkText="Forgot your password?111")
	private WebElement forgotPwdLink;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getLoginPageTitle() {
		BaseClass.log.info(driver.getTitle()+" returned");
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExist() {
		return forgotPwdLink.isDisplayed();
	}

	public void enterUserName(String username) {
		Util.sendKeys(driver, emailId, username, "User name");
	}

	public void enterPassword(String pwd) {
		Util.sendKeys(driver, password, pwd, "Password");
	}

	public void clickOnLogin() {
		Util.click(driver, signInButton, "Login");
	}

	public HomePage doLogin(String un, String pwd) {
		System.out.println("login with: " + un + " and " + pwd);
		Util.sendKeys(driver, emailId, un, "User name");
		Util.sendKeys(driver, password, pwd, "Password");
		Util.click(driver, signInButton, "Login");
		return new HomePage(driver);
	}


}

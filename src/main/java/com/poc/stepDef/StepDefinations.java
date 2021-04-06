package com.poc.stepDef;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.poc.config.BaseClass;
import com.poc.pages.HomePage;
import com.poc.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinations {
	WebDriver driver;
	private static String title;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	    driver = BaseClass.launchBrowser("chrome", "http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		LoginPage login = new LoginPage(driver);
		String title = login.getLoginPageTitle();
		BaseClass.log.info("Page title is: " + title);
		System.out.println("Page title is: " + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		LoginPage login = new LoginPage(driver);
		String title = login.getLoginPageTitle();
		BaseClass.log.info("page title is "+expectedTitleName);
		Assert.assertTrue(title.contains(expectedTitleName));
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		LoginPage login = new LoginPage(driver);
		login.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		LoginPage login = new LoginPage(driver);
		login.enterPassword(password);
	}

	@When("user clicks on Login button")	
	public void user_clicks_on_login_button() {
		LoginPage login = new LoginPage(driver);
		login.clickOnLogin();
	}

	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credTable) {
		LoginPage login = new LoginPage(driver);
		HomePage home = new HomePage(driver);
		List<Map<String, String>> credList = credTable.asMaps();
		String userName = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		driver = BaseClass.launchBrowser("chrome", "http://automationpractice.com/index.php?controller=authentication&back=my-account");
		home = login.doLogin(userName, password);

	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		HomePage home = new HomePage(driver);
		String title = home.getAccountsPageTitle();
		System.out.println("Accounts Page title is: " + title);
		BaseClass.log.info("Accounts Page title is: " + title);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionsTable) {
		HomePage home = new HomePage(driver);
		List<String> expAccountSectionsList = sectionsTable.asList();
		System.out.println("Expected accounts section list: " + expAccountSectionsList);
		List<String> actualAccountSectionsList = home.getAccountsSectionsList();
		System.out.println("Actual accounts section list: " + actualAccountSectionsList);
		Assert.assertTrue(expAccountSectionsList.containsAll(actualAccountSectionsList));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
		HomePage home = new HomePage(driver);
		Assert.assertTrue(home.getAccountsSectionCount() == expectedSectionCount);
	}

}

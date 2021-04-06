Feature: Login page feature 

Scenario: Login page title 
	Given user is on login page 
	When user gets the title of the page 
	Then page title should be "Login - My Store" 
	
	
Scenario: Login with correct credentials 
	Given user is on login page 
	When user enters username "cucumberpoc@gmail.com" 
	And user enters password "auto@12345" 
	And user clicks on Login button 
	Then user gets the title of the page 
	And page title should be "My account - My Store"
	
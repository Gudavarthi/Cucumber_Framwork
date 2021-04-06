Feature: Home Page Feature 

Scenario: Home page title 
	Given user is on login page 
	When user enters username "cucumberpoc@gmail.com" 
	And user enters password "auto@12345" 
	And user clicks on Login button 
	When user gets the title of the page 
	Then page title should be "My account - My Store" 

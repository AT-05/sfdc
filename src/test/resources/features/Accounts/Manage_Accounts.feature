Feature: Manage Accounts

  Background:
	Given I'm logged to Salesforce
		And I go to Accounts home page

		
	@Smoke
	Scenario: Verify that it is possible to Create an Account
	
	When I create a New Account with the following information:
		 | Name   | Type      | Phone |
		 | Aslak  | Customer  | 789123|
	Then the message for the Account created is displayed
		And the Account should be displayed in Accounts page

		
	@Funtional
	Scenario: Verify that it is possible to Edit an Account

	Given I have an Acount with the following information:
			| Name   | Type      	| Phone |
			| Aslak  | Competitor  	| 755555|
	When I select the Account
		And I edit that Account with the following information:
			| Name     | Type     | Phone |
			| Aslak 2  | Customer | 744444|

	Then I should see the Account updated in the Accounts page 

	

	
	
	
	@Funtional
	Scenarios: Verify that it is possible Delete an Account that does not have opportunities 
	Given I have Acount with the following information:
			| Name   | Type      	| Phone |
			| Aslak  | Competitor  	| 755555|
	
	When I select the Account 
		And Delete an Account
	
	Then I should see the Acount is removed from the Accounts page
	
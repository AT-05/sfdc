@Contacts @Functional @New
Feature: Manage Contacts   
  
  Background:
	Given I am logged to Salesforce
		And I go to Contacts home page
	
  Scenario: Verify that is possible to Create a Contact 
    When I select New Contact 
		And I create a Contact with the following information:
			| name   | lastName| accountName  | title|email		   |phone |street             |city   |state  |country|
			| tester | test    | Acme (Sample)| Buyer|test@mail.com|555121|150 Chestnut Street|Toronto|Ontario|Canada |
  Then Contact was created message should be displayed in Contact Content Page
	  And the Contact should be displayed in Contact content page


	
	
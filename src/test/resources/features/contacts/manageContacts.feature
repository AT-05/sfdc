@Contacts @Functional @New
Feature: Manage Contacts   
  
  Background:
	#Given I am logged to Salesforce
	#	And I go to Contacts home page
	
  Scenario: Verify that is possible to Create a Contact 
    When I select New Contact 
		And I create a Contact with the following information:
		 | name   | lastName      | accountName |
		 | tester | test    	  | acme        |
	Then the message for the Contact  created is displayed
		And the Contact  should be displayed in Contact list page
		
	#	@Negative
	#Scenario: Verify when I create a New Contact the fields Name, Last Name, Account Name are required
	#	And I select New Contact
	#	When I try to save whith this fill in blank
	#	Then the page should be display a message of error
		
	#Scenario: Verify that is possible to add List View
    #When I add a List View to the Contact List Views with the name "ListTitle"
	#Then the List View  should be displayed in Contact List Views
	
	
	
@Contacts @Functional @edit
Feature: Updating Contacts  
   
  
  Background:
	Given I am logged to Salesforce
		And I go to Contacts home page
		And I have a Contact with the following information:
			| name   | lastName      | accountName  |
			| tester | test    	     | Acme (Sample)|
	
	
    Scenario: Verify that is possible to edit a Contact	    
    When I edit this Contact with the following information:
		| name    | lastName     | accountName          |
		| testerN | testN    	 | Global Media (Sample)|
	Then Contact was saved message should be displayed in Contact Content Page
		And the Contact should be displayed in Contact content page

#	Then the Contact edited should be displayed in Contact list page
	
	
#	Scenario: Verify that is possible to delete a Contact
#    When I delete this Contact
#	Then the Contact should be deleted from the Contact list
#
#	Scenario: Verify that is possible to clone a Contact
#    When I clone this Contact
#	Then the Contact cloned should be displayed in Contact list page
#
#	Scenario: Verify that is possible to add a note to Contact
#    When I add a note to this Contact with the following information:
#		 | Title   | Tex      |
#		 | title   | text     |
#	Then the note  should be displayed in Contact related fill
	
	
	

	
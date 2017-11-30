@Contacts @Functional
Feature: Updating Contacts  
   
  
  Background:
	Given I'm logged to Salesforce
		And I go to Contacts page
		And I have a Contact with the following information:
		 | Name   | Last Name       | Account Name |
		 | tester | test    	    | acme         |
	
	
    Scenario: Verify that is possible to edit a Contact	    
    When I edit this Contact with the following information:
		 | Name   | Last Name      | Account Name |
		 | test   | tester  	   | Global Media |
	Then the Contact edited should be displayed in Contact list page		 
	
	
	Scenario: Verify that is possible to delete a Contact	
    When I delete this Contact
	Then the Contact should be deleted from the Contact list
	
	Scenario: Verify that is possible to clone a Contact
    When I clone this Contact
	Then the Contact cloned should be displayed in Contact list page
	
	Scenario: Verify that is possible to add a note to Contact    
    When I add a note to this Contact with the following information:
		 | Title   | Tex      |  
		 | title   | text     | 
	Then the note  should be displayed in Contact related fill	
	
	
	

	
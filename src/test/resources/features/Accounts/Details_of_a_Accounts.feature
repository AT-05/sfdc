Feature: Details of a Accounts

  Background:
	Given I'm logged to Salesforce
		And I go to Accounts page
		And I have Acount with the following information
			| Name   | Type      	| Phone |
			| Aslak  | Competitor  	| 755555|

	

	@Funtional
	Scenarios: Verify that it is possible add Notes to an Account
	
	When I go to the option of new Note
		And I add a new Notes with the following information:
		| Tytle   	| Body   	 		|
		| Reminder   | reminder body    |
		| Reminder2  | reminder body 2	|

	Then I should see the Note is display in the Note list


	
	@Funtional
	Scenarius: Verify that it is possible add a Call to an Account
	
	When I go to the option of register a Call
		And I add new Calls with the following information
		 | Subject	| Comment    	  | Name 		| Related with	|
		 | Call one  	| Competitor  	  |Candidates	| order		|
		 | Call two  	| Competitor two  |Candidates	| order		|
		 
	Then I should see the calls are displayed in the calls list

	
	
	@Funtional
	Scenarius: Verify that it is possible add a Task to an Account
	
	When I go to the option to add a Task
		And I add new Task with the following information
		 | Subject	| Due Date   	  | Assigned to		| Name		| Related to 	|
		 | Task  	| 30/11/2017  	  | Abner Mamani	| contacts	| Aslak			|
		 | Task 2  	| 30/11/2017  	  | Abner Mamani	| contacts	| Aslak			|
		 
		 
	Then I should see the Tasks are displayed in the Timeline of activities



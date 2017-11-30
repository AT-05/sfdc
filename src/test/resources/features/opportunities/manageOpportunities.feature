Feature: Manage Opportunities - CRUD
	
	Background:
		Given I'm logged to Salesforce
			And I go to Opportunities page
			And I have Opportunity with the following information
				| Opp Name		| Opp test  	|
				| Close Date	| Now + 1 month |
				| Stage			| Qualification	|
				| Account		| Acme			|

	@Smoke
	Scenario: User should be able to create an Opportunity
		Then a message should be displayed saying that the opportunity was created
			And the Opportunity created should be display in the Opportunities list
	
	@Funtional
	Scenario: User should be able to edit an Opportunity
		Given I select to edit the Opportunity created from the list
		When I edit the Opportunity with the following information
			| Opp Name		| Opp testing  	|
			| Close Date	| Now + 2 month |
			| Stage			| Proposal		|
			| Account		| Salesforce	|
		Then a message should be displayed saying that the opportunity was saved
			And the Opportunity edited should be display in the Opportunities list
		
	@Funtional
	Scenario: User should be able to delete an Opportunity
		Given I select the Opportunity created from the list 
		When I delete that Opportunity
		Then a message should be displayed saying that the Opportunity was deleted
			And the Opportunity should be delete of the list
	
	@Funtional
	Scenario: User should be able to duplicate Opportunity
		Given I select the Opportunity created from the list 
		When I Duplicate that Opportunity
		Then a message should be displayed saying that the Opportunity was created
			And two Opportunities with the same information should be displayed in the Opportunities list
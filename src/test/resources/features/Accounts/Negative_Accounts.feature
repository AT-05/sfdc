Feature: Unable to delete account


	@Negative
	Scenarios: Verify that it is not possible delete an account with has Won Opportunities
		Given I have Acount with the following information: 
			| Name   | Type      	| Phone |
			| Aslak  | Competitor  	| 755555|
		And I have Opportunity with the following information
			| Opp Name		| Opp test  	|
			| Close Date	| Now + 1 month |
			| Stage			| Closed Won	|
			| Account		| Aslak			|
	When I select the Account
		And Delete an Account 
			
	Then I verify that display the message that the account can not be Delete
	

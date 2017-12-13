Feature: Unable to delete account

  Background:
    Given I'm logged to Salesforce
    And I go to Accounts home page

  @Negative
  Scenario: Verify that it is not possible delete an account with has Won Opportunities
    Given I have Acount  with the following information and has a closed won Opportunity:
      | name          | type		| web			| description | phone 	| sector  | employees | streetBilling | shippingStreet  |
      | Acme (Sample) | Prospect	| www.higos.com	| description | 7742515 | Banking | 248		  | los pericos	  | shipping_street |
    When I select the Account
    And I delete an Account

    Then I verify that display the message that the account can not be Delete


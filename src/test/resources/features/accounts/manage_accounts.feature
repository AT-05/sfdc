@Login1
Feature: Manage Accounts

  Background:
    Given I'm logged to Salesforce
    And I go to Accounts home page

  @SmokeTest @create
  Scenario: Verify that it is possible to Create an Account

    When I create a New Account with the following information:
      | name   | type		| web			| description | phone 	| sector  | employees | streetBilling | shippingStreet  |
      | Alaska | Customer	| www.higos.com	| description | 7742515 | Banking | 248		  | los pericos	  | shipping_street |

    Then the message for the Account created is displayed
    And the Account should be displayed in Accounts page



  @Functional @delete
  Scenario: Verify that it is possible to Delete an Account without opportunities
    Given I have an Acount with the following information:
      | name   | type		| web			| description | phone 	| sector  | employees | streetBilling | shippingStreet  |
      | Alaska | Customer	| www.higos.com	| description | 7742515 | Banking | 248		  | los pericos	  | shipping_street |

    When I select the Account
    And I delete the Account
    Then I should see the Acount is removed from the Accounts page


  @Funtional @edit
  Scenario: Verify that it is possible to Edit an Account

    Given I have an Acount with the following information:
      | name   | type		| web			| description | phone 	| sector  | employees | streetBilling | shippingStreet  |
      | Alaska | Customer	| www.higos.com	| description | 7742515 | Banking | 248		  | los pericos	  | shipping_street |
    When I select the Account
    And I edit that Account with the following information:
      | name     | type		| web			     | description   | phone 	| sector  | employees | streetBilling | shippingStreet  |
      | Alaska 2 | Analyst	| www.lostiempos.com | description 2 | 444444    | Banking | 28		  | los pericos	  | shipping_street |

    Then I should see the Account updated in the Accounts page

#  Scenario: Users should be able to login using valid credentials
#    Given I navigate to Login page
#    When I login with enviroments params
#    Then I should login successfully

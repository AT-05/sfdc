@Login1
Feature: Manage Accounts

  Background:
    Given I'm logged to Salesforce
    And I go to Accounts home page

  @SmokeTest
  Scenario: Verify that it is possible to Create an Account

    When I create a New Account with the following information:
      | name   | address  | phone |
      | Aslak  | Customer  | 789123|
    Then the message for the Account created is displayed
    And the Account should be displayed in Accounts page



  @Functional
  Scenario: Verify that it is possible to Delete an Account without opportunities
    Given I have an Acount with the following information:
      | name   | address      	| phone |
      | Aslak  | Competitor  	| 755555|

    When I select the Account
    And I delete the Account
    Then I should see the Acount is removed from the Accounts page


  @Funtional @edit
  Scenario: Verify that it is possible to Edit an Account

    Given I have an Acount with the following information:
      | name   | address      	| phone |
      | Aslak  | Competitor  	| 755555|
    When I select the Account
    And I edit that Account with the following information:
      | name     | address      | phone |
      | Aslak 2  | Customer     | 744444|

    Then I should see the Account updated in the Accounts page

#  Scenario: Users should be able to login using valid credentials
#    Given I navigate to Login page
#    When I login with enviroments params
#    Then I should login successfully

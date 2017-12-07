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


#  Scenario: Users should be able to login using valid credentials
#    Given I navigate to Login page
#    When I login with enviroments params
#    Then I should login successfully

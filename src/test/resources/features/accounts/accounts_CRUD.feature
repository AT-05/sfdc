@Funtional @Account
Feature: Manage Accounts

  Background:
    Given I am logged to Salesforce
      And I go to Accounts home page

  @SmokeTest @createAccount
  Scenario: Verify that it is possible to Create an Account
    When I create a New Account with the following information:
      | name   | type     | web           | description | phone   | sector  | employees |
      | Alaska | Prospect | www.higos.com | description | 7742515 | Banking | 248       |
    Then the message for the Account created is displayed
    And the Account should be displayed in Accounts page
    And the Account should be saved

  @editAccount
  Scenario: Verify that it is possible to Edit an Account
    Given I have an Acount with the following information:
      | name   | type     | web           | description | phone   | sector  | employees |
      | Alaska | Prospect | www.higos.com | description | 7742515 | Banking | 248       |
    When I select the Account
    And I edit that Account with the following information:
      | name     | type    | web                | description   | phone  | sector  | employees |
      | Alaska 2 | Prospect | www.lostiempos.com | description 2 | 444444 | Banking | 28        |
    Then I should see the Account updated in the Accounts page

  @deleteAccount
  Scenario: Verify that it is possible to Delete an Account without opportunities
    Given I have an Acount with the following information:
      | name   | type     | web           | description | phone   | sector  | employees |
      | Alaska | Prospect | www.higos.com | description | 7742515 | Banking | 248       |

    When I select the Account
    And I delete the Account
    Then I should see the Acount is removed from the Accounts page


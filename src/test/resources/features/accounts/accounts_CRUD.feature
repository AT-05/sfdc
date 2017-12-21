@Funtional @Account @crudAccount
Feature: Manage Accounts

  Background:
    Given I am logged to Salesforce
      And I go to Accounts home page

  @SmokeTest @createAccount1
  Scenario: Verify that it is possible to Create an Account
    When I create a New Account with the following information:
      | name   | type     | web           | description | phone   | sector  | employees |
      | Alaska | Prospect | www.higos.com | description | 7742515 | Banking | 248       |
    Then the message for the Account created is displayed
    And the Account should be displayed in Accounts page
    And the Account should be saved

  @editAccount1
  Scenario: Verify that it is possible to Edit an Account
    Given I have an Account with the following information:
      | name       | type     | web           | description | phone   | sector  | employees |
      | PuertoVelo | Prospect | www.higos.com | description | 7742515 | Banking | 248       |
    When I select the Account
    And I edit that Account with the following information:
      | name     | type    | web                | description   | phone  | sector  | employees |
      | PuertoVelo 2 | Prospect | www.lostiempos.com | description 2 | 444444 | Banking | 28        |
    Then I should see the Account updated in the Accounts page

  @deleteAccount1
  Scenario: Verify that it is possible to Delete an Account without opportunities
    Given I have an Account with the following information:
      | name    | type     | website           | description | phone   | sector  | employees |
      | facundo | Prospect | www.higos.com | description | 7742515 | Banking | 248       |

    When I select the Account
    And I delete the Account
    Then I should see the Account is removed from the Accounts page


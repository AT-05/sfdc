@Negative @Account
Feature: Unable to delete account

  Background:
    Given I am logged to Salesforce
      And I go to Accounts home page

  @createAccount
  Scenario: Verify that is not possible create an Account without Name
    When I create a New Account with the following information and the Account without Name:
      | name | type     | web           | description | phone   | sector  | employees |
      |      | Prospect | www.higos.com | description | 7742515 | Banking | 248       |
    Then  the message should be displayed that is not possible create an Account

  @editAccount
  Scenario: Verify that is not possible edit an Account without Name
    Given I have an Acount with the following information:
      | name   | type     | web           | description | phone   | sector  | employees |
      | Alaska | Prospect | www.higos.com | description | 7742515 | Banking | 248       |
    When I select the Account
     And I edit that Account with the following information without Name:
      | name | type     | web           | description | phone   | sector  | employees |
      |      | Prospect | www.higos.com | description | 7742515 | Banking | 248       |
    Then the message should be displayed that is not possible Edit an Account

  @deleteAccount
  Scenario: Verify that it is not possible delete an account with has Won Opportunities
    Given I have Acount  with the following information and has a closed won Opportunity:
      | name          | type     | web           | description | phone   | sector  | employees |
      | Acme (Sample) | Prospect | www.higos.com | description | 7742515 | Banking | 248       |
    When I select an Account
      And I delete an Account
    Then I verify that display the message that the account can not be Delete

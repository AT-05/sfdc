@Contacts @Functional @NewContact
Feature: Manage Contacts

  Background:
    Given I am logged to Salesforce
      And I go to Contacts home page
@createContact
  Scenario: Verify that is possible to Create a Contact
    When I select New Contact
      And I create a Contact with the following information:
      | name   | lastName | accountName   | title | email         | phone  | street              | city    | state   | country |
      | tester | test     | Acme (Sample) | Buyer | test@mail.com | 555121 | 150 Chestnut Street | Toronto | Ontario | Canada  |
    Then Contact was created message should be displayed in Contact Content Page
      And the Contact should be displayed in Contact content page
  @createContactDD
  Scenario Outline: Verify that is possible to Create a Contact
    When I select New Contact
    And I create a Contact with the following information:"<name>" "<lastName>" "<accountName>" "<title>" "<email>" "<phone>" "<street>" "<city>" "<state>" "<country>"

    Then Contact was created message should be displayed in Contact Content Page
    And the Contact should be displayed in Contact content page
    Examples:
      | name      | lastName   | accountName   | title | email         | phone  | street              | city    | state   | country |
      | tester1$  | /test/     | Acme (Sample) | Buyer | test@mail.com | 555121 | 150 Chestnut Street | Toronto | Ontario | Canada  |
      | tester1%  | \test\     | Acme (Sample) | Buyer | test@mail.com | 555121 | 150 Chestnut Street | Toronto | Ontario | Canada  |
      | tester1&  | {test}     | Acme (Sample) | Buyer | test@mail.com | 555121 | 150 Chestnut Street | Toronto | Ontario | Canada  |
  @negative
  Scenario Outline: Verify that is not possible to Create a Contact with fields empty
    When I select New Contact
    And I create a Contact with the following information:"<name>" "<lastName>" "<accountName>" "<title>" "<email>" "<phone>" "<street>" "<city>" "<state>" "<country>"

    Then Contact created message error should be displayed in Contact Content Page

    Examples:
      | name      | lastName | accountName   | title | email         | phone  | street              | city    | state   | country |
      | tester1$  |          | Acme (Sample) | Buyer | test@mail.com | 555121 | 150 Chestnut Street | Toronto | Ontario | Canada  |
      | tester    | test     |               | Buyer | test@mail.com | 555121 | 150 Chestnut Street | Toronto | Ontario | Canada  |
      | tester    |          |               | Buyer | test@         | 555121 | 150 Chestnut Street | Toronto | Ontario | Canada  |

@Contacts @Negative
Feature: Unable to create, to edit contact

  Background:
    Given I am logged to Salesforce
    And I go to Contacts home page

  @ContactNegative
  Scenario Outline: Verify that is not possible to Create a Contact with fields empty
    When I select New Contact
    And I create a Contact with the following information:
      | name           | lastName         | accountName      | title           | email           | phone           | street          | city          | state           | country           |
      | <name_contact> | <last_contact>   | <account_contact>| <title_contact> | <email_contact> | <phone_contact> | <street_contact>|<city_contact> | <state_contact> | <country_contact> |
    Then Contact created message error should be displayed in Contact Edit Page
    Examples:
      | name_contact | last_contact | account_contact | title_contact | email_contact | phone_contact | street_contact      | city_contact | state_contact | country_contact |
      | tester       |              | Acme            | Buyer         | test@mail.com | 555121        | 150 Chestnut Street | Toronto      | Ontario       | Canada          |
      | tester       | test         |    Inc          | Buyer         | test@mail.    | 555121        | 150 Chestnut Street | Toronto      | Ontario       | Canada          |
      | tester       |              |    Inc          | Buyer         | test@         | 555121        | 150 Chestnut Street | Toronto      | Ontario       | Canada          |
  @ContactNegative
  Scenario Outline: Verify that is not possible to edit a Contact with Last Name and Account Name fields are empty
    Given I have a Contact with the following information:
      | name | lastName | accountName   | title | email         | phone   | street              | city    | state   | country |
      | test | tester   | Acme          | Buyer | test@mail.com | 5551212 | 100 Chestnut Street | Toronto | Ontario | Canada  |
    When I edit this Contact with the following information:
      | name           | lastName         | accountName      | title           | email           | phone           | street          | city          | state           | country           |
      | <name_contact> | <last_contact>   | <account_contact>| <title_contact> | <email_contact> | <phone_contact> | <street_contact>|<city_contact> | <state_contact> | <country_contact> |
    Then Contact edited message error should be displayed in Contact Edit Page
    Examples:
      | name_contact | last_contact | account_contact | title_contact | email_contact | phone_contact | street_contact      | city_contact | state_contact | country_contact |
      | tester       |              | Acme            | Buyer         | test@mail.com | 555121        | 150 Chestnut Street | Toronto      | Ontario       | Canada          |
      | tester       | test         |                 | Buyer         | test@mail.    | 555121        | 150 Chestnut Street | Toronto      | Ontario       | Canada          |
      | tester       |              |      Inc        | Buyer         | test@         | 555121        | 150 Chestnut Street | Toronto      | Ontario       | Canada          |

	
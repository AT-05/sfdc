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
      | tester | test     | Acme          | Buyer | test@mail.com | 555121 | 150 Chestnut Street | Toronto | Ontario | Canada  |
    Then Contact was created message should be displayed in Contact Content Page
      And the Contact should be displayed in Contact content page
  @editContact
  Scenario: Verify that is possible to edit a Contact
    Given I have a Contact with the following information:
      | name | lastName | accountName   | title | email         | phone   | street              | city    | state   | country |
      | test | tester   | Acme          | Buyer | test@mail.com | 5551212 | 100 Chestnut Street | Toronto | Ontario | Canada  |

    When I edit this Contact with the following information:
      | name   | lastName | accountName   | title    | email         | phone   | street              | city    | state   | country |
      | tester | test     | Global Media  | VP Sales | test@mail.com | 5551010 | 150 Chestnut Street | Toronto | Ontario | Canada  |
    Then Contact was saved message should be displayed in Contact Content Page
    And the Contact should be displayed in Contact content page

  @deleteContact
  Scenario: Verify that is possible to delete a Contact
    Given I have a Contact with the following information:
      | name | lastName | accountName   | title | email         | phone   | street              | city    | state   | country |
      | test | tester   | Acme          | Buyer | test@mail.com | 5551212 | 100 Chestnut Street | Toronto | Ontario | Canada  |

    When I delete this Contact
 #Then Contact was deleted message should be not displayed in Contact Content Page




	
	
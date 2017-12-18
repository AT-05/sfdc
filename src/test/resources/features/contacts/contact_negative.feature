@Contacts @Functional
Feature: Negative CRUD Contacts
  Background:
    Given I am logged to Salesforce
      And I go to Contacts home page
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

  @editContact @negative
  Scenario: Verify that is not possible to edit a Contact with Last Name and Account Name fields are empty
    Given I have a Contact with the following information:
      | name | lastName | accountName   | title | email         | phone   | street              | city    | state   | country |
      | test | tester   | Acme (Sample) | Buyer | test@mail.com | 5551212 | 100 Chestnut Street | Toronto | Ontario | Canada  |
    When I edit this Contact with the following information:
      | name   | lastName | accountName           | title    | email         | phone   | street              | city    | state   | country |
      | tester |          |                       | VP Sales | test@mail.com | 5551010 | 150 Chestnut Street | Toronto | Ontario | Canada  |
    Then  the message "These required fields must be completed"  should be displayed in Contact Content Page
  @negative
  Scenario: Verify that is not possible to delete a Contact associated to Case

    Given I have a Contact with the following information:
      | name | lastName | accountName   | title | email         | phone   | street              | city    | state   | country |
      | test | tester   | Acme (Sample) | Buyer | test@mail.com | 5551212 | 100 Chestnut Street | Toronto | Ontario | Canada  |
    And This Contact has associated a Case
    When I delete this Contact
    Then Contact delete could not be completed  message should be displayed in Contact Content Page





	
	
	

	
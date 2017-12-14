@Contacts @Functional
Feature: Updating Contacts


  Background:
    Given I am logged to Salesforce
      And I go to Contacts home page
      And I have a Contact with the following information:
      | name | lastName | accountName   | title | email         | phone   | street              | city    | state   | country |
      | test | tester   | Acme (Sample) | Buyer | test@mail.com | 5551212 | 100 Chestnut Street | Toronto | Ontario | Canada  |

  @editContact
  Scenario: Verify that is possible to edit a Contact
    When I edit this Contact with the following information:
      | name   | lastName | accountName           | title    | email         | phone   | street              | city    | state   | country |
      | tester | test     | Global Media (Sample) | VP Sales | test@mail.com | 5551010 | 150 Chestnut Street | Toronto | Ontario | Canada  |
    Then Contact was saved message should be displayed in Contact Content Page
      And the Contact should be displayed in Contact content page

  @deleteContact
  Scenario: Verify that is possible to delete a Contact
    When I delete this Contact
 #Then Contact was deleted message should be not displayed in Contact Content Page

	
	
	

	
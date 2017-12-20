@Contacts @Functional
Feature: Updating Contacts


  Background:
    Given I am logged to Salesforce
      And I go to Contacts home page
      And I have a Contact with the following information:
      | name | lastName | accountName   | title | email         | phone   | street              | city    | state   | country |
      | test | tester   | Acme          | Buyer | test@mail.com | 5551212 | 100 Chestnut Street | Toronto | Ontario | Canada  |


	

	
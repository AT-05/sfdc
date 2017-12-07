Feature: Management configuration product

  Background:
    Given I'm logged in Sales Force.
    And  I go to Product Home page
    Given  I have a product with the following information:
      | Product Name        | Patch Core cat. 6           |
      | Product code        | PCoreC6                     |
      | Product description | This is a small description |

  @Functional
  Scenario: Verify that is possible Search a product.
    When I search a product with the following keyword "PCoreC6"
    Then search list should be displayed with the products founds.

  @Functional
  Scenario: Verify that is possible change status to Active of a products
    When I select ALL products
    And I select Activate option
    Then the  status of the product should be changed to Active

  @Functional
  Scenario: Verify that is possible Deactivate products existing.
    When I select ALL products
    And I select Deactivate option
    Then the  status of the product should be changed to Active Deactivate.

  @Functional
  Scenario: Verify that is possible Create new note in a product
    When I select the Product "Patch Core cat. 6"
    And I Create new Note with the following information
      | Note Title  | First Note                          |
      | Description | this is my first note for a product |
    Then The new Note Should be displayed in the list of Notes of the product.




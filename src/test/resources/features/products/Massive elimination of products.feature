Feature: Price books

  Background:
    Given I'm logged in Sales Force.
    And  I go to Product Home page

  @Functional
  Scenario: Verify that is possible products Massive Elimination.
    Given  I have these product creates with the following information
      | Product Name             | Product code | Product description                 |
      | Patch Core cat. 6 red    | 0001PCoreC6R | This is a small description of test |
      | Patch Core cat. 6 blue   | 0001PCoreC6B | This is a small description of test |
      | Patch Core cat. 6 yellow | 0001PCoreC6Y | This is a small description of test |
    When I go to products Massive Elimination option.
    And I select  the following products
      | Product Name | Patch Core cat. 6 red    |
      | Product Name | Patch Core cat. 6 blue   |
      | Product Name | Patch Core cat. 6 yellow |
    Then the Products selects should be removed from the Product List
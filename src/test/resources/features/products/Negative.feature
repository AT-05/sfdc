Feature: negative feature

  Background:
    Given I'm logged in Sales Force.
    And  I go to Product option

  @Negative
  Scenario: Verify that is not possible Create new product with Product Name empty.
    When I Create new product with the follows information:
      | Product Name        |  |
      | Product code        |  |
      | Product description |  |
    Then the product is not create and error message should be displayed.
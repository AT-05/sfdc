@addProductInPriceBookK
Feature: Price books

  Background:
    Given I'm logged in Sales Force
    And  I go to Product Home page
  @Functional
  Scenario: Verify that is possible Add price book to an existing product.
    Given I have a New Product with the following information:
      | name       | code          | description                | active |
      | Test Marco | 0018881991C67 | This is a test description | true   |
    And I have a Price Book wih the following information :
      | name | uniqueName   |
      | Red2  | newPriceBook |
    When I select the Product
    And I add price book to product
    Then  the price book should be add to the product





@ManagementProduct
Feature: Marcos

  Background:
    Given I'm logged in Sales Force
    And  I go to Product Home page

  @SmokeTest
  Scenario: Verify that is possible create a New Product
    When I create a New Product with the following information:
      | name                | code       | description                | active |
      | Test Create product | 0011151C67 | This is a test description | true   |
    Then Product Details Page should be display with the information of the product created


  @Smoke @Functional
  Scenario: Verify that is possible Edit a product created
    Given I have a New Product with the following information:
      | name              | code          | description                | active |
      | Test Product Edit | 0018881991C67 | This is a test description | true   |
    When I select the Product
    And I Edit the Product information with the following information:
      | name                | code          | description                | active |
      | Test product Edited | 0018881991C67 | This is a test description | true   |
    Then Product Content Page should be displayed with the information updated

  @Smoke @Functional
  Scenario: Verify that is possible Delete a Product created
    Given I have a New Product with the following information:
      | name                  | code   | description                | active |
      | Test  Delete product7 | 121254 | This is a test description | true   |
    When I select the Product
    And  I delete the product
    Then the Product should be removed from the Product List
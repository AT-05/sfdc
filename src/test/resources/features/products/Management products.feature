@CreateProduct
Feature: Marcos

  Background:
    Given I'm logged in Sales Force
    And  I go to Product Home page

#  @SmokeTest
 # Scenario: Verify that is possible create a New Product
  #  When I create a New Product with the following information:
   #   | name              | code       | description                |
    #  | Patch Core cat. 6 | 0011151C67 | This is a test description |
   # Then Product Details Page should be display with the information of the product created

  @Smoke @Functional
  Scenario: Verify that is possible Edit a product created
    Given I have a New Product with the following information:
      | name             | code          | description                |
      | Patch panel cat6 | 0018881991C67 | This is a test description |
    When I select the Product
    And I Edit the Product information with the following information:
      | ProductName         | Patch Core cat. 7            |
      | Product code        | PCoreC7                      |
      | Product description | This is a small description2 |
    Then Product Content Page should be displayed with the information updated



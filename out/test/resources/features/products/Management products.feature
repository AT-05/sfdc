@Marcos
Feature: Marcos

  @SmokeTest
  Scenario: Verify that is possible create a New Product
    Given I'm logged in Sales Force
    And  I go to Product Home page
    When I create a New Product with the following information:

    Then Product Details Page should be display with the information of the product created


   #  | name              | code       | description                |
     # | Patch Core cat. 6 | 0011151C67 | This is a test description |
@CreateProduct
Feature: Marcos

  Background:
    Given I'm logged in Sales Force
    And  I go to Product Home page

  #@SmokeTest
  #Scenario: Verify that is possible create a New Product
   # When I create a New Product with the following information:
    #  | name                | code       | description                |
     # | Test Create product | 0011151C67 | This is a test description |
   # Then Product Details Page should be display with the information of the product created


  @Smoke @Functional
  Scenario: Verify that is possible Edit a product created
    And I have a New Product with the following information:
      | name              | code          | description                |
      | Test Product Edit | 0018881991C67 | This is a test description |
    When I select the Product
    And I Edit the Product information with the following information:
      | name                | code          | description                |
      | Test Edit Producted | 0018881991C67 | This is a test description |
    Then Product Content Page should be displayed with the information updated
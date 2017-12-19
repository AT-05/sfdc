@CreatePriceBook
Feature: Price books

  Background:
    Given I'm logged in Sales Force
    And  I go to Product Home page

  @Functional
  Scenario: Verify that is possible Create new Price Books.
    When I select Price Books new price book option
    And I create new Price with the following information:
      | name            | uniqueName        |
      | Price Booktest1 | PriceBoodddkTest1 |
    Then the new price book should be int Price books list


  @Smoke @Functional
  Scenario: Verify that is possible Edit a price book created
    Given I select Price Books new price book option
    And I have a Price book with the following information:
      | name             | uniqueName     |
      | Price Book test1 | PriceBookTest1 |
    When I select the price book
    And I Edit the price book information with the following information:
      | name             | uniqueName     |
      | Price Book test2 | PriceBookTest2 |
    Then Price Content Page should be displayed with the information updated





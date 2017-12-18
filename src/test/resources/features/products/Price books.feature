@CreatePriceBook
Feature: Price books

  Background:
    Given I'm logged in Sales Force
    And  I go to Product Home page

  @Functional
  Scenario: Verify that is possible Create new Price Books.
    When I select Price Books option
    And I create new Price with the following information:
      | name             | uniqueName     |
      | Price Book test1 | PriceBookTest1 |
    Then the new price book should be int Price books list


  @Smoke @Functional
  Scenario: Verify that is possible Edit a price book created
    Given I have a Price book with the following information:
      | name             | uniqueName     |
      | Price Book test1 | PriceBookTest1 |
    When I select the price book
    And I Edit the price book information with the following information:
      | name             | uniqueName     |
      | Price Book test2 | PriceBookTest2 |
    Then Price Content Page should be displayed with the information updated

  @Smoke @Functional
  Scenario: Verify that is possible Delete a price book created
    Given I have a Price book with the following information:
      | name             | uniqueName     |
      | Price Book test1 | PriceBookTest1 |
    When I select the price price book
    And  I delete the price book
    Then the price book should be removed from the Price book drop down list






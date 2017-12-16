Feature: Price books

  Background:
    Given I'm logged in Sales Force.
    And  I go to Product Home page

  @Functional
  Scenario: Verify that is possible Create new Price Books.
    When I select Price Books option.
    And I create new Price with the following information:
      | Name of the price list | PriceTest1 |
      | Description            | TestPrice  |
    Then the new price book should be int Price books list.






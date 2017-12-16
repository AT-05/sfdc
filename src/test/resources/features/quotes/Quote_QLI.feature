@Quote @QuoteLineItem @Functional
Feature: Manage Quote Line Items
  Test successfully adding, editing and deleting of Quote Line Items

  Background:
    Given I am logged to Salesforce
      And I go to Quotes Home Page
      And I select the Quote created with name "Premium", expiration date "12/12/2018", status "Draft", description, "Quote Description4", tax "2.0" and shipping and handling "30.0"

  @AddQuoteLineItem @Smoke
  Scenario: Verify that is possible to Add Quote Line Items
    When I add the following Products related to PriceBook "Standard Price Book" to the Quote
      | name      | salesPrice | quantity | discount | lineItemDescription |
      | ProdTest1 | 23         | 50       | 5        | description1        |
      | ProdTest2 | 40.50      | 10       | 8        | description2        |
    Then A successful saved changes message should be displayed
      And The Quote Totals should be updated correctly
      And I should see the new Products in the Quote Line Items view

  @EditQuoteLineItem
  Scenario: Verify that is possible to Edit a Quote Line Item
    Given I have the following Product added to the Quote
      | name      | salesPrice | quantity | discount | lineItemDescription |
      | ProdTest3 | 30         | 10       | 2        | description3        |
    When I edit the added Product with the following information
      | name      | salesPrice | quantity | discount | lineItemDescription |
      | ProdTest3 | 50         | 20       | 5        | description3        |
    Then A successful saved changes message should be displayed
      And The Products Details should be updated correctly
      And The Quote Totals should be updated correctly

  @DeleteQuoteLineItem
  Scenario: Verify that is possible to Delete a Quote Line Item
    Given I have the following Product added to the Quote
      | name      | salesPrice | quantity | discount | lineItemDescription |
      | ProdTest4 | 15         | 100      | 3        | description4        |
    When I delete the added Product from the Quote
    Then A Quote Line Item successful deleting message should be displayed
    And The deleted Product should disappear from the Quote Line Items view
      And The Quote Details should be updated correctly
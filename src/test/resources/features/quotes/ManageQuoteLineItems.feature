@Quote @QuoteLineItem @Functional
Feature: Manage Quote Line Items
  Test successfully adding, editing and deleting of Quote Line Items

  Background:
    Given I am logged to Salesforce
      And I have a Product created with name "ProductTest" related to a Price Book created with name "PriceBookTest"
      And I have an Opportunity with the following information:
      | Opp Name   | Opp test      |
      | Close Date | Now + 1 month |
      | Stage      | Qualification |
      | Account    | Acme          |
      And I have a Quote created with name "Test" for the Opportunity created
      And I go to Quotes Page
      And I select the Quote created

  @AddQuoteLineItem @Smoke
  Scenario: Verify that is possible to Add Quote Line Items
    When I add the following Products to the Quote
      | Product     | Price Book   | Price | Discount | Quantity |
      | Prod test 1 | Price Book 1 | 23    | 5%       | 50       |
      | Prod test 2 | Price Book 2 | 40    | 8%       | 10       |
    Then A successful saved changes message should be displayed
      And I should see the new Products in the Quote Line Items view
      And The Quote Totals should be updated correctly

  @EditQuoteLineItem
  Scenario: Verify that is possible to Edit a Quote Line Item
    Given I have the following Product added to the Quote
      | Product     | Price Book   | Price | Discount | Quantity |
      | Prod test 1 | Price Book 1 | 23    | 5%       | 50       |
    When I edit the added Product with the following information
      | Product     | Price Book   | Price | Discount | Quantity |
      | Prod test 1 | Price Book 2 | 70    | 5%       | 50       |
    Then A successful saved changes message should be displayed
      And The Products Details should be updated correctly
      And The Quote Totals should be updated correctly

  @DeleteQuoteLineItem
  Scenario: Verify that is possible to Delete a Quote Line Item
    Given I have the following Product added to the Quote
      | Product     | Price Book   | Price | Discount | Quantity |
      | Prod test 1 | Price Book 1 | 23    | 5%       | 50       |
    When I delete the added Product from the Quote
    Then A Quote Line Item successful deleting message should be displayed
      And The deleted Product should disappear from the Quote Line Items view
      And The Quote Details should be updated correctly
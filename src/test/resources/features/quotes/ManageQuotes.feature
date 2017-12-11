@Quote @Functional @Smoke
Feature: Manage Quotes
  Test successfully creating, editing and deleting of Quotes

  Background:
    Given I am logged to Salesforce

  @CreateQuote
  Scenario: Verify that is possible to Create a Quote
    Given I go to Opportunities Home Page
    And I select the Opportunity created "FrancoOpportunityTest"
    And I go to Opportunity Quotes view
    When I create a Quote with the following information
      | name       | expirationDate | status    | description       |
      | QuoteTest1 | 30/12/2017     | Presented | Quote Description |
    Then A Quote successful creation message should be displayed
    And I should see the new Quote in the Opportunity Quotes list

  @EditQuote
  Scenario: Verify that is possible to Edit a Quote
    Given I have a Quote created in opportunity "FrancoOpportunityTest" with the following information
      | name       | expirationDate | status | description        |
      | QuoteTest2 | 30/12/2017     | Draft  | Quote Description2 |
    And I go to Quotes Home Page
    And I select the Quote created
    When I edit the Quote with the following information
      | name       | expirationDate | status   | description        |
      | QuoteTest2 | 31/12/2018     | Accepted | Quote Description2 |
    Then A Quote successful editing message should be displayed
    And I should see the Quote information updated in the Quote details view

  @DeleteQuote
  Scenario: Verify that is possible to Delete a Quote
    Given I have a Quote created in opportunity "FrancoOpportunityTest" with the following information
      | name       | expirationDate | status | description       |
      | QuoteTest3 | 07/12/2017     | Draft  | Quote Description |
    And I go to Quotes Home Page
    And I select the Quote created
    When I delete the Quote
    Then A Quote successful deleting message should be displayed
    And The Quote should disappear from the Quotes list
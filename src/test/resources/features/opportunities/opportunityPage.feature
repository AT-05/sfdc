@OppyHome
Feature: Open the Opportunity page

  Background:
    Given I'm logged to Salesforce
    When I go to Opportunities page
    #and

  @Smoke
  Scenario: Verify that a user should be able to navigate to Opportunities page
    Then the Opportunities page should be displayed
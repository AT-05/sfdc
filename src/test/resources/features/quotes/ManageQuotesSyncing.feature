@Quote @QuotesSyncing @Functional @Smoke
Feature: Manage Quotes Syncing
  Test successfully syncing and stop syncing Quote with Opportunity

  Background:
    Given I am logged to Salesforce
      And I have an Opportunity with the following information:
      | Opp Name   | Opp test      |
      | Close Date | Now + 1 month |
      | Stage      | Qualification |
      | Account    | Acme          |
      And I have a Quote created with name "Test" for the Opportunity created
      And I go to Quotes Page
      And I select the Quote created

  @SyncQuote
  Scenario: Verify that is possible to Sync a Quote with an Opportunity
    When I sync the Quote created with its parent Opportunity
    Then A Quote synced with its parent Opportunity message should be displayed
      And And I should see the Quote's syncing box checked

  @StopSyncQuote
  Scenario: Verify that is possible to Stop Syncing a Quote with an Opportunity
    Given I have a synced Quote
    When I stop syncing the Quote with its parent Opportunity
    Then A not synced Quote message should be displayed
      And I should see the Quote's syncing box unchecked
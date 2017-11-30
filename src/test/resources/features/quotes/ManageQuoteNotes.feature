@Quote @QuoteNotes @Functional
Feature: Manage Quote Notes
  Test successfully adding and deleting a Quote Notes

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

  @AddQuoteNote
  Scenario: Verify that is possible to Add a Note to a Quote
    When I add a Note with the following information
      | Title | Text                |
      | Note1 | This is a Note Test |
    Then A Note successful adding message should be displayed
      And I should see the new Note in Quote Notes list

  @EditQuoteNote
  Scenario: Verify that is possible to Add a Note to a Quote
    Given I have a Note added with the following information
      | Title | Text                |
      | Note3 | This is a Note Test |
    When I edit the added Note with text "This is a Note"
    Then A Note successful editing message should be displayed
      And The Note information should be updated correctly

  @DeleteQuoteNote
  Scenario: Verify that is possible to Delete a Note from a Quote
    Given I have a Note added with the following information
      | Title | Text                |
      | Note2 | This is a Note Test |
    When I delete the added Note
    Then A Note successful deleting message should be displayed
      And The deleted Note should disappear from the Quote Notes list
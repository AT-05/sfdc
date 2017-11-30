@Quote @QuoteFiles @Functional
Feature: Manage Quote Files
  Test successfully adding, editing and deleting of Quote Files

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

  @AddQuoteFile
  Scenario: Verify that is possible to Add a File to a Quote
    When I add the following File
      | File Name         |
      | Sales_leadersship |
    Then A File successful adding message should be displayed
      And I should see the added File in the Quote Files list

  @EditQuoteFile
  Scenario: Verify that is possible to Edit File details
    Given I have a File added with name "FileTest1"
    When I edit the added File details with the following information
      | File Title | File Description |
      | FileTest   | Description      |
    Then A File successful editing message should be displayed
      And I should see the File details updated in the File details view

  @DeleteQuoteFile
  Scenario: Verify that is possible to Delete a File from a Quote
    Given I have a File added with name "FileTest1"
    When I delete the added File
    Then A File successful deleting message should be displayed
      And The File should disappear from the Quote Files list and all its related instances in the Quote
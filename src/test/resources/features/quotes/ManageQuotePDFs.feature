@Quote @QuotePDFs @Functional
Feature: Manage Quote PDFs
  Test successfully creating, deleting and emailing of Quote PDFs

  Background:
    Given I am logged to Salesforce
      And I have an Opportunity with the following information
      | Opp Name   | Opp test      |
      | Close Date | Now + 1 month |
      | Stage      | Qualification |
      | Account    | Acme          |
      And I have a Quote created with name "QuoteTest" for the Opportunity created
      And I go to Quotes Page
      And I select the Quote created


  @CreateQuotePDFStandard
  Scenario: Verify that is possible to Create a Quote PDF from the Standard Template
    When I create a Quote PDF from the Standard Template
    Then A Quote PDF successful creation message should be displayed
      And I should see the new Quote PDF in the Quote PDFs list

  @CreateQuotePDFTemplate
  Scenario: Verify that is possible to Create a Quote PDF by Selecting a Template
    Given I have a Quote PDF Template with name "QuoteTemplate1"
    When I create a Quote PDF by Selecting the Template created
    Then A Quote PDF successful creation message should be displayed
      And I should see the new Quote PDF in the Quote PDFs list

  @DeleteQuotePDF
  Scenario: Verify that is possible to Delete a Quote PDF
    Given I have a Quote PDF created with name "QuoteTest_V1"
    When I delete the Quote PDF created
    Then A Quote PDF successful deleting message should be displayed
      And The Quote PDF should disappear from the Quote PDFs list

  @EmailQuotePDF
  Scenario: Verify that is possible to Email a Quote PDF
    Given I have a Quote PDF created with name "QuoteTest_V1"
    When I email the Quote PDF created with the following info
      | To                                    | Subject        | Message                |
      | francodanielaldunatecordero@gmail.com | Test Email PDF | Test Email PDF Message |
    Then A Quote PDF successful email sent message should be displayed
      And I should see an email send confirmation message displayed
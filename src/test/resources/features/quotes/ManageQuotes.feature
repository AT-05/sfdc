@Quote @Functional @Smoke
Feature: Manage Quotes
  Test successfully creating, editing and deleting of Quotes

  Background:
    Given I am logged to Salesforce
      And I have an Opportunity with the following information:
      | Opp Name   | OpportunityTest1 |
      | Close Date | Now + 1 month    |
      | Stage      | Qualification    |
      | Account    | Acme             |
      And I have a Contact created with name "Gabriela Funes Rosales"
      And I go to Opportunities Page
      And I select the Opportunity created
      And I go to Opportunity Quotes view

  @CreateQuote
  Scenario: Verify that is possible to Create a Quote
    Given I create a Quote with the following information
      | Quote Name | Expiration Date | Syncing | Status    | Description       | Tax  | Shipping and Handling | Contact Name           | Phone    | Email            | Fax       | Bill To Name | Ship To Name | Bill To Street                  | Ship To Street        | Bill To City | Bill To State/Province | Bill To Zip/Postal Code | Bill To Country | Ship To City | Ship To State/Province | Ship To Zip/Postal Code | Ship To Country |
      | QuoteTest1 | 30/12/2017      | none    | Presented | Quote Description | 2,00 | 30,00                 | Gabriela Funes Rosales | 77799123 | gabifr@gmail.com | 453754324 | FrancoSoft   | FrancoSoft   | Avenida Melchor Pérez de Olguín | Blanco Galindo Avenue | Cochabamba   | Cercado                | 00000                   | Bolivia         | Cochabamba   | Cercado                | 00000                   | Bolivia         |
    Then A Quote successful creation message should be displayed
      And I should see the new Quote in the Opportunity Quotes list

  @EditQuote
  Scenario: Verify that is possible to Edit a Quote
    Given I have a Quote created with the following information
      | Quote Name | Expiration Date | Syncing | Status | Description       | Tax  | Shipping and Handling | Contact Name           | Phone    | Email            | Fax       | Bill To Name | Ship To Name | Bill To Street                  | Ship To Street        | Bill To City | Bill To State/Province | Bill To Zip/Postal Code | Bill To Country | Ship To City | Ship To State/Province | Ship To Zip/Postal Code | Ship To Country |
      | QuoteTest2 | 30/11/2017      | none    | Draft  | Quote Description | 2,00 | 30,00                 | Gabriela Funes Rosales | 77799123 | gabifr@gmail.com | 453754324 | FrancoSoft   | FrancoSoft   | Avenida Melchor Pérez de Olguín | Blanco Galindo Avenue | Cochabamba   | Cercado                | 00000                   | Bolivia         | Cochabamba   | Cercado                | 00000                   | Bolivia         |
    And I go to Quotes Page
      And I select the Quote created
    When I edit the Quote with the following information
      | Quote Name | Expiration Date | Syncing | Status   | Description       | Tax  | Shipping and Handling | Contact Name           | Phone    | Email            | Fax       | Bill To Name | Ship To Name | Bill To Street                  | Ship To Street        | Bill To City | Bill To State/Province | Bill To Zip/Postal Code | Bill To Country | Ship To City | Ship To State/Province | Ship To Zip/Postal Code | Ship To Country |
      | QuoteTest2 | 20/12/2017      | none    | Accepted | Quote Description | 7,00 | 70,00                 | Gabriela Funes Rosales | 77799123 | gabifr@gmail.com | 453754324 | FrancoSoft   | FrancoSoft   | Avenida Melchor Pérez de Olguín | Blanco Galindo Avenue | Cochabamba   | Cercado                | 00000                   | Bolivia         | Cochabamba   | Cercado                | 00000                   | Bolivia         |
    Then A Quote successful editing message should be displayed
      And I should see the Quote information updated in the Quote details view

  @DeleteQuote
  Scenario: Verify that is possible to Delete a Quote
    Given I have a Quote created with the following information
      | Quote Name | Expiration Date | Syncing | Status | Description       | Tax  | Shipping and Handling | Contact Name           | Phone    | Email            | Fax       | Bill To Name | Ship To Name | Bill To Street                  | Ship To Street        | Bill To City | Bill To State/Province | Bill To Zip/Postal Code | Bill To Country | Ship To City | Ship To State/Province | Ship To Zip/Postal Code | Ship To Country |
      | QuoteTest3 | 07/12/2017      | none    | Draft  | Quote Description | 5,00 | 40,00                 | Gabriela Funes Rosales | 77799123 | gabifr@gmail.com | 453754324 | FrancoSoft   | FrancoSoft   | Avenida Melchor Pérez de Olguín | Blanco Galindo Avenue | Cochabamba   | Cercado                | 00000                   | Bolivia         | Cochabamba   | Cercado                | 00000                   | Bolivia         |
    And I go to Quotes Page
      And I select the Quote created
    When I delete the Quote
    Then A Quote successful deleting message should be displayed
      And The Quote should disappear from the Quotes list
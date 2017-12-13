Feature: List View Controls of Opportunities

  Background:
    Given I'm logged to Salesforce
    And I go to Opportunities page

  @Functional @ModernSkin
  Scenario: User is able to create New List View Controls
    Given I select New List View Controls from the buttons options
    When I create List View Controls with the name "List View Test"
    Then the new List View Controls should be created

  @Negative
  Scenario: Verify that is not possible create a New List View without name
    Given I select New List View Controls from the buttons options
    When I try to create New List View whitout name
    Then the app should be display a message of error

  @Functional
  Scenario: Verify that the total sum of amount to each stage is correct
    Given I select all Opportunities from List View options
    When I select Kanvan view from Display As button
    Then the sum total of amount for each stage should be correct
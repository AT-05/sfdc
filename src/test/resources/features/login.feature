@Login
Feature: Login
  Test successfully login in to the application

  Background:
    Given I navigate to Main Page

  @SmokeTest
  Scenario: Verify that a user can login in to the application
    When I login to salesforce
    Then I should be redirected to home page

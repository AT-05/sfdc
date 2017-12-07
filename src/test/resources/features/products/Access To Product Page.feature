Feature: Access to Product page
  @Smoke
  Scenario: Verify that is possible Access to Product Home page.
    Given I'm logged in Sales Force.
    When  I go to Product option
    Then product Home Page should be displayed.
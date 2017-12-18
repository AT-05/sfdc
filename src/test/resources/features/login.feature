@Login
Feature: Login
  Test successfully and unsuccessfully login and logout

  @SmokeTest
  Scenario Outline: Users should be able to login using valid credentials
    Given I navigate to Login page
    When I login as "<User Name>" with password "<Password>"
    Then I should login successfully

    Examples: Short pass
      | User Name             | Password         |
      | franco@francosoft.com | ilovejesus100aml |
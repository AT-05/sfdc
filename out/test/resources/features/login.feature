@Login
Feature: Login
  Test successfully and unsuccessfully login and logout

  @SmokeTest @Logout
  Scenario: Users should be able to login using valid credentials
    Given I navigate to Login page
    When I login with enviroments params
    Then I should login successfully

#    Examples: Short pass
#      | User Name  | Password     |
#      | Admin      | Pass         |
#      | Admin      |              |
#
#    @Negative
#    Examples: Special pass
#      | User Name  | Password     |
#      | Regular    | Password123! |
#      | Pepito     | Password123! |
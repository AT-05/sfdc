@CrudOppy @FunctionalOppy
Feature: Manage Opportunities - CRUD

  Background:
    Given I am logged to Salesforce
    And I go to Opportunities page

  @Smoke @CreateOppy
  Scenario: User should be able to create an Opportunity
    Given I create an Opportunity with the following information
      | oppyName  | closeDate | stage         | account | privateOppy | amount |
      | Oppy test | 6/12/2018 | Qualification | Acme    | true        | 10000  |

    Then a message should be displayed saying that the Opportunity was created
    And the Opportunity created should have the correct values

  @Functional @EditOppy
  Scenario: User should be able to edit an Opportunity
    Given I have an Opportunity with the following information
      | oppyName | closeDate | stage         | account | privateOppy | amount |
      | Opp test | 6/12/2018 | Qualification | Acme    | false       | 10000  |

    And I select to edit the Opportunity created from the list
    When I edit the Opportunity with the following information
      | oppyName    | closeDate | stage             | account        | privateOppy | amount |
      | Opp testing | 6/2/2019  | Value Proposition | salesforce.com | true        | 5000   |

    Then a message should be displayed saying that the Opportunity was saved
    And the Opportunity edited should have the correct values

  @Functional @DeleteOppy
  Scenario: User should be able to delete an Opportunity
    Given I have an Opportunity with the following information
      | oppyName     | closeDate | stage         | account | privateOppy | amount |
      | Oppy testing | 6/12/2018 | Qualification | Acme    | true        | 10000  |

    And I select to delete the Opportunity created from the list
    When I delete that Opportunity
    Then a message should be displayed saying that the Opportunity was deleted
    And the Opportunity should be delete of the list


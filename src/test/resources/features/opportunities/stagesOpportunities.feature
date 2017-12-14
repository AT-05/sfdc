@Stages
Feature: Verify changes when assignment other stage of a opportunity

  @Functional
  Scenario Outline: Users should be able to change the stage of a opportunity created
    Given I am logged to Salesforce
      And I go to Opportunities page
      And I have Opportunity with the following information
        | oppyName    | closeDate | stage         | account      | budget | amount |
        | Plastiform  | 6/12/2018 | Qualification | Acme (Sample)| true   | 8000   |

    When I change the stage with "<stage_name>" option
    Then the stage selected should be associate to the Opportunity

    Examples:
          | stage_name     |
          | Needs Analysis |
          | Proposal       |
#          | Negotiation    |
#          | Closed Won     |
#          | Closed Lost    |
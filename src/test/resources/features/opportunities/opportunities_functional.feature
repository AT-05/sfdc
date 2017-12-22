@Stages @FunctionalOppy
Feature: Verify changes when assignment other stage of a opportunity

  @Functional
  Scenario Outline: Users should be able to change the stage of a opportunity created
    Given I am logged to Salesforce
      And I go to Opportunities page
      And I have an Opportunity with the following information
        | oppyName   | closeDate | stage         | account | privateOppy | amount |
        | <oppyName> | 6/12/2018 | Qualification | Acme    | false       | 8000   |

    When I change the stage with "<stage_name>" option
    Then the stage selected should be associate to the Opportunity

    Examples:
          | stage_name           | oppyName   |
          | Needs Analysis       | Plastiform |
          | Value Proposition    | Test       |
          | Id. Decision Makers  | Form       |
          | Proposal/Price Quote | Mega       |
          | Negotiation/Review   | Terra      |
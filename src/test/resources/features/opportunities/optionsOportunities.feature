Feature: Verifying options when creates new Opportunities

  Background:
    Given I'm logged to Salesforce
    And I go to Opportunities page
    And I select New Opportunity option

  @Functional
  Scenario: When user creates an Opportunity should be able to find accounts to associate to it
    When I write the name of an existing account "Acme" in Account Name field
    Then the account that match with that name should be displayed under the field

  @Functional
  Scenario Outline: When user creates an opportunity and associate with any stage the probability of that stage should displayed in the probability field
    When I select <Options> in stage field
    Then the <Porcents> of that stage should be displayed in the probability field

    Examples:
      | OPTIONS        | PORCENTS |
      | None           |          |
      | Qualification  | 10 %     |
      | Needs Analysis | 35 %     |
      | Proposal       | 75 %     |
      | Negotiation    | 90 %     |
      | Closed Won     | 100 %    |
      | Closed Lost    | 0 %      |

  @Negative
  Scenario: Verify when I create a new opportunity all fields required must be fill
    When I try to save whitout fill requiered fields
    Then the app should be display a message of error
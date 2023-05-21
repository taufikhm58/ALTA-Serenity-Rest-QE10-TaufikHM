Feature: Get list user feature

  @Latihan
  Scenario Outline: Get list user with valid parameter page
    Given Get list user with valid parameter page <page>
    When Send get list users
    Then Status code should be 200 OK
    And Response body page should be <page>
    And Validate get list user JSON Schema
    Examples:
      | page |
      | 1    |
      | 2    |
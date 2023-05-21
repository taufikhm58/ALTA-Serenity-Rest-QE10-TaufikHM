Feature: Delete user feature

  @Latihan
  Scenario Outline: Delete user with valid parameter id
    Given Delete user with valid id <id>
    When Send delete
    Then Status code should be 204 No Content
    Examples:
      | id |
      | 1  |
      | 2  |
Feature: Put update user

  @Latihan
  Scenario Outline: Put update user with valid json and id
    Given Put update user with valid json and id <id>
    When Send put update user
    Then Status code should be 200 OK
    And Response body name "morpheus" and job "zion resident"
    And Validate put create user JSON Schema validator

    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |
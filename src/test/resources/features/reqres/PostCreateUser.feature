Feature: Post create user feature

  @Latihan
  Scenario: Post create new user with valid json
    Given Post create user with valid json
    When Send post create user
    Then Status code should be 201 Created
    And Response body name was "Opik" and job was "QA Engineer"
    And validate post create user JSON Schema validator

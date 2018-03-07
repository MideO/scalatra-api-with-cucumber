Feature: Addition
  In order to add numbers
  As a users
  I want a calculator

  Scenario: Add two number
    Given a left operand with value "2"
    And a right operand with value "4"
    When I add both operands
    Then I expect the result to be "6"
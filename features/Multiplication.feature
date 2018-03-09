Feature: Multiplication API
  In order to multiply two numbers
  As a frontend client
  I want a calculator api

  Scenario: Multiplication of two number
    Given a left operand with value "2"
    And a right operand with value "4"
    When I multiply both operands
    Then I expect the api response to be 200
    And I expect the result to be "8"

  Scenario: Multiplication of two decimal number
    Given a left operand with value "5.1"
    And a right operand with value "4.4"
    When I multiply both operands
    Then I expect the api response to be 200
    And I expect the result to be "22.44"

  Scenario: Add two strings
    Given a left operand with value "abc"
    And a right operand with value "133"
    When I multiply both operands
    Then I expect the api response to be 400
    Then I expect the result to be "Unsupported arguments both arguments must be Integer like String or Decimal like String"
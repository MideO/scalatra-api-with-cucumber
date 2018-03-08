Feature: Addition API
  In order to add two  numbers
  As a frontend client
  I want a calculator api

  Scenario: Add integer two number
    Given a left operand with value "2"
    And a right operand with value "4"
    When I add both operands
    Then I expect the api response to be 200
    And I expect the result to be "6"

  Scenario: Add decimal two number
    Given a left operand with value "2.2"
    And a right operand with value "4.4"
    When I add both operands
    Then I expect the api response to be 200
    Then I expect the result to be "6.6"


  Scenario: Add two strings
    Given a left operand with value "abc"
    And a right operand with value "133"
    When I add both operands
    Then I expect the api response to be 400
    Then I expect the result to be "Unsupported arguments both arguments must be Integer like String or Decimal like String"
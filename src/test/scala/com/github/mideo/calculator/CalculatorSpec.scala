package com.github.mideo.calculator

import org.scalatest.{FunSuite, Matchers}

class CalculatorSpec extends FunSuite with Matchers{

  object AdditionCalculator extends Calculator

  test("Calculator should add int"){
    withClue("Failed to add int-like String ") {
      AdditionCalculator.add("1", "2") should equal("3")
    }
  }

  test("Calculator should add double"){
    withClue("Failed to add double-like String ") {
      AdditionCalculator.add("1.1111", "2.2222") should equal("3.3333")
    }
  }

  test("Calculator should trouble unsupported exception"){
    the[CalculatorException] thrownBy {
      AdditionCalculator.add("adc","ddd")
    } should have message "Unsupported arguments both arguments must be Integer like String or Double like String"
  }

}

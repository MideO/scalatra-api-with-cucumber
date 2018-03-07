package com.github.mideo.calculator

import org.scalatest.{FunSuite, Matchers}

class CalculatorSpec extends FunSuite with Matchers{

  private object Calculator extends Addition

  test("Calculator should add int"){
    withClue("Failed to add int-like String ") {
      Calculator.add("1", "2") should equal("3")
    }
  }

  test("Calculator should add BigDecimal"){
    withClue("Failed to add BigDecimal-like String ") {
      Calculator.add("1.1", "2.222") should equal("3.322")
    }
  }

  test("Calculator should trouble unsupported exception"){
    the[CalculationException] thrownBy {
      Calculator.add("adc","ddd")
    } should have message "Unsupported arguments both arguments must be Integer like String or Decimal like String"
  }

}

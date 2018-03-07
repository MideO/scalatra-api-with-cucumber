package com.github.mideo.calculator

import org.scalatest.{FunSuite, Matchers}

import scala.util.Success

class CalculatorAdditionSpec extends FunSuite with Matchers {

  test("Calculator should add int") {
    withClue("Failed to add int-like String ") {
      Calculator.add("1", "2") should equal(Success("3"))
    }
  }

  test("Calculator should add BigDecimal") {
    withClue("Failed to add BigDecimal-like String ") {
      Calculator.add("1.1", "2.222") should equal(Success("3.322"))
    }
  }

  test("Calculator should trouble unsupported exception") {
    the[CalculationException] thrownBy {
      Calculator.add("adc", "ddd").get
    } should have message "Unsupported arguments both arguments must be Integer like String or Decimal like String"
  }

}

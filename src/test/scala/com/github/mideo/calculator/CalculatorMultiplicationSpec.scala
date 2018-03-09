package com.github.mideo.calculator

import org.scalatest.{FunSuite, Matchers}

import scala.util.Success

class CalculatorMultiplicationSpec extends FunSuite with Matchers {


  test("Multiplication of two numbers") {
    Calculator.multiply("2", "3") should equal(Success("6"))
  }

  test("Multiplication of two decimal numbers") {
    Calculator.multiply("2.2", "4.4" ) should equal(Success("9.68"))
  }
  test("Multiplication of strings") {

    the[CalculationException] thrownBy {
      Calculator.multiply("one", "two").get
    } should have message "Unsupported arguments both arguments must be Integer like String or Decimal like String"

  }
}

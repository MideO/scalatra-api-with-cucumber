package com.github.mideo.calculator

import scala.util.Try

trait Multiplication extends Calculation {

  private def multiply(x: Int, y: Int): Int = x * y

  private def multiply(x: BigDecimal, y: BigDecimal): BigDecimal = x * y

  def multiply(x: String, y: String): Try[String] = {
    Try {
      (x, y) match {
        case (x: String, y: String) if areInt(x, y) => multiply(x.toInt, y.toInt).toString
        case (x: String, y: String) if areDecimal(x, y) => multiply(BigDecimal(x), BigDecimal(y)).toString
        case _ => throw CalculationException("Unsupported arguments both arguments must be Integer like String or Decimal like String")
      }
    }
  }

}

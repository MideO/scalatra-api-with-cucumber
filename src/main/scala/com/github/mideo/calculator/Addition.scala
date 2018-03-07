package com.github.mideo.calculator

import scala.util.Try

private[calculator] trait Addition extends Calculation {
  private def add(x: Int, y: Int): Int = x + y

  private def add(x: BigDecimal, y: BigDecimal): BigDecimal = x + y

  def add(x: String, y: String): Try[String] = {
    Try {
      (x, y) match {
        case (x: String, y: String) if areDecimal(x, y) => add(BigDecimal(x), BigDecimal(y)).toString
        case (x: String, y: String) if areInt(x, y) => add(x.toInt, y.toInt).toString
        case _ => throw CalculationException("Unsupported arguments both arguments must be Integer like String or Decimal like String")
      }
    }
  }
}
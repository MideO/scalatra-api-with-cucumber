package com.github.mideo.calculator

case class CalculationException(private val message: String = "",
                                private val cause: Throwable = None.orNull) extends RuntimeException(message, cause)

private[calculator] trait Calculation {
  private def isInt(s:String) = scala.util.Try(s.toInt).isSuccess && !s.contains('.')
  def areInt(s:String, y:String): Boolean = isInt(s) && isInt(y)
  private def isDecimal(s:String): Boolean = scala.util.Try(BigDecimal(s)).isSuccess && s.contains('.')
  def areDecimal(x:String, y:String): Boolean = isDecimal(x) && isDecimal(y)
}
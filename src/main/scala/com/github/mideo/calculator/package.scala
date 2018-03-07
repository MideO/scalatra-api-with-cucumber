package com.github.mideo


package object calculator {
  case class CalculatorException(private val message: String = "",
                                 private val cause: Throwable = None.orNull) extends RuntimeException(message, cause)

  sealed trait Calculation {
    private def isInt(s:String) = scala.util.Try(s.toInt).isSuccess && !s.contains('.')
    def areInt(s:String, y:String): Boolean = isInt(s) && isInt(y)
    private def isDecimal(s:String): Boolean = scala.util.Try(BigDecimal(s)).isSuccess && s.contains('.')
    def areDecimal(x:String, y:String): Boolean = isDecimal(x) && isDecimal(y)
  }

  sealed trait Addition extends Calculation{
    private def add(x:Int, y:Int): Int = x + y

    private def add(x:BigDecimal, y:BigDecimal): BigDecimal = x + y

    def add(x:String, y:String):String = {
      (x, y) match {
        case (x:String, y:String) if areDecimal(x, y) => add(BigDecimal(x), BigDecimal(y)).toString
        case (x:String, y:String) if areInt(x, y) => add(x.toInt, y.toInt).toString
        case _ => throw CalculatorException("Unsupported arguments both arguments must be Integer like String or Decimal like String")
      }
    }

  }

  trait Calculator
    extends Calculation
      with Addition


}

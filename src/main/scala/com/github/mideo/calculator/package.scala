package com.github.mideo


package object calculator {
  case class CalculatorException(private val message: String = "",
                                 private val cause: Throwable = None.orNull) extends RuntimeException(message, cause)

  sealed trait Calculation {
    private def isInt(s:String) = scala.util.Try(s.toInt).isSuccess && !s.contains('.')
    def areInt(s:String, y:String): Boolean = isInt(s) && isInt(y)
    private def isDouble(s:String): Boolean = scala.util.Try(s.toDouble).isSuccess && s.contains('.')
    def areDouble(x:String, y:String): Boolean = isDouble(x) && isDouble(y)
  }

  sealed trait Addition extends Calculation{
    private def add(x:Int, y:Int): Int = x + y

    private def add(x:Double, y:Double): Double = x + y

    def add(x:String, y:String):String = {
      (x, y) match {
        case (x:String, y:String) if areDouble(x, y) => add(x.toDouble, y.toDouble).toString
        case (x:String, y:String) if areInt(x, y) => add(x.toInt, y.toInt).toString
        case _ => throw CalculatorException("Unsupported arguments both arguments must be Integer like String or Double like String")
      }
    }

  }

  trait Calculator
    extends Calculation
      with Addition


}

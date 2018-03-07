package com.github.mideo.app

import com.github.mideo.calculator.{CalculationException, Calculator}
import org.scalatra._

import scala.util.{Failure, Success, Try}

class CalculatorServlet
  extends ScalatraServlet
  with Calculator {

  get("/:left/add/:right") {
    add(params("left"), params("right")) match {
      case Success(s) => s
      case Failure(f) => halt(400, f.getMessage)
    }
  }
}

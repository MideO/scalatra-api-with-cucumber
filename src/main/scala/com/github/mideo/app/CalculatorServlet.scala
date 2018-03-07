package com.github.mideo.app

import com.github.mideo.calculator.Calculator
import org.scalatra._

class CalculatorServlet
  extends ScalatraServlet
  with Calculator {

  get("/:left/add/:right") {
    add(params("left"), params("right"))
  }

}

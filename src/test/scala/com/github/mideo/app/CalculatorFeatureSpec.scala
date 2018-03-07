package com.github.mideo.app

import cucumber.api.Scenario
import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.Matchers
import org.scalatra.test.ScalatraTests

class CalculatorFeatureSpec  extends ScalaDsl
  with EN
  with ScalatraTests
  with Matchers {

  Before {
    _: Scenario =>
      start()

  }

  After() {
    _: Scenario => stop()
  }
  addServlet(classOf[CalculatorServlet], "/*")
  var leftOperand = ""
  var rightOperand = ""
  var result = ""
}

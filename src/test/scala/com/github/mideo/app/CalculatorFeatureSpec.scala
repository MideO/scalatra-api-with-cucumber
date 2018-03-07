package com.github.mideo.app

import cucumber.api.Scenario
import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.Matchers
import org.scalatra.swagger.Swagger
import org.scalatra.test.ScalatraTests

class CalculatorFeatureSpec extends ScalaDsl
  with EN
  with ScalatraTests
  with Matchers {
  var started = false

  def stopJetty() = stop()

  def bootstrapJetty(): Unit = {
    if (started) return

    start()
    Runtime.getRuntime.addShutdownHook(
      new Thread() {
        override def run(): Unit = {
          stopJetty()
        }
      }
    )
    started = true
  }


  Before {
    _: Scenario => bootstrapJetty()
  }

  implicit val swagger:Swagger = new CalculatorSwagger
  addServlet(new CalculatorServlet, "/*")
  var leftOperand = ""
  var rightOperand = ""
  var result = ""
  var statusCode = 0
}

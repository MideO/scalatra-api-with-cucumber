package com.github.mideo.app

import com.github.mideo.calculator.Calculator
import org.scalatra._
import org.scalatra.swagger._

import scala.util.{Failure, Success}

class CalculatorServlet(implicit val swagger: Swagger)
  extends ScalatraServlet
    with SwaggerSupport {

  override protected def applicationDescription: String = CalculatorSwagger.Info.description

  val add: SwaggerSupportSyntax.OperationBuilder = (
    apiOperation[String]("add")
      summary "adds two numbers"
      tags "add"
      parameters(pathParam[String]("left").description("left operand"), pathParam[String]("right").description("right operand"))
      responseMessage ResponseMessage(400, "Unsupported arguments both arguments must be Integer like String or Decimal like String")
    )

  get("/:left/add/:right", operation(add)) {
    Calculator.add(params("left"), params("right")) match {
      case Success(s) => s
      case Failure(f) => halt(400, f.getMessage)
    }
  }


  val multiply: SwaggerSupportSyntax.OperationBuilder = (
    apiOperation[String]("multiply")
      summary "multiply two numbers"
      tags "multiply"
      parameters(pathParam[String]("left").description("left operand"), pathParam[String]("right").description("right operand"))
      responseMessage ResponseMessage(400, "Unsupported arguments both arguments must be Integer like String or Decimal like String")
    )
  get("/:left/multiply/:right", operation(multiply)) {
    Calculator.multiply(params("left") ,params("right")) match {
      case Success(s) => s
      case Failure(f) => halt(400, f.getMessage)
    }
  }
}

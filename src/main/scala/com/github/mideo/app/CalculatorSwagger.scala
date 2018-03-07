package com.github.mideo.app

import org.scalatra.ScalatraServlet
import org.scalatra.swagger.{ApiInfo, NativeSwaggerBase, Swagger}


class ResourcesApp(implicit val swagger: Swagger) extends ScalatraServlet with NativeSwaggerBase


object CalculatorSwagger {
  val Info = ApiInfo(
    "The Calculator API",
    "Docs for the Calculator API",
    "",
    "mide.ojikutu@sgmail.com",
    "MIT",
    "http://opensource.org/licenses/MIT")
}

class CalculatorSwagger extends Swagger(Swagger.SpecVersion, "1", CalculatorSwagger.Info)
package com.github.mideo.app


class AdditionSteps extends CalculatorFeatureSpec {

  Given("""^a (left|right) operand with value "([^"]*)"""") { (operand:String, leftOperand: String) =>
    operand match {
      case "left" => this.leftOperand = leftOperand
      case "right" => this.rightOperand = leftOperand
    }
  }

  When("""^I add both operands$""") {
    () =>
      get(s"$leftOperand/add/$rightOperand") {
        status should equal(200)
        this.result = body
      }
  }

  Then("""^I expect the result to be "([^"]*)"$""") { (result: String) =>
    this.result should equal(result)
  }
}

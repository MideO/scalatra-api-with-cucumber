package com.github.mideo.app


class AdditionSteps extends CalculatorFeatureSpec {

  Given("""^a (left|right) operand with value "([^"]*)"""") { (operand:String, leftOperand: String) =>
    operand match {
      case "left" => this.leftOperand = leftOperand
      case "right" => this.rightOperand = leftOperand
    }
  }

  When("""^I ([^"]*) both operands$""") {
    (op:String) =>
      get(s"$leftOperand/$op/$rightOperand") {
        this.statusCode = status
        this.result = body
      }
  }

  Then("""^I expect the api response to be (\d+)$"""){ (code:Int) =>
    this.statusCode should equal(code)
  }

  And("""^I expect the result to be "([^"]*)"$""") { (result: String) =>
    this.result should equal(result)
  }
}

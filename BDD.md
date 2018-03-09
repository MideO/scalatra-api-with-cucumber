#### Table Of Content
 * [Test Driven Development (TDD)](#test-driven-development-tdd)
    * [TDD is](#tdd-is:)
 * [Behaviour Driven Development (BDD)](#behaviour-driven-development-bdd)
    * [BDD is](#bdd-is:)
    * [Why BDD](#why-bdd:)
 * [Live Coding Example](#live-coding-example)
    * [Requirement](#requirement:)

#### Test Driven Development (TDD)
A development process that is a repetition of a very short development cycles, broken down into three stages.
```
* Red - Write a failing test
* Green - Make the test pass
* Yellow - Refactor
```

##### TDD is:
   * Not writing unit tests and functional tests
   * Not refactoring
   * Not slow    

#### Behaviour Driven Development (BDD)
An attempt to unify satisfying function/non-functional requirements and application development and testing.
A practices derived from Test Driven Development (TDD) and Acceptance Test Driven Development (ATDD).
A process for describing an application/program specification by examples, usually characterised by four main keywords
```
* Given - Description of a state
* When - Description of an action
* Then - Verification of expected behaviour
* And  - Conjunction used in support of a Given, When or Then
```

##### BDD is:
  * Not test
  * a collaborative process
  
##### Why BDD:
  * Its written in a language that is understood by everyone
  * Its a Collaborative process 
  * Its usually short and concise
  * It's a good entry point for TDD (a failing test can easily be created in the `Red => Green => Yellow` Cycle )
 
    
#### Live Coding Example
 
##### Requirement: 
A calculator to perform mathematical operations

Feature List: 
   - Addition - Done
   - Multiplication  
   - Subtraction
   - Division
   

Feature: Multiplication API
  In order to multiply two numbers
  As a frontend client
  I want a calculator api



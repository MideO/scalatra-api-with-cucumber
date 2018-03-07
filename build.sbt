import scala.language.postfixOps
import scala.sys.process._

val ScalatraVersion = "2.6.2"

organization := "com.github.mideo"

name := "Scalatra-API-With-Cucumber"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.12.4"

resolvers += Classpaths.typesafeReleases

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra" % ScalatraVersion,
  "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "test",
  "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime",
  "org.eclipse.jetty" % "jetty-webapp" % "9.4.8.v20171121" % "container",
  "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",

  // Swagger
  "org.scalatra" %% "scalatra-swagger" % ScalatraVersion,
  "org.json4s" %% "json4s-native" % "3.5.3",
//  "io.swagger" % "swagger-core" % "1.5.0",

// Cucumber
  "io.cucumber" % "cucumber-core" % "2.0.0" % "test",
  "io.cucumber" %% "cucumber-scala" % "2.0.0" % "test",
  "io.cucumber" % "cucumber-jvm" % "2.0.0" % "test",
  "io.cucumber" % "cucumber-junit" % "2.0.0" % "test"

)

enablePlugins(ScalatraPlugin)

enablePlugins(CucumberPlugin)


CucumberPlugin.envProperties := Map("environment" -> "dev")

CucumberPlugin.monochrome := false
CucumberPlugin.glue := "com/github/mideo"

unmanagedClasspath in Test += baseDirectory.value / "features"


def before(): Unit = {
  println("Running Cucumber Tests")
}
def after(): Unit = {
  println("Finished Cucumber Tests")
}

CucumberPlugin.beforeAll := before
CucumberPlugin.afterAll := after


def executeBashCommand(command: String): Unit = {
  val exitCode: Int = command !

  if (exitCode != 0) {
    throw new Exception(s"Failed execution for shell command: `$command`")
  }
}


assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs@_*) => MergeStrategy.discard
  case x => MergeStrategy.first
}

val packageArtifact = TaskKey[Unit]("awsPackage", "Create Deployable AWS Package")

packageArtifact := {
  assembly.value
  val v = version in ThisBuild
  executeBashCommand("rm -rf dist")
  executeBashCommand("mkdir -p dist")
  executeBashCommand("cp target/scala-2.12/cscalatra-api-with-cucumber*.jar dist/scalatra-api-with-cucumber.jar")
}


val ScalatraVersion = "2.6.2"

organization := "com.github.mideo"

name := "Scalatra-API-With-Cucumber-API"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.12.4"

resolvers += Classpaths.typesafeReleases

libraryDependencies ++= Seq(
  "org.scalatra" %% "scalatra" % ScalatraVersion,
  "org.scalatra" %% "scalatra-scalatest" % ScalatraVersion % "test",
  "ch.qos.logback" % "logback-classic" % "1.2.3" % "runtime",
  "org.eclipse.jetty" % "jetty-webapp" % "9.4.8.v20171121" % "container",
  "org.scalatra" %% "scalatra-swagger" % ScalatraVersion,
  "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided",
  "io.cucumber" % "cucumber-core" % "2.0.0" % "test",
  "io.cucumber" %% "cucumber-scala" % "2.0.0" % "test",
  "io.cucumber" % "cucumber-jvm" % "2.0.0" % "test",
  "io.cucumber" % "cucumber-junit" % "2.0.0" % "test"

)

enablePlugins(ScalatraPlugin)

enablePlugins(CucumberPlugin)


CucumberPlugin.envProperties := Map("environment"->"dev")

CucumberPlugin.monochrome := false
CucumberPlugin.glue := "com/github/mideo"

unmanagedClasspath in Test += baseDirectory.value / "features"


def before() : Unit = { println("Running Cucumber Tests") }
def after() : Unit = { println("Finished Cucumber Tests") }

CucumberPlugin.beforeAll := before
CucumberPlugin.afterAll := after